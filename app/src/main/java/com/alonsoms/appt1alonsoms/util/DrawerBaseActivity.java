package com.alonsoms.appt1alonsoms.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alonsoms.appt1alonsoms.InicioActivity;
import com.alonsoms.appt1alonsoms.ListaSubastasActivity;
import com.alonsoms.appt1alonsoms.R;
import com.alonsoms.appt1alonsoms.linearLayout_04;
import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;

    @Override
    public void setContentView (View view){
        drawerLayout =(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base,null);
        FrameLayout container=drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
            super.setContentView(drawerLayout);


        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_navigation_drawer,R.string.close_Navigation_drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        drawerLayout.closeDrawer(GravityCompat.START);
        manejaraccionnavegacion(item.getItemId());

        return false;
    }


    private void manejaraccionnavegacion(int itemId) {
        if (itemId == R.id.nav_inicio) {
            iniciarNuevaActividad(linearLayout_04.class);
        } else if (itemId == R.id.nav_configuracion) {
            iniciarNuevaActividad(InicioActivity.class);
        } else if (itemId == R.id.navgaleria) {
            iniciarNuevaActividad(ListaSubastasActivity.class);
        }
    }

    private void iniciarNuevaActividad(Class<?>destinoactividad){
        startActivity(new Intent(this,destinoactividad));
        overridePendingTransition(0,0);

    }


}