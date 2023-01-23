package edu.upc.paneando.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.upc.paneando.models.Producto;
import edu.upc.paneando.util.dbPaneandoLite;

public class ProductoDAO {

    dbPaneandoLite db;
    SQLiteDatabase dbSQLite;
    Context context;

    public ProductoDAO(Context context) {
        db = new dbPaneandoLite(context);
        this.context = context;
        dbSQLite = db.getWritableDatabase();
    }

    public void Registrar(Producto objProducto) {
        try {
            ContentValues productoContent = new ContentValues();
            productoContent.put("nombre", objProducto.getNombre());
            productoContent.put("valor_venta", objProducto.getValor_venta());
            dbSQLite.insert("producto", null, productoContent);
        }catch (Exception e){
            Log.d("=>", e.getMessage());
        }
    }

    public List<Producto> Listar(){
        List<Producto> productos = new ArrayList<>();
        try{
           Cursor cursor = dbSQLite.rawQuery("SELECT * FROM productos", null);
           while (cursor.moveToNext()){
               productos.add(new Producto(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2)));
           }
       }
       catch (Exception e){
           Log.d("=>", e.getMessage());
       }
        return productos;
    }
}
