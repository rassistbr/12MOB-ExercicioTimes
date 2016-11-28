package com.example.rm31675.navigationview.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rm31675.navigationview.DetalheActivity;
import com.example.rm31675.navigationview.R;
import com.example.rm31675.navigationview.adapter.TimeListAdapter;
import com.example.rm31675.navigationview.api.TimeAPI;
import com.example.rm31675.navigationview.listener.OnClickListener;
import com.example.rm31675.navigationview.model.Time;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimesFragment extends Fragment implements Callback<List<Time>> {

    private String tipo;
    private RecyclerView rvTimes;
    private TimeListAdapter adapter;

    public TimesFragment() {
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_times, container, false);
        rvTimes = (RecyclerView) v.findViewById(R.id.rvTimes);
        rvTimes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTimes.setItemAnimator(new DefaultItemAnimator());
        rvTimes.setHasFixedSize(true);
        return v;

    }

    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        loadTimes();
    }

    private void loadTimes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TimeAPI api = retrofit.create(TimeAPI.class);
        Call<List<Time>> call = api.findBy();
        call.enqueue(this);
    }

    private OnClickListener onClickListener(){
        return new OnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(getContext(), DetalheActivity.class);
                i.putExtra("time", adapter.getItem(position));
                startActivity(i);
            }
        };
    }

    @Override
    public void onResponse(Call<List<Time>> call, Response<List<Time>> response) {
        adapter = new TimeListAdapter(getContext(), response.body(), onClickListener());
        rvTimes.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Time>> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
