package com.andresvanegas.practica3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by Vanegas on 30/09/2016.
 */
public class RepositorioDatos {
    private static RepositorioDatos repository = new RepositorioDatos();
    private HashMap<String, DatoPromo> leads = new HashMap<>();

    public static RepositorioDatos getInstance() {
        return repository;
    }

    private RepositorioDatos() {
        saveLead(new DatoPromo("Pastas", "CEO", "Insures S.O.", R.drawable.lpasta));
        saveLead(new DatoPromo("Pizzas", "Asistente", "Hospital Blue", R.drawable.lpizzas));
        saveLead(new DatoPromo("mixtos", "Directora de Marketing", "Electrical Parts ltd", R.drawable.lmixtos));
        saveLead(new DatoPromo("ensaladas", "Diseñadora de Producto", "Creativa App", R.drawable.lensalada));
        saveLead(new DatoPromo("licores", "Supervisor de Ventas", "Neumáticos Press", R.drawable.llicores));

    }

    private void saveLead(DatoPromo datoPromo) {
        leads.put(datoPromo.getId(), datoPromo);
    }

    public List<DatoPromo> getDatos() {
        return new ArrayList<>(leads.values());
    }
}
