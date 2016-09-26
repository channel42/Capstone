package com.example.kimji.helper_fourth;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class SHlistActivity extends AppCompatActivity {

    ArrayList<String> mDatas = new ArrayList<String>();
    ListView listView;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shlist);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("관광지 선택하기");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("호텔 선택하기");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);


        mDatas.add("여행계획1");
        mDatas.add("여행계획2");
        mDatas.add("여행계획3");
        mDatas.add("여행계획4");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mDatas);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(listener);

    }



    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(SHlistActivity.this, mDatas.get(position), Toast.LENGTH_SHORT).show();
            String count = mDatas.get(position);


            Intent intent = new Intent(getApplicationContext(), SightActivity.class);
            startActivity(intent);
        }
    };
}