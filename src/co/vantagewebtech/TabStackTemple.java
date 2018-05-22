package co.vantagewebtech;

import java.util.Stack;





import co.vantagewebtech.R;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

@SuppressWarnings("deprecation")
public class TabStackTemple extends ActivityGroup {
	private Stack<String> stack;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (stack == null)
			stack = new Stack<String>();
		// start default activity
		push("FirstStackActivity", new Intent(this, HomePage.class));
	}

	@Override
	public void finishFromChild(Activity child) {
		pop();
	}

	@Override
	public void onBackPressed() {
		pop();
	}

	public void push(String id, Intent intent) {
		Window window = getLocalActivityManager().startActivity(id,
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
		if (window != null) {
			stack.push(id);
			setContentView(window.getDecorView());
		}
	}


	public void pop() {
		if (stack.size() == 1)
		{//adb.setMessage(Html.fromHtml("<font color='#FF0000'><b>John:</b></font>"+"How are you?"))
			AlertDialog alertDialog = new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT).create();

			alertDialog.setTitle(Html.fromHtml("<font color='#3399FF'><b>QUIT</b></font>"));
			alertDialog.setMessage(Html.fromHtml("<font color='#3399FF'><b>Are you sure?</b></font>"));
			alertDialog.setIcon(R.drawable.lounch_icon);
			alertDialog.setButton("Yes", new  DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					TabStackTemple.this.finish();
				}
			});
			alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {

				}
			});


			alertDialog.show();
			//finish();
		}
		else
		{
			LocalActivityManager manager = getLocalActivityManager();
			manager.destroyActivity(stack.pop(), true);
			if (stack.size() > 0) {
				Intent lastIntent = manager.getActivity(stack.peek()).getIntent();
				Window newWindow = manager.startActivity(stack.peek(), lastIntent);
				setContentView(newWindow.getDecorView());
			}
		}
	}
}