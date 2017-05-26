package com.tian.myrecyclerdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by Administrator on 2017-04-01.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter {

    protected Context mContext;
    protected int mlayoutid;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, final int item_list, List<T> mDatas) {
        super(context,mDatas);
        this.mContext = context;
        this.mlayoutid = item_list;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId()
            {
                return mlayoutid;
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }


    protected abstract void convert(ViewHolder holder, T t, int position);





}
