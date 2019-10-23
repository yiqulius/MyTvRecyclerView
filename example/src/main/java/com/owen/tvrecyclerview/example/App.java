package com.owen.tvrecyclerview.example;

import android.app.Application;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

/**
 * Created by owen on 2017/8/8.
 * 
 */

public class App extends Application {
    private static App instance;
    final static float DESIGN_WIDTH = 1280; //绘制页面时参照的设计图宽度
    
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        DisplayAdaptive.getInstance().init(DESIGN_WIDTH, this);
        AutoSizeConfig.getInstance().getUnitsManager().setSupportSubunits(Subunits.PT);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
//        DisplayAdaptive.getInstance().release();
    }
    
    public static App get() {
        return instance;
    }
}
