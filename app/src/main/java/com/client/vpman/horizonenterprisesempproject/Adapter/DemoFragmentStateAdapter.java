package com.client.vpman.horizonenterprisesempproject.Adapter;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.client.vpman.horizonenterprisesempproject.Fragment.Recent;
import com.client.vpman.horizonenterprisesempproject.Fragment.ToDo;
import com.client.vpman.horizonenterprisesempproject.Fragment.User;

public class DemoFragmentStateAdapter extends FragmentStatePagerAdapter {
    public DemoFragmentStateAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return ToDo.newInstance("ToDO, Instance 1");

            case 1:
                return Recent.newInstance("Recent, Instance 1");
            case 2:
                return User.newInstance("User, Instance 1");
            /*case 3:
                return PFFirst.newInstance("PFFirst, Instance 4");*/
            default:
                return ToDo.newInstance("ToDo, Instance 1");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
