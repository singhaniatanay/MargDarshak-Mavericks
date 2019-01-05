package com.example.android.rajhackathon;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        TextView submit = (TextView) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText ticketno = (EditText) findViewById(R.id.tiketno);
                EditText exp = (EditText)  findViewById(R.id.exp);
                RatingBar rting = (RatingBar) findViewById(R.id.rting);
                SQLiteDatabase mydatabase = openOrCreateDatabase("guides",MODE_PRIVATE,null);
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Reviews(Ticket VARCHAR(30),Exp VARCHAR(300),Rating FLOAT);");
                ContentValues contentValues = new ContentValues();
                contentValues.put("Ticket", ticketno.getText().toString());
                contentValues.put("Exp", exp.getText().toString());
                contentValues.put("Rating", rting.getRating());
                mydatabase.insert("Reviews", null, contentValues);
                Intent i = new Intent(AddActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
