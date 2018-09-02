package it.finzicontini.simpleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Button goToB = findViewById(R.id.button_from_a_to_b);
        goToB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_A.this, Activity_B.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_A.this.startActivity(i);
            }
        });

        Button goToH = findViewById(R.id.button_from_a_to_h);
        goToH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_A.this, Activity_H.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Activity_A.this.startActivity(i);
            }
        });
    }
}
