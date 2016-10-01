package com.andresvanegas.practica3;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class InfoPromo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_promo);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String datoNombre = (String) extras.get("nombre");//Obtengo el nombre

        switch (datoNombre){
            case "Pastas":
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Promo1 fragment = new Promo1();
                fragmentTransaction.add(R.id.contenedor, fragment);
                fragmentTransaction.commit();
                break;
            case "Pizzas":
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                Promo2 fragment1 = new Promo2();
                fragmentTransaction1.add(R.id.contenedor, fragment1);
                fragmentTransaction1.commit();
                //Toast.makeText(this, "Iniciar screen de detalle para: \n"+ datoNombre, Toast.LENGTH_SHORT).show();
                break;
            case "mixtos":
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                Promo3 fragment2 = new Promo3();
                fragmentTransaction2.add(R.id.contenedor, fragment2);
                fragmentTransaction2.commit();
                //Toast.makeText(this, "Iniciar screen de detalle para: \n"+ datoNombre, Toast.LENGTH_SHORT).show();
                break;
            case "ensaladas":
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                Promo4 fragment3 = new Promo4();
                fragmentTransaction3.add(R.id.contenedor, fragment3);
                fragmentTransaction3.commit();
                //Toast.makeText(this, "Iniciar screen de detalle para: \n"+ datoNombre, Toast.LENGTH_SHORT).show();
                break;
            case "licores":
                FragmentManager fragmentManager4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();
                Promo5 fragment4 = new Promo5();
                fragmentTransaction4.add(R.id.contenedor, fragment4);
                fragmentTransaction4.commit();
                //Toast.makeText(this, "Iniciar screen de detalle para: \n"+ datoNombre, Toast.LENGTH_SHORT).show();
                break;

        }
/*
        if(datoNombre == "Pastas") {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Promo1 fragment = new Promo1();
            fragmentTransaction.add(R.id.contenedor, fragment);
            fragmentTransaction.commit();
        }
        else {
            Toast.makeText(this, "Iniciar screen de detalle para: \n"+ datoNombre, Toast.LENGTH_SHORT).show();
        }
*/
    }
}

