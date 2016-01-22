package com.example.fyp;

import com.example.fyp.R.id;
import com.example.fyp.R.layout;





import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.login);
        getActionBar().hide();
     // Login 
        Button login = (Button)findViewById(id.btnSignin);
        login.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText txtusername = (EditText) findViewById(id.txtlusername);
				 EditText txtPassword = (EditText) findViewById(id.txtlpassword);
				
				if(txtusername.getText().toString().length()<1) {
					Toast.makeText(Login.this, "Username field cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				else if(txtPassword.getText().toString().length()<1) {
					Toast.makeText(Login.this, "Password field cannot be empty", Toast.LENGTH_SHORT).show();
					txtPassword.requestFocus();
				    return;
				}
				else
				{
					Toast.makeText(Login.this, "Welcome back", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(Login.this, MainActivity2.class);
					startActivity(intent);
			
			}
			
			}});
        TextView reg = (TextView)findViewById(id.reg);
        reg.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(Login.this, MainActivity.class);
				startActivity(intent1);
				
			}});
	}
	
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        
	      
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	       
	        return super.onOptionsItemSelected(item);
	    }
	       

}
