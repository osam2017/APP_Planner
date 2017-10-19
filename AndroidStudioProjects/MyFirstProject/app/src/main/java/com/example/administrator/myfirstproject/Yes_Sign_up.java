package com.example.administrator.myfirstproject;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Yes_Sign_up extends AppCompatActivity implements View.OnClickListener {

    private TextView mDateDisplay1;
    private TextView mDateDisplay2;
    private int mYear1, mYear2;
    private int mMonth1, mMonth2;
    private int mDay1, mDay2;
    static final int DATE_DIALOG_ID1 = 0;
    static final int DATE_DIALOG_ID2 = 1;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes__sign_up);



        mDateDisplay1 = (TextView) findViewById(R.id.birthday);
        mDateDisplay2 = (TextView) findViewById(R.id.editText5);
        mDateDisplay1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID1);
            }
        });
        mDateDisplay2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID2);
            }
        });
        final Calendar c1 = Calendar.getInstance();
        final Calendar c2 = Calendar.getInstance();
        mYear1 = c1.get(Calendar.YEAR);
        mMonth1 = c1.get(Calendar.MONTH);
        mDay1 = c1.get(Calendar.DAY_OF_MONTH);
        mYear2 = c2.get(Calendar.YEAR);
        mMonth2 = c2.get(Calendar.MONTH);
        mDay2 = c2.get(Calendar.DAY_OF_MONTH);

        updateDisplay();

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID1:
                return new DatePickerDialog(this, mDateSetListener1, mYear1, mMonth1, mDay1);
            case DATE_DIALOG_ID2:
                return new DatePickerDialog(this, mDateSetListener2, mYear2, mMonth2, mDay2);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear1 = year;
            mMonth1 = month;
            mDay1 = dayOfMonth;
            updateDisplay();
        }
    };
    private DatePickerDialog.OnDateSetListener mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear2 = year;
            mMonth2 = month;
            mDay2 = dayOfMonth;
            updateDisplay();
        }
    };

    private void updateDisplay() {
        mDateDisplay1.setText(
                new StringBuilder()
                        .append(mYear1).append("-")
                        .append(mMonth1 + 1).append("-")
                        .append(mDay1).append("")
        );
        mDateDisplay2.setText(
                new StringBuilder()
                        .append(mYear2).append("-")
                        .append(mMonth2 + 1).append("-")
                        .append(mDay2).append("")
        );
    }

    @Override
    public void onClick(View v) {




        EditText my_name = (EditText) findViewById(R.id.editText3);
        String str_my_name = my_name.getText().toString();

        if(str_my_name.getBytes().length <= 0){
            Toast.makeText(getApplicationContext(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
        }
        else {
            EditText my_birthday = (EditText)findViewById(R.id.birthday);
            String str_my_birthday = my_birthday.getText().toString();

            EditText my_dDay = (EditText) findViewById(R.id.editText5);
            String str_my_dDay = my_dDay.getText().toString();


            Intent intentNext = new Intent(this, WantToActivity.class);
            intentNext.putExtra("intentNext_name", str_my_name);
            intentNext.putExtra("intentNext_dDay", str_my_dDay);
            intentNext.putExtra("year", mYear2);
            intentNext.putExtra("month", mMonth2 + 1);
            intentNext.putExtra("day", mDay2);


            startActivity(intentNext);
            finish();
        }




    }



}