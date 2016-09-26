package com.example.kimji.helper_fourth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaninfoActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 1002;
    ArrayList<String> spinnerlist = new ArrayList<String>();
    TextView country_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planinfo);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinnerlist.add("1박 2일");
        spinnerlist.add("2박 3일");
        spinnerlist.add("3박 4일");
        spinnerlist.add("4박 5일");
        spinnerlist.add("5일 이상");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                spinnerlist);
        spinner.setAdapter(adapter);


    }
    public void countryChoiceClicked(View v){
        Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }
    public void planMakeClicked(View v){
        Intent intent = new Intent(getApplicationContext(), SHlistActivity.class);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_MENU){
            Toast toast = Toast.makeText(getBaseContext(), "요청코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if(resultCode == RESULT_OK){
                String country = intent.getExtras().getString("country");
                toast = Toast.makeText(getBaseContext(),"전달된 country : " + country,Toast.LENGTH_LONG);
                toast.show();

                country_name = (TextView) findViewById(R.id.textView5);
                country_name.setText(country);
            }
        }
    }

}