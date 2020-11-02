package com.mendez.mascotas.Menu;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.mendez.mascotas.Email;
import com.mendez.mascotas.R;

import java.util.concurrent.ExecutionException;

public class Activity_contacto extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText nombre;
    private EditText correo;
    private EditText mensaje;

    private static final String TAG = Activity_contacto.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        generarToolbar();

        nombre = (EditText) findViewById(R.id.etNombre);
        correo = (EditText) findViewById(R.id.etCorreo);
        mensaje = (EditText) findViewById(R.id.etComent);


    }

    private void generarToolbar() {
        androidx.appcompat.widget.Toolbar toolb = findViewById(R.id.miActionBar);
        androidx.appcompat.widget.Toolbar toolbar = toolb;
        setSupportActionBar(toolb);

    }

    public void enviarCorreo(View view) {

        Email emailAsync = new Email();

        emailAsync.execute(correo.getText().toString(), mensaje.getText().toString());

        try {
            Object ob = emailAsync.get();
            if (ob != null) {
                Snackbar.make(view,ob.toString(),Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(view,"Mensaje no enviado :(",Snackbar.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    }

