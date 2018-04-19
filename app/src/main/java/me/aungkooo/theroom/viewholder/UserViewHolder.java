package me.aungkooo.theroom.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import me.aungkooo.theroom.R;
import me.aungkooo.theroom.database.User;

/**
 * Created by Ko Oo on 18/4/2018.
 */

public class UserViewHolder extends RecyclerViewHolder<User> implements View.OnClickListener
{
    @BindView(R.id.txt_username) TextView txtUsername;
    @BindView(R.id.txt_email) TextView txtEmail;

    private User user;

    public UserViewHolder(View itemView, Context context) {
        super(itemView, context);
        ButterKnife.bind(this, itemView);
        setOnClickListener(this);
    }

    @Override
    public void onBind(List<User> itemList)
    {
        user = itemList.get(getAdapterPosition());
        txtUsername.setText(user.getUsername());
        txtEmail.setText(user.getEmail());
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), String.valueOf(user.getUserId()), Toast.LENGTH_SHORT).show();
    }
}
