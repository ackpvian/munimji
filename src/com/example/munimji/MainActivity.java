package com.example.munimji;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button AddBuddy, viewer, update, delete;
	TextView display;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AddBuddy = (Button) findViewById(R.id.AddId);
		AddBuddy.setOnClickListener(this);
		viewer = (Button) findViewById(R.id.infoAmt);
		viewer.setOnClickListener(this);

		update = (Button) findViewById(R.id.Update_Entry);
		update.setOnClickListener(this);
		delete = (Button) findViewById(R.id.bDelEntry);
		delete.setOnClickListener(this);
		display = (TextView) findViewById(R.id.Total1);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	// giving life to button
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.AddId) {
			Intent openAddIdWizard = new Intent("com.example.munimji.ADDER");
			startActivity(openAddIdWizard); // initializing AddWizard activity
		}
		if (id == R.id.infoAmt) {
			Intent openView = new Intent("com.example.munimji.VIEW");
			startActivity(openView); // initializing AddWizard activity
		}
		if (id == R.id.Update_Entry) {
			Intent openView1 = new Intent("com.example.munimji.UPDATE");
			startActivity(openView1); // initializing UpdateWizard activity
		}
		if (id == R.id.bDelEntry) {
			Intent openView2 = new Intent("com.example.munimji.DELETE");
			startActivity(openView2); // initializing DeleteWizard activity
		}
	}
}