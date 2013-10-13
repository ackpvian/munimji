package in.co.sdslabs.iitr.munimji;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LendAddActivity extends Activity implements OnClickListener {

	Button lendAddMoneyGiven, lendAddMoneyTaken;
	EditText lendName, lendFor, lendDate, lendAmount;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lend_add);
		lendAddMoneyTaken = (Button) findViewById(R.id.buttonMoneyTaken);
		lendAddMoneyTaken.setOnClickListener(this);
		lendAddMoneyGiven = (Button) findViewById(R.id.buttonMoneyGiven);
		lendAddMoneyGiven.setOnClickListener(this);
		lendName = (EditText) findViewById(R.id.editTextName);
		lendFor = (EditText) findViewById(R.id.editTextFor);
		lendDate = (EditText) findViewById(R.id.editTextDate);
		lendAmount = (EditText) findViewById(R.id.editTextAmount);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.buttonMoneyGiven) {
			boolean ifworks = true;
			try {
				String name = lendName.getText().toString();
				String date = lendDate.getText().toString();
				String why = lendFor.getText().toString();
				Double amount = Double.parseDouble(lendAmount.getText()
						.toString());
				Database entry = new Database(LendAddActivity.this);
				entry.open();
				entry.createEntry(name, date, why, amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(LendAddActivity.this, "Name already exists",
						Toast.LENGTH_LONG)).show();

			} finally {
				if (ifworks) {
					(Toast.makeText(LendAddActivity.this,
							"Entered successfully", Toast.LENGTH_LONG)).show();
					lendName.setText("");
					lendFor.setText("");
					lendDate.setText("");
					lendAmount.setText("");
				}
			}
		}

		else if (id == R.id.buttonMoneyTaken) {
			boolean ifworks = true;
			try {
				String name = lendName.getText().toString();
				String date = lendDate.getText().toString();
				String why = lendFor.getText().toString();
				Double amount = -Double.parseDouble(lendAmount.getText()
						.toString());
				Database entry = new Database(LendAddActivity.this);
				entry.open();
				entry.createEntry(name, date, why, amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(LendAddActivity.this, "Name already exists",
						Toast.LENGTH_LONG)).show();

			} finally {
				if (ifworks) {
					(Toast.makeText(LendAddActivity.this,
							"Entered successfully", Toast.LENGTH_LONG)).show();
					lendName.setText("");
					lendFor.setText("");
					lendDate.setText("");
					lendAmount.setText("");
				}
			}
		}
	}

}
