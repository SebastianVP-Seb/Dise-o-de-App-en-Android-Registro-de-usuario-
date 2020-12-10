package com.iamseb.actividadsemana2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tvMnombre,tvMcelular,tvMmail,tvMdescripcion;
    Button tvFecha;
    DatePickerDialog.OnDateSetListener setListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMnombre=(TextInputEditText) findViewById(R.id.tvMnombre);
        tvMcelular=(TextInputEditText)findViewById(R.id.tvMcelular);
        tvMmail=(TextInputEditText)findViewById(R.id.tvMmail);
        tvMdescripcion=(TextInputEditText)findViewById(R.id.tvMdescripcion);

        //INICIA EL CALENDARIO
        tvFecha=(Button) findViewById(R.id.tvFecha);
        Calendar calendario=Calendar.getInstance();
        final int year=calendario.get(Calendar.YEAR);
        final int mes=calendario.get(Calendar.MONTH);
        final int dia=calendario.get(Calendar.DAY_OF_MONTH);

        tvFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,mes,dia);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                mes=mes+1;
                String fecha=dia+"/"+mes+"/"+year;
                tvFecha.setText(fecha);
            }
        };
        //FIN DEL CALENDARIO

        //INICIA RECIBO DE DATOS
        String nombre=getIntent().getStringExtra("Nombre");
        tvMnombre.setText(nombre);

        String celular=getIntent().getStringExtra("Celular");
        tvMcelular.setText(celular);

        String mail=getIntent().getStringExtra("Email");
        tvMmail.setText(mail);

        String descripcion=getIntent().getStringExtra("Descripcion");
        tvMdescripcion.setText(descripcion);

      //  String fecha=getIntent().getStringExtra("Fecha");
      //  tvFecha.setText(fecha);
        //FIN RECIBO DE DATOS
    }
    public void iraconfirmacion(View view){
        Intent ab=new Intent(this,ConfirmacionDatos.class);
        //INICIA ENVÍO DE DATOS
        ab.putExtra("Nombre",tvMnombre.getText().toString());
        ab.putExtra("Celular",tvMcelular.getText().toString());
        ab.putExtra("Email",tvMmail.getText().toString());
        ab.putExtra("Descripcion",tvMdescripcion.getText().toString());
        ab.putExtra("Fecha",tvFecha.getText().toString());
        //FIN ENVÍO DE DATOS
        startActivity(ab);
    }

}