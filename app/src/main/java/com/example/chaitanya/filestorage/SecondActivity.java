package com.example.chaitanya.filestorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by chaitanyatanna on 3/8/16.
 */
public class SecondActivity extends AppCompatActivity {

    TextView textViewName;
    Button buttonLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        textViewName = (TextView) findViewById(R.id.textUsername);
        buttonLoad = (Button) findViewById(R.id.btn_load);

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = openFileInput("file.txt");
                    int read = -1;
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((read = fileInputStream.read()) != -1) {
                        stringBuffer.append((char) read);
                    }
                    textViewName.setText(stringBuffer.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
