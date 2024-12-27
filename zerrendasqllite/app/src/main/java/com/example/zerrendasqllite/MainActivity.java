package com.example.zerrendasqllite;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new LehenengoFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.itxi) {
            Fragment currentFragment = getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentContainerView);

            // instanceof es un operador que comprueba si un objeto es una instancia de una clase
            // Asi no se cierra la aplicacion si no se esta en el fragmento principal
            if (currentFragment instanceof LehenengoFragment) {
                LehenengoFragment fragment = (LehenengoFragment) currentFragment;
                fragment.itxi();
            }
            return true;

        } else if (id == R.id.gehitu || id == R.id.gehituMenua) {
            GehituFragment gehituFragment = new GehituFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, gehituFragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }


}
