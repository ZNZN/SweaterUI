package com.alan.sweaterui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan.sweaterui.databinding.BindingFragmentBinding;
import com.alan.sweaterui.model.AlbumModel;
import com.alan.sweaterui.model.PhotoModel;

public class BindingFragment extends Fragment {
    private BindingFragmentBinding mBinding;
    private PhotoModel mModel;
    private AlbumModel mAlbum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = BindingFragmentBinding.inflate(inflater, container, false);
        mModel = new PhotoModel("Alan", 800, 480);
        mAlbum = new AlbumModel("ZNZN", 800, 480, 16);
        mBinding.setPhoto(mModel);
        mBinding.setAlbum(mAlbum);
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

    public String toBoundString(int w, int h) {
        return w + "x" + h;
    }

    public String toSizeString(int size) {
        return (float) size / 8 / 1024 / 1024 + "m";
    }

    public String toAlbumSizeString(int size) {
        return size + "m";
    }
}
