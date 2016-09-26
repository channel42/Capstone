package com.example.kimji.helper_fourth;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ArrayList<String> spinnerlist = new ArrayList<String>();

    String lang1 ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner3);

        spinnerlist.add("KOREAN");
        spinnerlist.add("CHINESE");
        spinnerlist.add("JAPANESE");
        spinnerlist.add("ENGLISH");
        spinnerlist.add("SPANISH");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerlist);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lang1 = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                class bgstuff extends AsyncTask<Void, Void, Void> {

                    EditText input = (EditText) findViewById(R.id.editText6);
                    String in = input.getText().toString();

                    String translatedText = "";
                    protected Void doInBackground(Void... params) {

                        try{
                            //String text = "지불하다";
                            //String text = string1;
                            translatedText = translate(in);
                        }
                        catch(Exception e){

                            e.printStackTrace();
                            translatedText = e.toString();
                        }
                        return null;
                    }

                    protected void onPostExecute(Void result){
                        ((TextView) findViewById(R.id.textView11)).setText(translatedText);
                        //((TextView) findViewById(R.id.textView2)).setText(lang1);
                        super.onPostExecute(result);
                    }
                }
                new bgstuff().execute();
            }
        });

        Button addButton = (Button) findViewById(R.id.button3);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),PlaninfoActivity.class);
                startActivity(intent);
            }
        });

    }

    public String translate(String text) throws Exception{

    Translate.setClientId("kimjiun94");
    Translate.setClientSecret("8bUCip+dbr0dmM4SsTw8deQJtsmmMnIXmw4MgXIL9mY=");

    String translatedText = "";

    if(lang1 == "KOREAN") {
        translatedText = Translate.execute(text, Language.KOREAN);
    }
    else if(lang1 == "CHINESE") {
        translatedText = Translate.execute(text, Language.CHINESE_SIMPLIFIED);
    }
    else if(lang1 == "JAPANESE") {
        translatedText = Translate.execute(text, Language.JAPANESE);
    }
    else if(lang1 == "ENGLISH") {
        translatedText = Translate.execute(text, Language.ENGLISH);
    }
    else if(lang1 == "SPANISH") {
        translatedText = Translate.execute(text, Language.SPANISH);
    }


    return translatedText;
}
}