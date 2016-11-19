package com.example.rm31675.navigationview.api;

import com.example.rm31675.navigationview.model.Carro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rm31675 on 19/11/2016.
 */
public interface CarroAPI {

    @GET("/carros/tipo/{tipo}")
    Call<List<Carro>> findBy(@Path("tipo") String tipo);


}
