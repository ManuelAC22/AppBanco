package com.glaxmac.bancoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CuentasActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTNRETIRO, BTNDEPOSITO;
    TextView LBLCUENTA, LBLSALDO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);

        LBLCUENTA = findViewById(R.id.lbl_cuenta);
        LBLSALDO = findViewById(R.id.lbl_saldo);

        BTNRETIRO = findViewById(R.id.btn_retiro);
        BTNDEPOSITO = findViewById(R.id.btn_deposito);

        BTNRETIRO.setOnClickListener(this);
        BTNDEPOSITO.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_deposito:{

            }break;
            case R.id.btn_retiro:{

            }break;
        }
    }
}
