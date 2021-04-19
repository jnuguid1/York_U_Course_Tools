package com.example.yorkucoursetools;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    final private GPA_Calculator calc = new GPA_Calculator();
    private TextView enterCourseView;
    private TextView enterGradeView;
    private TextView enterCreditsView;
    private TextView courseListView;
    private TextView removeCourseView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_delete_all) {

        }
        return super.onOptionsItemSelected(item);
    }
*/
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




    /*
    public void addCourse(View view) {
        enterCourseView = findViewById(R.id.enterCourse);
        enterGradeView = findViewById(R.id.enterGrade);
        enterCreditsView = findViewById(R.id.enterCredits);
        courseListView = findViewById(R.id.courseList);
        double weight;
        String courseListText = "";

        String courseName = enterCourseView.getText().toString();
        String grade = enterGradeView.getText().toString();
        if (enterCreditsView.getText().toString().equals("")) {
            weight = 1;
        } else {
            weight = Double.parseDouble(enterCreditsView.getText().toString());
        }
        if (!(calc.contains(courseName))) {
            calc.addCourse(courseName, grade, weight);
            enterCourseView.setText("");
            enterGradeView.setText("");
            enterCreditsView.setText("");
            for (Course c: calc.getCourseList()) {
                courseListText += c.getName() + " | " + c.getGrade() + " | " + c.getWeight() + "\n";
            }
            courseListView.setText(courseListText);
        } else {
            Toast.makeText(getApplicationContext(), "Course already entered.",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void calculateGPA(View view) {
        double gpa = calc.calculate9PointGPA();
        String gpaStr = String.format("%.2f", gpa);
        TextView gpaOutput = findViewById(R.id.ninePointTextView);
        gpaOutput.setText("Your 9.0 GPA is " + gpaStr);

        gpa = calc.calculate4PointGPA();
        gpaStr = String.format("%.2f", gpa);
        gpaOutput = findViewById(R.id.fourPointTextView);
        gpaOutput.setText("Your 4.0 GPA is " + gpaStr);

        enterCourseView = findViewById(R.id.enterCourse);
        enterGradeView = findViewById(R.id.enterGrade);
        enterCreditsView = findViewById(R.id.enterCredits);
        enterCourseView.setText("");
        enterGradeView.setText("");
        enterCreditsView.setText("");
    }

    public void editCourse(View view) {
        enterCourseView = findViewById(R.id.enterCourse);
        enterGradeView = findViewById(R.id.enterGrade);
        enterCreditsView = findViewById(R.id.enterCredits);
        courseListView = findViewById(R.id.courseList);
        String courseListText = "";
        String courseName = enterCourseView.getText().toString();
        String grade = enterGradeView.getText().toString();
        double weight;

        if (enterCreditsView.getText().toString().equals("")) {
            weight = 1;
        } else {
            weight = Double.parseDouble(enterCreditsView.getText().toString());
        }

        if (calc.editCourse(courseName, grade, weight)) {
            for (Course c: calc.getCourseList()) {
                courseListText += c.getName() + " | " + c.getGrade() + " | " + c.getWeight() + "\n";
            }
            courseListView.setText(courseListText);
            Toast.makeText(getApplicationContext(), "Course edited.",
                    Toast.LENGTH_LONG).show();
            enterCourseView.setText("");
            enterGradeView.setText("");
            enterCreditsView.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Course not found.",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void removeCourse(View view) {
        removeCourseView = findViewById(R.id.removeCourse);
        courseListView = findViewById(R.id.courseList);
        String courseListText = "";
        String courseName = removeCourseView.getText().toString();

        if(calc.removeCourse(courseName)) {
            for (Course c: calc.getCourseList()) {
                courseListText += c.getName() + " | " + c.getGrade() + " | " + c.getWeight() + "\n";
            }
            courseListView.setText(courseListText);
            Toast.makeText(getApplicationContext(), "Course removed.",
                    Toast.LENGTH_LONG).show();
            removeCourseView.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Course not found.",
                    Toast.LENGTH_LONG).show();
        }

    }
    */
}