package com.alan.sweaterui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Index fragment of App
 */
public class IndexFragment extends Fragment {
    private final String TAG = "IndexFragment";

    public IndexFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_index, container, false);

        // add Click Listener
        layout.findViewById(R.id.toLayoutBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transToLayout = getFragmentManager().beginTransaction();
                transToLayout.replace(R.id.fragment_container, new LayoutFragment());
                transToLayout.addToBackStack(null);
                transToLayout.commit();
            }
        });

        return layout;
    }

}
