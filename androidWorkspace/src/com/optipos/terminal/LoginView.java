package com.optipos.terminal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginView extends Activity {

	EditText editTextPasswordField;
	Button logingButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_view);
		logingButton = (Button) findViewById(R.id.buttonLogin);
		editTextPasswordField = (EditText)findViewById(R.id.editTextPasswordField);
		
//		editTextPasswordField = (EditText) findViewById(R.id.editTextPasswordField);

		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	public void checkPasswordAndLogin(View v) {
		
		String toastMessage = editTextPasswordField.getText().toString();
		Intent intentCashRegister = new Intent (this,CashRegister.class);
			 startActivity(intentCashRegister);
		}
		
	}

