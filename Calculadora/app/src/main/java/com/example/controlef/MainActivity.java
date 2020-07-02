package com.example.controlef;

import android.content.Intent;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;


import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button DesSim = (Button) findViewById(R.id.DesSim);
        DesSim.setOnClickListener(clicknext);
        Button JurSim = (Button) findViewById(R.id.JurSim);
        JurSim.setOnClickListener(clickJu);
        Button JurComp = (Button) findViewById(R.id.JurCom);
        JurComp.setOnClickListener(clickJuC);





    }


    private View.OnClickListener clicknext = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent SimDesIntent = new Intent(MainActivity.this, DesSimples.class);
            startActivity(SimDesIntent);
            finish();
        }

        };

    private View.OnClickListener clickJu = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent JuSiIntent = new Intent(MainActivity.this, JuSi.class);
            startActivity(JuSiIntent);
            finish();
        }

    };

    private View.OnClickListener clickJuC = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent JuCoIntent = new Intent(MainActivity.this, JuComp.class);
            startActivity(JuCoIntent);
            finish();
        }

    };



    }


