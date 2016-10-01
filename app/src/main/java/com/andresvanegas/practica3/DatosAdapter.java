package com.andresvanegas.practica3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
/**
 * Created by Vanegas on 30/09/2016.
 */
public class DatosAdapter extends ArrayAdapter<DatoPromo> {
    public DatosAdapter(Context context, List<DatoPromo> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        // ¿Ya se infló este view?
        if (null == convertView) {
            //Si no existe, entonces inflarlo con image_list_view.xml
            convertView = inflater.inflate(
                    R.layout.list_item_datos,
                    parent,
                    false);

            holder = new ViewHolder();
            holder.avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.company = (TextView) convertView.findViewById(R.id.tv_company);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Lead actual.
        DatoPromo datoPromo = getItem(position);

        // Setup.
        holder.name.setText(datoPromo.getName());
        holder.title.setText(datoPromo.getTitle());
        holder.company.setText(datoPromo.getCompany());
        Glide.with(getContext()).load(datoPromo.getImage()).into(holder.avatar);

        return convertView;
    }

    static class ViewHolder {
        ImageView avatar;
        TextView name;
        TextView title;
        TextView company;
    }
}
