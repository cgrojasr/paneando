package edu.upc.paneando;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CatalogoActivity extends AppCompatActivity {
    private BottomNavigationView navMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        setComponents();
        setNavMenuPrincipal();
        setFragment(new ProductosFragment());
    }

    private void setComponents(){
        navMenuPrincipal = findViewById(R.id.navMenuPrincipal);
    }

    private void setNavMenuPrincipal(){
        navMenuPrincipal.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_1: {
                        setFragment(new ProductosFragment());
                        break;
                    }
                    case R.id.menu_2: {
                        setFragment(new CarritoFragment());
                        break;
                    }
                    case R.id.menu_3: {
                        break;
                    }
                    default: break;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frmCatalogo, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}