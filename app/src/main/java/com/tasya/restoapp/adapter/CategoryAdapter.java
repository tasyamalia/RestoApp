package com.tasya.restoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tasya.restoapp.R;
import com.tasya.restoapp.model.Categories;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<Categories> categories;
    Context context;
    LayoutInflater layoutInflater;
    public CategoryAdapter(ArrayList<Categories> categories, Context context){
        this.categories = categories;
        this.context = context;
        layoutInflater = (LayoutInflater.from(context));
    }
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_category, parent, false);
        CategoryAdapter.ViewHolder ts = new CategoryAdapter.ViewHolder(view);
        return ts;

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        Categories cat = categories.get(position);
        holder.nameCategory.setText(cat.getNama_kategori());
        Picasso.get()
                .load(cat.getFoto_kategori())
                .into(holder.imageCategory);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageCategory;
        TextView nameCategory;
        LinearLayout linearLayout;
        public ViewHolder(View itemView){
            super(itemView);
            imageCategory = itemView.findViewById(R.id.imageCategory);
            nameCategory = itemView.findViewById(R.id.nameCategory);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
