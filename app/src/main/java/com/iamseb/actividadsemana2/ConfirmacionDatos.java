package com.iamseb.actividadsemana2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    TextView tvCnombre,tvCfecha,tvCcelular,tvCmail,tvCdescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);
        //INICIA RECIBO DE DATOS
        tvCnombre=(TextView) findViewById(R.id.tvCnombre);
        String nombre=getIntent().getStringExtra("Nombre");
        tvCnombre.setText(nombre);

        tvCcelular=(TextView)findViewById(R.id.tvCcelular);
        String celular=getIntent().getStringExtra("Celular");
        tvCcelular.setText(celular);

        tvCmail=(TextView)findViewById(R.id.tvCmail);
        String mail=getIntent().getStringExtra("Email");
        tvCmail.setText(mail);

        tvCdescripcion=(TextView)findViewById(R.id.tvCdescripcion);
        String descripcion=getIntent().getStringExtra("Descripcion");
        tvCdescripcion.setText(descripcion);

        tvCfecha=(TextView)findViewById(R.id.tvCfecha);
        String fecha=getIntent().getStringExtra("Fecha");
        tvCfecha.setText(fecha);
        //FINALIZA RECIBO DE DATOS
    }
    public void iraeditar (View view){
        Intent cd=new Intent(this,MainActivity.class);
        //INICIA ENVÍO DE DATOS
        cd.putExtra("Nombre",tvCnombre.getText().toString());
        cd.putExtra("Celular",tvCcelular.getText().toString());
        cd.putExtra("Email",tvCmail.getText().toString());
        cd.putExtra("Descripcion",tvCdescripcion.getText().toString());
        cd.putExtra("Fecha",tvCfecha.getText().toString());
        //FINALIZA ENVÍO DE DATOS
        startActivity(cd);

    }
}