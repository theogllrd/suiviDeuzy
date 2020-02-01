package com.example.suivideuzyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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



    public void onButtonClicked(View v) {
        // Toast.makeText(v.getContext(), ((Button) v).getId() + " clicked", Toast.LENGTH_SHORT).show();
        Bundle myBdl = new Bundle();
        myBdl.putString("SpaceName", (String) ((Button) v).getText());

        Intent versSpaceViewActivity = new Intent(this,SpaceViewActivity.class);
        versSpaceViewActivity.putExtras(myBdl);
        startActivity(versSpaceViewActivity);
    }


}
