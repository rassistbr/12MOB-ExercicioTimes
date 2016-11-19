package com.example.rm31675.navigationview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rm31675.navigationview.R;
import com.example.rm31675.navigationview.model.Carro;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by rm31675 on 19/11/2016.
 */
public class CarroListAdapter extends RecyclerView.Adapter<CarroListAdapter.CarrosViewHolder>{

    private Context context;
    private List<Carro> carros;

    public CarroListAdapter(Context context, List<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.carro_item, parent, false);
        return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarrosViewHolder holder, int position) {
        holder.tvNome.setText(carros.get(position).getNome());
        holder.tvDescricao.setText(carros.get(position).getDescricao());
        Picasso.with(context).load(carros.get(position).getFoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivCarro);
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{

        TextView tvNome;
        TextView tvDescricao;
        ImageView ivCarro;

        public CarrosViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.tvCarro);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            ivCarro = (ImageView) itemView.findViewById(R.id.ivCarro);
        }
    }
}
