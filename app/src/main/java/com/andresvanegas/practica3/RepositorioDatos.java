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
        saveLead(new DatoPromo("Pastas", "Sede: La mota", "Disponible el dia lunes.", R.drawable.lpasta));
        saveLead(new DatoPromo("Pizzas", "Sede: Laureles", "Disponible el dia martes", R.drawable.lpizzas));
        saveLead(new DatoPromo("mixtos", "Sede: Llanogrande", "Disponible el dia miercoles", R.drawable.lmixtos));
        saveLead(new DatoPromo("ensaladas", "Sede: La mota", "Disponible el dia jueves", R.drawable.lensalada));
        saveLead(new DatoPromo("licores", "Sede: Llanogrande", "Disponible el dia viernes", R.drawable.llicores));

    }

    private void saveLead(DatoPromo datoPromo) {
        leads.put(datoPromo.getId(), datoPromo);
    }

    public List<DatoPromo> getDatos() {
        return new ArrayList<>(leads.values());
    }
}
