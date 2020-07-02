package com.example.controlef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.controlef.ui.dessimples.DesSimplesFragment;

import java.text.DecimalFormat;

public class DesSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.des_simples_activity);

        Button voltar = (Button) findViewById(R.id.voltar);
        voltar.setOnClickListener(clickReturn);

        Button calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(clickCalcular);
        }


     private View.OnClickListener clickReturn = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(DesSimples.this, MainActivity.class);
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
                double N = Double.parseDouble(Capital.getText().toString());

                EditText TaxaJ = (EditText) findViewById(R.id.taxaJ);
                double i = Double.parseDouble(TaxaJ.getText().toString());

                EditText Mes = (EditText) findViewById(R.id.mes);
                int n = Integer.parseInt(Mes.getText().toString());


                TextView calculo = (TextView) findViewById(R.id.resultado);
                TextView CalDeSi = (TextView) findViewById(R.id.CalculoDescontoS);

                Double Des = N - (N * i * 0.01 * n);
                Double CDS = N * i * 0.01 * n;

                if (Des>0) {
                calculo.setText("Valor Total = " + String.valueOf(rs.format(Des)) + " R$");
                CalDeSi.setText("Valor Desconto = " + String.valueOf(rs.format(CDS)) + " R$");
                }
                else {

                    calculo.setText("Valor Total = " + (rs.format(0.00))+ " R$");
                    CalDeSi.setText("Desconto Total");


                }

            }



            catch (Exception ex) {
                TextView calculo = (TextView) findViewById(R.id.resultado);
                TextView CDS = (TextView) findViewById(R.id.CalculoDescontoS);

                calculo.setText("Campos Vazios");
                CDS.setText("");

            }









        }
    };


}