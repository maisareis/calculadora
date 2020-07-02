package com.example.controlef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class JuSi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_si);


        Button voltar = (Button) findViewById(R.id.voltar);
        voltar.setOnClickListener(clickReturn);
        Button calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(clickCalcular);
    }


    private View.OnClickListener clickReturn = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(JuSi.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    };

    private View.OnClickListener clickCalcular = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        DecimalFormat rs = new DecimalFormat("#0.00");

        try {
            EditText Capital = (EditText) findViewById(R.id.capital);
            double C = Double.parseDouble(Capital.getText().toString());

            EditText TaxaJ = (EditText) findViewById(R.id.taxaJ);
            double i = Double.parseDouble(TaxaJ.getText().toString());

            EditText Mes = (EditText) findViewById(R.id.mes);
            int t = Integer.parseInt(Mes.getText().toString());


            TextView calculo = (TextView) findViewById(R.id.resultado);
            TextView CalJuSi = (TextView) findViewById(R.id.CalculoJurosS);

            Double JuSi = C + (C * i * 0.01 * t);
            Double CJS =  C * i * 0.01 * t;
            calculo.setText("Valor Total = " + String.valueOf(rs.format(JuSi)) + " R$");
            CalJuSi.setText("Valor dos Juros = " + String.valueOf(rs.format(CJS)) + " R$");

        }

        catch (Exception ex) {
            TextView calculo = (TextView) findViewById(R.id.resultado);
            TextView CalJuSi = (TextView) findViewById(R.id.CalculoJurosS);

            calculo.setText("Campos Vazios");
            CalJuSi.setText("");
        }


        }
    };
}