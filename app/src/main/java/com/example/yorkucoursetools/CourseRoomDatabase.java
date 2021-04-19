package com.example.yorkucoursetools;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Course.class}, version = 2, exportSchema = false)
public abstract class CourseRoomDatabase extends RoomDatabase {
    public abstract CourseDao courseDao();

    private static CourseRoomDatabase INSTANCE;

    public static CourseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CourseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CourseRoomDatabase.class, "course_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
    };

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final CourseDao mDao;

        PopulateDbAsync(CourseRoomDatabase db) {
            mDao = db.courseDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            return null;
        }
    }


}
