package com.mobigolabs.urzaslifecounter;

import android.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.util.Log;

import java.util.Random;

/**
 * Created by jordan on 9/27/16.
 */
public class coinFlip extends DialogFragment {

    private String coinFlip(){

        Random r = new Random();
        int randNum = r.nextInt(2) + 1;

        String flippedCoin = "Heads";

        if(randNum == 1){
            flippedCoin = "Tails";
        }

        return flippedCoin;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // add the text

        builder.setMessage("You flipped " + coinFlip());

        // Add the buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });


// Create the AlertDialog
        return builder.create();

    }
}
