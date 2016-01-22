package com.example.fyp;

import com.example.fyp.MainActivity;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        getActionBar().hide();
        Button signup = (Button)findViewById(R.id.btnsignupp);
      
        signup.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
			 EditText txtemail = (EditText) findViewById(R.id.txtemail);
			 EditText txtusername = (EditText) findViewById(R.id.txtusername);
			 EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
			 EditText txtmobile = (EditText) findViewById(R.id.txtmobile);
			 EditText txtrPassword = (EditText) findViewById(R.id.txtrPassword);
				
				
				if(txtemail.getText().toString().length()<1) {
					Toast.makeText(MainActivity.this, "Email field cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				else if(txtusername.getText().toString().length()<1) {
					Toast.makeText(MainActivity.this, "Username field cannot be empty", Toast.LENGTH_SHORT).show();
					txtusername.requestFocus();
				    return;
				}
				else if(txtmobile.getText().toString().length()<1) {
					Toast.makeText(MainActivity.this, "Mobile field cannot be empty", Toast.LENGTH_SHORT).show();
					txtmobile.requestFocus();
				    return;
				}
				else if(txtPassword.getText().toString().length()<1) {
					Toast.makeText(MainActivity.this, "Password field cannot be empty", Toast.LENGTH_SHORT).show();
					txtusername.requestFocus();
				    return;
				}
				else if(txtrPassword.getText().toString().length()<1) {
					Toast.makeText(MainActivity.this, "Retype Password field cannot be empty", Toast.LENGTH_SHORT).show();
					
					txtrPassword.requestFocus();
				    return;
				}
				
				else
				{
					LayoutInflater layout = (LayoutInflater)
							getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
					final View popUp = layout.inflate(R.layout.pop_up_window_register, null);
					final PopupWindow popUpWindow = new PopupWindow(popUp, LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);
					popUpWindow.showAtLocation(popUp, Gravity.CENTER, 0, 0);
					new Handler().postDelayed(new Runnable() {
			            @Override
			            public void run() {
			            	
							popUpWindow.dismiss();
							Intent intent = new Intent(MainActivity.this, Login.class);
							startActivity(intent);
			            }
			        }, 5000);
				}
    
			}
				
		});
        
       
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       
        return super.onOptionsItemSelected(item);
    }
       

}
