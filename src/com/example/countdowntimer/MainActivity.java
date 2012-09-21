package com.example.countdowntimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView tv = (TextView) findViewById(R.id.textView1);
		Button start = (Button) findViewById(R.id.button1);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// time to be inserted in milliseconds
				long timeInMilli = 5400000;
				new CountDownTimer(timeInMilli, 1000) {

					public void onTick(long millisUntilFinished) {
						// tv.setText("seconds remaining: " +
						// millisUntilFinished / 1000);
						int seconds = (int) (millisUntilFinished / 1000);
						tv.setText(seconds / 3600 + ":"
								+ ((seconds % 3600) / 60) + ":"
								+ ((seconds % 3600) % 60));
					}

					public void onFinish() {
						tv.setText("done!");
					}
				}.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
