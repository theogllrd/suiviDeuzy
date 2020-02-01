package com.example.suivideuzyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Bundle bdl = this.getIntent().getExtras();
        String SpaceName = bdl.getString("SpaceName");
        this.setTitle(SpaceName);
    }
}
