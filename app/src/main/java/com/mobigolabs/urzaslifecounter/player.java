package com.mobigolabs.urzaslifecounter;
import org.json.JSONException;
import org.json.JSONObject;

public class player {

    private String mName;
    private String mLifeTotal;
    private String mNotes;

    private int mPlayerLifeValue;

    private static final String JSON_NAME = "name";
    private static final String JSON_LIFETOTAL = "life total";
    private static final String JSON_NOTES = "player notes";

    // Only used when new is called with a JSONObject
    public player(JSONObject jo) throws JSONException {
        mName =  jo.getString(JSON_NAME);
        mLifeTotal = jo.getString(JSON_LIFETOTAL);
        mNotes = jo.getString(JSON_NOTES);
    }

    // Now we must provide an empty default constructor for when we create a Note
    public player (){

    }

    public JSONObject convertToJSON() throws JSONException{
        JSONObject jo = new JSONObject();

        jo.put(JSON_NAME, mName);
        jo.put(JSON_LIFETOTAL, mLifeTotal);
        jo.put(JSON_NOTES, mNotes);

        return jo;
    }

    public String getmNotes() {
        return mNotes;
    }

    public void setmNotes(String mNotes) {
        this.mNotes = mNotes;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLifeTotal() {
        return mLifeTotal;
    }

    public void setmLifeTotal(String mLifeTotal) {
        this.mLifeTotal = mLifeTotal;
    }

    public int getmPlayerLifeValue() {
        return mPlayerLifeValue;
    }

    public void setmPlayerLifeValue(int mplayerLifeValue) {
        this.mPlayerLifeValue = mplayerLifeValue;
    }
}
