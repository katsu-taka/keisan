package com.example.keisan;

import android.os.AsyncTask;

public class NormalModeTask extends AsyncTask<String, Integer, Integer> {

	// @Override
	// protected onPreExecute() {
	// 実行前のプレ処理を記述
	// }

	@Override
	protected Integer doInBackground(String... params) {
		// バックグラウンドで実行したい処理を記述
		return null;
	}

	@Override
	protected void onProgressUpdate(Integer... progress) {

	}

	protected void onPostExecute(Long result) {

	}

}
