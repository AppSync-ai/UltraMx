package com.example.ultramx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.mt.lamdatrack.Rate.RatesReq;
import com.mt.lamdatrack.Rate.nodes.ForexRates;

import java.util.ArrayList;

import static android.util.Log.wtf;

public class MainActivity extends AppCompatActivity implements ForexRates.Rates {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ForexRates.getAllRates(this);
    }

    @Override
    public void FRates(ArrayList<RatesReq> list) {
        wtf("Hulk-26",
                "Size : " + list.size() + "\n" +
                        "" + list.get(0).getCURRENCY() + "\n" +
                        "" + list.get(0).getPRICE() + "\n" +
                        "" + list.get(0).getCHANGE() + "\n" +
                        "" + list.get(0).getCHANGE_percent() + "\n" +
                        "" + list.get(0).getLOW_HIGH() + "\n" +
                        "");
    }

    @Override
    public void FailedToLoad(String error) {
        wtf("Hulk-38", error);
    }
}