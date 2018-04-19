package me.aungkooo.theroom.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import me.aungkooo.theroom.UserRepository;
import me.aungkooo.theroom.database.User;

/**
 * Created by Ko Oo on 19/4/2018.
 */

public class UserModel extends AndroidViewModel
{
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public UserModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepository(application);
        this.allUsers = this.userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insertUser(User user)
    {
        userRepository.insertUser(user);
    }
}
