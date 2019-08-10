package com.client.vpman.horizonenterprisesempproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.client.vpman.horizonenterprisesempproject.Adapter.RecsAdapter;
import com.client.vpman.horizonenterprisesempproject.R;

public class ToDo extends Fragment
{
    View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.todo,container,false);
        recyclerView=view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        adapter=new RecsAdapter(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter=new RecsAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

    public static ToDo newInstance(String text) {
        ToDo f = new ToDo();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}
