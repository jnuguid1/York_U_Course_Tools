package com.example.yorkucoursetools;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GPA_Calculator {
    private static final String TAG = "@string/app_name";

    public GPA_Calculator() {
    }

    public static double calculate9PointGPA(List<Course> courses) {
        int gradeTotal = 0;
        int totalCredits = 0;
        for (Course c : courses) {
            switch (c.getGrade()) {
                case "A+":
                    gradeTotal += 9 * c.getWeight();
                    break;
                case "A":
                    gradeTotal += 8 * c.getWeight();
                    break;
                case "B+":
                    gradeTotal += 7 * c.getWeight();
                    break;
                case "B":
                    gradeTotal += 6 * c.getWeight();
                    break;
                case "C+":
                    gradeTotal += 5 * c.getWeight();
                    break;
                case "C":
                    gradeTotal += 4 * c.getWeight();
                    break;
                case "D+":
                    gradeTotal += 3 * c.getWeight();
                    break;
                case "D":
                    gradeTotal += 2 * c.getWeight();
                    break;
                case "E":
                    gradeTotal += 1 * c.getWeight();
                    break;
                case "F":
                    gradeTotal += 0 * c.getWeight();
                    break;
                default:
                    Log.d(TAG, "Invalid input");
            }
            totalCredits += c.getWeight();
        }
        return (double)gradeTotal/totalCredits;
    }

    public static double calculate4PointGPA(List<Course> courses) {
        int gradeTotal = 0;
        int totalCredits = 0;
        for (Course c: courses) {
            switch (c.getGrade()) {
                case "A+":
                    gradeTotal += 4 * c.getWeight();
                    break;
                case "A":
                    gradeTotal += 3.8 * c.getWeight();
                    break;
                case "B+":
                    gradeTotal += 3.3 * c.getWeight();
                    break;
                case "B":
                    gradeTotal += 2.8 * c.getWeight();
                    break;
                case "C+":
                    gradeTotal += 2.3 * c.getWeight();
                    break;
                case "C":
                    gradeTotal += 2 * c.getWeight();
                    break;
                case "D+":
                    gradeTotal += 1.7 * c.getWeight();
                    break;
                case "D":
                    gradeTotal += 1 * c.getWeight();
                    break;
                case "E":
                    gradeTotal += 0.7 * c.getWeight();
                    break;
                case "F":
                    gradeTotal += 0 * c.getWeight();
                    break;
                default:
                    Log.d(TAG, "Invalid input");
            }
            totalCredits += c.getWeight();
        }
        return (double)gradeTotal/totalCredits;
    }
}
