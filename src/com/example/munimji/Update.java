package com.example.munimji;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends Activity implements OnClickListener {
	Button Add, Sub;
	EditText Amt;
	AutoCompleteTextView NameUpdate;

	public void onCreate(Bundle AddingNames) {
		// TODO Auto generated method stub
		super.onCreate(AddingNames);
		setContentView(R.layout.update);
		Add = (Button) findViewById(R.id.bAdd1);
		Sub = (Button) findViewById(R.id.bSub1);
		NameUpdate = (AutoCompleteTextView) findViewById(R.id.etNameUpdate);
		Amt = (EditText) findViewById(R.id.etAmtEnter);

		Add.setOnClickListener(this);// THIS_MIGHT_CREATE_PROBLEMS
		Sub.setOnClickListener(this);

		Database db = new Database(Update.this);
		db.open();
		ArrayList<String> list = new ArrayList<String>();
		db.getSuggestions(list);
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.tv, R.id.tvsuggestions, list);
		NameUpdate.setAdapter(ad);
		db.close();

	}

	@Override
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.bAdd1) {
			boolean ifworks = true;
			try {
				String name = NameUpdate.getText().toString();
				Double amount = Double.parseDouble(Amt.getText().toString());
				Database entry = new Database(Update.this);
				entry.open();
				entry.updateEntryAdd(name, amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(Update.this, "Fake Buddy", Toast.LENGTH_LONG))
						.show();

			} finally {
				if (ifworks) {
					(Toast.makeText(Update.this, "Updated", Toast.LENGTH_LONG))
							.show();
					NameUpdate.setText("");
					Amt.setText("");
				}
			}
		} else if (id == R.id.bSub1) {
			boolean ifworks = true;
			try {
				String name = NameUpdate.getText().toString();
				Double amount = Double.parseDouble(Amt.getText().toString());
				
				Database entry = new Database(Update.this);
				entry.open();
				entry.updateEntryAdd(name, -amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(Update.this, "Fake Buddy", Toast.LENGTH_LONG))
						.show();

			} finally {
				if (ifworks) {
					(Toast.makeText(Update.this, "Updated", Toast.LENGTH_LONG))
							.show();
					NameUpdate.setText("");
					Amt.setText("");
				}
			}
		}
	}

}