package com.example.waltersantiago.appmanillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView res;
    private EditText nombres, apellidos,cantidad;
    private Resources resources;
    private Spinner material;
    private Spinner dije;
    private Spinner tipoDeDije;
    private Spinner tipoDeMoneda;
    private String mat[];
    private String dij[];
    private String tipdij[];
    private String tipmon[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        res = (TextView)findViewById(R.id.lblResultado);

        //EditText
        nombres = (EditText)findViewById(R.id.txtNombres);
        apellidos = (EditText)findViewById(R.id.txtApellidos);
        cantidad = (EditText)findViewById(R.id.txtCantidad);

        //Spinner
        material = (Spinner)findViewById(R.id.cmbMaterial);
        dije = (Spinner)findViewById(R.id.cmbDije);
        tipoDeDije = (Spinner)findViewById(R.id.cmbTipoDije);
        tipoDeMoneda = (Spinner)findViewById(R.id.cmbTipoMoneda);

        //resources
        resources = this.getResources();

        //Llenado Spinners
        mat = resources.getStringArray(R.array.materiales);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,mat);
        material.setAdapter(adapter);

        dij = resources.getStringArray(R.array.dijes);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,dij);
        dije.setAdapter(adapter1);

        tipdij = resources.getStringArray(R.array.tiposDeDijes);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipdij);
        tipoDeDije.setAdapter(adapter2);

        tipmon = resources.getStringArray(R.array.TiposDeMonedas);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipmon);
        tipoDeMoneda.setAdapter(adapter3);
    }

    public boolean validar (){

        if (nombres.getText().toString().isEmpty()) {
            nombres.setError(resources.getString(R.string.mensaje_error_uno));
            return false;
        }
        if (apellidos.getText().toString().isEmpty()) {
            apellidos.setError(resources.getString(R.string.mensaje_error_dos));
            return false;
        }
        if (cantidad.getText().toString().isEmpty()) {
            cantidad.setError(resources.getString(R.string.mensaje_error_tres));
            return false;
        }

        return true;
    }

    //Estructura para llamar a un botón
    public void comprar (View v){

        int opcion;
        int opcion2;
        int opcion3;
        int opcion4;
        int pagoTotal=0;
        int pagoTotalMasCant=0;
        String materialEscogido ="";
        String dijeEscogido="";
        String tipoDeDijeEscogido="";
        String tipoDeMonedaEscogida="";
        res.setText("");

       if ( validar()){

           //Material escogido
           opcion=material.getSelectedItemPosition();
           switch (opcion){
               case 0:
                   materialEscogido = "Cuero";
                   break;
               case 1:
                   materialEscogido = "Cuerda";
                   break;
           }

           //Dije escogido
           opcion2=dije.getSelectedItemPosition();
           switch (opcion2){
               case 0:
                   dijeEscogido = "Martillo";
                   break;
               case 1:
                   dijeEscogido = "Ancla";
                   break;
           }

           //Tipo de dije escogido
           opcion3=tipoDeDije.getSelectedItemPosition();
           switch (opcion3){
               case 0:
                   tipoDeDijeEscogido = "Oro";
                   break;
               case 1:
                   tipoDeDijeEscogido = "Oro rosado";
                   break;
               case 2:
                   tipoDeDijeEscogido = "Plata";
                   break;
               case 3:
                   tipoDeDijeEscogido = "Niquel";
                   break;
           }

           //Tipo de Moneda Escogida
           opcion4=tipoDeMoneda.getSelectedItemPosition();
           switch (opcion4){
               case 0:
                   tipoDeMonedaEscogida = "Pesos";
                   if (materialEscogido == "Cuero" && dijeEscogido == "Martillo"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 100*3200;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 80*3200;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 70*3200;
                       }
                   }else if(materialEscogido == "Cuero" && dijeEscogido == "Ancla"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 120*3200;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 100*3200;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 90*3200;
                       }
                   }else if (materialEscogido == "Cuerda" && dijeEscogido == "Martillo"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 90*3200;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 70*3200;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 50*3200;
                       }
                   }else if(materialEscogido == "Cuerda" && dijeEscogido == "Ancla"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 110*3200;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 90*3200;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 80*3200;
                       }
                   }
                   pagoTotalMasCant = pagoTotal * Integer.parseInt(cantidad.getText().toString());
                   break;
               case 1:
                   tipoDeMonedaEscogida = "Dolares";
                   if (materialEscogido == "Cuero" && dijeEscogido == "Martillo"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 100;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 80;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 70;
                       }
                   }else if(materialEscogido == "Cuero" && dijeEscogido == "Ancla"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 120;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 100;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 90;
                       }
                   }else if (materialEscogido == "Cuerda" && dijeEscogido == "Martillo"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 90;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 70;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 50;
                       }
                   }else if(materialEscogido == "Cuerda" && dijeEscogido == "Ancla"){
                       if (tipoDeDijeEscogido == "Oro" || tipoDeDijeEscogido == "Oro rosado"){
                           pagoTotal = 110;
                       }else if(tipoDeDijeEscogido == "Plata"){
                           pagoTotal = 90;
                       }else if(tipoDeDijeEscogido == "Niquel"){
                           pagoTotal = 80;
                       }
                   }
                   pagoTotalMasCant = pagoTotal * Integer.parseInt(cantidad.getText().toString());
                   break;
           }

           res.setText(nombres.getText().toString() +" "+ apellidos.getText().toString() +" "+Integer.parseInt(cantidad.getText().toString())+" "+
                   materialEscogido+" "+dijeEscogido+" "+tipoDeDijeEscogido+" "+tipoDeMonedaEscogida+" "+" Su valor a pagar es: "+ pagoTotalMasCant+ " "+tipoDeMonedaEscogida);

       }

    }

    //Estructura para llamar a un botón
    public void borrar (View v){

        res.setText("");
        nombres.setText("");
        apellidos.setText("");
        cantidad.setText(""+1);
        nombres.requestFocus();
        //material.setSelection(0);

    }
}
