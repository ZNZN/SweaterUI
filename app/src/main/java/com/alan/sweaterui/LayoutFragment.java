package com.alan.sweaterui;


import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LayoutFragment extends Fragment {
    private final String TAG = "LayoutFragment";
    private boolean mShownDetail;

    public LayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        final ConstraintLayout root = (ConstraintLayout) inflater.inflate(R.layout.fragment_layout,
                container, false);
        mShownDetail = false;

        // obtain ConstraintLayout LayoutParams
        final ConstraintSet defaultLayoutSet = new ConstraintSet();
        defaultLayoutSet.clone(root);
        final ConstraintSet layoutSet = new ConstraintSet();
        layoutSet.clone(getActivity(), R.layout.fragment_layout_1);

        // add click listener
        root.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(root);
                if (mShownDetail) {
                    defaultLayoutSet.applyTo(root);
                } else {
                    layoutSet.applyTo(root);
                }
                mShownDetail = !mShownDetail;
            }
        });
        return root;
    }
}
