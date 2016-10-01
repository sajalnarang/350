package com.example.android.a350;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    String players[]=new String[6];
    ArrayAdapter<String> adapter;
    String score[]=new String[6];
    float b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Spinner sp1=(Spinner)findViewById(R.id.sp1);
        Spinner sp2=(Spinner)findViewById(R.id.sp2);
        Spinner sp3=(Spinner)findViewById(R.id.sp3);
        Intent intent=getIntent();
        score=intent.getStringArrayExtra("Scores");
        players=intent.getStringArrayExtra("Players");
        java.util.ArrayList<String> strings=new java.util.ArrayList<>();
        for (int i=0;i<6;i++)
            strings.add(players[i]);
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, strings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);
        sp3.setAdapter(adapter);
    }
    public void updateScores(View view) {
        Spinner sp1=(Spinner)findViewById(R.id.sp1);
        Spinner sp2=(Spinner)findViewById(R.id.sp2);
        Spinner sp3=(Spinner)findViewById(R.id.sp3);
        EditText bet=(EditText)findViewById(R.id.bet);
        b=Float.parseFloat(String.valueOf(bet.getText()));
        if((b >= 200) && (b <= 350) && ((b % 5) == 0)) {
            score[(int)sp1.getSelectedItemId()]=Float.toString(Float.parseFloat(score[(int)sp1.getSelectedItemId()])+b);
            score[(int)sp2.getSelectedItemId()]=Float.toString(Float.parseFloat(score[(int)sp2.getSelectedItemId()])+(b/2));
            score[(int)sp3.getSelectedItemId()]=Float.toString(Float.parseFloat(score[(int)sp3.getSelectedItemId()])+(b/2));
            Intent intent = new Intent(Main2Activity.this, Game.class);
            intent.putExtra("Players", players);
            intent.putExtra("Scores",score);
            intent.putExtra("Bet", b);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter valid bet amount",Toast.LENGTH_SHORT);
        }
    }
    public void cancelAdd(View view) {
        Intent intent = new Intent(Main2Activity.this,Game.class);
        intent.putExtra("Players",players);
        intent.putExtra("Scores",score);
        startActivity(intent);
    }

    public void decreaseScores(View view) {
        Spinner sp1=(Spinner)findViewById(R.id.sp1);
        Spinner sp2=(Spinner)findViewById(R.id.sp2);
        Spinner sp3=(Spinner)findViewById(R.id.sp3);
        EditText bet=(EditText)findViewById(R.id.bet);
        b=Float.parseFloat(String.valueOf(bet.getText()));
        if((b >= 200) && (b <= 350) && ((b % 5) == 0)) {
            score[(int)sp1.getSelectedItemId()]=Float.toString(Float.parseFloat(score[(int)sp1.getSelectedItemId()])-b);
            score[(int)sp2.getSelectedItemId()]=Float.toString(Float.parseFloat(score[(int)sp2.getSelectedItemId()])-(b/2));
            score[(int)sp3.getSelectedItemId()]=Float.toString(Float.parseFloat(score[(int)sp3.getSelectedItemId()])-(b/2));
            Intent intent = new Intent(Main2Activity.this, Game.class);
            intent.putExtra("Players", players);
            intent.putExtra("Scores",score);
            intent.putExtra("Bet", b);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter valid bet amount",Toast.LENGTH_SHORT);
        }
    }

    public void removePlaceholder(View view) {
        EditText bet=(EditText)findViewById(R.id.bet);
        bet.setText("");
    }
}
