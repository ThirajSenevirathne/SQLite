package com.example.thiraj.sq_lite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class display extends AppCompatActivity {

    Button bout;
    TextView ud;

    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String username=getIntent().getStringExtra("username");
        TextView tv=(TextView)findViewById(R.id.TVusername);
        ud=(TextView)findViewById(R.id.userDetails);
        tv.setText(username);

        //Session class instance
        session=new SessionManagement(getApplicationContext());

        bout=(Button)findViewById(R.id.bLogOut);

        Toast.makeText(getApplicationContext(), "User Login Status: "+session.isLoggedIn(), Toast.LENGTH_LONG).show();

        /*Call this funcertion whenever we want to check user login. This will
          redirect user to MainActivity is he is not logged in.
         */
        session.checkLogin();

        //get user data from session
        HashMap<String, String> user=session.getUserDetails();

        String name=user.get(SessionManagement.KEY_NAME);
        //String pass=user.get(SessionManagement.KEY_PASS);

        ud.setText("User: "+name);

        bout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });
    }
}
