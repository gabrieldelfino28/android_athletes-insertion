package br.edu.fateczl.athletesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.fateczl.athletesapp.control.AtletaComumControl;
import br.edu.fateczl.athletesapp.control.IAtletaFactoryControl;
import br.edu.fateczl.athletesapp.model.Atleta;

public class AtletaComumFragment extends Fragment {

    private View view;

    private EditText inNomeAC;
    private EditText inDataNascAC;
    private EditText inBairroAC;
    private EditText inAcademia;
    private EditText inRecord;


    public AtletaComumFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_comum, container, false);

        inNomeAC = view.findViewById(R.id.inNomeAC);
        inDataNascAC = view.findViewById(R.id.inDataNascAC);
        inBairroAC = view.findViewById(R.id.inBairroAC);
        inAcademia = view.findViewById(R.id.inQtdAnos);
        inRecord = view.findViewById(R.id.inRecorde);
        Button btnInsert = view.findViewById(R.id.btnInsertAC);
        btnInsert.setOnClickListener(insert -> {
            try {
                cadastroAtleta();
            } catch (Exception e) {
                Toast.makeText(view.getContext(), R.string.err, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


    private void cadastroAtleta() throws Exception{
        IAtletaFactoryControl<Atleta> IFactory = new AtletaComumControl();

        String nome = inNomeAC.getText().toString();
        String dataNasc = inDataNascAC.getText().toString();
        String bairro = inBairroAC.getText().toString();
        String academia = inAcademia.getText().toString();
        verifyStrings(nome,dataNasc,bairro,academia);

        int recorde = Integer.parseInt(inRecord.getText().toString());

        Atleta at = IFactory.createAtleta(nome, dataNasc, bairro, academia, recorde, false);
        Toast.makeText(view.getContext(), at.toString(), Toast.LENGTH_LONG).show();
    }

    private void verifyStrings(String n1, String n2, String n3, String n4) throws Exception {
        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty() || n4.isEmpty()) {
            throw new Exception("Err: empty str");
        }
    }
}