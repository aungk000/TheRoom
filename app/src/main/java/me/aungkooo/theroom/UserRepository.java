package me.aungkooo.theroom;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

import me.aungkooo.theroom.asynctask.InsertTask;
import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.database.UserDao;
import me.aungkooo.theroom.database.UserDatabase;


/**
 * Created by Ko Oo on 19/4/2018.
 */

public class UserRepository
{
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application app) {
        UserDatabase userDb = UserDatabase.build(app);
        userDao = userDb.userDao();
        allUsers = userDao.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insertUser(User user)
    {
        InsertTask insertTask = new InsertTask(userDao);
        insertTask.execute(user);
    }
}
