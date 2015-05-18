package com.example.user_app;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



@SuppressLint("NewApi") public class mainActivity2 extends ActionBarActivity{
		
	
    @Override
    protected void onCreate(Bundle bundle) {
    	
        super.onCreate(bundle);
        setContentView(R.layout.activity2_main);
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        Uri imageUri = getIntent().getData();
        imageView.setImageURI(imageUri);
    	
        
        
        Button button1 = (Button) findViewById(R.id.button1);
        InputStream iStream = null;
        Log.d("xyz","istream made");
		try {
			iStream = getContentResolver().openInputStream(imageUri);
					Log.d("xyz","contentresolved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Log.d("xyz","content not resolved");
			e.printStackTrace();
		}
		byte[] inputData = null;
		
        try {
			inputData = getBytes(iStream);
			Log.d("xyz","get bytes called");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("xyz","get bytes not called");
		}
        final byte[] imgData = inputData;
        Log.d("xyz",inputData.toString());
    	
		button1.setOnClickListener(new OnClickListener() {

    		@Override
    		public void onClick(View v) {
    			
    			EditText textView = (EditText) findViewById(R.id.editText1);
    	    	String data = textView.getText().toString();
    	    	GPSTracker gps;
        		double lat = 0;
                double lng=0;
                gps = new GPSTracker(mainActivity2.this);
                Log.d("xyz","gps object made");
                // check if GPS enabled    
                if(gps.canGetLocation()){
                	Log.d("xyz","gps can get location");
                    lat = gps.getLatitude();
                    lng = gps.getLongitude(); 
                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + lat + "\nLong: " + lng, Toast.LENGTH_LONG).show();   
                    
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                	Log.d("xyz","gps cant get location");
                    gps.showSettingsAlert();
                }
                
    	    		Log.d("Post Activity",data);
    	    		
    	    	postData(lat,lng,imgData,data);
    		    Intent intent = new Intent(v.getContext(),mainActivity3.class);
                startActivity(intent);  
    		}
    	});
    }
    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
          byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
      }
    public void postData(final double lat,final double lng,final byte[] img,final String description) {
    	// Create a new HttpClient and Post Header
    	class ss extends AsyncTask<Void, Void, Void>
    	{

    	int responseCode;
    	@Override
    	protected Void doInBackground(Void... params) 
    	{
    		
    		// Create a new HttpClient and Post Header
    		HttpClient httpclient = new DefaultHttpClient();
    		HttpPost httppost = new HttpPost("http://192.168.43.54:8080/rirct/test");
    		Log.d("xyz","post object made");
    		//HttpGet httpget = new HttpGet("http://restapi-packagekit.rhcloud.com/api/packages");
    		try 
    		{
    			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
            	Log.d("Check 1","namesend");
            	nameValuePairs.add(new BasicNameValuePair("photo", Base64.encodeToString(img,Base64.DEFAULT)));
            	nameValuePairs.add(new BasicNameValuePair("latitude", Double.toString(lat)));
            	nameValuePairs.add(new BasicNameValuePair("longitude", Double.toString(lng)));
            	nameValuePairs.add(new BasicNameValuePair("description", description));
            	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    			// Execute HTTP Post Request.
    			Log.d("xyz","finallyyy about to execute post");
    			Log.d("xyz",img.toString());
    			Log.d("xyz",Double.toString(lat));
    			Log.d("xyz",Double.toString(lng));
    			Log.d("xyz",description);
    			HttpResponse response = httpclient.execute(httppost);
    			Log.d("xyz","response received");
    			//responseCode = response.getStatusLine().getStatusCode();
    			InputStream content= response.getEntity().getContent();
    			Log.d("xyz",content.toString());
    		} 
    		catch (ClientProtocolException e) 
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
    		catch (IOException e) 
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
    		return null;
    	}

    	@Override
    	protected void onPostExecute(Void result) 
    	{
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);
    		Log.d("check4","yayeeeeee");        
    	}
    }

    ss obj=new ss();
    obj.execute(null,null,null);
    }
    }
    
  
