package services;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class InternetConnectionChecking extends Activity {
	public InternetConnectionChecking() {

		new Thread(new innerCheckingInternet()).start();
	}

	private boolean isInternetConnected() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;

		}
		return false;
	}

	private boolean isInternetAvailable() {
		try {
			InetAddress ipAddress = InetAddress
					.getByAddress("google.com", null);
			if (ipAddress.equals("")) {
				Log.d("SomeText", "AnotherText" );
				return false;
			} else {
				Log.d("SomeText", "AnotherText" );
				return true;

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;

		}
	}

	private class innerCheckingInternet implements Runnable {

		@Override
		public void run() {
			
			isInternetAvailable();
			isInternetConnected();

		}

	}

}
