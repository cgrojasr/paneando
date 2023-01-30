package edu.upc.paneando.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbPaneandoLite extends SQLiteOpenHelper {

    public dbPaneandoLite(Context context){
        super(context, "paneando.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE producto (id_producto INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nombre TEXT NOT NULL, "+
                "valor_venta DECIMAL NOT NULL);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1 == 2){
            String query =
                    "CREATE TABLE carrito_item (id_item INTEGER PRIMARY KEY AUTOINCREMENT, "+
                            "id_producto INTEGER NOT NULL, "+
                            "nombre TEXT NOT NULL, "+
                            "valor_unitario DECIMAL NOT NULL, "+
                            "cantidad INTEGER NOT NULL, "+
                            "valor_total DECIMAL NOT NULL);";

            sqLiteDatabase.execSQL(query);
        }

        if(i1 == 3){
            String query =
                    "ALTER TABLE producto ADD image INTEGER;";

            sqLiteDatabase.execSQL(query);
        }
    }
}
