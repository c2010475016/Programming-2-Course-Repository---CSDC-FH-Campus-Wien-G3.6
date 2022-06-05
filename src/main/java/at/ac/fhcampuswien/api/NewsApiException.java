package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.Enums.NewsApiExceptionErrorCode;

public class NewsApiException extends Exception {

    NewsApiExceptionErrorCode errorCode;

    NewsApiException(NewsApiExceptionErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
