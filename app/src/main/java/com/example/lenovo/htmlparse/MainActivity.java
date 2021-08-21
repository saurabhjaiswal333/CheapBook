package com.example.lenovo.htmlparse;




import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    String book=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etbook = (EditText) findViewById(R.id.etbook);
        final Button bsearch = (Button) findViewById(R.id.bsearch);
        book = etbook.getText().toString();
        bsearch.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view)  {
                Intent registerIntent=new Intent(MainActivity.this,Result.class);
                MainActivity.this.startActivity(registerIntent);
                //registerIntent.putExtra("book name", book);

            }

        });

    }/*
    public void call(){
        Result obj = new Result();
        obj.assign(book);
    }*/
}
