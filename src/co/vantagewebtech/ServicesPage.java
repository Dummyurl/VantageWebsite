package co.vantagewebtech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.vantagewebtech.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ServicesPage extends Activity {
	TextView textView;
	Button btnback,btncontactus;
	// Array of strings storing country names
	String[] Services = new String[] {
			"Designing",
			"Website Development",
			"Mobile Apps",
			"Internet Marketing"        
	};

	// Array of integers points to images stored in /res/drawable-ldpi/
	int[] flags = new int[]{
			R.drawable.designing,
			R.drawable.websitedevelopment,
			R.drawable.webapps,
			R.drawable.seoservices

	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.services_page);  
		String[] Description = new String[]{
				getResources().getString(R.string.Designing),
				getResources().getString(R.string.Website_development),
				getResources().getString(R.string.Mobiles_app),
				getResources().getString(R.string.internat_marketing)

		};
		// Each row in the list stores country name, currency and flag
		List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        

		for(int i=0;i<4;i++){
			HashMap<String, String> hm = new HashMap<String,String>();
			hm.put("txt",  Services[i]);
			hm.put("cur",Description[i]);
			hm.put("flag", Integer.toString(flags[i]) );            
			aList.add(hm); 
		}

		// Keys used in Hashmap
		String[] from = { "flag","txt","cur" };

		// Ids of views in listview_layout
		int[] to = { R.id.service_image,R.id.title,R.id.description};        
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.serviceslistitems, from, to);
		ListView listView = ( ListView ) findViewById(R.id.ListView1);
		listView.setAdapter(adapter);   
		Tabs.btnback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ServicesPage.this.finish();
			}
		});
		Tabs.btncontactus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(getParent(),ContactUsPage.class);
				TabStackTemple home_contactus=(TabStackTemple)getParent();
				home_contactus.push("contactus",in);
			}
		});
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Tabs.btnback.setVisibility(View.VISIBLE);
		Tabs.textView.setText("Services");
		Tabs.btncontactus.setVisibility(View.VISIBLE);
	}

}