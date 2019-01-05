package com.example.android.rajhackathon;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public String q1() {
        EditText answer = (EditText) findViewById(R.id.name);
        String ans = answer.getText().toString();
        ans = ans.toUpperCase();
        return ans;
    }

    public String q2() {
        CheckBox jasalmer = (CheckBox) findViewById(R.id.q2_opt1);
        CheckBox jaipur = (CheckBox) findViewById(R.id.q2_opt2);
        CheckBox ajmer = (CheckBox) findViewById(R.id.q2_opt3);
        CheckBox udaipur = (CheckBox) findViewById(R.id.q2_opt4);
        String ans = "";
        if(jasalmer.isChecked())
            ans += 1;
        else
            ans +=0;
        if(jaipur.isChecked())
            ans += 1;
        else
            ans +=0;
        if(ajmer.isChecked())
            ans += 1;
        else
            ans +=0;
        if(udaipur.isChecked())
            ans +=1;
        else
            ans +=0;

        return ans;
    }

    public String q3() {
        EditText answer = (EditText) findViewById(R.id.q3_phone);
        String ans = answer.getText().toString();
        return ans;
    }

    public String q4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.q4_rg);
        RadioButton selected_button = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        if (selected_button != null) {
            String ans = selected_button.getText().toString();
            return ans;
        }
        return null;
    }

    public String q5() {
        EditText answer = (EditText) findViewById(R.id.q5_email);
        String ans = answer.getText().toString();
        ans = ans.toLowerCase();
        return ans;
    }

    public void submit(View view) {
        String name = q1();
        String citi = q2();
        String ph = q3();
        String sex = q4();
        String email = q5();
        SQLiteDatabase mydatabase = openOrCreateDatabase("guides",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS GuideTable(Name VARCHAR(30),Citi VARCHAR(20),Phone VARCHAR(15),Sex VARCHAR(10),Email VARCHAR(30));");
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Phone", ph);
        contentValues.put("Email", email);
        contentValues.put("Citi", citi);
        contentValues.put("Sex", sex);
        mydatabase.insert("GuideTable", null, contentValues);
        //mydatabase.execSQL("INSERT INTO GuideTable VALUES(\"name\",\"citi\",\"ph\",\"sex\",\"email\");");
        Context context = getApplicationContext();
        CharSequence text = "Thank you for registering!"+name;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
