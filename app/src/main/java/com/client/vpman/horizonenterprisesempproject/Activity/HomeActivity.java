package com.client.vpman.horizonenterprisesempproject.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.client.vpman.horizonenterprisesempproject.Adapter.DemoFragmentStateAdapter;
import com.client.vpman.horizonenterprisesempproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    NavigationView navigationView;
    MenuItem prevMenuItem;
    private DrawerLayout mDrawereLayout;
    private ActionBarDrawerToggle drawerToggle;

    private ViewPager mViewPager;
    private DemoFragmentStateAdapter adapter;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawereLayout = findViewById(R.id.Main);
        toolbar = findViewById(R.id.appBar);
        floatingActionButton=findViewById(R.id.fab007);
        floatingActionButton.setTransitionName("reveal");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView = findViewById(R.id.navigation);


        mViewPager = findViewById(R.id.pager);
        adapter = new DemoFragmentStateAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);


        drawerToggle = new ActionBarDrawerToggle(this, mDrawereLayout, R.string.open, R.string.close);
        mDrawereLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        toolbar.setNavigationOnClickListener(v -> {
            // mDrawereLayout.openDrawer(GravityCompat.START);
            mDrawereLayout.openDrawer(GravityCompat.START);
        });
        BottomNavigationView bottomNav = findViewById(R.id.bottombar007);

    floatingActionButton.setOnClickListener(this::presentActivity);

        bottomNav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.Todo:
                    mViewPager.setCurrentItem(0);
                    floatingActionButton.setVisibility(View.VISIBLE);
                    break;
                case R.id.recent:
                    mViewPager.setCurrentItem(1);
                    floatingActionButton.setVisibility(View.GONE);
                    break;
                case R.id.profile:
                    mViewPager.setCurrentItem(2);
                    floatingActionButton.setVisibility(View.GONE);
                    break;
                default:
                    mViewPager.setCurrentItem(0);
                    break;
            }
            return true;
        });



      mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



          }

          @Override
          public void onPageSelected(int i) {
              if (prevMenuItem != null) {
                  prevMenuItem.setChecked(false);
              }
              else
              {
                  bottomNav.getMenu().getItem(0).setChecked(false);

              }
              bottomNav.getMenu().getItem(i).setChecked(true);

              prevMenuItem = bottomNav.getMenu().getItem(i);
              if (i==0)
              {
                  floatingActionButton.setVisibility(View.VISIBLE);

              }
              else
                  {

                  floatingActionButton.setVisibility(View.GONE);

              }

          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void presentActivity(View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "transition");
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY = (int) (view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(this, Add_Detail.class);
        intent.putExtra(Add_Detail.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(Add_Detail.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

}
