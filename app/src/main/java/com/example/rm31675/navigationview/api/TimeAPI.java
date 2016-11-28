package com.example.rm31675.navigationview.api;

import com.example.rm31675.navigationview.model.Time;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rm31675 on 19/11/2016.
 */
public interface TimeAPI {

    @GET("/v2/57c49ba10f00007111b50c00")
    Call<List<Time>> findBy();

}
