package com.example.rm31675.navigationview;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rm31675.navigationview.model.Time;
import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    private ImageView ivTime;
    private CollapsingToolbarLayout ctblNome;
    private TextView tvDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);


        if(getIntent()!=null){

            tvDescricao = (TextView) findViewById(R.id.tvDescricaoDetalhe);
            ivTime = (ImageView) findViewById(R.id.ivFotoDetalhe);
            ctblNome = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

            Time time = getIntent().getParcelableExtra("time");

            ctblNome.setTitle(time.getNome());
            tvDescricao.setText("Fundado em " + time.getEstado() + ", no ano de " + time.getAnofundacao());
            Picasso.with(getBaseContext()).load(time.getEscudo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivTime);

        }
    }
}
