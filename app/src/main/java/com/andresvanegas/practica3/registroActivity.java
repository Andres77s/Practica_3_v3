package com.andresvanegas.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroActivity extends AppCompatActivity {

    Button rcancelar,raceptar;
    EditText usuario,contra,rcontra,email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        rcancelar = (Button) findViewById(R.id.rcancelar);
        raceptar = (Button) findViewById(R.id.raceptar);
        usuario = (EditText) findViewById(R.id.erusuario);
        contra = (EditText)findViewById(R.id.ercontra);
        rcontra = (EditText)findViewById(R.id.erpcontra);
        email = (EditText)findViewById(R.id.eemail);


        /*raceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent();
               // i.putExtra("usuario",usuario.getText().toString());
               // i.putExtra("contrasena",contra.getText().toString());
                //setResult(RESULT_OK,i);
                finish();
            }
        });*/
        raceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().isEmpty()||contra.getText().toString().isEmpty()
                        ||rcontra.getText().toString().isEmpty()||email.getText().toString().isEmpty()){
                    Toast.makeText(registroActivity.this,"faltan datos",Toast.LENGTH_SHORT).show();
                }
                else if (contra.getText().toString().equals(rcontra.getText().toString())){
                    Intent intent = new Intent();
                    intent.putExtra("usuario",usuario.getText().toString());
                    intent.putExtra("contrasena",contra.getText().toString());
                    intent.putExtra("correo", email.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }
                else{
                    //Toast is the pop up message
                    Toast.makeText(getApplicationContext(), "datos incorrectos",Toast.LENGTH_LONG).show();
                }
            }
        });

        rcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }


}
