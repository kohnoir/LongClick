package com.example.longclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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
    BaseAdapter listContentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.zone_list);

        Data firstObject = new Data(getString(R.string.anton),getString(R.string.anton_description),12);
        Data secondObject = new Data(getString(R.string.georg),getString(R.string.georg_description),33);
        map = new HashMap<>();
        map.put(firstObject.getName(),firstObject.getDescription());
        map.put(secondObject.getName(),secondObject.getDescription());
        arrayList.add(map);

        listContentAdapter = createAdapter(arrayList);
        listView.setAdapter(listContentAdapter);

        button = findViewById(R.id.checkBox);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               arrayList.remove(position);
               listContentAdapter.notifyDataSetChanged();
               listView.setAdapter(listContentAdapter);
            }
        });
    }
    @NonNull
    private BaseAdapter createAdapter(ArrayList arrayList) {
        return new ArrayAdapter<>(this, R.layout.item_list_view, arrayList);
    }

}
