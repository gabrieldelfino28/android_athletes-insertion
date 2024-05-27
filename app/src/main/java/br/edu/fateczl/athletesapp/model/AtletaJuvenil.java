package br.edu.fateczl.athletesapp.model;

import androidx.annotation.NonNull;

public class AtletaJuvenil extends Atleta {
    private int qtdAnosEsporte;

    public AtletaJuvenil() {
        super();
    }

    public int getQtdAnosEsporte() {
        return qtdAnosEsporte;
    }

    public void setQtdAnosEsporte(int qtdAnosEsporte) {
        this.qtdAnosEsporte = qtdAnosEsporte;
    }

    @NonNull
    @Override
    public String toString() {
        return  getNome() +
                ", " + getDataNasc() +
                ", " + getBairro() +
                ", " + getQtdAnosEsporte();
    }
}
