package com.example.munimji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	// Assigning class Splash and passing SplashScreen to it
	protected void onCreate(Bundle SplashScreen) {
		// TODO Auto-generated method stub
		super.onCreate(SplashScreen);
		setContentView(R.layout.splash);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(600);// taking time of splash screen to 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();// building log of errors maybe
				} finally {
					Intent openStartingPoint = new Intent("com.example.munimji.MAINACTIVITY");
					startActivity(openStartingPoint); // initializing_next_Activity
				}
			}
		};
		timer.start();
	}
}