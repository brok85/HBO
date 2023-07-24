package com.arcore.AI_ResourceControl;


import android.content.Context;
import android.media.Image;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ModelRequest {

    private String filename;
    private float percentageReduction;
    private Context appContext;
    private WeakReference<MainActivity> mainActivityWeakReference;
    private int ID;
    private Queue<Integer> similarRequestIDArray;
    private float cache;
    Image imgFrame;
    //private List<Float> cacheratio ;

    ModelRequest(float cr,String filename, float percentageReduction, Context context, MainActivity mainActivity, int mID)
    {
        Log.d("ModelRequest", "Created ModelRequest - filename: " + filename);
        this.filename = filename;
        this.percentageReduction = percentageReduction;
        this.appContext = context;
        this.mainActivityWeakReference = new WeakReference<MainActivity>(mainActivity);
        this.ID = mID;
        this.similarRequestIDArray = new LinkedBlockingQueue<Integer>();
        this.similarRequestIDArray.add(this.ID);
        this.cache=cr;
        //this.cacheratio=new ArrayList<>(cacheratio) ;
    }


    ModelRequest(String aiName, Context context, MainActivity mainActivity,Image img)
    {

        this.filename = aiName;
        Log.d("ModelRequest", "Created ModelRequest - filename: " + filename);
        this.appContext = context;
        this.mainActivityWeakReference = new WeakReference<MainActivity>(mainActivity);
        imgFrame=img;
    }


    public Image getImage()
    {
        return imgFrame;
    }
    public float getCache()
    {
        return cache;
    }
    public float getPercentageReduction()
    {
        return percentageReduction;
    }
    public String getFilename()
    {
        return filename;
    }

    public Context getAppContext()
    {
        return appContext;
    }

    public int getID() { return ID; }
    public Queue<Integer> getSimilarRequestIDArray() { return similarRequestIDArray; }
    public void addIDToArray(int ID)
    {
        similarRequestIDArray.offer(ID);
    }
    public WeakReference<MainActivity> getMainActivityWeakReference()
    {
        return mainActivityWeakReference;
    }






}
