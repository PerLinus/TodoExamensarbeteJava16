package nilsson83.linus.todo.sqlite;/*
package com.nilsson83gmail.linus.todo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

*/
/**
 * Created by s060qm on 3/19/2018.
 *//*


public class TodoDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "todo";
    private static final int DB_VERSION = 1;

    public TodoDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TODO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "TODOS TEXT);");
        insertTodo(db, "Fixa", "Måste fixa snarast");
        insertTodo(db, "Skoj", "Bada på badhus och simma");
        insertTodo(db, "Planering", "måste planeras snarast");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE TODO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "TODOS TEXT);");
            insertTodo(db, "Fixa", "Måste fixa snarast");
            insertTodo(db, "Skoj", "Bada på badhus och simma");
            insertTodo(db, "Planering", "måste planeras snarast");
        }

        if (oldVersion < 2){

        }
    }

    private void insertTodo(SQLiteDatabase db, String name, String content) {

        ContentValues todoValues = new ContentValues();
        todoValues.put("NAME", name);
        todoValues.put("TODOS", content);
        db.insert("TODO", null, todoValues);

    }

}
*/
