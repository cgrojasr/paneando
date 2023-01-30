package edu.upc.paneando;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.upc.paneando.dao.CarritoItemDAO;
import edu.upc.paneando.dao.ProductoDAO;
import edu.upc.paneando.models.CarritoItem;
import edu.upc.paneando.models.Producto;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    EditText txtUsuario, txtPassword;
    ProductoDAO objProductoDAO = new ProductoDAO(this);
    CarritoItemDAO objCarritoItemDAO = new CarritoItemDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadProductos();
        setComponents();

        btnIngresar.setOnClickListener(view->{
            Intent intent = new Intent(this, CatalogoActivity.class);
            if(txtUsuario.getText().toString().equals("pciscroj")  && txtPassword.getText().toString().equals("123")){
                startActivity(intent);
            }
            else {
                txtUsuario.setError("Usuario incorrecto");
                txtPassword.setError("Contraseña incorrecta");
            }
        });
    }

    private void setComponents(){
        btnIngresar = findViewById(R.id.btnIngresar);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);
    }

    private void loadProductos(){
        //objProductoDAO = new ProductoDAO(this);

        //Limpieza de las tablas
        objProductoDAO.Eliminar_Todo();
        objCarritoItemDAO.Eliminar_Todo();

        Producto producto = new Producto("Pan frances", 0.4, R.drawable.panenado_frances);
        objProductoDAO.Registrar(producto);
        producto = new Producto("Pan yema", 0.4, R.drawable.panenado_yema);
        objProductoDAO.Registrar(producto);
        producto = new Producto("Pan integral", 0.4, R.drawable.panenado_integral);
        objProductoDAO.Registrar(producto);
    }
}