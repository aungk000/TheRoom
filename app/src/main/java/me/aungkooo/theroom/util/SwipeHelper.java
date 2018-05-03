package me.aungkooo.theroom.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import me.aungkooo.theroom.listener.OnSwipeListener;


/**
 * Created by Ko Oo on 3/5/2018.
 */

public class SwipeHelper extends ItemTouchHelper
{
    public SwipeHelper(ItemTouchHelper.Callback callback) {
        super(callback);
    }

    public static class SwipeCallback extends ItemTouchHelper.Callback
    {
        private OnSwipeListener listener;

        public SwipeCallback(OnSwipeListener listener) {
            this.listener = listener;
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if(recyclerView.getLayoutManager() instanceof LinearLayoutManager)
            {
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;

                return makeMovementFlags(0, swipeFlags);
            }
            else {
                return 0;
            }
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                              RecyclerView.ViewHolder target)
        {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            listener.onSwiped(viewHolder.getAdapterPosition());
        }
    }
}
