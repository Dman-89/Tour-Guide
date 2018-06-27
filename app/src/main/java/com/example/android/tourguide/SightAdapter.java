package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SightAdapter extends RecyclerView.Adapter<SightAdapter.ViewHolder> {

    private List<Sight> sights;
    private Context context;

    public SightAdapter (Context context, List<Sight> sights) {
        this.context = context;
        this.sights = sights;
    }

    // create new RecyclerView elements (before it will have enough of them to recycle)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.sight_item, parent, false)
        );
    }

    // behind the scenes when this method is used either onCreateViewHolder is called to create new
    // layout (list or grid) items or recycles already existing ones
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Sight sight = sights.get(position);

        holder.nameTextView.setText(sight.getName());
        holder.imageResourceId.setImageResource(sight.getImageResourceId());

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_SIGHT, (Parcelable) sight);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.sights.size();
    }


    // custom class needed for use in onBindViewHolder
    // because RecyclerView.ViewHolder is an abstract class and can't be instantiated
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private ImageView imageResourceId;
        private View parentView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.parentView = view;
            this.nameTextView = (TextView)view
                    .findViewById(R.id.name_text_view);
            this.imageResourceId = (ImageView)view
                    .findViewById(R.id.image);
        }
    }
}
