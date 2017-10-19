package com.example.administrator.myfirstproject;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yes = (Button)findViewById(R.id.yesbutton);
        yes.setOnClickListener(this);

        Button no = (Button)findViewById(R.id.nobutton);
        no.setOnClickListener(this);

            }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()){
            case R.id.yesbutton:
                Intent intentYes = new Intent(this, Yes_Sign_up.class);
                startActivity(intentYes);
                break;
            case R.id.nobutton:
                Intent intentNo = new Intent(this, No_Sign_in.class);
                startActivity(intentNo);
                break;
                }

            }
        }
