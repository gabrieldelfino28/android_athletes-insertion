package br.edu.fateczl.athletesapp.model;

import androidx.annotation.NonNull;

public class AtletaComum extends Atleta {
    private String Academia;
    private int recordeSeg;

    public AtletaComum() {
        super();
    }

    public String getAcademia() {
        return Academia;
    }

    public void setAcademia(String academia) {
        Academia = academia;
    }

    public int getRecordeSeg() {
        return recordeSeg;
    }

    public void setRecordeSeg(int recordeSeg) {
        this.recordeSeg = recordeSeg;
    }

    @NonNull
    @Override
    public String toString() {
        return  getNome() +
                ", " + getDataNasc() +
                ", " + getBairro() +
                ", " + getAcademia() +
                ", " + getRecordeSeg();
    }
}
