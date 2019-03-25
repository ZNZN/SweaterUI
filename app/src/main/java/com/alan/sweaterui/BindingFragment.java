package com.alan.sweaterui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan.sweaterui.databinding.BindingFragmentBinding;
import com.alan.sweaterui.model.PhotoModel;

public class BindingFragment extends Fragment {
    private BindingFragmentBinding mBinding;
    private PhotoModel mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = BindingFragmentBinding.inflate(inflater, container, false);
        mModel = new PhotoModel("Alan", 800, 480);
        mBinding.setPhoto(mModel);
        mBinding.setHandle(this);
        mBinding.setConvert(this);
        return mBinding.getRoot();
    }

    public void onImageClick(View v) {
        if ("Allen" == mModel.getAuthor()) {
            mModel.setAuthor("Alan");
        } else {
            mModel.setAuthor("Allen");
        }
    }

    public String toSizeString(int w, int h) {
        return w + "x" + h;
    }
}
