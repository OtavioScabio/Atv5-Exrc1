package com.example.atv5_exrc1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.Random;


import java.util.ArrayList;
import java.util.List;

/* Otávio Gabriel Ribeiro Scabio - 1110482223043 */
public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupDados;
    private Spinner spinnerDados;
    private Button buttonRolar;
    private TextView textViewResultado;




    private int[] tiposDeDado = {4, 6, 8, 10, 12, 20, 100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroupDados = findViewById(R.id.radioGroupDados);
        spinnerDados = findViewById(R.id.spinnerDados);
        buttonRolar = findViewById(R.id.buttonRolar);
        textViewResultado = findViewById(R.id.textViewResultado);

        preencherSpiner ();
        buttonRolar.setOnClickListener(op-> gerar());

    }

    private void gerar() {
        int quantidadeDeDados = Integer.parseInt(spinnerDados.getSelectedItem().toString());
        int tipoDeDado = getTipoDeDado();

        if (tipoDeDado == 0) {
            textViewResultado.setText("Por favor, selecione um dado.");
            return;
        }

        StringBuilder resultados = new StringBuilder("Resultados: ");
        Random random = new Random();

        for (int i = 0; i < quantidadeDeDados; i++) {
            int resultado = random.nextInt(tipoDeDado) + 1;
            resultados.append(resultado).append(" , ");
        }

        textViewResultado.setText(resultados.toString());
    }

    private int getTipoDeDado() {
        int selectedId = radioGroupDados.getCheckedRadioButtonId();

        if (selectedId == R.id.radioD4) {
            return tiposDeDado[0];
        } else if (selectedId == R.id.radioD6) {
            return tiposDeDado[1];
        } else if (selectedId == R.id.radioD8) {
            return tiposDeDado[2];
        } else if (selectedId == R.id.radioD10) {
            return tiposDeDado[3];
        } else if (selectedId == R.id.radioD12) {
            return tiposDeDado[4];
        } else if (selectedId == R.id.radioD20) {
            return tiposDeDado[5];
        } else if (selectedId == R.id.radioD100) {
            return tiposDeDado[6];
        } else {
            return 0;
        }
    }

    private void preencherSpiner(){
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDados.setAdapter(adapter);

    }


}