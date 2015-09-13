package com.example.kaitpicco.puzzleapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper {

    private static final String database_name="DATABASES_AWESOME";
    private static final int database_version=1;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ContractClass.BaseEntry.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, database_name, null, database_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + ContractClass.BaseEntry.TABLE_NAME +
                " (" +
                ContractClass.BaseEntry._ID + " INTEGER PRIMARY KEY," +
                ContractClass.BaseEntry.FIRSTNAME + " VARCHAR" + "," +
                ContractClass.BaseEntry.LASTNAME + " VARCHAR" +
                " );";
        db.execSQL(CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);

    }
}
