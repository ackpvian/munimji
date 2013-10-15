package in.co.sdslabs.iitr.munimji;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button lendBtton, personalBtton, budgetBttn, groupBttn;
	TextView display;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		lendBtton = (Button) findViewById(R.id.lendButton);
		lendBtton.setOnClickListener(this);
		personalBtton = (Button) findViewById(R.id.personalButton);
		personalBtton.setOnClickListener(this);

		budgetBttn = (Button) findViewById(R.id.budgetButton);
		budgetBttn.setOnClickListener(this);
		groupBttn = (Button) findViewById(R.id.groupButton);
		groupBttn.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	// giving life to buttons
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.lendButton) {
			Intent intent = new Intent(this, LendActivity.class);
			startActivity(intent);
		}
		if (id == R.id.personalButton) {
			Intent intent = new Intent(this, PersonalActivity.class);
			startActivity(intent);
		}
		if (id == R.id.budgetButton) {
			Intent intent = new Intent(this, BudgetActivity.class);
			startActivity(intent);
		}
		if (id == R.id.groupButton) {
			// Intent intent = new Intent(this, GroupActivity.class);
			Intent intent = new Intent(this, GroupTransactionActivity.class);

			startActivity(intent);
		}

	}
}