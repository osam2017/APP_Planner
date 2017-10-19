package com.example.administrator.myfirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class WantToActivity extends AppCompatActivity {

    ListView listView_wanna;
    ArrayList<String> arrayList_goal = new ArrayList<String>();
    Button btn_add_goal;
    Button btn_dlt_goal;
    ArrayAdapter<String> adapter_goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to);

        Intent intentNext = getIntent();

        String str_my_name = intentNext.getStringExtra("intentNext_name");
        String str_my_dDay = intentNext.getStringExtra("intentNext_dDay");

        TextView ownername = (TextView) findViewById(R.id.ownername);
        ownername.setText(str_my_name);

        TextView dDay = (TextView) findViewById(R.id.dDay);
        dDay.setText(str_my_dDay);

        int year = getIntent().getExtras().getInt("year");
        int month = getIntent().getExtras().getInt("month");
        int day = getIntent().getExtras().getInt("day");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar todaCal = Calendar.getInstance();
        Calendar ddayCal = Calendar.getInstance();
        month += -1;
        ddayCal.set(year, month, day);
        long today = todaCal.getTimeInMillis() / 86400000;
        long dday = ddayCal.getTimeInMillis() / 86400000;
        long count = dday - today;

        String countday = String.valueOf(count);
        TextView leftDay = (TextView) findViewById(R.id.leftday);
        leftDay.setText("전역까지 " + countday + "일" + " 남았습니다");

        listView_wanna = (ListView) findViewById(R.id.wannado);
        Button btn_add_goal = (Button) findViewById(R.id.addgoal);
        Button btn_dlt_goal = (Button) findViewById(R.id.dltgoal);
        adapter_goal = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrayList_goal);
        listView_wanna.setAdapter(adapter_goal);

        listView_wanna.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = arrayList_goal.get(position);
                Toast.makeText(WantToActivity.this, "선택항목 : " + item, Toast.LENGTH_SHORT).show();
            }
        });
        final EditText edt_goal = (EditText) findViewById(R.id.mygoal);

        btn_add_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_goal = edt_goal.getText().toString();
                if (str_goal.getBytes().length <= 0) {
                    Toast.makeText(WantToActivity.this, "목표를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    arrayList_goal.add(str_goal);
                    adapter_goal.notifyDataSetChanged();
                    edt_goal.setText("");
                }
            }
        });
    }
}












