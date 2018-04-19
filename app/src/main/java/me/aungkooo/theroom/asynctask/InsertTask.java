package me.aungkooo.theroom.asynctask;

import android.os.AsyncTask;

import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.database.UserDao;

/**
 * Created by Ko Oo on 19/4/2018.
 */

public class InsertTask extends AsyncTask<User, Void, Void>
{
    private UserDao userDao;

    public InsertTask(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected Void doInBackground(User... users)
    {
        userDao.insertUser(users[0]);
        return null;
    }
}
