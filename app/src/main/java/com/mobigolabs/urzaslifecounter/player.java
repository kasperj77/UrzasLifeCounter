package com.mobigolabs.urzaslifecounter;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jordan on 9/27/16.
 */
public class player {

    private String mName;
    private int mLifeTotal;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmLifeTotal() {
        return mLifeTotal;
    }

    public void setmLifeTotal(int mLifeTotal) {
        this.mLifeTotal = mLifeTotal;
    }
}
