package com.example.flagapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("all")
    Call<List<CountryList>> getCountries(
            @Query("fields") String fields
    );
}
