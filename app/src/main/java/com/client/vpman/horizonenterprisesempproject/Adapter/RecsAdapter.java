package com.client.vpman.horizonenterprisesempproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.client.vpman.horizonenterprisesempproject.R;
import com.client.vpman.horizonenterprisesempproject.pojo.BeanSchoolDetail;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class RecsAdapter extends RecyclerView.Adapter<RecsAdapter.MyViewHolder>
{
    private Context context;
    List<BeanSchoolDetail> mList;

    public RecsAdapter(Context context, List<BeanSchoolDetail>  mList) {
        this.context = context;
        this.mList = mList;
    }


    @NonNull
    @Override
    public RecsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recs_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecsAdapter.MyViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position).getImage()).into(holder.imageView);
         holder.schoolName.setText(mList.get(position).getSchoolName());

         holder.imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
    }

    @Override
    public int getItemCount() {
        return mList.size();
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
