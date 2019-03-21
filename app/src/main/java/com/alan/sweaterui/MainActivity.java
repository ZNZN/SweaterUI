package com.alan.sweaterui;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "SweaterActivity";

    private final SparseArray<Fragment> fragmentCache = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        setTitle("SweaterUI");
        setContentView(R.layout.activity_main);

        FragmentTransaction transToIndex = getSupportFragmentManager().beginTransaction();
        transToIndex.add(R.id.fragment_container, new IndexFragment());
        transToIndex.commit();
    }

    @Override
    protected  void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected  void onResume() {
        super.onResume();
    }

    @Override
    protected  void onPause() {
        super.onPause();
    }

    @Override
    protected  void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    Fragment getFragment(@LayoutRes final int layoutResId) {
        Fragment fragment = fragmentCache.get(layoutResId);
        if (null == fragment) {
            switch(layoutResId) {
                case R.layout.fragment_layout:
                    fragment = new LayoutFragment();
                    break;
                case R.layout.fragment_index:
                    fragment = new IndexFragment();
                    break;
                default:
                    // Intentionally empty
                    break;
            }

            if (null != fragment) {
                fragmentCache.put(layoutResId, fragment);
            }
        }

        return fragment;
    }
}
