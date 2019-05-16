package com.glaxmac.bancoapp.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.glaxmac.bancoapp.Modelo.SaldoCajeroBean;
import com.glaxmac.bancoapp.R;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void realizarRetiro() {

        String cantidadRetiro = TXTCANTIDAD.getText().toString();

        if (!cantidadRetiro.equals("")) {

            Double retiro = Double.parseDouble(cantidadRetiro);

            if (retiro == 10.00 || retiro == 20.00 || retiro == 50.00 || retiro == 100.00 || retiro == 200.00) {

                if (retiro > saldo) {
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
                } else {
                    String info = SaldoaRetirar(retiro);
                    new PromptDialog(RetiroActivity.this)
                            .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                            .setAnimationEnable(true)
                            .setTitleText("ÉXITO EN PROCESO")
                            .setContentText(info)
                            .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                                @Override
                                public void onClick(PromptDialog dialog) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
            } else {
                new PromptDialog(RetiroActivity.this)
                        .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                        .setAnimationEnable(true)
                        .setTitleText("Error")
                        .setContentText("Las cantidades de retiro son\n" +
                                "S/. 10.00\n" +
                                "S/. 20.00\n" +
                                "S/. 50.00\n" +
                                "S/. 100.00\n" +
                                "S/. 200.00\n")
                        .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                            @Override
                            public void onClick(PromptDialog dialog) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        }else{
            new PromptDialog(RetiroActivity.this)
                    .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                    .setAnimationEnable(true)
                    .setTitleText("Error")
                    .setContentText("Ingrese la Cantidad a Retirar")
                    .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                        @Override
                        public void onClick(PromptDialog dialog) {
                            dialog.dismiss();
                        }
                    }).show();
        }
    }

    public String SaldoaRetirar(Double saldo){

        Double arraySaldoTot [] = {10.00,10.00,20.00,20.00,50.00,50.00,100.00,100.00,100.00,200.00};

        Double arrayDouble [] = new Double[arraySaldoTot.length];

        int position = 0;


        for ( int i = 0 ; i < arraySaldoTot.length; i++) {
            if(arraySaldoTot[i] <= saldo){
                arrayDouble[position] = arraySaldoTot[i];
                position++;
            }
        }

        Double finaly = 0.0;
        Double aux;

        for (int i = 0;i < arrayDouble.length;i++){
            for (int j = i+1 ;j< arrayDouble.length;j++) {
                if (arrayDouble[i] != null && arrayDouble[j] != null) {
                    if (arrayDouble[i] < arrayDouble[j]) {
                        aux = arrayDouble[i];
                        arrayDouble[i] = arrayDouble[j];
                        arrayDouble[j] = aux;
                    }
                }
            }
        }
        int position22 = 0;
        Double arrayTotalEterno [] = new Double[arrayDouble.length];

        for (int i = 0;i < arrayDouble.length;i++) {
            if(arrayDouble[i]!= null) {
                if (finaly < saldo) {
                    finaly = finaly + arrayDouble[i];
                    arrayTotalEterno[position22] = arrayDouble[i];
                }
            }
        }
        String mensaje = "Se hizo uso de ";
        int cantidad = 0;
        String mensajeComplemento = "";

        for (int i = 0;i < arrayTotalEterno.length;i++) {
            if(arrayTotalEterno[i]!= null) {
                cantidad++;
                mensajeComplemento = mensajeComplemento + arrayTotalEterno[i]+"";
            }
        }

        String asd = mensaje+ " "+cantidad+" billete(s),\n se usaron las sgtes. cantidades: "+mensajeComplemento;

        return asd;
    }
}
