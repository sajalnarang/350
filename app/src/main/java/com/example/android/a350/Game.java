package com.example.android.a350;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    String players[]=new String[6];
    TextView p1,p2,p3,p4,p5,p6;
    TextView s1,s2,s3,s4,s5,s6;
    String score[]=new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        players=intent.getStringArrayExtra("Players");
        if (intent.hasExtra("Scores")) {
            score=intent.getStringArrayExtra("Scores");
        }
        else {
            for (int i=0;i<6;i++) {
                score[i]="0";
            }
        }
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        p1=(TextView)findViewById(R.id.p1);
        p2=(TextView)findViewById(R.id.p2);
        p3=(TextView)findViewById(R.id.p3);
        p4=(TextView)findViewById(R.id.p4);
        p5=(TextView)findViewById(R.id.p5);
        p6=(TextView)findViewById(R.id.p6);
        s1=(TextView)findViewById(R.id.s1);
        s2=(TextView)findViewById(R.id.s2);
        s3=(TextView)findViewById(R.id.s3);
        s4=(TextView)findViewById(R.id.s4);
        s5=(TextView)findViewById(R.id.s5);
        s6=(TextView)findViewById(R.id.s6);
        p1.setText(players[0]);
        p2.setText(players[1]);
        p3.setText(players[2]);
        p4.setText(players[3]);
        p5.setText(players[4]);
        p6.setText(players[5]);
        s1.setText(score[0]);
        s2.setText(score[1]);
        s3.setText(score[2]);
        s4.setText(score[3]);
        s5.setText(score[4]);
        s6.setText(score[5]);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Game.this,Main2Activity.class);
                intent1.putExtra("Players",players);
                intent1.putExtra("Scores",score);
                startActivity(intent1);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
