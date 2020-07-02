package com.example.controlef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class JuComp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_comp);
        Button voltar = (Button) findViewById(R.id.voltar);
        voltar.setOnClickListener(clickReturn);


        Button calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(clickCalcular);


    }


    private View.OnClickListener clickReturn = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(JuComp.this, MainActivity.class);
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
                TextView CalJuCo = (TextView) findViewById(R.id.CalculoJurosC);

                Double JuCo = C * Math.pow((1+(0.01*i)),t);
                Double CJC = JuCo - C;
                calculo.setText("Valor Total = " + String.valueOf(rs.format(JuCo)) + " R$");
                CalJuCo.setText("Total dos Juros = " + String.valueOf(rs.format(CJC)) + " R$");
            }

            catch (Exception ex) {
                TextView calculo = (TextView) findViewById(R.id.resultado);
                TextView CalJuCo = (TextView) findViewById(R.id.CalculoJurosC);
                calculo.setText("Campos Vazios");
                CalJuCo.setText("");

            }


        }
    };
}

