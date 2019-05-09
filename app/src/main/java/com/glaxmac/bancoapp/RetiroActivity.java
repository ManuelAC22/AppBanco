package com.glaxmac.bancoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RetiroActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTNRETIRO;
    TextView LBLCUENTA, LBLSALDO;
    TextView TXTCANTIDAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retiro);

        LBLCUENTA = findViewById(R.id.lbl_cuenta);
        LBLSALDO = findViewById(R.id.lbl_saldo);

        BTNRETIRO = findViewById(R.id.btn_retirar);
        TXTCANTIDAD = findViewById(R.id.txt_cantidad);

        BTNRETIRO.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_retirar:{

            }break;
        }
    }
}
