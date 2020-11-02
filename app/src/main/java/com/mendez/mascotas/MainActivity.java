package com.mendez.mascotas;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mendez.mascotas.Adaptador.PageAdapter;
import com.mendez.mascotas.Fragment.PerfilFragment;
import com.mendez.mascotas.Fragment.RecyclerViewFragment;
import com.mendez.mascotas.Menu.Activity_acercade;
import com.mendez.mascotas.Menu.Activity_contacto;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CircleImageView civ = (CircleImageView) findViewById(R.id.imagPerfil);

        androidx.appcompat.widget.Toolbar toolb = findViewById(R.id.miActionBar);
        androidx.appcompat.widget.Toolbar toolbar = toolb;
        setSupportActionBar(toolb);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolb != null) {
            setSupportActionBar(toolb);
        }

    }



    private ArrayList<Fragment> agregarFragments (){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;



    }


    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perro);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent i = new Intent(this, Activity_contacto.class);
                startActivity(i);
                break;

            case R.id.mAcerca:
                Intent intent = new Intent(this, Activity_acercade.class);
                startActivity(intent);
                break;



        }

        return super.onOptionsItemSelected(item);
    }



    public void IrSegundaA(View v){
        Intent intent = new Intent(this, mascota_favorita.class);
        startActivity(intent);
    }



}