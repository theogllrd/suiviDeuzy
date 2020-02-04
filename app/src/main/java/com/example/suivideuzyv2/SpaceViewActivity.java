package com.example.suivideuzyv2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SpaceViewActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_view);

        Bundle bdl = this.getIntent().getExtras();

        this.title = bdl.getString("SpaceName"); // On met dans la variable le spaceName
        this.setTitle(title + " - " + android.text.format.DateFormat.format("dd MMMM yyyy", Calendar.getInstance().getTime())); // on affiche le titre avec la date du jour

        this.initButtonIndicators(); // affichage des boutons indicators
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        Date date = c.getTime(); // on recupere la date choisit depuis le calendrier
        this.setTitle(title + " - " + android.text.format.DateFormat.format("dd MMMM yyyy", date)); // on actualise le titre avec la nouvelle date
        // IL FAUT REACTULISER LA LISTE DES INDICATORS POUR LA DATE CHOISIT
    }

    // Creation et affichage du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_with_calendar, menu);
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

            case R.id.action_calendar :
                //startActivity(new Intent(this,CalendarActivity.class));
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // init des buttons
    public void initButtonIndicators(){
        LinearLayout linearLayout = findViewById(R.id.indicatorsList);
        for (int i = 1; i <= 15; i++) {
            Button btn = new Button(this);
            //btn.setId(i);
            btn.setText("INDICATOR "+i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Toast.makeText(v.getContext(), ((Button) v).getId() + " clicked", Toast.LENGTH_SHORT).show();
                    Bundle myBdl = new Bundle();
                    myBdl.putString("SpaceName", (String) ((Button) v).getText());
                    Intent versSpaceViewActivity = new Intent(getApplicationContext(),SpaceViewActivity.class);
                    versSpaceViewActivity.putExtras(myBdl);
                    startActivity(versSpaceViewActivity);*/
                }
            });
            linearLayout.addView(btn);
        }
    }
}
