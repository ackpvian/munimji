package in.co.sdslabs.iitr.munimji;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

public class LendAddActivity extends Activity{

	ImageButton lendAdd;
	AutoCompleteTextView searchBox;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lend_add);
				

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
}

