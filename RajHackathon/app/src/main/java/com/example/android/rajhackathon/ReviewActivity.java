package com.example.android.rajhackathon;
import java.util.Random;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Random rand = new Random();
        int r1 = rand.nextInt(10000);
        int r2 = rand.nextInt(10000);
        int r3 = rand.nextInt(10000);
        int r4 = rand.nextInt(10000);
        String a = ""+r1;
        String b = ""+r2;
        String c = ""+r3;
        String d = ""+r4;


        ArrayList<Review_Item> items = new ArrayList<Review_Item>();
        items.add(new Review_Item(a,"This is a sample review and not in database",3));
        items.add(new Review_Item(b,"This is just to chk code",2));

        SQLiteDatabase mydatabase = openOrCreateDatabase("guides",MODE_PRIVATE,null);
        try {

            Cursor resultSet = mydatabase.rawQuery("Select * from Reviews", null);
            if (resultSet != null) {
                resultSet.moveToFirst();
                while (!resultSet.isAfterLast()) {
                    items.add(new Review_Item(resultSet.getString(0), resultSet.getString(1), resultSet.getFloat(2)));
                    resultSet.moveToNext();
                }
            }
        }catch (SQLException e){
        }


        Review_Adapter adapter = new Review_Adapter(this, items);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        TextView add = (TextView) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(ReviewActivity.this, AddActivity.class);
                startActivity(i);
            }
        });

    }
}
