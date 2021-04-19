package com.example.yorkucoursetools;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {
    @PrimaryKey(autoGenerate =  true)
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "grade")
    private String grade;

    @NonNull
    @ColumnInfo(name = "weight")
    private double weight;

    public Course(int id, @NonNull String name, @NonNull String grade, @NonNull double weight) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.weight = weight;
    }

    public String getName() {return this.name;}

    public double getWeight() {
        return this.weight;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setWeight(double weight) { this.weight = weight; }

    public void setGrade(String grade){ this.grade = grade; }
}
