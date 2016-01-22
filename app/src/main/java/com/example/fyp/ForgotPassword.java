package com.example.fyp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * Created by jadephong on 20/1/2016.
 */
public class ForgotPassword extends Activity {
    private static final String URL = "http://jstarcnavigator.esy.es/andriod_user_api/checkemailexist.php";
    private final String senderEmail = "tarcnavigator2016@gmail.com";
    private final String senderPassword = "navigator2016";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        getActionBar().hide();
        Button btnRecover = (Button) findViewById(R.id.btnRecover);
        btnRecover.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText emailRecover = (EditText) findViewById(R.id.txtEmailRecover);
                String email = emailRecover.getText().toString();
                final String randomPassword = getRandomPassword();
                if (emailRecover.getText().toString().length() < 1) {
                    Toast.makeText(ForgotPassword.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    /*login(username, password);*/
				/*	Toast.makeText(Login.this, "Welcome back", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(Login.this, MainActivity2.class);
					startActivity(intent);*/
                    sendEmail(email, randomPassword);
                    forgotPassword(email,randomPassword);

                }

            }
        });
        TextView tv_goBack = (TextView) findViewById(R.id.tv_goBack);
        tv_goBack.setOnClickListener(new TextView.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ForgotPassword.this, Login.class);
                startActivity(intent1);


            }
        });
    }

    private void forgotPassword(final String email,final String randomPassword) {

        String urlSuffix = "?email=" + email + "&password=" + randomPassword;
        class RecoverPassword extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ForgotPassword.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                if ("Password Recover Email Is Sending".equals(s)) {


                    Toast.makeText(getApplicationContext(), "Email sent. Please check your email", Toast.LENGTH_LONG).show();
                   /* Intent intent = new Intent(ForgotPassword.this, Login.class);
                    startActivity(intent);*/

                }
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                } catch (Exception e) {
                    return null;
                }
            }
        }

        RecoverPassword rp = new RecoverPassword();
        rp.execute(urlSuffix);

    }

    protected void sendEmail(String email, String randomPassword) {

        String recipients = email;
        String[] parts = email.split("@");
        final String subject = "Tarc Navigator Password Recovery";
        String body = "Hi " + parts[0] + ",\n\n" +
                "We've received a request to reset the password.\n" +
                "A random password had been created. Please use this password to recover your account.\n" +
                "Password:" + randomPassword +
                "\n\nRegards,\nTarcNavigator";


        GMail sender = new GMail(senderEmail, senderPassword);
        try {
            sender.sendMail(subject, body, senderEmail,
                    recipients);
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }



    protected String getRandomPassword() {
        int length=8;
        String candidateChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
       /* getMenuInflater().inflate(R.menu.main, menu);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

                return super.onOptionsItemSelected(item);
    }
}
