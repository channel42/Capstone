package com.example.kimji.helper_fourth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        ImageButton koreaButton = (ImageButton) findViewById(R.id.imageButton);
        koreaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("country", "KOREA");

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        ImageButton japanButton = (ImageButton) findViewById(R.id.imageButton2);
        japanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("country", "JAPAN");

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        ImageButton chinaButton = (ImageButton) findViewById(R.id.imageButton3);
        chinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("country", "CHINA");

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

}