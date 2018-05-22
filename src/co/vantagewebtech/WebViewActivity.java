package co.vantagewebtech;

import co.vantagewebtech.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View viewToLoad = LayoutInflater.from(this.getParent()).inflate(R.layout.web_view, null);
		this.setContentView(viewToLoad);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://vantagewebtech.com/");

//		String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
//		webView.loadData(customHtml, "text/html", "UTF-8");

	}

}