package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    private final Context context;
    // create a DB file "Login.db"

    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users (username TEXT primary key, password TEXT, sex TEXT, birthday TEXT, nickname TEXT, type TEXT)");
        //MyDB.execSQL("create Table music(Mid TEXT primary key, Mname TEXT, singer TEXT, album TEXT, Mtype TEXT)");
    }
    // Create a Table "users", set the Table, include username (TEXT) and password (TEXT)

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }
    // If there is a Table with the same name, the system will ignore the new Table.

    public boolean insertData(String username, String password, String sex, String birth, String nick, String type){  //insertData function
        SQLiteDatabase MyDB = this.getWritableDatabase();     //set the DB connection
        ContentValues contentValues = new ContentValues();    //set the "contentValues" to save the value
        contentValues.put("username", username);              //Put the username and password into "contentValues"
        contentValues.put("password", password);
        contentValues.put("sex", sex);
        contentValues.put("birthday", birth);
        contentValues.put("nickname", nick);
        contentValues.put("type", type);

        long result = MyDB.insert("users", null, contentValues);
        if (result==-1) {// insert the contentValues into the table(users)
            Log.d("Debuggggg", "xxxxx");
            return false;
        }
        else
            return true;
    }

    public boolean checkusername(String username){         //checkusername function
        SQLiteDatabase MyDB = this.getWritableDatabase();  //set the DB connection
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? ",new String[]{username} );
        if (cursor.getCount() > 0)           //Search the table, if the database has one, getCount+1
            return true;
        else
            return false;
    }

    public boolean checkusernamepassword(String username, String password){ //checkusernamepassword function
        SQLiteDatabase MyDB = this.getWritableDatabase();  //set the DB connection
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?  and password = ?",new String[]{username, password});
        if (cursor.getCount() > 0)          //Search the table, if the database has one, getCount+1
            return true;
        else
            return false;
    }
    public Cursor readAllData(){
        String query = "SELECT * FROM " + "users";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
