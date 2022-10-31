package com.example.android_portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(toggle);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container, new AboutFragment()
        ).commit();



    }

//    @Override
//    public boolean onOptionsItemsSelected(@NonNull MenuItem item){
//        if(toggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("here item "+ item.getItemId()+" about fragment"+R.id.fragment_about
                +" skills fragment"+R.id.fragment_skills);
        if(item.getItemId() == R.id.menu_about){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new AboutFragment()
            ).commit();
        }else if(item.getItemId() == R.id.menu_skills){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new SkillsFragment()
            ).commit();
        }else if(item.getItemId() == R.id.menu_experience){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new ExperienceFragment()
            ).commit();
        }else if(item.getItemId() == R.id.menu_certifications){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new CertificationsFragment()
            ).commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}