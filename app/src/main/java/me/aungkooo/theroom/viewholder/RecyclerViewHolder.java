package me.aungkooo.theroom.viewholder;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ko Oo on 9/4/18.
 */

public abstract class RecyclerViewHolder<OBJ> extends RecyclerView.ViewHolder
{
    private Context context;
    private View view;

    public RecyclerViewHolder(View itemView, Context context) {
        super(itemView);
        this.view = itemView;
        this.context = context;
    }

    public OBJ getItem(List<OBJ> itemList)
    {
        return itemList.get(getAdapterPosition());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
    }

    public Context getContext() {
        return context;
    }

    public View getView() {
        return view;
    }

    public abstract void onBind(List<OBJ> itemList);
}
