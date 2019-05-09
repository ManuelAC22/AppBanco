package com.glaxmac.bancoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.refactor.lib.colordialog.PromptDialog;

public class RetiroActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTNRETIRO;
    TextView LBLCUENTA, LBLSALDO;
    TextView TXTCANTIDAD;

    String cuenta = "";
    Double saldo = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retiro);

        LBLCUENTA = findViewById(R.id.lbl_cuenta);
        LBLSALDO = findViewById(R.id.lbl_saldo);

        BTNRETIRO = findViewById(R.id.btn_retirar);
        TXTCANTIDAD = findViewById(R.id.txt_cantidad);

        BTNRETIRO.setOnClickListener(this);



        Bundle bundle = getIntent().getExtras();
        cuenta = bundle.getString("identidificador");
        saldo = Double.parseDouble(bundle.getString("dataMoney"));

        LBLCUENTA.setText(cuenta);
        LBLSALDO.setText("S/. "+saldo);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_retirar:{
                realizarRetiro();
            }break;
        }
    }

    public void realizarRetiro(){
        Double retiro = Double.parseDouble(TXTCANTIDAD.getText().toString());

        if(retiro>saldo){
            new PromptDialog(RetiroActivity.this)
                    .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                    .setAnimationEnable(true)
                    .setTitleText("Error")
                    .setContentText("No cuenta con el saldo suficiente para realizar el retiro")
                    .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                        @Override
                        public void onClick(PromptDialog dialog) {
                            dialog.dismiss();
                        }
                    }).show();
        }else{
            new PromptDialog(RetiroActivity.this)
                    .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                    .setAnimationEnable(true)
                    .setTitleText("ÉXITO EN PROCESO")
                    .setContentText("ACERQUESE A LA VENTANILLA PARA OBTENER EL DINERO")
                    .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                        @Override
                        public void onClick(PromptDialog dialog) {
                            dialog.dismiss();
                            finish();
                        }
                    }).show();
        }
    }
}
