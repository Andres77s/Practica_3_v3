package com.andresvanegas.practica3;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    TextView perfil, correo;
    String ur, cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        perfil = (TextView) findViewById(R.id.tpus);
        correo = (TextView) findViewById(R.id.tpcor);

        //Intent intent = new Intent(PerfilActivity.this, registroActivity.class);
        //startActivityForResult(intent, 13);
        Bundle extras = getIntent().getExtras();

        ur=extras.getString("usuario");
        cr=extras.getString("correo");

        perfil.setText(ur);
        correo.setText(cr);

            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_main:
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);

                intent.putExtra("usuario",ur);
                intent.putExtra("correo",cr);

                startActivity(intent);
                finish();
                break;
            case R.id.menu_perfil:
                break;


        }
        return true;
    }
   }