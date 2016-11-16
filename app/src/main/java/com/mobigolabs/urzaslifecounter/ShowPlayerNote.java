package com.mobigolabs.urzaslifecounter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ShowPlayerNote extends DialogFragment {

    private player mPlayerNote;

    @Override
    public Dialog onCreateDialog(Bundle savedInstaceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();


        View diaglogView = inflater.inflate(R.layout.show_player_notes, null);
        TextView txtTitle = (TextView) diaglogView.findViewById(R.id.notesTitle);
        final TextView txtDescription = (TextView) diaglogView.findViewById(R.id.playerNotes);

        TextView showNotes = (TextView) diaglogView.findViewById(R.id.noteView);
        showNotes.setText(mPlayerNote.getmNotes());

        Button btnOK = (Button) diaglogView.findViewById(R.id.btnOK);

        builder.setView(diaglogView);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayerNote.setmNotes(txtDescription.getText().toString());
                dismiss();
            } });

        return builder.create();
    }

    public void sendPlayerSelected(player playerSelected) {
        mPlayerNote = playerSelected;
    }
}
