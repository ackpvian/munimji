package com.example.munimji;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adder extends Activity implements OnClickListener {
	Button Add, Sub;
	EditText NameAdder, Amt;

	public void onCreate(Bundle AddingNames) {
		// TODO Auto generated method stub
		super.onCreate(AddingNames);
		setContentView(R.layout.buddy_adder);
		Add = (Button) findViewById(R.id.bAdd);
		Sub = (Button) findViewById(R.id.bSub);
		NameAdder = (EditText) findViewById(R.id.etNameAdder);
		Amt = (EditText) findViewById(R.id.etAmtEnter);

		Add.setOnClickListener(this);// THIS_MIGHT_CREATE_PROBLEMS
		Sub.setOnClickListener(this);

	}

	@Override
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.bAdd) {
			boolean ifworks = true;
			try {
				String name = NameAdder.getText().toString();
				Double amount = Double.parseDouble(Amt.getText().toString());
				Database entry = new Database(Adder.this);
				entry.open();
				entry.createEntry(name, amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(Adder.this, "Name already exists", Toast.LENGTH_LONG)).show();
				
			} finally {
				if (ifworks) {
					(Toast.makeText(Adder.this, "Entered successfully", Toast.LENGTH_LONG)).show();
					NameAdder.setText("");
					Amt.setText("");
				}
			}
		} else if (id == R.id.bSub) {
			boolean ifworks = true;
			try {
				String name = NameAdder.getText().toString();
				Double amount = - Double.parseDouble(Amt.getText().toString());
				Database entry = new Database(Adder.this);
				entry.open();
				entry.createEntry(name, amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(Adder.this, "Name already exists", Toast.LENGTH_LONG)).show();
				
			} finally {
				if (ifworks) {
					(Toast.makeText(Adder.this, "Entered successfully", Toast.LENGTH_LONG)).show();
					NameAdder.setText("");
					Amt.setText("");
				}
			}
		}
	}
	
}
