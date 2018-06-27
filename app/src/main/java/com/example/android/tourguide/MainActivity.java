package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // top toolbar setup
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_24);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // Установить заголовок для action bar'а
                        setTitle(menuItem.getTitle());

                        // selection of respective fragments
                        Class fragmentClass;
                        switch(menuItem.getItemId()) {
                            case R.id.nav_vladimir:
                                fragmentClass = VladimirFragment.class;
                                break;
                            case R.id.nav_suzdal:
                                fragmentClass = SuzdalFragment.class;
                                break;
                            case R.id.nav_murom:
                                fragmentClass = MuromFragment.class;
                                break;
                            case R.id.nav_raduzhnyy:
                                fragmentClass = RaduzhnyyFragment.class;
                                break;
                            default:
                                fragmentClass = VladimirFragment.class;
                        }

                        Fragment fragment = null;
                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // Insert fragment replacing any existing one
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // hide start page image an greeting
                        findViewById(R.id.start_page).setVisibility(View.GONE);
                        return true;
                    }
                });

        // drops grey color from side icons in navigation drawer menu (makes icons appear in their true colors)
        navigationView.setItemIconTintList(null);

    }

    // this method contains logic behind clicking on toolbar home button
    // Menu (3 horizontal stripes) button in this case
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
