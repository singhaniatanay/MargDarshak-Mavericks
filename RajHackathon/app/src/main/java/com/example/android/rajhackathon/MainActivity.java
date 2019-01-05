package com.example.android.rajhackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView reg = (TextView) findViewById(R.id.reg);
        TextView book = (TextView) findViewById(R.id.book);
        TextView review = (TextView) findViewById(R.id.review);
        TextView support = (TextView) findViewById(R.id.support);
        book.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, BookActivity.class);
                startActivity(i);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        review.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(i);
            }
        });
        support.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SupportActivity.class);
                startActivity(i);
            }
        });

        ArrayList<Citi_Item> items = new ArrayList<Citi_Item>();
        items.add(new Citi_Item(getString(R.string.jasalmer),"Jasalmer",R.drawable.jasalmer));
        items.add(new Citi_Item(getString(R.string.jaipur),"Jaipur",R.drawable.jaipur));
        items.add(new Citi_Item(getString(R.string.ajmer),"Ajmer",R.drawable.ajmer));
        items.add(new Citi_Item(getString(R.string.udaipur),"Udaipur",R.drawable.udaipur));


        Citi_Adapter adapter = new Citi_Adapter(this, items);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


    }
}
