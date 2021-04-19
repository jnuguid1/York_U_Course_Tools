package com.example.yorkucoursetools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.R;

public class EditCourseActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";
    public static final String EXTRA_REPLY_ID = "com.android.example.roomwordssample.REPLY_ID";
    private EditText enterCourse;
    private EditText enterCredits;
    private EditText enterGrade;
    private Button editButton;
    private int id = -1;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);

        enterCourse = findViewById(R.id.enterCourse);
        enterCredits = findViewById(R.id.enterCredits);
        enterGrade = findViewById(R.id.enterGrade);
        editButton = findViewById(R.id.editCourseButton);
        int id = -1;
        extras = getIntent().getExtras();

    }

    public void editCourse(View view) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(enterCourse.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String course = enterCourse.getText().toString();
            replyIntent.putExtra(EXTRA_REPLY, course);
        }
    }
}