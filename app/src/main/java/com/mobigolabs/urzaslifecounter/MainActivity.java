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

    private int yourValue = 20;

    private int yourEnergyValue = 0;
    private int yourPoisonValue = 0;

    private Button btnAddLife;
    private Button btnDecreaseLife;

    private Button btnAddYourEnergy;
    private Button btnDecreaseYourEnergy;


    private Button btnAddYourPoison;
    private Button btnDecreaseYourPoison;


    private TextView yourLife;

    private TextView yourPoisonCount;
    private TextView yourEnergyCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecounter_layout);


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



        // Setting onClick listeners for the buttons --------------------------------------------

        btnAddLife.setOnClickListener(this);
        btnDecreaseLife.setOnClickListener(this);
        btnAddYourEnergy.setOnClickListener(this);
        btnDecreaseYourEnergy.setOnClickListener(this);
        btnAddYourPoison.setOnClickListener(this);
        btnDecreaseYourPoison.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
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

        }

    }

    private void newGame(){

        yourValue = 20;
        yourEnergyValue = 0;
        yourPoisonValue = 0;
        yourLife.setText("" + yourValue);
        yourEnergyCount.setText("" + yourEnergyValue);
        yourPoisonCount.setText("" + yourPoisonValue);
        Toast.makeText(MainActivity.this, "A new game has started",
                Toast.LENGTH_LONG).show();
    }

    private void flipCoin(){

    }

    private void diceRoll(){

    }

    player mTempPlayer = new player();

    public void createNewPlayer(player n){
        //Temporary code
        mTempPlayer = n;
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
        switch (id){

            case R.id.action_roll:
                roleDice dice = new roleDice();
                dice.show(getFragmentManager(),"");
                break;
            case R.id.action_add:
                NewPlayer magicPlayer = new NewPlayer();
                magicPlayer.show(getFragmentManager(), "");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
