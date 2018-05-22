package co.vantagewebtech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.vantagewebtech.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class AboutUsPage extends Activity {
	TextView title,details;
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us_page);
		title=(TextView) findViewById(R.id.aboutus);
		details=(TextView) findViewById(R.id.details);
		details.setText(getResources().getString(R.string.about_us));
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.expandableListView1);

		// preparing list data
		prepareListData();

		ExpandableListAdapter	listAdapter = new co.vantagewebtech.ExpandableListAdapter(AboutUsPage.this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		//	btnback.setOnClickListener(new OnClickListener() {
		//
		//			@Override
		//			public void onClick(View v) {
		//				// TODO Auto-generated method stub
		//				AboutUsPage.this.finish();
		//			}
		//		});
		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				//				Toast.makeText(getApplicationContext(),
				//						listDataHeader.get(groupPosition) + " Expanded",
				//						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				//				Toast.makeText(getApplicationContext(),
				//						listDataHeader.get(groupPosition) + " Collapsed",
				//						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				//				Toast.makeText(
				//						getApplicationContext(),
				//						listDataHeader.get(groupPosition)
				//						+ " : "
				//						+ listDataChild.get(
				//								listDataHeader.get(groupPosition)).get(
				//										childPosition), Toast.LENGTH_SHORT)
				//										.show();
				return false;
			}
		});
		Tabs.btnback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AboutUsPage.this.finish();
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

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		listDataHeader.add("Web Designing");
		listDataHeader.add("Search Engine Optimization");
		listDataHeader.add("Opensource software");
		listDataHeader.add("Web Development");
		listDataHeader.add("Ongoing Support and Maintanence");



		List<String> WebDesigning = new ArrayList<String>();
		WebDesigning.add("Vantage Webtech provides the following designing services.");
		WebDesigning.add("1. Web Designing - This includes creating customized static and flash designs for websites, e- newsletters, web banners etc.");
		WebDesigning.add("2. Graphic Designing - This includes logos, brochures, posters, pamphlets etc.A website is the face of any business on the internet. It is the main medium of communication between a company and their customers. Even for those businesses, which are not completely dependant on online business, the website is what the customer may look at to make a choice over a competitor Graphic Design Services With our comprehensive offerings in designing, flash, web development and online marketing, we are able to create solutions, which are not only attractive but also effective, and user friendly. Since the goal of each design and development project is eventually to reach out to a specific target audience, our solutions and recommendations are worked out from the eventual marketing efforts or plan. These help our clients in their online marketing efforts. These attributes makes us a comprehensive solutions provider and one stop shop for all online presence needs.");




		List<String> SearchEngineOptimization = new ArrayList<String>();
		SearchEngineOptimization.add("Search Engine Optimization (SEO) Services Company Search Engine Optimization (SEO) involves making some changes in the website to make it search engine friendly, which would help it to rank on search engines. SEO addresses the on page factors, which makes the website relevant on search engines for the keywords important to that website.");
		SearchEngineOptimization.add("Organic SEO Consultants Our SEO Consultants helps the website to rank high organically or naturally on search engines unlike paid advertising (PPC) in which you have to pay to get your ads to rank and get traffic. Thus, SEO helps the website to get free traffic, publicity and establish trust. SEO is an ongoing process and the website has to be updated regularly for the latest keywords, search trends, competition etc. SEO can be done stand-alone also but a website generally requires support from incoming links through Link building and Articles Syndication to attain high Search Engine rankings. At Vantage Webtech, we have the expertise to create and implement Search Engine Marketing strategies, which include SEO, which would help in improving the online performance of your website on search engines.");


		List<String> Opensourcesoftware = new ArrayList<String>();
		Opensourcesoftware.add("Open Source Softwares are free to use ready made software source codes which can be customized as per requirements to create applications and websites. There are open source softwares available for Content Management Systems, Community Websites, Corporate websites and Intranets, E-commerce websites, Directories and Portals. Easy to tweak code makes custom design implementation possible.");
		Opensourcesoftware.add("At VantageWebtech we offer services to create websites and applications using open source softwares. We create and implement customized designs, set up features as per the scope, search engine optimize, secure, launch and maintain websites made from open source softwares.");
		Opensourcesoftware.add("Websites and applications made from open source softwares are economical, faster to build and highly scalable. Some commonly used open source softwares are Joomla, Wordpress, Drupal, OS Commerce, Magento, Open Cart, Virtuemart and Zen Cart");


		List<String> WebDevelopment = new ArrayList<String>();
		WebDevelopment.add("Vantage Webtech provides the following web development services.");
		WebDevelopment.add("Responsive websites");
		WebDevelopment.add("E-commerce websites");
		WebDevelopment.add("Content Management System websites");
		WebDevelopment.add("Community websites");
		WebDevelopment.add("Dynamic websites of all types - such as JOOMLA , Drupal, Wordpress, Magento, Open cart, Codeigniter framwork, Core php, CakePHP.");
		WebDevelopment.add("Upgradation and debugging of existing websites.");
		WebDevelopment.add("Implementation of SEO and other changes.");
		WebDevelopment.add("Website maintenance services.");
		WebDevelopment.add("Vantage Webtech follows the best practices in the industry for all web development projects - be it a stand-alone design job, third party integration like Joomla content management system integration or a customized dynamic website solution. We have proficiency in working on all major technologies and databases, which gives us the capabilities to handle all levels and types of web development projects. This capability in turn helps us in providing web development solutions, which best match our clients requirements and budget. E-commerce Shopping Cart and Joomla Content Management System (CMS) Development Solutions At Vantage Webtech, our aim is not just creating solutions for our clients but also providing them with consultation on technical and non-technical (such as web marketing) aspects of the projects. Our e-commerce shopping cart solutions are not only quality tested, but also quality assured. We provide a high level of support to our clients during and post development.");



		List<String> OngoingSupportandMaintanence = new ArrayList<String>();
		OngoingSupportandMaintanence.add("Customer Service");
		OngoingSupportandMaintanence.add("We provide 100% client satisfaction. We provide life time warranty of our code provided no one tampers with the code. We provide full support till the time our client is not comfortable using the system.");




		listDataChild.put(listDataHeader.get(0), WebDesigning); // Header, Child data
		listDataChild.put(listDataHeader.get(1), SearchEngineOptimization);
		listDataChild.put(listDataHeader.get(2), Opensourcesoftware);
		listDataChild.put(listDataHeader.get(3), WebDevelopment);
		listDataChild.put(listDataHeader.get(4), OngoingSupportandMaintanence);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Tabs.btnback.setVisibility(View.VISIBLE);
		Tabs.textView.setText("About Us");
		Tabs.btncontactus.setVisibility(View.VISIBLE);
	}
}
