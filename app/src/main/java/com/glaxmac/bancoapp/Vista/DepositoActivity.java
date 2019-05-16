package com.glaxmac.bancoapp.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.glaxmac.bancoapp.R;

import java.util.ArrayList;

import cn.refactor.lib.colordialog.PromptDialog;

public class DepositoActivity extends AppCompatActivity {

    Button BTNDEPOSITO;
    TextView LBLCUENTA, LBLSALDO;
    TextView TXTCANTIDAD, TXTCUENTA;
    ListView listadoDepositos;

    String cuenta = "";
    Double saldo = 0.0;
    Double salfoOld = 0.0;

    ArrayList datosDocente;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        LBLCUENTA = findViewById(R.id.lbl_cuenta);
        LBLSALDO = findViewById(R.id.lbl_saldo);

        BTNDEPOSITO = findViewById(R.id.btn_depositar);
        TXTCANTIDAD = findViewById(R.id.txt_cantidad);
        TXTCUENTA = findViewById(R.id.txt_cuenta);
        listadoDepositos = findViewById(R.id.listadoDepositos);

        Bundle bundle = getIntent().getExtras();
        saldo = Double.parseDouble(bundle.getString("dataMoney"));

        cuenta = bundle.getString("identidificador");
        LBLCUENTA.setText(cuenta);
        LBLSALDO.setText(saldo+"");

        datosDocente = new ArrayList<String>();

        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosDocente);
        listadoDepositos.setAdapter(adaptador);

        BTNDEPOSITO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String cuentita = TXTCUENTA.getText().toString();

                if(!cuentita.equals("")) {
                    String cant = TXTCANTIDAD.getText().toString();
                    if(!cant.equals("")) {
                        final Double data = Double.parseDouble(cant);
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
                        } else {
                            new PromptDialog(DepositoActivity.this)
                                    .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                                    .setAnimationEnable(true)
                                    .setTitleText("Éxito")
                                    .setContentText("Se envió la cantidad ingresada a la cuenta")
                                    .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                                        @Override
                                        public void onClick(PromptDialog dialog) {
                                            dialog.dismiss();
                                            Double nuevaCantidad = saldo - data;
                                            LBLSALDO.setText(nuevaCantidad + "");
                                            saldo = nuevaCantidad;
                                            salfoOld = nuevaCantidad;

                                            datosDocente.add("Cuenta: "+TXTCUENTA.getText().toString() + "  Cantidad:"+ TXTCANTIDAD.getText().toString());
                                            adaptador.notifyDataSetChanged();

                                            TXTCUENTA.setText("");
                                            TXTCANTIDAD.setText("");
                                        }
                                    }).show();
                        }
                    }else{
                        new PromptDialog(DepositoActivity.this)
                                .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                                .setAnimationEnable(true)
                                .setTitleText("Error")
                                .setContentText("Ingrese la cantidad a enviar")
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
            }
        });

    }

}
