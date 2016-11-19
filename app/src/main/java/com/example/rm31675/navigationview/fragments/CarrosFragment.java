package com.example.rm31675.navigationview.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rm31675.navigationview.DetalheActivity;
import com.example.rm31675.navigationview.R;
import com.example.rm31675.navigationview.adapter.CarroListAdapter;
import com.example.rm31675.navigationview.api.CarroAPI;
import com.example.rm31675.navigationview.listener.OnClickListener;
import com.example.rm31675.navigationview.model.Carro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarrosFragment extends Fragment implements Callback<List<Carro>> {

    private String tipo;
    private RecyclerView rvCarros;
    private CarroListAdapter adapter;

    public CarrosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        if(getArguments() != null){
            this.tipo = getArguments().getString("tipo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_carros, container, false);
        rvCarros = (RecyclerView) v.findViewById(R.id.rvCarros);
        //rvCarros.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvCarros.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCarros.setItemAnimator(new DefaultItemAnimator());
        rvCarros.setHasFixedSize(true);
        return v;

    }

    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        loadCarros();
    }

    private void loadCarros() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.heiderlopes.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CarroAPI api = retrofit.create(CarroAPI.class);
        Call<List<Carro>> call = api.findBy(tipo);
        call.enqueue(this);
    }

    private OnClickListener onClickListener(){
        return new OnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(getContext(), DetalheActivity.class);
                i.putExtra("carro", adapter.getItem(position));
                startActivity(i);
            }
        };
    }

    @Override
    public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response) {
        adapter = new CarroListAdapter(getContext(), response.body(), onClickListener());
        rvCarros.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Carro>> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
