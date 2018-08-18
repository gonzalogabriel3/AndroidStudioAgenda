package com.example.gonzalo.sharedpreferencesagenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText etdatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        etdatos=findViewById(R.id.etdatos);

    }

    public void guardar(View view){
        String nombre=et1.getText().toString();
        String datos=etdatos.getText().toString();

        SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor=preferencias.edit();

        //Agrego los datos al archivo
        Obj_editor.putString(nombre, datos);
        Obj_editor.commit();

        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_SHORT).show();

    }

    public void buscar(View view){
        String nombre = et1.getText().toString();

        //Creo una variable sharedPreferences para acceder al archivo
        SharedPreferences preferencias=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        //Busco los datos asociados al nombre
        String datos=preferencias.getString(nombre,"");

        if(datos.length()==0){
            Toast.makeText(this,"No se encontraron datos asociado a ese nombre",Toast.LENGTH_SHORT).show();
        }else{
            etdatos.setText(datos);
        }

    }

    public void salir(View view){
        finish();
    }
}
