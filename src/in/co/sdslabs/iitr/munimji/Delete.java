package in.co.sdslabs.iitr.munimji;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class Delete extends Activity implements OnClickListener {
	Button Del;
	AutoCompleteTextView NameDelete;

	public void onCreate(Bundle AddingNames) {
		// TODO Auto generated method stub
		super.onCreate(AddingNames);
		setContentView(R.layout.delete_entry);
		Del = (Button) findViewById(R.id.bDel);
		NameDelete = (AutoCompleteTextView) findViewById(R.id.etNameDelete);

		Del.setOnClickListener(this);// THIS_MIGHT_CREATE_PROBLEMS

		Database db = new Database(Delete.this);
		db.open();
		ArrayList<String> list = new ArrayList<String>();
		db.getSuggestions(list);
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.tv,
				R.id.tvsuggestions, list);
		NameDelete.setAdapter(ad);
		db.close();

	}

	@Override
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if (id == R.id.bDel) {
			boolean ifworks = true;
			try {
				String name = NameDelete.getText().toString();
				Database entry = new Database(Delete.this);
				entry.open();
				entry.deleteEntry(name);
				entry.close();
			} catch (Exception e) {
				ifworks = false;
				(Toast.makeText(Delete.this, e.toString(), Toast.LENGTH_LONG))
						.show();

			} finally {
				if (ifworks) {
					(Toast.makeText(Delete.this, "Deleted", Toast.LENGTH_LONG))
							.show();
					NameDelete.setText("");
				}
			}
		}
	}
}