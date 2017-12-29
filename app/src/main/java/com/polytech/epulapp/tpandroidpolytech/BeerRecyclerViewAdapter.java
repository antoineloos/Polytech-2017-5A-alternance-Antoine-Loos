package com.polytech.epulapp.tpandroidpolytech;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.polytech.epulapp.tpandroidpolytech.models.Beer;
import com.polytech.epulapp.tpandroidpolytech.services.ThumbnailDownloadTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class BeerRecyclerViewAdapter extends RecyclerView.Adapter<BeerRecyclerViewAdapter.ViewHolder> {

    private final List<Beer> mValues;


    public BeerRecyclerViewAdapter(List<Beer> items, int rowLayout, Context context) {
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_beer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mAbvView.setText(mValues.get(position).abv);
        if ( mValues.get(position).getBeerThumbnail()==null) {
            try {
                new ThumbnailDownloadTask(holder.mThumbnail,mValues.get(position)).execute(new URL(mValues.get(position).image_url));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mAbvView;
        public final ImageView mThumbnail;
        public Beer mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mAbvView = (TextView) view.findViewById(R.id.abv);
            mThumbnail = (ImageView) view.findViewById(R.id.img);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
