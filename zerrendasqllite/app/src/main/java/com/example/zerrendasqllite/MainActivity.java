package com.example.zerrendasqllite;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
        LehenengoFragment fragment = (LehenengoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        int id = menuItem.getItemId();
        if (id == R.id.itxi) {
            Toast.makeText(this, "Itxi", Toast.LENGTH_SHORT).show();
            fragment.itxi();
            return true;
        } else if (id == R.id.erakutsi) {
            if (fragment != null) {
                fragment.erakutsiLengoaiak();
            }
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
