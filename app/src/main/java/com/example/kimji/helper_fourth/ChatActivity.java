package com.example.kimji.helper_fourth;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        final String string1 = (((EditText) findViewById(R.id.editText)).getText()).toString();
        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,items);
        final ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                class bgstuff extends AsyncTask<Void, Void, Void> {

                    EditText input = (EditText) findViewById(R.id.editText);
                    String in = input.getText().toString();

                    String translatedText = "";
                    protected Void doInBackground(Void... params) {

                        try{
                            //String text = "지불하다";
                            //String text = string1;
                            translatedText = translate(in);
                            items.add(translatedText);
                            adapter.notifyDataSetChanged();
                        }
                        catch(Exception e){

                            e.printStackTrace();
                            translatedText = e.toString();
                        }
                        return null;
                    }

                    protected void onPostExecute(Void result){
                        //((TextView) findViewById(R.id.textView)).setText(translatedText);
                        super.onPostExecute(result);
                    }
                }
                new bgstuff().execute();
            }
        });

    }

    public String translate(String text) throws Exception{

        Translate.setClientId("kimjiun94");
        Translate.setClientSecret("8bUCip+dbr0dmM4SsTw8deQJtsmmMnIXmw4MgXIL9mY=");

        String translatedText = "";

        translatedText = Translate.execute(text, Language.KOREAN);

        return translatedText;
    }
}