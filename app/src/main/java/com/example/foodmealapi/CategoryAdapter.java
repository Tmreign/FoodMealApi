package com.example.foodmealapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<Category> categories = new ArrayList<>();
    private  Context context;

    public CategoryAdapter(Context context, ArrayList<Category> categories){
        this.categories = categories;
        this.context =context;

    }
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_items,parent ,false);

        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

        ViewHolder.Category_name.setText(categories.get(i).getstrCategory());


        Picasso.get().load(categories.get(i)).getstrCategoryThumb().into(ViewHolder.car_image);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private ImageView car_image;
        private TextView Category_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            car_image=(ImageView)itemView.findViewById(R.id.car_image);
            Category_name=(TextView)itemView.findViewById(R.id.Category_name);
        }
    }
}
