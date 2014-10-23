package com.optipos.terminal;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SOAPRequest extends Activity {

	private final String URL = "http://www.mobilesuite365.net/app2/getdata.asmx?op=VerifyRep";
	private final String METHOD_NAME = "GetCustomers";
	private final String NAMES_SPACE = "http://mobilesuite365.com/";
	// private final String TAG = "OptiposAndroidTAG";
	private static String soapRequestShowCustomers = "";
	private static final String SOAP_ACTION = "http://mobilesuite365.com/GetCustomers";
	// private static final String ENVELOPE =
	// "http://www.w3.org/2001/XMLSchema-instance";
	private String customerNumber = "8BEBFB9F-D9C9-4880-9225-AB50976F2975";
	// private int shopID = 1;
	Button soapRequestButtonGetCustomers;

	// EditText soapRequestEditTextShowCustomers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.soap_request);
		soapRequestButtonGetCustomers = (Button) findViewById(R.id.soapRequestButtonGetCustomers);
		// soapRequestEditTextShowCustomers =
		// (EditText)findViewById(R.id.soapRequestEditText);
		soapRequestButtonGetCustomers.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AsyncCallGetCustomers asyncCallGetCustomers = new AsyncCallGetCustomers();
				asyncCallGetCustomers.execute();

			}

		});
	}

	private class AsyncCallGetCustomers extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			try {
				getCustomers();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
 			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			// soapRequestEditTextShowCustomers.setText(soapRequestShowCustomers);
		}
	}

	private void getCustomers() throws IOException, XmlPullParserException {
		
		SoapObject request = new SoapObject(NAMES_SPACE, METHOD_NAME);
		request.addProperty("LicenseId", customerNumber);
		request.addProperty("OutletId","" );
		request.addProperty("Search","" );
		request.addProperty("LastUpdated","" );
		request.addProperty("Auth","" );

		// PropertyInfo customersInfo = new PropertyInfo();
		// customersInfo.setName("Customers");
		// customersInfo.setType(String.class);
		// request.addProperty(customersInfo);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		
		envelope.setOutputSoapObject(request);
		envelope.dotNet = false;
		
		HttpTransportSE androidHTTPTransport = new HttpTransportSE(URL);
		envelope.encodingStyle ="text";
		androidHTTPTransport.call(SOAP_ACTION, envelope);

		SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
		soapRequestShowCustomers = response.toString();

	}
}
