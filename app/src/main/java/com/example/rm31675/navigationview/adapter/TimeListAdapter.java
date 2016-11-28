package com.example.rm31675.navigationview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rm31675.navigationview.R;
import com.example.rm31675.navigationview.listener.OnClickListener;
import com.example.rm31675.navigationview.model.Time;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rm31675 on 19/11/2016.
 */
public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.TimesViewHolder>{

    private Context context;
    private List<Time> times;
    private OnClickListener clickListener;

    public TimeListAdapter(Context context, List<Time> times, OnClickListener clickListener) {
        this.context = context;
        this.times = times;
        this.clickListener = clickListener;
    }

    @Override
    public TimesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.time_item, parent, false);
        return new TimesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TimesViewHolder holder, final int position) {
        holder.tvNome.setText(times.get(position).getNome());
        holder.tvDescricao.setText("Fundado em " + times.get(position).getEstado() + ", no ano de " + times.get(position).getAnofundacao());
        Picasso.with(context).load(times.get(position).getEscudo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivTime);

        if(clickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(holder.itemView, position);
                }
            });
        }
    }

    public Time getItem(int position){
        return times.get(position);
    }


    @Override
    public int getItemCount() {
        return times.size();
    }

    public static class TimesViewHolder extends RecyclerView.ViewHolder{

        TextView tvNome;
        TextView tvDescricao;
        ImageView ivTime;

        public TimesViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.tvCarro);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            ivTime = (ImageView) itemView.findViewById(R.id.ivTime);
        }
    }
}
