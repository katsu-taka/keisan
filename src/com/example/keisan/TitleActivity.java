package com.example.keisan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
	}

	public void inputMode(View view) {
		switch (view.getId()) {
		case R.id.button1:
			Intent intent = new Intent(this, MainActivity.class);

			break;
		case R.id.button2:
			break;
		}
	}

}
