package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClick(View view) {
        Button btnSelected = (Button)view;
        btnSelected.setEnabled(false);
        int id = 0;

        switch(btnSelected.getId()) {

            case R.id.btn1:
                id = 1;
                break;
            case R.id.btn2:
                id = 2;
                break;
            case R.id.btn3:
                id = 3;
                break;
            case R.id.btn4:
                id = 4;
                break;
            case R.id.btn5:
                id = 5;
                break;
            case R.id.btn6:
                id = 6;
                break;
            case R.id.btn7:
                id = 7;
                break;
            case R.id.btn8:
                id = 8;
                break;
            case R.id.btn9:
                id = 9;
                break;
        }
        playGame(id,btnSelected);
        winner();
    }

    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();
    int activePlayer = 1;
    int count = 0;

    public void playGame(int id,Button btnSelected) {



        if(activePlayer == 1) {
            btnSelected.setBackgroundColor(Color.CYAN);
            btnSelected.setText("X");
            player1.add(id);
            activePlayer = 2;
            count++;
        }
        else {
            btnSelected.setBackgroundColor(Color.GRAY);
            btnSelected.setText("O");
            player2.add(id);
            activePlayer = 1;
            count++;
        }

    }

    public void winner() {


        if ((player1.contains(1) && player1.contains(2) && player1.contains(3)) || (player1.contains(4) && player1.contains(5) && player1.contains(6)) || (player1.contains(7) && player1.contains(8) && player1.contains(9)) || (player1.contains(1) && player1.contains(4) && player1.contains(7)) || (player1.contains(2) && player1.contains(5) && player1.contains(8)) || (player1.contains(3) && player1.contains(6) && player1.contains(9)) || (player1.contains(1) && player1.contains(5) && player1.contains(9)) || (player1.contains(3) && player1.contains(5) && player1.contains(7))) {
            Toast.makeText(this, "Player 1 Won", Toast.LENGTH_LONG).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } else if ((player2.contains(1) && player2.contains(2) && player2.contains(3)) || (player2.contains(4) && player2.contains(5) && player2.contains(6)) || (player2.contains(7) && player2.contains(8) && player2.contains(9)) || (player2.contains(1) && player2.contains(4) && player2.contains(7)) || (player2.contains(2) && player2.contains(5) && player2.contains(8)) || (player2.contains(3) && player2.contains(6) && player2.contains(9)) || (player2.contains(1) && player2.contains(5) && player2.contains(9)) || (player2.contains(3) && player2.contains(5) && player2.contains(7))) {
            Toast.makeText(this, "Player 2 Won", Toast.LENGTH_LONG).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

        if(count == 9) {
            Toast.makeText(this, "Game Drawn", Toast.LENGTH_LONG).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }
}
