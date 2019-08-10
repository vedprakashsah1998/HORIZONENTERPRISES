package com.client.vpman.horizonenterprisesempproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.client.vpman.horizonenterprisesempproject.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

public class RecsAdapter extends RecyclerView.Adapter<RecsAdapter.MyViewHolder>
{
    private Context context;

    public RecsAdapter(Context context) {
        this.context = context;
    }

    private  Integer[] schools= {
            R.drawable.ops,
            R.drawable.oxford_school,
            R.drawable.cropped,
            R.drawable.ontonagon_school,
            R.drawable.school
    };
    private String[] scName={"Oxford Public School","Oxford School","St.Xaviers Jr/Sr School","Cambridge School","Harvard School"};

    @NonNull
    @Override
    public RecsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recs_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecsAdapter.MyViewHolder holder, int position) {


    holder.imageView.setImageResource(schools[position]);
    holder.schoolName.setText(scName[position]);
    }

    @Override
    public int getItemCount() {
        return schools.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        MaterialTextView schoolName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);
            schoolName=itemView.findViewById(R.id.SchoolName);



        }
    }
}
