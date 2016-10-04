package com.andresvanegas.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String ur, cr;
    private String[] opciones = new String[] { "Carta", "Perfil","cerrar sesion"};//para navigation drawer
    private DrawerLayout drawerLayout;//para navigation
    ListView list;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //    Bundle extras = getIntent().getExtras();
//        ur = extras.getString("usuario");
  //      cr = extras.getString("correo");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent carta = new Intent(MainActivity.this, clasificacionActivity.class);
                        carta.putExtra("usuario",ur);
                        carta.putExtra("correo",cr);
                        startActivity(carta);
                        finish();
                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                        intent.putExtra("usuario",ur);
                        intent.putExtra("correo",cr);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        Intent cerrar = new Intent(MainActivity.this, LogginActivity.class);
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
/*-----------------por el menu de overflow--------------------
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
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
