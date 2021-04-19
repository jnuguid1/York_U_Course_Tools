package com.example.yorkucoursetools;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CourseRepository {
    private CourseDao mCourseDao;
    private LiveData<List<Course>> mAllCourses;
    private List<Course> mCourseList;

    CourseRepository(Application application) {
        CourseRoomDatabase db = CourseRoomDatabase.getDatabase(application);
        mCourseDao = db.courseDao();
        mAllCourses = mCourseDao.getAllCourses();
    }

    LiveData<List<Course>> getAllCourses() {
        return mAllCourses;
    }

    public void insert (Course course) {
        new insertAsyncTask(mCourseDao).execute(course);
    }

    public void deleteAll() {
        new deleteAllCoursesAsyncTask(mCourseDao).execute();
    }

    public void update(Course course) { new updateCourseAsyncTask(mCourseDao).execute(course); }

    public void deleteCourse(Course course) {
        new deleteCourseAsyncTask(mCourseDao).execute(course);
    }

    private static class insertAsyncTask extends AsyncTask<Course, Void, Void> {

        private CourseDao mAsyncTaskDao;

        insertAsyncTask(CourseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private CourseDao mAsyncTaskDao;

        deleteAllCoursesAsyncTask(CourseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    private static class deleteCourseAsyncTask extends AsyncTask<Course, Void, Void>{
        private CourseDao mAsyncTaskDao;

        deleteCourseAsyncTask(CourseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.deleteCourse(params[0]);
            return null;
        }

    }

    private static class updateCourseAsyncTask extends AsyncTask<Course, Void, Void>{
        private CourseDao mAsyncTaskDao;

        updateCourseAsyncTask(CourseDao dao) { mAsyncTaskDao = dao; }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }


}
