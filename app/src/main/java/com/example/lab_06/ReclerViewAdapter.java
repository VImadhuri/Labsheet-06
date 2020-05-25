package com.example.lab_06;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.ArrayList;

import static java.lang.System.load;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "test.sliit.recyclerview.RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mContext;
    private Instant Glide;
    private Object TemporalField;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String>
            mImage, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImage = mImage;
        this.mContext = mContext;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @RequiresApi(api=Build.VERSION_CODES.O)
    @SuppressLint("LongLogTag")

    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with((TemporalAdjuster) mContext).get((java.time.temporal.TemporalField) TemporalField).load(mImage.get(position)).into(holder.image);
        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on"+mImageNames.get(position));

                Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount() {
        return mImageNames.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        private class CircleImageView {
        }
    }
}
