package com.codeburrow.aspectratiodemo.data;

import com.codeburrow.aspectratiodemo.data.model.Photo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Modeling the unsplash.it API, using retrofit: http://square.github.io/retrofit/
 * Retrofit turns your HTTP API into a Java interface.
 */
public interface UnsplashService {

    String ENDPOINT = "https://unsplash.it";

    @GET("/list")
    void getFeed(Callback<List<Photo>> callback);
}