package it.finzicontini.simpleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_H extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h);
        Button goToA = findViewById(R.id.button_from_h_to_a);
        goToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_H.this, Activity_A.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_H.this.startActivity(i);
            }
        });
        Button goToI= findViewById(R.id.button_from_h_to_i);
        goToI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_H.this, Activity_I.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_H.this.startActivity(i);
            }
        });

        Button goToG = findViewById(R.id.button_from_h_to_g);
        goToG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_H.this, Activity_G.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_H.this.startActivity(i);
            }
        });
    }
}
