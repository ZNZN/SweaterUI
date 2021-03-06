package com.alan.sweaterui.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.alan.sweaterui.BR;

public class PhotoModel extends BaseObservable {
    private final int PIEXL_SIZE = 8 * 4;        // rgba, and 8 bit for each

    private String mAuthor;
    private int mWidth;
    private int mHeight;
    private int mSize;

    public PhotoModel(String author, int w, int h) {
        mAuthor = author;
        mWidth = w;
        mHeight = h;
        mSize = w * h * PIEXL_SIZE;
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
