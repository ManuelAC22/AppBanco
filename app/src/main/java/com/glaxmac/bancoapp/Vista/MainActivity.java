package com.glaxmac.bancoapp.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.glaxmac.bancoapp.R;

import cn.refactor.lib.colordialog.PromptDialog;

public class MainActivity extends AppCompatActivity {

    ImageView imagenMensaje;

    EditText cardIdOne1,cardIdDow2,cardIdTree3,cardIdFour4,contrasenaController;
    Button btnIngresar;

    int datoCantidad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenMensaje = findViewById(R.id.imagenMensaje);
        cardIdOne1 = findViewById(R.id.cardIdOne1);
        cardIdDow2 = findViewById(R.id.cardIdDow2);
        cardIdTree3 = findViewById(R.id.cardIdTree3);
        cardIdFour4 = findViewById(R.id.cardIdFour4);
        contrasenaController = findViewById(R.id.contrasenaController);
        btnIngresar = findViewById(R.id.btnIngresar);




        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String indenti = "1324-4567-7891-1234";//cardIdOne1.getText()+"-"+cardIdDow2.getText()+"-"+cardIdTree3.getText()+"-"+cardIdFour4.getText();
                String pass = contrasenaController.getText().toString();

               // if((indenti.equals("1324-4567-7891-1234") && pass.equals("132456")) || (indenti.equals("9876-6541-4895-6547") && pass.equals("123459"))) {
                    Intent intent = new Intent(MainActivity.this, CuentasActivity.class);
                    intent.putExtra("identidificador", indenti+"");
                   // if(indenti.equals("1324-4567-7891-1234")){
                        intent.putExtra("dataMoney", "100");
                   // }else if (indenti.equals("9876-6541-4895-6547")){
                       // intent.putExtra("dataMoney", "250");
                   // }
                    startActivity(intent);

                    datoCantidad = 0;
              /*  }else{
                    datoCantidad = datoCantidad +1;

                    new PromptDialog(MainActivity.this)
                            .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                            .setAnimationEnable(true)
                            .setTitleText("Error")
                            .setContentText("Las credenciales no son correctas, por favor ingrese otra vez, Te quedan "+(3-datoCantidad)+" intentos")
                            .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                                @Override
                                public void onClick(PromptDialog dialog) {
                                    dialog.dismiss();
                                }
                            }).show();
                    contrasenaController.setText("");

                    if(datoCantidad == 3) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                }*/
            }
        });

        imagenMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PromptDialog(MainActivity.this)
                        .setDialogType(PromptDialog.DIALOG_TYPE_INFO)
                        .setAnimationEnable(true)
                        .setTitleText("Información")
                        .setContentText("No deben compartir su contraseña y recuerde que son 6 dígitos")
                        .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                            @Override
                            public void onClick(PromptDialog dialog) {
                                /*SharedPreferences.Editor editor = sharedpreferencesIni.edit();
                                editor.putString("actualCursoComparativo", identidificadorCurso);
                                editor.commit();
                                Intent intent = new Intent(InformacionCursoActivity.this, InformacionInstitucionActivity.class);
                                intent.putExtra("identidificador", "UA");
                                startActivity(intent);*/
                                dialog.dismiss();
                            }
                        }).show();
            }
        });


    }
}
