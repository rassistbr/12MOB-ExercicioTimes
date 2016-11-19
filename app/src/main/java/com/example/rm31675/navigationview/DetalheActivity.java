package com.example.rm31675.navigationview;

import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rm31675.navigationview.model.Carro;
import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    private ImageView ivCarro;
    private CollapsingToolbarLayout ctblNome;
    private TextView tvDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);


        if(getIntent()!=null){

            tvDescricao = (TextView) findViewById(R.id.tvDescricaoDetalhe);
            ivCarro = (ImageView) findViewById(R.id.ivFotoDetalhe);
            ctblNome = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

            Carro carro = getIntent().getParcelableExtra("carro");

            ctblNome.setTitle(carro.getNome());
            tvDescricao.setText(carro.getDescricao());
            Picasso.with(getBaseContext()).load(carro.getFoto())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivCarro);


            //Toast.makeText(this, carro.getNome(), Toast.LENGTH_SHORT).show();
        }
    }
}
