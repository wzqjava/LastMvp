package com.wzq.mvp_retrofit.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.wzq.mvp_retrofit.R;
import com.wzq.mvp_retrofit.base.BaseActivity;
import com.wzq.mvp_retrofit.base.IMvpView;
import com.wzq.mvp_retrofit.view.fragment.DashboardFragment;
import com.wzq.mvp_retrofit.view.fragment.HomeFragment;
import com.wzq.mvp_retrofit.view.fragment.NotificationFragment;

public class MainActivity extends BaseActivity implements IMvpView {

    private HomeFragment homeFragment;
    private DashboardFragment dashboardFragment;
    private NotificationFragment notificationFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl, homeFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getFragmentManager();
            hideFragments(fragmentManager);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (homeFragment != null) {
                        fragmentManager.beginTransaction().show(homeFragment).commit();
                    }

                    return true;
                case R.id.navigation_dashboard:
                    if (dashboardFragment == null) {
                        dashboardFragment = new DashboardFragment();
                        fragmentManager.beginTransaction().add(R.id.fl, dashboardFragment).commit();
                    } else {
                        fragmentManager.beginTransaction().show( dashboardFragment).commit();
                    }

                    return true;
                case R.id.navigation_notifications:
                    if (notificationFragment == null) {
                        notificationFragment = new NotificationFragment();
                        fragmentManager.beginTransaction().add(R.id.fl, notificationFragment).commit();
                    } else {
                        fragmentManager.beginTransaction().show( notificationFragment).commit();

                    }

                    return true;
            }
            return false;
        }
    };

    private void hideFragments(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }if (dashboardFragment != null) {
            fragmentTransaction.hide(dashboardFragment);
        }if (notificationFragment != null) {
            fragmentTransaction.hide(notificationFragment);
        }
        fragmentTransaction.commit();

    }


    @Override
    public void showData(String data) {

    }
}
