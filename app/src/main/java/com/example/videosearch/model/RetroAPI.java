package com.example.videosearch.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroAPI {

    @GET()
    Observable<Response> searchGiphy(
            @Query("q") String query,
            @Query("limit") int limit,
            @Query("offset") int offset
    );
}

