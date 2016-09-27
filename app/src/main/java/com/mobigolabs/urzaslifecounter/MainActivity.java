// adding a comment to deploy to Codeship

package com.mobigolabs.urzaslifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    // Declaring our buttons for increasing and decreasing life. --------------------------------

    private int oppValue = 20;
    private int yourValue = 20;

    private int oppPoisonValue = 0;
    private int oppEnergyValue = 0;
    private int yourEnergyValue = 0;
    private int yourPoisonValue = 0;

    private Button btnAddOpp;
    private Button btnDecreaseOpp;
    private Button btnAddLife;
    private Button btnDecreaseLife;

    private Button btnAddYourEnergy;
    private Button btnDecreaseYourEnergy;
    private Button btnAddOppEnergy;
    private Button btnDecreaseOppEnergy;


    private Button btnAddYourPoison;
    private Button btnDecreaseYourPoison;
    private Button btnAddOppPoison;
    private Button btnDecreaseOppPoison;

    private Button btnRestart;


    private TextView oppLife;
    private TextView yourLife;

    private TextView yourPoisonCount;
    private TextView yourEnergyCount;
    private TextView oppPoisonCount;
    private TextView oppEnergyCount;


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

        // Initializing our buttons for energy, poison and totals -------------------------------

        btnAddYourEnergy = (Button) findViewById(R.id.increaseYourEnergy);
        btnDecreaseYourEnergy = (Button) findViewById(R.id.decreaseYourEnergy);

        btnAddYourPoison = (Button) findViewById(R.id.increaseYourPoison);
        btnDecreaseYourPoison = (Button) findViewById(R.id.decreaseYourPoison);

        yourEnergyCount = (TextView) findViewById(R.id.yourEnergyCounter);
        yourPoisonCount = (TextView) findViewById(R.id.yourPoisonCounter);

        // Initializing our opponents buttons for energy, poison and totals ---------------------

        btnAddOppEnergy = (Button) findViewById(R.id.increaseOppEnergy);
        btnDecreaseOppEnergy = (Button) findViewById(R.id.decreaseOppEnergy);

        btnAddOppPoison = (Button) findViewById(R.id.increaseOppPoison);
        btnDecreaseOppPoison = (Button) findViewById(R.id.decreaseOppPoison);

        oppEnergyCount = (TextView) findViewById(R.id.energyCountOpp);
        oppPoisonCount = (TextView) findViewById(R.id.poisonCounterOpp);

        // Initializing extra buttons -----------------------------------------------------------

        btnRestart = (Button) findViewById(R.id.newGame);

        // Setting onClick listeners for the buttons --------------------------------------------

        btnAddLife.setOnClickListener(this);
        btnDecreaseLife.setOnClickListener(this);
        btnAddOpp.setOnClickListener(this);
        btnDecreaseOpp.setOnClickListener(this);
        btnRestart.setOnClickListener(this);
        btnAddYourEnergy.setOnClickListener(this);
        btnDecreaseYourEnergy.setOnClickListener(this);
        btnAddYourPoison.setOnClickListener(this);
        btnDecreaseYourPoison.setOnClickListener(this);
        btnAddOppEnergy.setOnClickListener(this);
        btnDecreaseOppEnergy.setOnClickListener(this);
        btnAddOppPoison.setOnClickListener(this);
        btnDecreaseOppPoison.setOnClickListener(this);

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
            case R.id.increaseYourEnergy:
                yourEnergyValue ++;
                yourEnergyCount.setText("" + yourEnergyValue);
                break;
            case R.id.decreaseYourEnergy:
                yourEnergyValue --;
                yourEnergyCount.setText("" + yourEnergyValue);
                break;
            case R.id.increaseYourPoison:
                yourPoisonValue ++;
                yourPoisonCount.setText("" + yourPoisonValue);
                break;
            case R.id.decreaseYourPoison:
                yourPoisonValue --;
                yourPoisonCount.setText("" + yourPoisonValue);
                break;

            case R.id.increaseOppEnergy:
                oppEnergyValue ++;
                oppEnergyCount.setText("" + oppEnergyValue);
                break;
            case R.id.decreaseOppEnergy:
                oppEnergyValue --;
                oppEnergyCount.setText("" + oppEnergyValue);
                break;
            case R.id.increaseOppPoison:
                oppPoisonValue ++;
                oppPoisonCount.setText("" + oppPoisonValue);
                break;
            case R.id.decreaseOppPoison:
                oppPoisonValue --;
                oppPoisonCount.setText("" + oppPoisonValue);
                break;



            case R.id.newGame:
                yourValue = 20;
                oppValue = 20;
                yourEnergyValue = 0;
                yourPoisonValue = 0;
                oppEnergyValue = 0;
                oppPoisonValue = 0;
                yourLife.setText("" + yourValue);
                oppLife.setText("" + oppValue);
                yourEnergyCount.setText("" + yourEnergyValue);
                yourPoisonCount.setText("" + yourPoisonValue);
                oppEnergyCount.setText("" + oppEnergyValue);
                oppPoisonCount.setText("" + oppPoisonValue);
                Toast.makeText(MainActivity.this, "A new game has started",
                        Toast.LENGTH_LONG).show();
                break;

        }

    }

    // setting up menu options and inflating it --------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //--------------------------------------------------------------------------
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
