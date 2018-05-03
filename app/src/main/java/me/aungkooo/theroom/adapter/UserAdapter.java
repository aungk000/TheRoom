package me.aungkooo.theroom.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.aungkooo.theroom.R;
import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.listener.OnSwipeListener;
import me.aungkooo.theroom.model.UserModel;
import me.aungkooo.theroom.viewholder.UserViewHolder;

/**
 * Created by Ko Oo on 18/4/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> implements OnSwipeListener
{
    private Context context;
    private List<User> userList;
    private UserModel userModel;
    private View parentView;

    public UserAdapter(Context context, UserModel userModel) {
        this.context = context;
        this.userModel = userModel;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user, parent, false);
        parentView = parent;
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

    @Override
    public void onSwiped(final int position)
    {
        final User user = userList.get(position);
        userModel.deleteUser(user);

        Snackbar.make(parentView, "Deleted " + user.getUsername(), Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userModel.insertUser(user);
                    }
                }).show();
    }
}
