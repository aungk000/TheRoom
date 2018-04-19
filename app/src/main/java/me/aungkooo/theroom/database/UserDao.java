package me.aungkooo.theroom.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Ko Oo on 18/4/2018.
 */

@Dao
public interface UserDao
{
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();

    @Insert
    void insertUser(User user);

    @Query("DELETE FROM user WHERE userId = :id")
    void deleteUser(int id);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM user")
    void deleteAllUsers();
}
