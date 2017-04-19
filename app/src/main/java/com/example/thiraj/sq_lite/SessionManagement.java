package com.example.thiraj.sq_lite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by thiraj on 1/9/17.
 */

/*This class has all session related functions to make available in all activities. */
public class SessionManagement {
    //Shared Preferences
    SharedPreferences pref;

    //Editor for Shared preferences
    SharedPreferences.Editor editor;

    //Context
    Context _context;

    //Shared pref mode
    int PRIVATE_MODE=0;

    //Sharedpref file name
    private static final String PREF_NAME="AndroidH";

    //All Shared Preferences Keys
    private static final String IS_LOGIN="IsLoggedIn";

    //User name(make variable public to access from outside)
    public static final String KEY_NAME="name";

    //Password(make variable public to access from outside)
    public static final String KEY_PASS="password";

    //Constructor
    public SessionManagement(Context context){
        this._context=context;
        pref=_context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor=pref.edit();
    }

    /* storing login status, name, email in shared preferences. */
    public void createLoginSession(String name, String password){

        //Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        //Storing name in pref
        editor.putString(KEY_NAME, name);

        //Storing password in pref
        editor.putString(KEY_PASS, password);

        //commit changes
        editor.commit();
    }

    /* to get stored preferences data.This will read shared preferences and returns
    user data in HashMap
     */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user=new HashMap<String, String>();

        //user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        //user password
        user.put(KEY_PASS, pref.getString(KEY_PASS, null));

        //return user
        return user;
    }

    /* to check whether user logged in or not.We can call all activities to check
     user login status from shared prefernces. if user is not login it will
     redirect user to LoginActivity. */
    public void checkLogin(){

        //Check login status
        if(!this.isLoggedIn()){

            //user is not logged in redirect him to Login Activity
            Intent i=new Intent(_context, MainActivity.class);

            //Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //Starting Login Activity
            _context.startActivity(i);
        }
    }

    /* clear session details */
    public void logoutUser(){
        //Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        //After logout redirect user to Login Activity
        Intent i=new Intent(_context, MainActivity.class);

        //Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //Add new flag to start  new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //Start Login Activity
        _context.startActivity(i);
    }

    /* Quick check for login. get Login State */
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

}
