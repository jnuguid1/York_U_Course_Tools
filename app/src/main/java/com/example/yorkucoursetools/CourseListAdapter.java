package com.example.yorkucoursetools;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {

    private final LayoutInflater mInflater;
    private List<Course> mCourses;
    private Context mContext;

    public CourseListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        if (mCourses != null) {
            Course current = mCourses.get(position);
            holder.courseItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.courseItemView.setText("No Course");
        }
    }

    public void setCourses(List<Course> courses){
        mCourses = courses;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mCourses has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mCourses != null)
            return mCourses.size();
        else return 0;
    }

    public Course getCourseAtPosition (int position) {
        return mCourses.get(position);
    }

    class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView courseItemView;

        private CourseViewHolder(View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Course currentCourse = mCourses.get(getAdapterPosition());
            Intent editCourseIntent = new Intent(mContext, EditCourseActivity.class);
            editCourseIntent.putExtra("course_name", currentCourse.getName());
            mContext.startActivity(editCourseIntent);
        }
    }

}
