package com.tarikkilic.connectfour;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.ImageView;

import com.tarikkilic.connectfour.R;

/**
 * Created by tarik on 22.02.2018.
 */

public class imageViews extends ImageView {
    private int x;
    private int y;
    private int cellId;
    private int sariId;
    private int maviId;
    Context c;
    public imageViews(Context context,int i,int j) {
        super(context);
        c = context;
        x = i;
        y = j;
        cellId = R.drawable.bos;
        Drawable cell = AppCompatDrawableManager.get().getDrawable(context,cellId);
        setBackground(cell);
    }

    public void setYellow(){
        sariId = R.drawable.sari;
        Drawable cellY = AppCompatDrawableManager.get().getDrawable(c,sariId);
        setBackground(cellY);
    }

    public void setBlue(){
        maviId = R.drawable.mavi;
        Drawable cellX = AppCompatDrawableManager.get().getDrawable(c,maviId);
        setBackground(cellX);
    }

    public int getI(){
        return x;
    }

    public int getJ(){
        return y;
    }

    public void setEmpty() {
        cellId = R.drawable.bos;
        Drawable cell = AppCompatDrawableManager.get().getDrawable(c,cellId);
        setBackground(cell);
    }
}
