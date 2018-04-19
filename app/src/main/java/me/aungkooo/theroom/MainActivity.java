package me.aungkooo.theroom;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aungkooo.theroom.adapter.UserAdapter;
import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.dialog.DialogNewUser;
import me.aungkooo.theroom.listener.OnDialogDismissListener;
import me.aungkooo.theroom.model.UserModel;


/**
 * Created by Ko Oo on 18/4/2018.
 */

public class MainActivity extends AppCompatActivity implements OnDialogDismissListener
{
    @BindView(R.id.recycler_view_main) RecyclerView recyclerViewMain;
    @BindView(R.id.fab_main) FloatingActionButton fabMain;

    public UserAdapter userAdapter;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        userAdapter = new UserAdapter(this);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMain.setAdapter(userAdapter);
        recyclerViewMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState > 0)
                {
                    fabMain.hide();
                }
                else {
                    fabMain.show();
                }
            }
        });

        userModel = ViewModelProviders.of(this).get(UserModel.class);
        userModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userAdapter.setUserList(users);
            }
        });

        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogNewUser dialogNewUser = new DialogNewUser();
                dialogNewUser.show(getSupportFragmentManager(), "New user");
            }
        });
    }

    @Override
    public void onDialogDismissed(User user)
    {
        userModel.insertUser(user);
    }
}
