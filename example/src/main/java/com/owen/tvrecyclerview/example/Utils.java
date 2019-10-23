package com.owen.tvrecyclerview.example;

import android.content.Context;

public class Utils {
    public static int dp2px(Context context, float dipValue) {
        return (int) ((dipValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
