package com.alan.sweaterui.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.alan.sweaterui.BR;

public class AlbumModel extends BaseObservable {
    private String mAuthor;
    private int mWidth;
    private int mHeight;
    private int mSize;

    public AlbumModel(String author, int w, int h, int size) {
        mAuthor = author;
        mWidth = w;
        mHeight = h;
        mSize = size;
    }

    @Bindable
    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
        notifyPropertyChanged(BR.author);
    }

    @Bindable
    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
        notifyPropertyChanged(BR.width);
    }

    @Bindable
    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
        notifyPropertyChanged(BR.height);
    }

    @Bindable
    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
        notifyPropertyChanged(BR.size);
    }
}
