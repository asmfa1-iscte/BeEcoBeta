package com.example.beecobeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //NavigationBar
    BottomNavigationView navigationView;
    Fragment home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,
                new ProfileFragment(DadosPerfil.getNome(), DadosPerfil.getNivel(),
                        DadosPerfil.getPontos(), DadosPerfil.getProgresso())).commit();
        navigationView.setSelectedItemId(R.id.nav_profile);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        fragment = new ProfileFragment(DadosPerfil.getNome(), DadosPerfil.getNivel(),
                                DadosPerfil.getPontos(), DadosPerfil.getProgresso());
                        break;
                    case (R.id.nav_vouchers):
                        fragment = new VouchersFragment();
                        break;
                    case (R.id.nav_qrcode):
                        fragment = new QRCodeFragment();
                        break;
                    case (R.id.nav_mapa):
                        fragment = new MapFragment();
                        break;
                    case (R.id.nav_loja):
                        fragment = new LojaFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });

        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(getDrawable(R.drawable.action_bar3));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.logo_horizontal2);
        actionBar.setDisplayUseLogoEnabled(true);


    }

    public Fragment getToHome(/*passar paramentros novos*/) {
        return new ProfileFragment(DadosPerfil.getNome(), DadosPerfil.getNivel(),
                DadosPerfil.getPontos(), DadosPerfil.getProgresso());
    }

}