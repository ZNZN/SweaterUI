package com.alan.sweaterui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan.sweaterui.adapter.AlbumListAdapter;
import com.alan.sweaterui.databinding.BindingFragmentBinding;
import com.alan.sweaterui.model.AlbumModel;
import com.alan.sweaterui.model.PhotoModel;

import java.util.ArrayList;
import java.util.List;

public class BindingFragment extends Fragment {
    private BindingFragmentBinding mBinding;
    private PhotoModel mModel;
    private AlbumModel mAlbum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = BindingFragmentBinding.inflate(inflater, container, false);
        mModel = new PhotoModel("Alan", 800, 480);
        mBinding.setPhoto(mModel);
        mBinding.setHandle(this);
        mBinding.setConvert(this);

        // init RecyclerView
        List<AlbumModel> data= new ArrayList<>();
        data.add(new AlbumModel("AAA", 800, 480, 16));
        data.add(new AlbumModel("BBB", 800, 480, 16));
        data.add(new AlbumModel("CCC", 800, 480, 16));
        data.add(new AlbumModel("DDD", 800, 480, 16));
        data.add(new AlbumModel("EEE", 800, 480, 16));
        data.add(new AlbumModel("FFF", 800, 480, 16));
        data.add(new AlbumModel("GGG", 800, 480, 16));

        mBinding.bindRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.bindRecycler.setLayoutManager(layoutManager);
        mBinding.bindRecycler.setAdapter(new AlbumListAdapter(data));

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
