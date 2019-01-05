package com.example.android.rajhackathon;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import java.util.Random;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        SQLiteDatabase mydatabase = openOrCreateDatabase("guides",MODE_PRIVATE,null);
        ArrayList<Guide_Item> items = new ArrayList<Guide_Item>();
        try {

            Cursor resultSet = mydatabase.rawQuery("Select * from GuideTable", null);
            if (resultSet != null) {
                resultSet.moveToFirst();
                while (!resultSet.isAfterLast()) {
                    items.add(new Guide_Item(resultSet.getString(0), resultSet.getString(3), resultSet.getString(2), resultSet.getString(4), resultSet.getString(1)));
                    resultSet.moveToNext();
                }
            }
        }catch (SQLException e){
        }
        items.add(new Guide_Item("Adarsh", "Male", "+91-9810105506", "singhaniatanay18@gmail.com", "1010"));
        items.add(new Guide_Item("Pratush", "Male", "+91-9810105506", "singhaniatanay18@gmail.com", "1010"));
        items.add(new Guide_Item("Samarth", "Male", "+91-9810105506", "singhaniatanay18@gmail.com", "1010"));
        final Random rand = new Random();

        final Guide_Adapter adapter = new Guide_Adapter(this, items);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

               Guide_Item curr = (Guide_Item) adapter.getItem(position);

                Intent email = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+curr.getmEmail()));
                email.putExtra(Intent.EXTRA_SUBJECT, "Booking ID :"+rand.nextInt());
                email.putExtra(Intent.EXTRA_TEXT,"Respected "+curr.getmName()+",\nPlease Confirm this booking by replying this mail & pl mention quotation too");
                startActivity(email);


            }
        });
    }
}
