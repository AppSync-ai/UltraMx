package com.example.ultramx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.nodes.ForexRates;

import java.util.ArrayList;

import static android.util.Log.*;
import static android.util.Log.wtf;

public class MainActivity extends AppCompatActivity implements ForexRates.Rates {

    RecyclerView recycler;
    RatesAdapter adapter;
    ArrayList<RatesReq> arr_list;
    FloatingActionButton refresh_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ForexRates.getAllRates(this);

        refresh_btn = findViewById(R.id.refresh_btn);
        refresh_btn.setVisibility(View.GONE);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        arr_list = new ArrayList<>();
        adapter = new RatesAdapter(arr_list);
        recycler.setAdapter(adapter);

        refresh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh_btn.setVisibility(View.GONE);
                ForexRates.getAllRates(MainActivity.this);
            }
        });


    }

    @Override
    public void FRates(ArrayList<RatesReq> list) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                arr_list.addAll(list);
                adapter.notifyDataSetChanged();
                wtf("Hulk-44", arr_list.size() + "");
                refresh_btn.setVisibility(View.VISIBLE);
            }
        });

//        wtf("Hulk-26",
//                "Size : " + list.size() + "\n" +
//                        "" + list.get(0).getCURRENCY() + "\n" +
//                        "" + list.get(0).getPRICE() + "\n" +
//                        "" + list.get(0).getCHANGE() + "\n" +
//                        "" + list.get(0).getCHANGE_percent() + "\n" +
//                        "" + list.get(0).getLOW_HIGH() + "\n" +
//                        "");

    }

    @Override
    public void FailedToLoad(String error) {
        wtf("Hulk-38", error);
    }
}