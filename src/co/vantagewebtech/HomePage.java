package co.vantagewebtech;

import co.vantagewebtech.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage extends Activity {
	Button btn_services,btn_aboutus,btn_portfolio,btn_contactus;
	int[] imageArray1 = { R.drawable.banner1, R.drawable.banner2,
			R.drawable.banner3,R.drawable.banner4 };
	 
	    
	ImageView SliderImage1,SliderImage2,SliderImage3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		btn_services=(Button) findViewById(R.id.services);
		btn_aboutus=(Button) findViewById(R.id.aboutus);
		btn_portfolio=(Button) findViewById(R.id.portfolio);
		btn_contactus=(Button) findViewById(R.id.contactus);
		SliderImage1=(ImageView) findViewById(R.id.header2);
		final Handler handler = new Handler();
		Runnable runnable = new Runnable() {
			int i = 0;

			public void run() {
				SliderImage1.setImageResource(imageArray1[i]);

				i++;
				if (i > imageArray1.length - 1) {
					i = 0;
				}
				handler.postDelayed(this, 4000);

			}
		};
		handler.postDelayed(runnable, 2000);
		btn_services.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(getParent(),ServicesPage.class);
				TabStackTemple home_services=(TabStackTemple)getParent();
				home_services.push("services",in);
			}
		});
		btn_aboutus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(getParent(),AboutUsPage.class);
				TabStackTemple hom_aboutuse=(TabStackTemple)getParent();
				hom_aboutuse.push("aboutus",in);
			}
		});
		btn_portfolio.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(getParent(),PortFolioPage.class);
				TabStackTemple home_portfolio=(TabStackTemple)getParent();
				home_portfolio.push("portfolio",in);
			}
		});
		btn_contactus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(getParent(),ContactUsPage.class);
				TabStackTemple home_contactus=(TabStackTemple)getParent();
				home_contactus.push("contactus",in);
			}
		});
		Tabs.btnback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//				TabStackTemple t=new TabStackTemple();
				//				t.pop();
				HomePage.this.finish();
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
		Tabs.textView.setText("Home");
		Tabs.btnback.setVisibility(View.VISIBLE);
		Tabs.btncontactus.setVisibility(View.GONE);

	}
}