package com.glaxmac.bancoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import cn.refactor.lib.colordialog.PromptDialog;

public class MainActivity extends AppCompatActivity {

    ImageView imagenMensaje;

    EditText cardIdOne1,cardIdDow2,cardIdTree3,cardIdFour4,contrasenaController;
    Button btnIngresar;

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
                Intent intent = new Intent(MainActivity.this, CuentasActivity.class);
                intent.putExtra("identidificador", cardIdOne1+"-"+cardIdDow2+"-"+cardIdTree3+"-"+cardIdFour4);
                startActivity(intent);
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
