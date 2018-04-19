package me.aungkooo.theroom.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.aungkooo.theroom.viewholder.RecyclerViewHolder;

/**
 * Created by Ko Oo on 9/4/18.
 */

public abstract class RecyclerAdapter<VH extends RecyclerViewHolder, OBJ> extends RecyclerView.Adapter<VH>
{
    private Context context;
    private List<OBJ> itemList;

    public RecyclerAdapter(Context context, List<OBJ> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public View createView(@LayoutRes int resource, @Nullable ViewGroup parent)
    {
        return LayoutInflater.from(context).inflate(resource, parent, false);
    }

    @Override
    public int getItemCount() {
        if(itemList != null)
        {
            return itemList.size();
        }
        else {
            return 0;
        }
    }

    public List<OBJ> getItemList() {
        return itemList;
    }

    public void setItemList(List<OBJ> itemList) {
        this.itemList = itemList;
    }

    public Context getContext() {
        return context;
    }
}
