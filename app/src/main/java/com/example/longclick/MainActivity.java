package com.example.longclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    Button button;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.zone_list);

        String Name = "Name";
        String Description = "Description";
        Data firstObject = new Data("Anton","Funny kid",12);
        Data secondObject = new Data("Georg","Ded",33);


        map = new HashMap<>();
        map.put(Name,firstObject.getName());
        map.put(Description,firstObject.getDescription());
        arrayList.add(map);

        map = new HashMap<>();
        map.put(Name,secondObject.getName());
        map.put(Description,secondObject.getDescription());
        arrayList.add(map);

        final SimpleAdapter adapter = new SimpleAdapter(this ,arrayList , R.layout.item_list_view ,
                new String[]{Name,Description},
                new int[]{R.id.Name,R.id.Description});
        listView.setAdapter(adapter);

        button = findViewById(R.id.checkBox);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Object number = adapter.getItem(position);
               arrayList.remove(number);
               adapter.notifyDataSetChanged();
            }
        });
    }
}
