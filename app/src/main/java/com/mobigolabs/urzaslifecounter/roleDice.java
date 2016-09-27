package com.mobigolabs.urzaslifecounter;

import android.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import java.util.Random;

/**
 * Created by jordan on 9/27/16.
 */
public class roleDice extends DialogFragment {

    private int rollDice(){

        Random r = new Random();
        int diceRolled = r.nextInt(6) + 1;

        return diceRolled;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // add the text

        builder.setMessage("You rolled a " + rollDice() + " and your opponent rolled a " + rollDice());

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
