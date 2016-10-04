package com.andresvanegas.practica3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PromoFragment extends Fragment {

    private ListView mLeadsList;
    private DatosAdapter mLeadsAdapter;

    public PromoFragment() {
        // Required empty public constructor
    }
    public static PromoFragment newInstance(/*parámetros*/) {
        PromoFragment fragment = new PromoFragment();
        // Setup parámetros
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Gets parámetros
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_promo, container, false);

        // Instancia del ListView.
        mLeadsList = (ListView) root.findViewById(R.id.leads_list);

        // Inicializar el adaptador con la fuente de datos.
        mLeadsAdapter = new DatosAdapter(getActivity(),
                RepositorioDatos.getInstance().getDatos());

        //Relacionando la lista con el adaptador
        mLeadsList.setAdapter(mLeadsAdapter);

        // Eventos
        mLeadsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DatoPromo currentLead = mLeadsAdapter.getItem(position);

                Intent explicit_intent;//Declaro el Intent

                //Instanciamos el Intent dandole:
                // el contexto y la clase a la cual nos deseamos dirigir
                explicit_intent = new Intent(getActivity(), InfoPromo.class);
                //String auxEdiNombre=ediNombre.getText().toString();
                //String auxEdiTelefono=ediTelefono.getText().toString();

                explicit_intent.putExtra("nombre",currentLead.getName());//Guardamos una cadena
                //explicit_intent.putExtra("telefono",auxEdiTelefono);//Guardamos un entero

                //lo iniciamos pasandole la intencion, con todos sus parametros guardados
                startActivity(explicit_intent);
               // Toast.makeText(getActivity(),"Iniciar screen de detalle para: \n" + currentLead.getName(),
                 //       Toast.LENGTH_SHORT).show();
            }
        });

        setHasOptionsMenu(true);
        return root;
    }

}
