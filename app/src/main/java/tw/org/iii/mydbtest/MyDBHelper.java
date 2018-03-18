package tw.org.iii.mydbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/3/18.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private final String createTable =
            "CREATE TABLE cust (id integer primary key autoincrement,cname text,birthday date)";

    public MyDBHelper(Context context,
                      String name,
                      SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
