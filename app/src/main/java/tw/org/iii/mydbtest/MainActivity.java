package tw.org.iii.mydbtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);

        dbHelper = new MyDBHelper(this, "brad"
                    ,null, 1);
        db = dbHelper.getReadableDatabase();

    }

    public void add(View view) {
        ContentValues values = new ContentValues();
        values.put("cname", "brad");
        values.put("birthday", "1999-01-02");
        db.insert("cust", null, values);
        query(null);
    }
    public void delete(View view) {
    }
    public void update(View view) {
    }
    public void query(View view) {
        // select * from cust
        Cursor cursor = db.query("cust", null,
                null,null,
                null,null,null);
        StringBuffer sb = new StringBuffer();
        while (cursor.moveToNext()){
            String id = cursor.getString(
                    cursor.getColumnIndex("id"));
            String cname = cursor.getString(
                    cursor.getColumnIndex("cname"));
            String birthday = cursor.getString(
                    cursor.getColumnIndex("birthday"));
            sb.append(id +":"+cname+ ":" + birthday + "\n");
        }
        tv.setText(sb);


    }
}
