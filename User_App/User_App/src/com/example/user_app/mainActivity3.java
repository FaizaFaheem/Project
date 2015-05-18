package com.example.user_app;


import java.net.URI;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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



@SuppressLint("NewApi") public class mainActivity3 extends ActionBarActivity {
	
    
    @Override
    protected void onCreate(Bundle bundle) {
    	
        super.onCreate(bundle);
        setContentView(R.layout.activity3_main);
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
       
      
    }
    
    
}
