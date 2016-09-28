package com.mobigolabs.urzaslifecounter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class showPlayer extends Fragment implements View.OnClickListener {

    private player mPlayer;
    private int yourValue = 20;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        final View playerView = inflater.inflate(R.layout.lifecounter_layout, null);

        // Initializing our buttons and life total ----------------------------------------------

        TextView yourLife = (TextView) playerView.findViewById(R.id.yourLife);
        final TextView yourLifeTotal = (TextView) playerView.findViewById(R.id.yourLifeTotal);

        Button btnAddLife = (Button) playerView.findViewById(R.id.increaseYourLife);
        btnAddLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourValue ++;
                yourLifeTotal.setText("" + yourValue);
            }
        });

        Button btnDecreaseLife = (Button) playerView.findViewById(R.id.decreaseYourLife);
        btnDecreaseLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yourValue --;
                yourLifeTotal.setText("" + yourValue);
            }
        });

        return inflater.inflate(R.layout.lifecounter_layout,container,false);
    }

    public void onClick(View view){


    }

    //Receive a player from the MainActivity
        public void sendPlayerSelected(player playerSelected) {
            mPlayer = playerSelected;
        }
}

