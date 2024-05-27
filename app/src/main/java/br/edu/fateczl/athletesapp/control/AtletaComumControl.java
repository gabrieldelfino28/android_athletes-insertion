package br.edu.fateczl.athletesapp.control;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.athletesapp.model.Atleta;
import br.edu.fateczl.athletesapp.model.AtletaComum;

public class AtletaComumControl implements IAtletaFactoryControl<Atleta> {
    @Override
    public Atleta createAtleta(String nome, String dataNasc, String bairro, String academia, int recorde, boolean isCardiaco) {
        AtletaComum at = new AtletaComum();

        at.setNome(nome);
        at.setDataNasc(dataNasc);
        at.setBairro(bairro);
        at.setAcademia(academia);
        at.setRecordeSeg(recorde);

        return at;
    }
}
