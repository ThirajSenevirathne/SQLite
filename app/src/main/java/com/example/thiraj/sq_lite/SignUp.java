package com.example.thiraj.sq_lite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends  AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onButtonClick(View v){
        if(v.getId()==R.id.Bsignup){
            EditText name=(EditText)findViewById(R.id.TFname);
            EditText email=(EditText)findViewById(R.id.TFemail);
            EditText uname=(EditText)findViewById(R.id.TFuname);
            EditText pass1=(EditText)findViewById(R.id.TFpass1);
            EditText pass2=(EditText)findViewById(R.id.TFpass2);

            String namestr=name.getText().toString();
            String mailstr=email.getText().toString().trim();
            String unamestr=uname.getText().toString();
            String pass1str=pass1.getText().toString();
            String pass2str=pass2.getText().toString();

            if(!mailstr.matches(emailPattern)){
                Toast pass=Toast.makeText(SignUp.this,"Please enter valid email!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(pass2str.compareTo(pass1str)!=0){
                //popup
                Toast pass=Toast.makeText(SignUp.this,"Password don't match",Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(namestr.isEmpty()){
                Toast pass=Toast.makeText(SignUp.this,"Name can't be empty!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(mailstr.isEmpty()){
                Toast pass=Toast.makeText(SignUp.this,"Mail can't be empty!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(unamestr.isEmpty()){
                Toast pass=Toast.makeText(SignUp.this,"Username can't be empty!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(pass1str.isEmpty()){
                Toast pass=Toast.makeText(SignUp.this,"Password can't be empty!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(pass2str.isEmpty()){
                Toast pass=Toast.makeText(SignUp.this,"Please re-enter password ",Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                //insert data to db
                Contact c=new Contact();
                c.setName(namestr);
                c.setEmail(mailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);

                Intent i=new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
            }
        }
    }
}
