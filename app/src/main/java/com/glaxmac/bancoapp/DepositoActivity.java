package com.glaxmac.bancoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.refactor.lib.colordialog.PromptDialog;

public class DepositoActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTNDEPOSITO;
    TextView LBLCUENTA, LBLSALDO;
    TextView TXTCANTIDAD, TXTCUENTA;

    String cuenta = "";
    Double saldo = 0.0;

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

        Bundle bundle = getIntent().getExtras();
        String cuenta2 = bundle.getString("identidificador");
        saldo = Double.parseDouble(bundle.getString("dataMoney"));

        String[] c = new String[4];
        c = cuenta2.split("-");

        cuenta = c[0].substring(0,3) + "-" + c[0].substring(3) + c[1]+c[2].substring(0,3) + "-" + c[2].substring(3) + "-" + c[3].substring(0,2);
        LBLCUENTA.setText(cuenta);
        LBLSALDO.setText(saldo+"");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_depositar:{
                Double data = Double.parseDouble(TXTCANTIDAD.getText().toString());
                String cuentita = TXTCUENTA.getText().toString();

                if(!cuentita.equals("")) {
                    if (data > saldo) {
                        new PromptDialog(DepositoActivity.this)
                                .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                                .setAnimationEnable(true)
                                .setTitleText("Error")
                                .setContentText("La cantidad a enviar es mayor a la cantidad que tiene en su cuenta")
                                .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                                    @Override
                                    public void onClick(PromptDialog dialog) {
                                        dialog.dismiss();
                                    }
                                }).show();
                    }
                }else{
                    new PromptDialog(DepositoActivity.this)
                            .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                            .setAnimationEnable(true)
                            .setTitleText("Error")
                            .setContentText("Ingrese la cuenta a enviar")
                            .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                                @Override
                                public void onClick(PromptDialog dialog) {
                                    dialog.dismiss();
                                }
                            }).show();
                }

            }break;
        }
    }

}
