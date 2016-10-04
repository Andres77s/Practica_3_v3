package com.andresvanegas.practica3;

import android.content.Intent;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;//para navigation
    ListView list;
    private ActionBarDrawerToggle drawerToggle;
    private String[] opciones = new String[] { "principal", "carta", "Cerrar sesion"};//para navigation drawer
    TextView perfil, correo;
    String ur, cr, ur1, cr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ur = prefs.getString("usuario","02");
        cr = prefs.getString("correo","02");

        perfil = (TextView) findViewById(R.id.tpus);
        correo = (TextView) findViewById(R.id.tpcor);

        //Intent intent = new Intent(PerfilActivity.this, registroActivity.class);
        //startActivityForResult(intent, 13);
        Bundle extras = getIntent().getExtras();

        //ur=extras.getString("usuario");
        //cr=extras.getString("correo");

        perfil.setText(ur);
        correo.setText(cr);
        //---------------Navigation drawer------------------------------------------------
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        list = (ListView)findViewById(R.id.left_drawer);
        list.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent main = new Intent(PerfilActivity.this, MainActivity.class);
                        main.putExtra("usuario",ur);
                        main.putExtra("correo",cr);
                        startActivity(main);
                        finish();
                        break;
                    case 1:
                        Intent carta = new Intent(PerfilActivity.this, clasificacionActivity.class);
                        carta.putExtra("usuario",ur);
                        carta.putExtra("correo",cr);
                        startActivity(carta);
                        finish();
                        break;
                    case 2:
                        Intent cerrar = new Intent(PerfilActivity.this, LogginActivity.class);
                        cerrar.putExtra("usuario",ur);
                        cerrar.putExtra("correo",cr);
                        startActivity(cerrar);
                        finish();
                        break;
                }
                list.setItemChecked(1, true);
                drawerLayout.closeDrawer(list);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abierto, R.string.cerrado);
        drawerLayout.setDrawerListener(drawerToggle);
//-------------------------------------------------------------------------------------

            }
    /*@Override
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
    }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
   /* public  void algo(){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ur = prefs.getString("usuario","02");
        cr = prefs.getString("correo","02");
        ur1=ur;
        cr1=cr;

    }*/
   }