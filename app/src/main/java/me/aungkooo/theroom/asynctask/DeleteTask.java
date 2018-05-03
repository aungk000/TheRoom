package me.aungkooo.theroom.asynctask;

import android.os.AsyncTask;

import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.database.UserDao;

/**
 * Created by Ko Oo on 3/5/2018.
 */

public class DeleteTask extends AsyncTask<User, Void, Void>
{
    private UserDao userDao;

    public DeleteTask(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected Void doInBackground(User... users) {
        userDao.deleteUser(users[0]);
        return null;
    }
}
