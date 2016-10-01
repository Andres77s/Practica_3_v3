package com.andresvanegas.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String ur, cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        ur = extras.getString("usuario");
        cr = extras.getString("correo");

        //}

        //------------para listview promociones---------------------
        PromoFragment promoFragment = (PromoFragment)
                getSupportFragmentManager().findFragmentById(R.id.datos_container);

        if (promoFragment == null) {
            promoFragment = PromoFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.datos_container, promoFragment)
                    .commit();
        }
    }
    //----------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_perfil:
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("usuario",ur);
                intent.putExtra("correo",cr);
                startActivity(intent);
                finish();
                break;
            case R.id.menu_main:
                break;
            case R.id.menu_carta:
                Intent carta = new Intent(MainActivity.this, clasificacionActivity.class);
                startActivity(carta);
                finish();

        }
        return true;
    }


}
