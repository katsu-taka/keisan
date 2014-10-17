package com.example.keisan;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView text1;
	private EditText text2;
	int result,answer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// TextView取得
		text1 = (TextView) findViewById(R.id.textView2);
		// EditView取得
		text2 = (EditText) findViewById(R.id.edittext1);
		// Button取得
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new onClickButton(this));
		
		// 計算問題を準備
		newQuestion();
	}
	
	class onClickButton implements OnClickListener {
		
		private Context _context;
		
		public onClickButton(Context context) {
			_context = context;
		}
		@Override
		public void onClick(View v) {
			String resultstr;
			answer = Integer.parseInt(text2.getText().toString());
			if (answer == result) {
				resultstr = "正解";
			} else {
				resultstr = "不正解";
			}
			
			Toast.makeText(_context, resultstr, Toast.LENGTH_SHORT).show();
			text2.setText(null);
			newQuestion();
		}
	}
	
	private void newQuestion() {
		Random r = new Random();
		int n1 = r.nextInt(8) + 1;
		int n2 = r.nextInt(8) + 1;
		
		text1.setText(String.valueOf(n1) + " × " + String.valueOf(n2) + " = ?");
		result = n1 * n2;
	}
}
