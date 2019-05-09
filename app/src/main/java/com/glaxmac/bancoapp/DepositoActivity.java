package com.glaxmac.bancoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DepositoActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTNDEPOSITO;
    TextView LBLCUENTA, LBLSALDO;
    TextView TXTCANTIDAD, TXTCUENTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        LBLCUENTA = findViewById(R.id.lbl_cuenta);
        LBLSALDO = findViewById(R.id.lbl_saldo);

        BTNDEPOSITO = findViewById(R.id.btn_depositar);
        TXTCANTIDAD = findViewById(R.id.txt_cantidad);
        TXTCUENTA = findViewById(R.id.txt_cuenta);

        BTNDEPOSITO.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_depositar:{

            }break;
        }
    }

}
