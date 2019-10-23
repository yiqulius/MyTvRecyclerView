package com.owen.tvrecyclerview.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.owen.tvrecyclerview.example.fragment.MetroFragment;
import com.owen.tvrecyclerview.utils.Loger;

/**
 * @author ZhouSuQiang
 */
public class MainActivity extends AppCompatActivity{


    private static final String TAG = "MainActivity";
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //是否打开TvRecyclerView的log打印
        Loger.isDebug = true;

        FragmentTransaction mFt = getSupportFragmentManager().beginTransaction();
        if (mFragment == null) {
            mFragment = Fragment.instantiate(MainActivity.this, MetroFragment.class.getName());
            mFt.add(R.id.content, mFragment);
        } else {
            mFt.attach(mFragment);
        }
        mFt.commit();
    }

}
