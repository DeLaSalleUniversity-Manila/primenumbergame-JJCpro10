package com.example.janssen.primenumbersgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int number;
    private int score;
    private boolean answer;

    public void onClickPrime(View view){
        answer = true;
        verifyAnswer();
        displayScore();
        displayRandomNumber();
    }

    public void onClickComposite(View view){
        answer = false;
        verifyAnswer();
        displayScore();
        displayRandomNumber();
    }

    private void verifyAnswer() {
        if (answer ^ !(isPrime(number))){
            score++;
            Toast.makeText(this, "You are Correct!!",Toast.LENGTH_SHORT).show();
        }
        else{
            score = score - 5;
            Toast.makeText(this, "You are wrong.",Toast.LENGTH_SHORT).show();

        }


    }

    private boolean isPrime(int value){
        Boolean x = true;
        for (int y = 2; y < Math.sqrt(value); y++) {
            if (value % y == 0) {
                x = false;
            }
        }
        return x;
    }

    private void displayRandomNumber(){
        Random z = new Random();
        number = 2 + z.nextInt(1000);
        TextView tv = (TextView) findViewById(R.id.textViewNumber);
        tv.setText("" +number);
    }

    private void displayScore(){
        TextView f = (TextView) findViewById(R.id.textViewScore);
        f.setText("Your score is" + score);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayRandomNumber();



            }

    }



