package com.tasya.restoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tasya.restoapp.R;
import com.tasya.restoapp.model.Menus;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>  {
    ArrayList<Menus> menus;
    Context context;
    LayoutInflater layoutInflater;
    public MenuAdapter (ArrayList<Menus> menus, Context context){
        this.menus = menus;
        this.context = context;
        layoutInflater = (LayoutInflater.from(context));
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View t = layoutInflater.inflate(R.layout.item_menu, parent, false);
        MenuAdapter.ViewHolder ts = new MenuAdapter.ViewHolder(t);
        return ts;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Menus menu = menus.get(position);
        holder.nameMenu.setText(menu.getNama_menu());
        holder.descMenu.setText(menu.getDeskripsi_menu());
        holder.hargaMenu.setText(menu.getHarga_menu());
        Picasso.get()
                .load(menu.getFoto_menu())
                .into(holder.imageMenu);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageMenu;
        TextView nameMenu;
        TextView descMenu;
        TextView hargaMenu;
        LinearLayout linearLayout;

        public ViewHolder(View itemView){
            super(itemView);
            imageMenu = itemView.findViewById(R.id.imageMenu);
            nameMenu = itemView.findViewById(R.id.nameMenu);
            descMenu = itemView.findViewById(R.id.descMenu);
            hargaMenu = itemView.findViewById(R.id.hargaMenu);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
