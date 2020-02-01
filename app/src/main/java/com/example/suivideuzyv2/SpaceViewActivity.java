package com.example.suivideuzyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SpaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_view);

        Bundle bdl = this.getIntent().getExtras();
        String SpaceName = bdl.getString("SpaceName");
        Toast t = Toast.makeText(this,"SpaceName = "+ SpaceName, Toast.LENGTH_LONG);
        t.show();

        this.setTitle(SpaceName);
    }
}
