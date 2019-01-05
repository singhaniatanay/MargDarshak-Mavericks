package com.example.android.rajhackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        TextView call = (TextView) findViewById(R.id.call);
        TextView mail = (TextView) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent email = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:abc@gmail.com"));
                email.putExtra(Intent.EXTRA_SUBJECT, "QUERY");
                startActivity(email);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9810105506"));
                startActivity(intent);
            }
        });
    }
}
