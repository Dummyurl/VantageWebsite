package co.vantagewebtech;
import co.vantagewebtech.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContactUsPage extends Activity {
	Button btnsubmit,btnwebsite;
	EditText edtsub,edtemail,edtmessage;
	TextView textView;
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	String email,msg,subject;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_us_page);
		edtsub=(EditText) findViewById(R.id.edtname);
		edtemail=(EditText) findViewById(R.id.edtemail);
		edtmessage=(EditText) findViewById(R.id.edtmessage);
		btnsubmit=(Button) findViewById(R.id.btnsubmit);
		btnwebsite=(Button) findViewById(R.id.btnwebsite);

		edtemail.addTextChangedListener(new TextWatcher() 
		{
			public void afterTextChanged(Editable s) {
				// put the code of save Database here 
				edtemail.setError(null);
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});
		edtsub.addTextChangedListener(new TextWatcher() 
		{
			public void afterTextChanged(Editable s) {
				// put the code of save Database here 
				edtsub.setError(null);
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});
		edtmessage.addTextChangedListener(new TextWatcher() 
		{
			public void afterTextChanged(Editable s) {
				// put the code of save Database here 
				edtmessage.setError(null);
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});

		btnsubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				email=edtemail.getText().toString();
				subject=edtsub.getText().toString();
				msg=edtmessage.getText().toString();
				if(email.equalsIgnoreCase(""))//||(latitude.getText().toString().trim().length()<=4))
				{

					edtemail.requestFocus();
					edtemail.setText("");
					edtemail.setError("Please Fill Email.");
				}
				else
				{

					if(!email.matches(emailPattern))
					{
						edtemail.requestFocus();
						edtemail.setText("");
						edtemail.setError("Invalid email.");
					}
					else
					{
						if(subject.equalsIgnoreCase(""))//||(latitude.getText().toString().trim().length()<=4))
						{

							edtsub.requestFocus();
							edtsub.setText("");
							edtsub.setError("Write the subject.");
						}
						else
						{

							if(msg.equalsIgnoreCase(""))//||(latitude.getText().toString().trim().length()<=4))
							{

								edtmessage.requestFocus();
								edtmessage.setText("");
								edtmessage.setError("Write your messages.");
							}
							else
							{
								Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
								intent.setType("text/plain");
								intent.putExtra(Intent.EXTRA_SUBJECT, edtsub.getText().toString());
								intent.putExtra(Intent.EXTRA_TEXT, edtmessage.getText().toString());
								intent.setData(Uri.parse("mailto:"+edtemail.getText().toString())); // or just "mailto:" for blank
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
								startActivity(intent);
							}






						}
					}
				}
			}
		});
		btnwebsite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(getParent(),WebViewActivity.class);
				TabStackTemple tstack=(TabStackTemple)getParent();
				tstack.push("web",in);




			}
		});
		Tabs.btnback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContactUsPage.this.finish();
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Tabs.btnback.setVisibility(View.VISIBLE);
		Tabs.textView.setText("Contact Us");
		Tabs.btncontactus.setVisibility(View.GONE);
	}
}
