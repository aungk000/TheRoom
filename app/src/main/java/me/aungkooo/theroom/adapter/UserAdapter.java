package me.aungkooo.theroom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.aungkooo.theroom.R;
import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.database.UserDatabase;
import me.aungkooo.theroom.viewholder.UserViewHolder;

/**
 * Created by Ko Oo on 18/4/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>
{
    private Context context;
    private List<User> userList;

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user, parent, false);
        return new UserViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.onBind(userList);
    }

    @Override
    public int getItemCount() {
        if(userList != null)
        {
            return userList.size();
        }
        else {
            return 0;
        }
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }
}
