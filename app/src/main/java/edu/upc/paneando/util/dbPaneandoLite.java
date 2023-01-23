package edu.upc.paneando.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbPaneandoLite extends SQLiteOpenHelper {

    public dbPaneandoLite(Context context){
        super(context, "paneando.db", null, 1);
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

    }
}
