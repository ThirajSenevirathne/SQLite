package com.example.thiraj.sq_lite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Session Manager Class
    SessionManagement session;
    Button login, signup;
    EditText a, b;

    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.Blogin);
        signup=(Button)findViewById(R.id.bsignuphere);

        //Session manager
        session=new SessionManagement(getApplicationContext());

        a=(EditText)findViewById(R.id.TFusername);
        b=(EditText)findViewById(R.id.pass);

        Toast.makeText(getApplicationContext(), "User Login Status: "+session.isLoggedIn(), Toast.LENGTH_LONG).show();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=a.getText().toString();
                String pass=b.getText().toString();

                String password=helper.searchPass(str);

                if(pass.equals(password)){

                    //Creating user login session
                    //Use user real data
                    session.createLoginSession(str, pass);

                    Intent i=new Intent(MainActivity.this,display.class);
                    i.putExtra("username",str);
                    startActivity(i);
                }else{
                    Toast temp=Toast.makeText(MainActivity.this,"Username and Password don't match",Toast.LENGTH_SHORT);
                    temp.show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });

    }

}
