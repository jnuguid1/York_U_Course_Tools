package com.example.yorkucoursetools.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.yorkucoursetools.Course;
import com.example.yorkucoursetools.CourseListAdapter;
import com.example.yorkucoursetools.CourseViewModel;
import com.example.yorkucoursetools.GPA_Calculator;

import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private TextView enterCourseView;
    private TextView enterGradeView;
    private TextView enterCreditsView;
    private TextView gpaNineView;
    private TextView gpaFourView;
    public Button addButton;
    public Button gpaButton;
    private CourseViewModel mCourseViewModel;
    private List<Course> courseList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gpa_calculator, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rView);
        final CourseListAdapter adapter = new CourseListAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        mCourseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        mCourseViewModel.getAllCourses().observe(getViewLifecycleOwner(), new Observer<List<Course>>(){
           @Override
           public void onChanged(@Nullable final List<Course> courses) {
               adapter.setCourses(courses);
               courseList = courses;
            }
        });

        setHasOptionsMenu(true);

        addButton = (Button) root.findViewById((R.id.addCourseButton));
        addButton.setOnClickListener(this);
        gpaButton = (Button) root.findViewById((R.id.calculateButton));
        gpaButton.setOnClickListener(this);
        enterCourseView = root.findViewById(R.id.enterCourse);
        enterGradeView = root.findViewById(R.id.enterGrade);
        enterCreditsView = root.findViewById(R.id.enterCredits);
        gpaNineView = root.findViewById(R.id.gpaNineView);
        gpaFourView = root.findViewById(R.id.gpa4view);

        // Add the functionality to swipe items in the
        // recycler view to delete that item
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                         int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Course myCourse = adapter.getCourseAtPosition(position);
                        mCourseViewModel.deleteCourse(myCourse);
                    }
                });

        helper.attachToRecyclerView(recyclerView);

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_delete_all) {
            Toast.makeText(getActivity(), "Clearing Courses", Toast.LENGTH_SHORT).show();
            mCourseViewModel.deleteAll();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addCourseButton:
                double weight;
                String courseName = enterCourseView.getText().toString();
                String grade = enterGradeView.getText().toString();
                if (enterCreditsView.getText().toString().equals("")) {
                    weight = 1;
                } else {
                    weight = Double.parseDouble(enterCreditsView.getText().toString());
                }
                mCourseViewModel.insert(new Course(courseName, grade, weight));
                enterCourseView.setText("");
                enterGradeView.setText("");
                enterCreditsView.setText("");
                break;
            case R.id.editCourseButton:
                break;
            case R.id.calculateButton:
                gpaNineView.setText(String.format("%.2f", GPA_Calculator.calculate9PointGPA(courseList)));
                gpaFourView.setText(String.format("%.2f", GPA_Calculator.calculate4PointGPA(courseList)));
                break;
        }
    }
}