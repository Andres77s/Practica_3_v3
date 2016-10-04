package com.andresvanegas.practica3;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class clasificacionActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;//para navigation
    ListView list;
    private ActionBarDrawerToggle drawerToggle;
    private String[] opciones = new String[] { "principal", "perfil","Cerrar sesion"};//para navigation drawer
    TextView perfil, correo;
    String ur, cr;
    private ViewPager mViewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);
        Bundle extras = getIntent().getExtras();
        ur = extras.getString("usuario");
        cr = extras.getString("correo");

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
                        Intent main = new Intent(clasificacionActivity.this, MainActivity.class);
                        main.putExtra("usuario",ur);
                        main.putExtra("correo",cr);
                        startActivity(main);
                        finish();
                        break;
                    case 1:
                        Intent carta = new Intent(clasificacionActivity.this, PerfilActivity.class);
                        carta.putExtra("usuario",ur);
                        carta.putExtra("correo",cr);
                        startActivity(carta);
                        finish();
                        break;
                    case 2:
                        Intent cerrar = new Intent(clasificacionActivity.this, LogginActivity.class);
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

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };
        ActionBar.Tab tab = actionBar.newTab().setText("PASTAS").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("PIZZAS").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("DE TOMAR").setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelected(int position){
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });
    }
    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new PastasFragment();
                case 1: return new PizzasFragment();
                case 2: return new TomarFragment();
                default:return null;
            }

        }

        @Override
        public int getCount() {

            return 3;
        }
    }

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
