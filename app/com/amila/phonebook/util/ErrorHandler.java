package com.amila.phonebook.util;

import com.gebsmed.services.JSONService;
import com.google.inject.Singleton;
import play.http.HttpErrorHandler;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by Amila Nuwan Thilina on 16/07/28.
 */
@Singleton
public class ErrorHandler implements HttpErrorHandler {
    @Override
    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        return CompletableFuture.completedFuture(
                Results.status(statusCode,JsonServiceUtil
                        .toJsonNode(new ResponseWrapper<>( "A client error occurred: ".concat(message), null))));
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        return CompletableFuture.completedFuture(
                Results.internalServerError(JsonServiceUtil
                        .toJsonNode(new ResponseWrapper<>("A server error occurred: ", exception.getLocalizedMessage()))));
    }
}
