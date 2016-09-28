// adding a comment to deploy to Codeship

package com.mobigolabs.urzaslifecounter;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    android.app.FragmentManager fragmentManager = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View view){


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

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //NewPlayer magicPlayer = new NewPlayer();
                //magicPlayer.show(getFragmentManager(), "");

                showPlayer newMagicPlayer = new showPlayer();

                newMagicPlayer.sendPlayerSelected(mTempPlayer);

                transaction.add(R.id.fragment_holder,newMagicPlayer);
                transaction.commit();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
