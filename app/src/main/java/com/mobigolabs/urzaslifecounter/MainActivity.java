package com.mobigolabs.urzaslifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    // Declaring our buttons for increasing and decreasing life.

    private int oppValue = 20;
    private int yourValue = 20;

    private Button btnDecreaseOpp;
    private Button btnAddLife;
    private Button btnDecreaseLife;

    private TextView oppLife;
    private TextView yourLife;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecounter_layout);

        // Initializing our opponents buttons and life total

        Button btnAddOpp = (Button) findViewById(R.id.increaseOppLife);
        Button btnDecreaseOpp = (Button) findViewById(R.id.decreaseOppLife);
        TextView oppLife = (TextView) findViewById(R.id.txtValue2);

        // Initializing our buttons and life total

        btnAddLife = (Button) findViewById(R.id.increaseYourLife);
        btnDecreaseLife = (Button) findViewById(R.id.decreaseYourLife);
        yourLife = (TextView) findViewById(R.id.txtValue);

        btnAddLife.setOnClickListener(this);
        btnDecreaseLife.setOnClickListener(this);
        btnAddOpp.setOnClickListener(this);
        btnDecreaseOpp.setOnClickListener(this);

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


        }

    }
}
