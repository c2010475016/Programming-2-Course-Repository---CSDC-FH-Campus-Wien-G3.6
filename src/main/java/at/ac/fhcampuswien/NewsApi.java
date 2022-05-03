package at.ac.fhcampuswien;

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

    public NewsResponse getNews(Endpoint endpoint, String query, Country country) { //generic solution instead of multiple scope-based methods

        String url = "";

        switch (endpoint) {
            case EVERYTHING -> url = GET_ALL_NEWS + "apiKey=" + API_KEY + "&q=" + query;

            case TOP_HEADLINES -> url = GET_TOP_HEADLINES + "apiKey=" + API_KEY + "&country=" + country;
            default -> {
            }
        }

        if (url.isEmpty()) {
            return new NewsResponse();
        }
        return run(url);
    }

    private NewsResponse run(String url) {
        OkHttpClient client = new OkHttpClient(); //client in der methode definiert statt als parameter von run methode
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                return new NewsResponse();
            }

            Gson gson = new Gson();
            NewsResponse newsResponse = gson.fromJson(Objects.requireNonNull(response.body()).string(), NewsResponse.class); //was kommt rein und in was soll es konvertiert werden
            return newsResponse;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new NewsResponse();
    }
}
