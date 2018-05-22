package co.vantagewebtech;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.vantagewebtech.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class PortFolioPage extends Activity {
	TextView textView,text;
	String[] Services = new String[] {
			"2scalearch",
			"CMS based book site",
			"CMS based book and media site",
			"Childrens Book and media CMS site",
			"Custom Book and Media",
			"Christian Book and Media",
			"Allthat jazz site",
			"Ameya Flowers",
			"Balmainvet Site",
			"Designer Furniture",
			"Charlie site",
			"Drupal site",
			"Gym wordpress site",
			"Collinsacquisitions1 site",
			"Cook Fresh",
			"Bilingual Spa cms site",
			"Enttex site",
			"Recruitment site",
			"Firstkytrust site",
			"fnzey site",
			"Multiuser Gaming site",
			"Vacuum Cleaners",
			"Habitats1 Site",
			"Hellostranger site",
			"Hunterprofessional1 site",
			"Events based wordpress site",
			"Wordpress site using Avada theme",
			"Katrina Site",
			"Kingstonstorage1 site",
	"Living Sabai" 	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.port_folio_page);  
		ListView mListView1=(ListView) findViewById(R.id.list);
		int[] img = new int[]{
				R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
				R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,
				R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,
				R.drawable.a16,R.drawable.a17,R.drawable.a19,R.drawable.a20,
				R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25,
				R.drawable.a26,R.drawable.a27,R.drawable.a30,R.drawable.a31,R.drawable.a32,R.drawable.a33,R.drawable.a34

		};

		// Each row in the list stores country name, currency and flag
		List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        

		for(int i=0;i<30;i++){
			HashMap<String, String> hm = new HashMap<String,String>();
			hm.put("txt",  Services[i]);
			hm.put("flag", Integer.toString(img[i]) );            
			aList.add(hm); 
		}

		// Keys used in Hashmap
		String[] from = { "flag","txt" };

		// Ids of views in listview_layout
		int[] to = { R.id.images,R.id.values};        

		// Instantiating an adapter to store each items
		// R.layout.listview_layout defines the layout of each item
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.portfoliolistitem, from, to);

		// Getting a reference to listview of main.xml layout file
		ListView listView = ( ListView ) findViewById(R.id.list);

		// Setting the adapter to the listView
		listView.setAdapter(adapter);     
		Tabs.btnback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PortFolioPage.this.finish();
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
		Tabs.textView.setText("Portfolio");
		Tabs.btncontactus.setVisibility(View.VISIBLE);
	}
}