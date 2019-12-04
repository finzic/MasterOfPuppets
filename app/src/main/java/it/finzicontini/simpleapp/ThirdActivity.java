package it.finzicontini.simpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void onClickBtnTo2nd(View v){
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickBtnTo4th(View v){
        Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
        startActivity(intent);
        finish();
    }
}
