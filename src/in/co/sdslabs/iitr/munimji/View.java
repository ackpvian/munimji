package in.co.sdslabs.iitr.munimji;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class View extends Activity {
	TextView tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbview);
		ListView lv = (ListView) findViewById(R.id.listMe);
		Database info = new Database(this);
		info.open();
		ArrayList<String> data = info.getData(); 
		info.close();
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
		
		/*TextView tv1 = (TextView) findViewById(R.id.tvName);
		TextView tv2 = (TextView) findViewById(R.id.tvAmt);
		Database info = new Database(View.this);
		info.open();
		String data1 = info.getData();
		String data2 = info.getData2();
		info.close();
		tv1.setText(data1);
		tv2.setText(data2);*/
	}

}