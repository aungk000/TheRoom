package me.aungkooo.theroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Ko Oo on 18/4/2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase
{
    public abstract UserDao userDao();

    @NonNull
    public static UserDatabase build(Context context)
    {
        return Room.databaseBuilder(context, UserDatabase.class, "user-database").build();
    }
}
