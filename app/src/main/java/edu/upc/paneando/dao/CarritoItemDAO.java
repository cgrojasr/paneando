package edu.upc.paneando.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.upc.paneando.models.CarritoItem;
import edu.upc.paneando.models.Producto;
import edu.upc.paneando.util.dbPaneandoLite;

public class CarritoItemDAO {

    dbPaneandoLite db;
    SQLiteDatabase dbSQLite;
    Context context;

    public CarritoItemDAO(Context context) {
        db = new dbPaneandoLite(context);
        this.context = context;
    }

    public void Registrar(CarritoItem objCarritoItem) {
        try {
            dbSQLite = db.getWritableDatabase();
            ContentValues itemContent = new ContentValues();
            itemContent.put("id_producto", objCarritoItem.getId_producto());
            itemContent.put("nombre", objCarritoItem.getNombre());
            itemContent.put("valor_unitario", objCarritoItem.getValor_unitario());
            itemContent.put("cantidad", objCarritoItem.getCantidad());
            itemContent.put("valor_total", objCarritoItem.getCantidad()*objCarritoItem.getValor_unitario());
            dbSQLite.insert("carrito_item", null, itemContent);
        }catch (Exception e){
            Log.d("=>", e.getMessage());
        }
    }

    public List<CarritoItem> Listar(){
        dbSQLite = db.getWritableDatabase();
        List<CarritoItem> items = new ArrayList<>();
        try{
            Cursor cursor = dbSQLite.rawQuery("SELECT * FROM carrito_item", null);
            while (cursor.moveToNext()){
                items.add(new CarritoItem(cursor.getInt(0), cursor.getInt(1), cursor.getString(2),
                        cursor.getDouble(3) , cursor.getInt(4), cursor.getDouble(5)));
            }
        }
        catch (Exception e){
            Log.d("=>", e.getMessage());
        }
        return items;
    }
}
