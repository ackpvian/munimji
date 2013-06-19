package in.co.sdslabs.iitr.munimji;
import android.app.Activity;
	import android.content.Intent;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.Button;
import android.widget.EditText;

public class FeedBack extends Activity implements View.OnClickListener {

	EditText data;
	String datasend;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		data = (EditText) findViewById(R.id.message);
		sendEmail = (Button) findViewById(R.id.bSentEmail);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
		String email[] = {"sdsmobilelabs@gmail.com"};
		String message = "Feedback from user \n" + data +"\n Regards user";
		
		Intent EmailIntent = new Intent(android.content.Intent.ACTION_SEND);
		EmailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, email);
		EmailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback for munimji" );
		EmailIntent.setType("plain/Text");
		EmailIntent.putExtra(android.content.Intent.EXTRA_TEXT, datasend);
		startActivity(EmailIntent);
	}

	private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
				datasend = data.getText().toString();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}