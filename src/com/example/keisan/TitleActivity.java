package com.example.keisan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleActivity extends Activity {
	String[] ary = new String[3];

	private final int REQUEST_MAIN_CODE = 10;
	private final int REQUEST_RESULT_CODE = 20;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
	}

	public void clickStart(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		switch (view.getId()) {
		// 通常モードでゲーム画面（MainActivity）を開く
		case R.id.button1:
			ary[0] = "normal";
			intent.putExtra("mode", ary);
			startActivityForResult(intent, REQUEST_MAIN_CODE);
			break;
		// エンドレスモードでゲーム画面（MainActivity）を開く
		case R.id.button2:
			ary[0] = "endless";
			intent.putExtra("mode", ary);
			startActivityForResult(intent, REQUEST_MAIN_CODE);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		// ゲーム画面（MainActivity）からの戻り
		if (requestCode == REQUEST_MAIN_CODE) {
			if (resultCode == RESULT_OK) {
				String[] str = intent.getStringArrayExtra("mode");
				switch (str[0]) {
				case "normal":
					Intent nintent = new Intent(this, ResultActivity.class);
					// ary[0] = "normal";
					nintent.putExtra("mode", str);
					startActivityForResult(nintent, REQUEST_RESULT_CODE);
					break;

				case "endless":
					Intent eintent = new Intent(this, MainActivity.class);
					ary[0] = "endless";
					eintent.putExtra("mode", ary);
					startActivityForResult(eintent, REQUEST_MAIN_CODE);
					break;
				}
			}
		}

		// 結果画面（ResultActivity）からの戻り
		if (requestCode == REQUEST_RESULT_CODE) {
			if (resultCode == RESULT_OK) {
				Intent nintent = new Intent(this, MainActivity.class);
				ary[0] = "normal";
				nintent.putExtra("mode", ary);
				startActivityForResult(nintent, REQUEST_MAIN_CODE);
			}
		}
	}
}
