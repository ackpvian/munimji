package in.co.sdslabs.iitr.munimji;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GroupSummary extends Activity {
	TextView tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_db_view);
		TextView tv1 = (TextView) findViewById(R.id.tvName);
		DatabaseGroup info = new DatabaseGroup(GroupSummary.this);
		info.open();
		String data1 = info.getSummary();
		info.close();
		tv1.setText(data1);
	}

}