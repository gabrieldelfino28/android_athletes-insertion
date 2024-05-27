package br.edu.fateczl.athletesapp.model;

import androidx.annotation.NonNull;

public class AtletaSenior extends Atleta{
    private Boolean isCardiaco;

    public AtletaSenior() {
        super();
    }

    public Boolean getCardiaco() {
        return isCardiaco;
    }

    public void setCardiaco(Boolean cardiaco) {
        isCardiaco = cardiaco;
    }

    @NonNull
    @Override
    public String toString() {
        return  getNome() +
                ", " + getDataNasc() +
                ", " + getBairro() +
                ", " + getCardiaco();
    }
}
