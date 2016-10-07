package com.mobigolabs.urzaslifecounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{


    // Setting up layout and setting the list for users and adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerAdapter = new PlayerAdapter();

        ListView listPlayer = (ListView) findViewById(R.id.listView);

        assert listPlayer != null;
        listPlayer.setAdapter(mPlayerAdapter);

        listPlayer.setLongClickable(true);

        listPlayer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int whichItem, long id) {
                // Ask NoteAdapter to delete this entry

                Log.i("info", "Long clicking item");

                mPlayerAdapter.deletePlayer(whichItem);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handles the settings bar

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

    private PlayerAdapter mPlayerAdapter;

    public void createNewPlayer(player n){

        mPlayerAdapter.addPlayer(n);
    }

    // Handles the display and layout of multiple players

    public class PlayerAdapter extends BaseAdapter {

        // setting the mSerializer variable -------------------------------------------------------
        private JSONSerializer mSerializer;

        // player Adapter method which sets up the Serializer to store the JSON data into file ----
        public PlayerAdapter(){
            mSerializer = new JSONSerializer("urzaslifecounter.json",MainActivity.this.getApplicationContext());
            try {
                playerList = mSerializer.load();
            } catch (Exception e) {
                playerList = new ArrayList<>();
                Log.e("Error loading notes: ", "", e);
            }
        }

        // This is saving the notes when you leave the page. --------------------------------------
        public void savePlayers(){
            try{
                mSerializer.save(playerList);
            }
            catch(Exception e){
                Log.e("Error Saving Notes","", e);
            }
        }

        public void deletePlayer(int n){
            playerList.remove(n);
            notifyDataSetChanged();
        }

        // creating the list of players -----------------------------------------------------------
        List<player> playerList = new ArrayList<>();

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
        public View getView(final int whichItem, View view, ViewGroup viewGroup) {

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.lifecounter_layout, viewGroup, false);
            }
            view.setLongClickable(true);

            // Grab a reference to the widget layouts
            TextView playerName = (TextView) view.findViewById(R.id.yourLife);
            final TextView playerLife = (TextView) view.findViewById(R.id.yourLifeTotal);
            Button btnNotes = (Button) view.findViewById(R.id.btnNotes);

            Button btnPlus = (Button) view.findViewById(R.id.increaseYourLife);
            Button btnMinus = (Button) view.findViewById(R.id.decreaseYourLife);

            // Hide any ImageView widgets that are not relevant
            final player tempPlayer = playerList.get(whichItem);

            // Add the text to the heading
            playerName.setText(tempPlayer.getmName());
            playerLife.setText(tempPlayer.getmLifeTotal());

            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int totalLife = tempPlayer.getmPlayerLifeValue();
                    int decreaseLife = totalLife-1;
                    tempPlayer.setmPlayerLifeValue(decreaseLife);
                    tempPlayer.setmLifeTotal(String.valueOf(decreaseLife));
                    playerLife.setText(String.valueOf(decreaseLife));
                }
            });

            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int totalLife = tempPlayer.getmPlayerLifeValue();
                    int increaseLife = totalLife+1;
                    tempPlayer.setmPlayerLifeValue(increaseLife);
                    tempPlayer.setmLifeTotal(String.valueOf(increaseLife));
                    playerLife.setText(String.valueOf(increaseLife));
                }
            });

            btnNotes.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v){
                    player tempPlayer = mPlayerAdapter.getItem(whichItem);
                    // Create a new dialog window
                    ShowPlayerNote dialog = new ShowPlayerNote();
                    // Send in a reference to the note to be shown
                    dialog.sendPlayerSelected(tempPlayer);
                    // Show the dialog window with the note in it
                    dialog.show(getFragmentManager(), "");
                }
            });

            return view;
        }

        public void addPlayer(player n) {
            playerList.add(n);
            notifyDataSetChanged();
        }

    }

    @Override
    protected void onResume(){
        super.onResume();

        SharedPreferences mPrefs = getSharedPreferences("urzaslifecounter", MODE_PRIVATE);
        boolean mSound = mPrefs.getBoolean("sound", true);
        int mAnimOption = mPrefs.getInt("anim option", SettingsActivity.FAST);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mPlayerAdapter.savePlayers();
    }
}
