package com.mobigolabs.urzaslifecounter;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jordan on 9/27/16.
 */
public class player {

    private String mName;
    private String mLifeTotal;
    private int mPoisonTotal;
    private int mEnergyTotal;

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

    public int getmPoisonTotal() {
        return mPoisonTotal;
    }

    public void setmPoisonTotal(int mPoisonTotal) {
        this.mPoisonTotal = mPoisonTotal;
    }

    public int getmEnergyTotal() {
        return mEnergyTotal;
    }

    public void setmEnergyTotal(int mEnergyTotal) {
        this.mEnergyTotal = mEnergyTotal;
    }
}
