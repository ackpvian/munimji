package in.co.sdslabs.munimji.item;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EntryAdapter extends ArrayAdapter<Item> {

	private Context context;
	private ArrayList<Item> items;
	private LayoutInflater vi;

	public EntryAdapter(Context context, ArrayList<Item> items) {
		super(context, 0, items);
		this.context = context;
		this.items = items;
		vi = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final Item i = items.get(position);
		if (i != null) {
			if (i.isSection()) {
				SectionItem si = (SectionItem) i;
				v = vi.inflate(R.layout.list_item_section, null);

				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);
				final TextView sectionView = (TextView) v
						.findViewById(R.id.list_section_text);
				sectionView.setText(si.getTitle());
			} else {
				EntryItem ei = (EntryItem) i;
				v = vi.inflate(R.layout.list_item_entry, null);
				final TextView name = (TextView) v
						.findViewById(R.id.tvEventName);
				final TextView location = (TextView) v
						.findViewById(R.id.tvEventLocation);
				final TextView time = (TextView) v
						.findViewById(R.id.tvEventTime);
				final TextView date = (TextView) v
						.findViewById(R.id.tvEventDate);
				final ImageView image = (ImageView) v.findViewById(R.id.ivLogo);

				if (ei.name != null)
					name.setText(ei.name);
				else
					name.setVisibility(View.GONE);

				if (ei.location != null)
					location.setText(ei.location);
				else
					location.setVisibility(View.GONE);

				if (ei.time != null)
					time.setText(ei.time);
				else
					time.setVisibility(View.GONE);

				if (ei.date != null)
					date.setText(ei.date);
				else
					date.setVisibility(View.GONE);

				if (ei.image != null && ei.name != null) {
					image.setBackgroundResource(ei.image);
					image.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
					
				} else if (ei.image != null && ei.name == null) {
					image.setBackgroundResource(ei.image);

				} else
					image.setVisibility(View.GONE);

			}
		}
		return v;
	}
}