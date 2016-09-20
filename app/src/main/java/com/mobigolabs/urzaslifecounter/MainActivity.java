package com.mobigolabs.urzaslifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    // Declaring our buttons for increasing and decreasing life. --------------------------------

    private int oppValue = 20;
    private int yourValue = 20;

    private Button btnAddOpp;
    private Button btnDecreaseOpp;
    private Button btnAddLife;
    private Button btnDecreaseLife;
    private Button btnRestart;

    private TextView oppLife;
    private TextView yourLife;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecounter_layout);

        // Initializing our opponents buttons and life total ------------------------------------

        btnAddOpp = (Button) findViewById(R.id.increaseOppLife);
        btnDecreaseOpp = (Button) findViewById(R.id.decreaseOppLife);
        oppLife = (TextView) findViewById(R.id.oppLifeTotal);

        // Initializing our buttons and life total ----------------------------------------------

        btnAddLife = (Button) findViewById(R.id.increaseYourLife);
        btnDecreaseLife = (Button) findViewById(R.id.decreaseYourLife);
        yourLife = (TextView) findViewById(R.id.yourLifeTotal);

        // Initializing extra buttons -----------------------------------------------------------

        btnRestart = (Button) findViewById(R.id.newGame);

        // Setting onClick listeners for the buttons --------------------------------------------

        btnAddLife.setOnClickListener(this);
        btnDecreaseLife.setOnClickListener(this);
        btnAddOpp.setOnClickListener(this);
        btnDecreaseOpp.setOnClickListener(this);
        btnRestart.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.increaseOppLife:
                oppValue ++;
                oppLife.setText("" + oppValue);
                break;
            case R.id.decreaseOppLife:
                oppValue --;
                oppLife.setText("" + oppValue);
                break;
            case R.id.increaseYourLife:
                yourValue ++;
                yourLife.setText("" + yourValue);
                break;
            case R.id.decreaseYourLife:
                yourValue --;
                yourLife.setText("" + yourValue);
                break;
            case R.id.newGame:
                yourValue = 20;
                oppValue = 20;
                yourLife.setText("" + yourValue);
                oppLife.setText("" + oppValue);
                Toast.makeText(MainActivity.this, "A new game has started",
                        Toast.LENGTH_LONG).show();
                break;

        }

    }
}
