package br.edu.fateczl.athletesapp.control;

public interface IAtletaFactoryControl<E> {
    E createAtleta(String nome, String dataNasc, String bairro, String academia, int anosEsporte_or_record, boolean isCardiaco);
}
