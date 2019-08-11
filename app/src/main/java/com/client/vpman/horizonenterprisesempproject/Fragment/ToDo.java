package com.client.vpman.horizonenterprisesempproject.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.client.vpman.horizonenterprisesempproject.Adapter.RecsAdapter;
import com.client.vpman.horizonenterprisesempproject.R;
import com.client.vpman.horizonenterprisesempproject.pojo.BeanSchoolDetail;

import java.util.ArrayList;
import java.util.List;

import static com.client.vpman.horizonenterprisesempproject.Activity.HomeActivity.mDrawereLayout;

public class ToDo extends Fragment
{
    View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecsAdapter adapter;
    Context mContext;
    List<BeanSchoolDetail>  mList ;
    Toolbar toolbar;
    TextView toolbar_title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.todo,container,false);
        recyclerView=view.findViewById(R.id.recyclerView);
        mContext = getActivity();
        mList = new ArrayList<>();

        toolbar = view.findViewById(R.id.toolBar);
        toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawereLayout.openDrawer(GravityCompat.START);

            }
        });

        layoutManager = new GridLayoutManager(mContext,2);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecsAdapter(mContext,mList);
        recyclerView.setAdapter(adapter);
        setData();
        return view;
    }

    private void setData() {
        mList.add(new BeanSchoolDetail(R.drawable.ops,"Oxford Public School"));
        mList.add(new BeanSchoolDetail(R.drawable.oxford_school,"Oxford School"));
        mList.add(new BeanSchoolDetail(R.drawable.cropped,"St.Xaviers Jr/Sr School"));
        mList.add(new BeanSchoolDetail(R.drawable.ontonagon_school,"Cambridge School"));
        mList.add(new BeanSchoolDetail(R.drawable.school,"Harvard School"));
    }


}


