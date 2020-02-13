package com.example.suivideuzyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class IndicatorViewActivity extends AppCompatActivity {

    private int idIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_view);

        Bundle bdl = this.getIntent().getExtras();

        this.idIndicator = bdl.getInt("idIndicator");
        this.setTitle("Indicator " + this.idIndicator);
    }
}
