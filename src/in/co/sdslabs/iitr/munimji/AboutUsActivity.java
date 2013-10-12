package in.co.sdslabs.iitr.munimji;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import in.co.sdslabs.munimji.item.EntryAdapter;
import in.co.sdslabs.munimji.item.EntryItem;
import in.co.sdslabs.munimji.item.Item;
import in.co.sdslabs.munimji.item.SectionItem;

public class AboutUsActivity extends ListActivity {
	/** Called when the activity is first created. */
	
	ArrayList<Item> items = new ArrayList<Item>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		items.add(new SectionItem("Powered By"));
		items.add(new EntryItem(R.drawable.intentfinal, null, null, null, null,
				"https://www.facebook.com/SDSLabs"));
		
		/*	items.add(new SectionItem("Developers"));
		items.add(new EntryItem(R.drawable.me, "Anindya Chakravarti", "CSE II Year",
				null, null, "https://www.facebook.com/Anindya1995"));
		
		EntryAdapter adapter = new EntryAdapter(this, items);

		setListAdapter(adapter);
*/	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		if (!items.get(position).isSection()) {
			try {
				EntryItem item = (EntryItem) items.get(position);
				Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(item.url));
				startActivity(in);
			} catch (Exception e) {
			}

		}

		super.onListItemClick(l, v, position, id);
	}

}