package com.example.yorkucoursetools;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Course course);

    @Query("DELETE FROM course_table")
    void deleteAll();

    @Query("SELECT * FROM course_table")
    LiveData<List<Course>> getAllCourses();

    @Delete
    void deleteCourse(Course course);

    @Update
    void update(Course... course);
}
