package it.finzicontini.simpleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_B extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Button goToA = findViewById(R.id.button_from_b_to_a);
        goToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_B.this, Activity_A.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_B.this.startActivity(i);
            }
        });

        Button goToC = findViewById(R.id.button_from_b_to_c);
        goToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_B.this, Activity_C.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_B.this.startActivity(i);
            }
        });

        Button goToH = findViewById(R.id.button_from_b_to_h);
        goToH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_B.this, Activity_H.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_B.this.startActivity(i);
            }
        });

    }
}
