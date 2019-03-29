package com.alan.sweaterui.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan.sweaterui.BR;
import com.alan.sweaterui.databinding.ItemAlbumlistBinding;
import com.alan.sweaterui.model.AlbumModel;

import java.util.List;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder> {
    private List<AlbumModel> list;

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding binding;

        public AlbumViewHolder(View itemView, ViewDataBinding binding) {
            super(itemView);
            this.binding = binding;
        }

    }

    public AlbumListAdapter(List<AlbumModel> data) {
        list = data;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAlbumlistBinding binding =
                ItemAlbumlistBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new AlbumViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.binding.setVariable(BR.album, list.get(position));
        holder.binding.setVariable(BR.convert, this);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public String toBoundString(int w, int h) {
        return w + "x" + h;
    }
}
