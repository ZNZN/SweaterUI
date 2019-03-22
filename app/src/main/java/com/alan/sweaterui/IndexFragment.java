package com.alan.sweaterui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Index fragment of App
 */
public class IndexFragment extends Fragment {
    private final String TAG = "IndexFragment";
    private String[] mBtnData = {"Layout", "Animation"};

    /**
     * Recycle View Adapter
     */
    private static class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.ItemHolder> {
        private String[] mData;
        private OnItemClickListener mListener;

        /**
         * Recycle View Holder inflate view from R.layout.item_indexitem
         */
        public static class ItemHolder extends RecyclerView.ViewHolder {
            private View mRoot;

            public ItemHolder(View v) {
                super(v);
                mRoot = v;
            }

            public void setText(String text) {
                if (mRoot instanceof Button) {
                    ((Button) mRoot).setText(text);
                }
            }

            public View getView() {
                return mRoot;
            }
        }

        /**
         * Interface definition for a callback to be invoked when a list item is clicked.
         */
        public interface OnItemClickListener {
            void onItemClick(View v, int position);
        }

        public IndexAdapter(String[] data) {
            this(data, null);
        }

        public IndexAdapter(String[] data, OnItemClickListener listener) {
            mListener = listener;
            mData = data;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_indexitem, parent, false);
            return new ItemHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.setText(mData[position]);

            // bind Item Click Event
            if (null != mListener) {

                final OnItemClickListener fListener = mListener;
                final int fPosition = position;

                holder.getView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fListener.onItemClick(v, fPosition);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mData.length;
        }
    }

    public IndexFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_index, container, false);

        RecyclerView list = layout.findViewById(R.id.recycler);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        // new an adapter with EventListener
        IndexAdapter adapter = new IndexAdapter(mBtnData, new IndexAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (v instanceof Button) {
                    if ("Layout" == ((Button) v).getText()) {
                        FragmentTransaction transToLayout = getFragmentManager().beginTransaction();
                        transToLayout.replace(R.id.fragment_container, new LayoutFragment());
                        transToLayout.addToBackStack(null);
                        transToLayout.commit();
                    }
                }
            }
        });
        list.setAdapter(adapter);

        return layout;
    }

}
