package com.andresvanegas.practica3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity implements View.OnClickListener {

    Button registrar, ingresar;
    EditText usuario, contrasena;
    String ur,con,cr;
    String ur1="",con1="",cr1;
    Bundle extras;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        registrar = (Button) findViewById(R.id.bregistrar);
        ingresar = (Button) findViewById(R.id.bingresar);
        usuario = (EditText) findViewById(R.id.eusuario);
        contrasena = (EditText) findViewById(R.id.econtrasena);

        registrar.setOnClickListener(this);
        ingresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.bregistrar:
                Intent intent = new Intent(this, registroActivity.class);
                startActivityForResult(intent, 12);
                break;
            case R.id.bingresar:
                prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                if(usuario.getText().toString().isEmpty() || contrasena.getText().toString().isEmpty()) {
                    Toast.makeText(this ,"Faltan datos",Toast.LENGTH_SHORT).show();
                }else if(prefs.getString("usuario","02").length()==0){
                    Toast.makeText(getApplicationContext(),"Usuario no Registrado",Toast.LENGTH_SHORT).show();
                }
                else if(usuario.getText().toString().equals(ur) || usuario.getText().toString().equals(prefs.getString("usuario","01"))
                        && contrasena.getText().toString().equals(con) || contrasena.getText().toString().equals(prefs.getString("contrasena","02"))){
                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    intent1.putExtra("usuario",ur);
                    intent1.putExtra("correo",cr);
                    startActivity(intent1);
                    finish();
                }

                else {
                    Toast.makeText(this ,"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 12 && resultCode == RESULT_OK) {
            prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            editor = prefs.edit();
            String user = data.getExtras().getString("usuario");
            String contrasena = data.getExtras().getString("contrasena");
            String correo = data.getExtras().getString("correo");
            ur = user;
            con = contrasena;
            cr = correo;

            /*ur1=extras.getString("usuario");
            con1=extras.getString("contrasena");
            cr1=extras.getString("correo");
            */

            //Log.d("user",user);
            //Log.d("contraseña",contrasena);
            Toast.makeText(this, "user: " + user + " contrasena:" + contrasena, Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 12 && resultCode == RESULT_CANCELED) {
            //Log.d("mensaje","no se cargaron datos");
            Toast.makeText(this, "no se cargo nada", Toast.LENGTH_SHORT).show();
        }


    }
}




