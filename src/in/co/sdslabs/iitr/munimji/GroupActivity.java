package in.co.sdslabs.iitr.munimji;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class GroupActivity extends Activity implements OnClickListener {

	//ImageButton lendAdd;
	Button lendAdd;
	AutoCompleteTextView searchBox;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group);
		/* = (ImageButton) findViewById(R.id.lendAddButton);
		lendAdd.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        Intent intent = new Intent(Intent.ACTION_MAIN);
		        intent.setComponent(new ComponentName(this, LendAddActivity.class));
		        startActivity(intent); 
		    }
		});*/
		
		Button lendAdd = (Button) findViewById(R.id.lendAddButton);
		lendAdd.setOnClickListener(this);
		searchBox = (AutoCompleteTextView) findViewById(R.id.lendSearch);

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
		if (id == R.id.lendAddButton) {
			Intent intent = new Intent(this, LendAddActivity.class);
			startActivity(intent);
		}
		

	}
}