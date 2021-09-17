package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ReportDatabase extends SQLiteOpenHelper {  // sqlite open helper is the parent class we have inherited to use its functionallity

    private static final String dbname = "reportCrime.db";
    private static final String tableName = "usersReport";
    private static final String col_1 = "ID";
    private static final String Col_2 = "USERNAME";
    private static final String Col_3 = "USERCONTACT";
    private static final String Col_4 = "USERADDRESS";
    private static final String Col_5 = "DATE";
    private static final String Col_6 = "DESCRIPTION";


    public ReportDatabase(@Nullable Context context) {
        super(context, dbname, null, 1);

    } // constructor

    @Override
    public void onCreate(SQLiteDatabase db) {    // creating function

        db.execSQL("create table " + tableName + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT,USERCONTACT INTEGER, USERADDRESS INTEGER , DATE INTEGER, DESCRIPTION TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);

    }

    public boolean insertData(String name, String phone_no, String address, String date, String info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col_2, name);
        cv.put(Col_3, phone_no);
        cv.put(Col_4, address);
        cv.put(Col_5, date);
        cv.put(Col_6, info);
        long result = db.insert(tableName, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


}
