package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.Enums.Country;
import at.ac.fhcampuswien.Enums.Endpoint;
import at.ac.fhcampuswien.Enums.NewsApiExceptionErrorCode;
import at.ac.fhcampuswien.models.NewsResponse;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class NewsApi {
    private static final String GET_ALL_NEWS = "https://newsapi.org/v2/everything?";
    private static final String GET_TOP_HEADLINES = "https://newsapi.org/v2/top-headlines?";
    private static final String API_KEY = "379bbec59c044cb7a85c990dbcf00dc4";
    private final Gson gson = new Gson();

    public NewsResponse getNews(Endpoint endpoint, String query, Country country) throws NewsApiException { //generic solution instead of multiple scope-based methods

        String url = "";

        switch (endpoint) {
            case EVERYTHING -> {
                url = (GET_ALL_NEWS + "apiKey=" + API_KEY + "&q=" + query);
                if (country != null) {
                    url = url + "&country=" + country;
                }
            }

            case TOP_HEADLINES -> {
                url = (GET_TOP_HEADLINES + "apiKey=" + API_KEY);
                if (country != null) {
                    url = url + "&country=" + country;
                }
            }
            default -> {throw new NewsApiException(NewsApiExceptionErrorCode.notSupportedEndPoint, "An Endpoint which is currently not supported has been provided: " + endpoint.name());
            }
        }
        return run(url);
    }

    private NewsResponse run(String url) throws NewsApiException {

        if (url.isEmpty()) {
            throw new NewsApiException(NewsApiExceptionErrorCode.providedUrlIsEmpty, "The URL provided has no value aka empty.");
        }
        OkHttpClient client = new OkHttpClient(); //client in der methode definiert statt als parameter von run methode
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                throw new NewsApiException(NewsApiExceptionErrorCode.responseBodyIsEmpty, "The body of the response is empty.");
            }

            NewsResponse newsResponse = gson.fromJson(Objects.requireNonNull(response.body()).string(), NewsResponse.class); //was kommt rein und in was soll es konvertiert werden
            return newsResponse;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NewsApiException e) {
            e.printStackTrace();
        }
        return new NewsResponse();
    }
}
