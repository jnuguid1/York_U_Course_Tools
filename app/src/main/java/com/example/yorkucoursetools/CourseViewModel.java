package com.example.yorkucoursetools;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class CourseViewModel extends AndroidViewModel{
    private CourseRepository mRepository;
    private LiveData<List<Course>> mAllCourses;

    public CourseViewModel (Application application) {
        super(application);
        mRepository = new CourseRepository(application);
        mAllCourses = mRepository.getAllCourses();
    }

    public LiveData<List<Course>> getAllCourses() { return mAllCourses; }

    public void insert(Course course) { mRepository.insert(course); }

    public void deleteAll() {mRepository.deleteAll();}

    public void deleteCourse(Course course) {mRepository.deleteCourse(course);}

    public void update(Course course) { mRepository.update(course); }
}
