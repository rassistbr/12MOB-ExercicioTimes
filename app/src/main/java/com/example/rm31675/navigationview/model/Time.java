package com.example.rm31675.navigationview.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rm31675 on 19/11/2016.
 */
public class Time implements Parcelable{

    private String nome;
    private String estado;
    private String escudo;
    private String anofundacao;

    protected Time(Parcel in) {
        nome = in.readString();
        estado = in.readString();
        escudo = in.readString();
        anofundacao = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(estado);
        dest.writeString(escudo);
        dest.writeString(anofundacao);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Time> CREATOR = new Creator<Time>() {
        @Override
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getAnofundacao() {
        return anofundacao;
    }

    public void setAnofundacao(String anofundacao) {
        this.anofundacao = anofundacao;
    }
}
