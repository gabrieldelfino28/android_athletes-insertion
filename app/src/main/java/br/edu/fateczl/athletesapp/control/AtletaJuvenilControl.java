package br.edu.fateczl.athletesapp.control;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.athletesapp.model.Atleta;
import br.edu.fateczl.athletesapp.model.AtletaJuvenil;

public class AtletaJuvenilControl implements IAtletaFactoryControl<Atleta> {

    @Override
    public Atleta createAtleta(String nome, String dataNasc, String bairro, String academia, int anosEsporte, boolean isCardiaco) {
        AtletaJuvenil at = new AtletaJuvenil();

        at.setNome(nome);
        at.setDataNasc(dataNasc);
        at.setBairro(bairro);
        at.setQtdAnosEsporte(anosEsporte);

        return at;
    }

}
