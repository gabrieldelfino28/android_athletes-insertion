package br.edu.fateczl.athletesapp.control;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.athletesapp.model.Atleta;
import br.edu.fateczl.athletesapp.model.AtletaSenior;

public class AtletaSeniorControl implements IAtletaFactoryControl<Atleta>{
    @Override
    public Atleta createAtleta(String nome, String dataNasc, String bairro, String academia, int anosAcademia_or_record, boolean isCardiaco) {
        AtletaSenior at = new AtletaSenior();

        at.setNome(nome);
        at.setDataNasc(dataNasc);
        at.setBairro(bairro);
        at.setCardiaco(isCardiaco);

        return at;
    }
}
