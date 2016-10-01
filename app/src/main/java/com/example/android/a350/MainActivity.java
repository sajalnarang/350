package com.example.android.a350;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText p1,p2,p3,p4,p5,p6;
    String players[] = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1=(EditText)findViewById(R.id.p1);
        p2=(EditText)findViewById(R.id.p2);
        p3=(EditText)findViewById(R.id.p3);
        p4=(EditText)findViewById(R.id.p4);
        p5=(EditText)findViewById(R.id.p5);
        p6=(EditText)findViewById(R.id.p6);
    }

    public void startGame(View view) {
        players[0] = String.valueOf(p1.getText());
        players[1] = String.valueOf(p2.getText());
        players[2] = String.valueOf(p3.getText());
        players[3] = String.valueOf(p4.getText());
        players[4] = String.valueOf(p5.getText());
        players[5] = String.valueOf(p6.getText());
        Intent intent = new Intent(MainActivity.this,Game.class);
        intent.putExtra("Players",players);
        startActivity(intent);
    }

    public void removePlaceholder1(View view) {
        p1=(EditText)findViewById(R.id.p1);
        p1.setText("");
    }
    public void removePlaceholder2(View view) {
        p2=(EditText)findViewById(R.id.p2);
        p2.setText("");
    }
    public void removePlaceholder3(View view) {
        p3=(EditText)findViewById(R.id.p3);
        p3.setText("");
    }
    public void removePlaceholder4(View view) {
        p4=(EditText)findViewById(R.id.p4);
        p4.setText("");
    }
    public void removePlaceholder5(View view) {
        p5=(EditText)findViewById(R.id.p5);
        p5.setText("");
    }
    public void removePlaceholder6(View view) {
        p6=(EditText)findViewById(R.id.p6);
        p6.setText("");
    }

}
