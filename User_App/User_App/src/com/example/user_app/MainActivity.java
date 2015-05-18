package com.example.user_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends ActionBarActivity {
	
	private static int REQUEST_CODE = 1;
	
	
    
    @Override
    protected void onCreate(Bundle bundle) {
    	
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        
        Button button1 = (Button) findViewById(R.id.button1);
        button1.getBackground().setAlpha(64);
    	button1.setOnClickListener(new OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			
    			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    			
    			if(intent.resolveActivity(getPackageManager())!=null)
    			{
    				startActivityForResult(intent,REQUEST_CODE);
    			}
    			  
    		}
    	});
    }
    
    public void onActivityResult(int requestcode,int resultcode,Intent data){
    	
    	if (requestcode == REQUEST_CODE ){
    		if(resultcode == RESULT_OK){
    			
    			Bundle bundle = new Bundle();
    			bundle = data.getExtras();
    			Bitmap BMP = (Bitmap)bundle.get("data");
    			
    			
    			Uri imageUri = data.getData();
    			
    			Intent i = new Intent(getBaseContext(),mainActivity2.class);
    			i.setData(imageUri);
    			startActivity(i);
    		}
    		
    }
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
