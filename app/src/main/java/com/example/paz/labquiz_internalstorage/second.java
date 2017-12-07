package com.example.paz.labquiz_internalstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class second extends AppCompatActivity {
    TextView author, quote; FileInputStream fis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        author = (TextView) findViewById(R.id.tvAuthor);
        quote = (TextView) findViewById(R.id.tvQuote);

        String filename = "author.txt";
        String filename1 = "quote.txt";
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        int read = 0;

        try{
            fis = openFileInput(filename);
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }

            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            fis = openFileInput(filename1);
            while((read = fis.read()) != -1){
                buffer1.append((char)read);
            }

            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        author.setText(buffer.toString());
        quote.setText(buffer1.toString());

    }
    public void back(View view){
        Intent intent = new Intent(this,first.class);
        startActivity(intent);
    }
}