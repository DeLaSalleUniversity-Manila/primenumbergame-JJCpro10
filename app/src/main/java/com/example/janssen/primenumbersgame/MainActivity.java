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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
