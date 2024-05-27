package br.edu.fateczl.athletesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            loadFragment(bundle);
        }
    }

    private void loadFragment(Bundle bundle) {
        String tipoAtleta = bundle.getString("tipoAtleta");
        assert tipoAtleta != null;

        switch (tipoAtleta) {
            case "Comum":
                fragment = new AtletaComumFragment();
                break;
            case "Juvenil":
                fragment = new AtletaJuvenilFragment();
                break;
            case "Senior":
                fragment = new AtletaSeniorFragment();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        fTransaction.replace(R.id.fragment, fragment);
        fTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Intent i = new Intent(this, MainActivity.class);
        if (id == R.id.menu_frag1) {
            bundle.putString("tipoAtleta", "Comum");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        if (id == R.id.menu_frag2) {
            bundle.putString("tipoAtleta", "Juvenil");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        if (id == R.id.menu_frag3) {
            bundle.putString("tipoAtleta", "Senior");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}