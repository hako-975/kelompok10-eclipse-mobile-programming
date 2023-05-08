package com.example.materiactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener { 
	private String[][] dataUser = {{"ADMIN", "ADMIN" ,"Administrator"},
			 {"user1","password1","Nama User 1"},
			 {"user2","password2","Nama User 2"}};
	private EditText userNameET, passwordET;
	private final int SUCCESS=1;
			
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameET = (EditText) findViewById(R.id.usernameEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText); 
        
        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.tutupButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case R.id.loginButton:
				int i=0;
				boolean success=false;
				while ((i<dataUser.length) && (!success)){
					if ((userNameET.getText().toString().equals(dataUser[i][0])) && (passwordET.getText().toString().equals(dataUser[i][1])))
					{
						success=true;
					} 
					else 
					{
						i++;
					}
				}

				Intent intent;
				if (success){
					intent = new Intent(this, SuccessActivity.class); 
					intent.putExtra("namaUser", dataUser[i][2]);
					startActivityForResult(intent,SUCCESS); 
				}
				else 
				{
					intent = new Intent(this, FailedActivity.class);
					startActivity(intent);
				}
				startActivity(intent); 
				break; 
			case R.id.tutupButton:
				System.exit(0);
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		switch (requestCode) { 
	 		case SUCCESS:
	 			userNameET.setText(""); passwordET.setText("");
	 			break; 
	 	}
	} 
}
