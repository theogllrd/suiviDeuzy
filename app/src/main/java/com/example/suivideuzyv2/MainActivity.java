package com.example.suivideuzyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Home");
        this.initButtonSpaces();
    }

    // Creation et affichage du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    // gestion des clics sur les éléments du menu :
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_home :
                // redirection vers l'activité home
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    // init des buttons
    public void initButtonSpaces(){
        LinearLayout linearLayout = findViewById(R.id.spacesList);
        for (int i = 1; i <= 3; i++) {
            Button btn = new Button(this);
            Button btnHistory = new Button(this);
            //btn.setId(i);
            btn.setText("SPACE "+i);
            btnHistory.setText("History of Space "+i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), ((Button) v).getId() + " clicked", Toast.LENGTH_SHORT).show();
                    Bundle myBdl = new Bundle();
                    myBdl.putString("SpaceName", (String) ((Button) v).getText());
                    Intent versSpaceViewActivity = new Intent(getApplicationContext(),SpaceViewActivity.class);
                    versSpaceViewActivity.putExtras(myBdl);
                    startActivity(versSpaceViewActivity);
                }
            });
            btnHistory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle myBdl = new Bundle();
                    myBdl.putString("SpaceName", (String) ((Button) v).getText());
                    Intent versHistoryActivity = new Intent(getApplicationContext(),HistoryActivity.class);
                    versHistoryActivity.putExtras(myBdl);
                    startActivity(versHistoryActivity);
                }
            });


            linearLayout.addView(btn);
            linearLayout.addView(btnHistory);
        }
        // Création du bouton "add space"
        Button btn = new Button(this);
        btn.setText("NEW SPACE");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewSpaceActivity.class));
            }
        });
        linearLayout.addView(btn);
    }


}
