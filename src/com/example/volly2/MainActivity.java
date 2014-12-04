package com.example.volly2;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
	
	TextView tv;
	   // Volley's request queue
    private RequestQueue requestQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView)findViewById(R.id.textView1);
		
		// Create the request queue
        requestQueue = Volley.newRequestQueue(this);


		String url = "http://site.bongobd.com/api/category.php?catID=1";
		//http://en.wikipedia.org/w/api.php?action=parse&page=Mango&format=json&prop=links
		//http://site.bongobd.com/api/category.php?catID=1
		//http://demo.mysamplecode.com/Servlets_JSP/CountryJSONData
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response) {
                    // response
                    Log.d("Response", response);
                  //  Toast.makeText(getBaseContext(), ""+response, Toast.LENGTH_LONG).show();
                    tv.setText("response:"+response);
                }
            },
            new Response.ErrorListener()
            {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     // error
                     Log.d("Error.Response", "sss");
               }
            }
        ) {    
            @Override
            protected Map<String, String> getParams()
            { 
                    Map<String, String>  params = new HashMap<String, String>(); 
                    params.put("name", "Alif"); 
                    params.put("domain", "http://itsalif.info");
                     
                    return params; 
            }
        };
        requestQueue.add(postRequest);
	}
	
}
