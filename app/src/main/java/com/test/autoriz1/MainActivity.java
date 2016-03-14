package com.test.autoriz1;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessException;
import com.test.autoriz1.Fragments.FragAutoriz;
import com.test.autoriz1.Fragments.FragRegist;

public class MainActivity extends AppCompatActivity{

    private static final String YOUR_SECRET_KEY = "1624FBDA-39AE-FB03-FF8F-D03F7E507A00";
    private static final String YOUR_APP_ID = "B95D45A1-ED7C-36F7-FF03-7046ECB17100";
    private static final String VERSION = "1";
    FragmentTransaction fragmentTransaction;

    FragRegist fragRegist = new FragRegist();
    FragAutoriz fragAutoriz = new FragAutoriz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Backendless.initApp(this, YOUR_APP_ID, YOUR_SECRET_KEY, VERSION);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragRegist);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void onMyButtonClick(View view)
    {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragAutoriz);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onMyButtonClick2(View view)
    {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragRegist);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public  void onMyButtonClickReg(View view) {

        EditText text = (EditText) findViewById(R.id.editText4);
        EditText text2 = (EditText) findViewById(R.id.editText5);
        EditText textE = (EditText) findViewById(R.id.editText3);

        Log.d("reg", String.valueOf(text));
        Log.d("reg", String.valueOf(text2));
        Log.d("reg", String.valueOf(textE));


        BackendlessUser user = new BackendlessUser();
        user.setEmail("michael1@backendless.com");
        user.setPassword("my_super_password");

        Backendless.UserService.register(user, new BackendlessCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                Log.d("Registration", backendlessUser.getEmail() + " successfully registered " + backendlessUser.getPassword());
            }
        });
    }


     public void onMyButtoClickEnter(View view){

         Backendless.initApp( YOUR_APP_ID, YOUR_SECRET_KEY, VERSION); // where to get the argument values for this call
         BackendlessUser user;

         try
         {
             user = Backendless.UserService.login( username, password );
         }
         catch( BackendlessException exception )
         {
             // login failed, to get the error code, call exception.getFault().getCode()
         }
    }






}