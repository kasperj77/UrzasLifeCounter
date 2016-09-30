package com.mobigolabs.urzaslifecounter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPlayer extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        // creating the alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // creating the inflater for activity
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // inflating the dialog new note layout
        View dialogView = inflater.inflate(R.layout.new_player, null);


        // get a reference to each of the UI widgets, marking as final because they will be used

        final EditText playerName = (EditText) dialogView.findViewById(R.id.playerName);

        final EditText playerLife = (EditText) dialogView.findViewById(R.id.playerLife);

        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView);



        // Handle the cancel button onClick -----------------------------------------------------

        btnCancel.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        // Handle the OK button onClick-----------------------------------------------------------

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                // Create a new player
                player newMagicPlayer = new player();

                //Set its variables to match the users entries on the form
                newMagicPlayer.setmName(playerName.getText().toString());
                newMagicPlayer.setmLifeTotal(playerLife.getText().toString());

                // Get a reference to MainActivity
                MainActivity callingActivity = (MainActivity) getActivity();

                // Pass newPlayer back to MainActivity
                callingActivity.createNewPlayer(newMagicPlayer);

                //Quit the dialog
                dismiss();
            }
        });

        return builder.create();
    }
}
