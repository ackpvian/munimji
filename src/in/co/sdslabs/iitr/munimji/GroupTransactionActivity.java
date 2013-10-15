package in.co.sdslabs.iitr.munimji;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GroupTransactionActivity extends Activity implements
		OnClickListener {

	Button groupTransactionDone, groupHistoryView, groupSummaryView;
	EditText groupPaidName, groupTakerName, groupDate, groupAmount, groupFor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_transaction);
		groupTransactionDone = (Button) findViewById(R.id.buttonGroupTransaction);
		groupTransactionDone.setOnClickListener(this);
		groupHistoryView = (Button) findViewById(R.id.buttonGroupHistoryView);
		groupHistoryView.setOnClickListener(this);
		groupSummaryView = (Button) findViewById(R.id.buttonGroupSummaryView);
		groupSummaryView.setOnClickListener(this);
		groupPaidName = (EditText) findViewById(R.id.editTextGroupPaidName);
		groupTakerName = (EditText) findViewById(R.id.editTextGroupTakerName);
		groupDate = (EditText) findViewById(R.id.editTextGroupDate);
		groupFor = (EditText) findViewById(R.id.editTextGroupFor);
		groupAmount = (EditText) findViewById(R.id.editTextGroupAmount);

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
		if (id == R.id.buttonGroupTransaction) {// OKAY Button functions
			boolean ifworks = true;
			try {
				String grpName = "X";// Define group Name here by bringing from
										// previous activity
				String paidName = groupPaidName.getText().toString();
				String takerName = groupTakerName.getText().toString();
				String date = groupDate.getText().toString();
				String why = groupFor.getText().toString();
				Double amount = Double.parseDouble(groupAmount.getText()
						.toString());
				DatabaseGroup entry = new DatabaseGroup(
						GroupTransactionActivity.this);
				entry.open();
				entry.createEntry(grpName, paidName, takerName, date, why,
						amount);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(GroupTransactionActivity.this,
						"Name already exists", Toast.LENGTH_LONG)).show();

			} finally {
				if (ifworks) {
					(Toast.makeText(GroupTransactionActivity.this,
							"Entered successfully", Toast.LENGTH_LONG)).show();
					groupPaidName.setText("");
					groupTakerName.setText("");
					groupDate.setText("");
					groupFor.setText("");
					groupAmount.setText("");
				}
			}
		} else if (id == R.id.buttonGroupHistoryView) {
			Intent intent = new Intent(this, GroupView.class);
			startActivity(intent);

		}
		else if (id == R.id.buttonGroupSummaryView) {
			Intent intent = new Intent(this, GroupSummary.class);
			startActivity(intent);

		}
	}
}