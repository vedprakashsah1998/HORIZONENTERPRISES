package com.client.vpman.horizonenterprisesempproject.useful;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.client.vpman.horizonenterprisesempproject.Fragment.ToDo;
import com.client.vpman.horizonenterprisesempproject.R;

public class UtilityMethod {

    public static void gonextFragmentWithBackStack(Context mContext, Fragment fragment)
    {
        FragmentManager manager = fragment.getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.swipe_left,R.anim.swipe_right,R.anim.swipe_right,R.anim.swipe_left);
        transaction.addToBackStack(null);
        transaction.replace(R.id.container,fragment,"");
        transaction.commit();
    }
}
