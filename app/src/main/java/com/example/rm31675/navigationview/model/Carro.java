package com.example.rm31675.navigationview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rm31675 on 19/11/2016.
 */
public class Carro {
    private String nome;

    @SerializedName("desc")
    private String descricao;
    private String foto;





    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
