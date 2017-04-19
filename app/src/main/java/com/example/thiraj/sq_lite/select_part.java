package com.example.thiraj.sq_lite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select_part extends AppCompatActivity {

    Button remainder, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_part);

        remainder=(Button)findViewById(R.id.btRemainder);
        home=(Button)findViewById(R.id.btHome);

        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(select_part.this, remainder.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(select_part.this, home.class);
                startActivity(intent);
            }
        });

    }
}
