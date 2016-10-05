package com.mobigolabs.urzaslifecounter;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class JSONSerializer {

    private String mFilename;
    private Context mContext;

    public JSONSerializer(String fn, Context context){
        mFilename = fn;
        mContext = context;
    }

    public void save(List<player> players) throws IOException, JSONException{

        // Make an array in JSON format
        JSONArray jArray = new JSONArray();

        // And load it with the notes
        for (player n : players)
            jArray.put(n.convertToJSON());

        // Now write it to the private disk space of our app
        Writer writer = null;

        try {
            OutputStream out = mContext.openFileOutput(mFilename, mContext.MODE_PRIVATE);

            writer = new OutputStreamWriter(out);
            writer.write(jArray.toString());
        }
        finally {
            if (writer != null) {

                writer.close();
            }
        }
    }

    public ArrayList<player> load() throws IOException, JSONException {
        ArrayList<player> playerList = new ArrayList<player>();

        BufferedReader reader = null;
        try {


            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {

                jsonString.append(line);
            }


            JSONArray jArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0; i < jArray.length(); i++) {
                playerList.add(new player(jArray.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // we will ignore this one, since it happens when we start fresh
        } finally {
            if (reader != null)
                reader.close();
        }

        return playerList;
    }
}
