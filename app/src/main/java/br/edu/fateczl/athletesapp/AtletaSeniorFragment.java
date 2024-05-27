package br.edu.fateczl.athletesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import br.edu.fateczl.athletesapp.control.AtletaSeniorControl;
import br.edu.fateczl.athletesapp.control.IAtletaFactoryControl;
import br.edu.fateczl.athletesapp.model.Atleta;

public class AtletaSeniorFragment extends Fragment {
    private View view;

    private EditText inNomeAC;
    private EditText inDataNascAC;
    private EditText inBairroAC;

    private RadioButton rbNo;
    private RadioButton rbYes;


    public AtletaSeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_senior, container, false);

        inNomeAC = view.findViewById(R.id.inNomeAC);
        inDataNascAC = view.findViewById(R.id.inDataNascAC);
        inBairroAC = view.findViewById(R.id.inBairroAC);

        rbNo = view.findViewById(R.id.rbNo);
        rbYes = view.findViewById(R.id.rbYes);

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

    private void cadastroAtleta() throws Exception {
        IAtletaFactoryControl<Atleta> IFactory = new AtletaSeniorControl();

        String nome = inNomeAC.getText().toString();
        String dataNasc = inDataNascAC.getText().toString();
        String bairro = inBairroAC.getText().toString();
        verifyStrings(nome,dataNasc,bairro);

        boolean isCardiaco = checkRadioButton();

        Atleta at = IFactory.createAtleta(nome, dataNasc, bairro, null, 0, isCardiaco);
        Toast.makeText(view.getContext(), at.toString(), Toast.LENGTH_LONG).show();
    }

    private void verifyStrings(String n1, String n2, String n3) throws Exception {
        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty()) {
            throw new Exception("Err: empty str");
        }
    }

    private boolean checkRadioButton() {
        return !rbNo.isChecked();
    }
}