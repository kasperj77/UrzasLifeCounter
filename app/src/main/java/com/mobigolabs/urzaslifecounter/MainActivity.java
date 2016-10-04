package com.mobigolabs.urzaslifecounter;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private PlayerAdapter mPlayerAdapter;

    public void createNewPlayer(player n) {

        mPlayerAdapter.addPlayer(n);
    }


    // Setting up layout and setting the list for users and adapter -------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerAdapter = new PlayerAdapter();

        ListView listPlayer = (ListView) findViewById(R.id.listView);

        assert listPlayer != null;
        listPlayer.setAdapter(mPlayerAdapter);

    }

    // setting up menu options and inflating it ---------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handles the settings bar -------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
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


    // Handles the display and layout of multiple players -----------------------------------------

    public class PlayerAdapter extends BaseAdapter {

        List<player> playerList = new ArrayList<player>();

        public void addPlayer(player n) {
            playerList.add(n);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {

            return playerList.size();
        }

        @Override
        public player getItem(int whichItem) {
            // Returns the requested note
            return playerList.get(whichItem);
        }

        @Override
        public long getItemId(int whichItem) {
            // Method used internally
            return whichItem;
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup) {

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.lifecounter_layout, viewGroup, false);
            }

            // Grab a reference to the widget layouts
            TextView playerName = (TextView) view.findViewById(R.id.yourLife);
            TextView playerLife = (TextView) view.findViewById(R.id.yourLifeTotal);

            // Hide any ImageView widgets that are not relevant
            player tempPlayer = playerList.get(whichItem);

            // Add the text to the heading
            playerName.setText(tempPlayer.getmName());
            playerLife.setText(tempPlayer.getmLifeTotal());

            return view;
        }
    }

    private boolean mSound;
    private int mAnimOption;
    private SharedPreferences mPrefs;

    @Override
    protected void onResume(){
        super.onResume();

        mPrefs = getSharedPreferences("mobinotes", MODE_PRIVATE);
        mSound = mPrefs.getBoolean("sound",true);
        mAnimOption = mPrefs.getInt("anim option", SettingsActivity.FAST);
    }
}
