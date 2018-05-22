package co.vantagewebtech;

import co.vantagewebtech.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends TabActivity {
	public static Tabs myTabLayoutDemo;
	private static final String Email = "Email";

	public static TabHost tabHost;
	public static TextView textView;

	public static Button btnback,btncontactus;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_tabs);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
		textView = (TextView)findViewById(R.id.custom_title_text);
		btnback=(Button) findViewById(R.id.btnback);
		btncontactus=(Button) findViewById(R.id.btnaboutus);
		textView.setText("Custom Title");

		tabHost = getTabHost();
		tabHost.getTabWidget().setStripEnabled(false);

		TabSpec email = tabHost.newTabSpec(Email);
		email.setIndicator(prepareTabView(Email,R.drawable.ic_launcher));
		Intent emailIntent = new Intent(this, TabStackTemple.class);
		emailIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		email.setContent(emailIntent);




		tabHost.addTab(email);
	}
	private View prepareTabView(String text, int resId) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabss, null);
		ImageView iv = (ImageView) view.findViewById(R.id.TabImageView);
		iv.setBackgroundResource(resId);
		return view;
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();

	}
}
