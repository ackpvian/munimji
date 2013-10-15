package in.co.sdslabs.iitr.munimji;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.app.ListActivity;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class GroupActivity extends Activity implements OnClickListener {

	// ImageButton lendAdd;
	Button lendAdd;
	AutoCompleteTextView searchBox;
	String str[] = { "Akash", "aaaa", "bbbb", "cccc", "sdddd" };// populate
																// string using
																// database

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group);
		//setListAdapter(new ArrayAdapter<String>(GroupActivity.this,
			//	android.R.layout.simple_list_item_1, str));

		/*
		 * = (ImageButton) findViewById(R.id.lendAddButton);
		 * lendAdd.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { Intent intent = new
		 * Intent(Intent.ACTION_MAIN); intent.setComponent(new
		 * ComponentName(this, LendAddActivity.class)); startActivity(intent); }
		 * });
		 */

		Button lendAdd = (Button) findViewById(R.id.lendAddButton);
		lendAdd.setOnClickListener(this);
		searchBox = (AutoCompleteTextView) findViewById(R.id.lendSearch);
	}

	// giving life to button
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.lendAddButton) {
			Intent intent = new Intent(this, LendAddActivity.class);
			startActivity(intent);
		}

	}

	/*protected void onListItemClick(ListView l, View v1, int position, long id1) {
		// TODO Auto-generated method stub

		super.onListItemClick(l, v1, position, id1);
		Object o = this.getListAdapter().getItem(position);
		String keyword = o.toString();
		Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_LONG)
				.show();
		Intent intent = new Intent(this, GroupTransactionActivity.class);
		startActivity(intent);
	}*/
}