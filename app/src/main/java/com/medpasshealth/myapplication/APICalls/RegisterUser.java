package com.medpasshealth.myapplication.APICalls;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpService;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by awilliams13 on 2/23/2015.
 */
public class RegisterUser extends AsyncTask<Void, Void, JSONObject> {

    private static final String URL = "https://medpasswebapi.azurewebsites.net/MedPassUser";
    private JSONObject user;
    private JSONObject result = new JSONObject();

    private static final String TAG = "Register Post";

    public RegisterUser (JSONObject user)
    {
        this.user = user;
    }


    protected JSONObject doInBackground(Void... params){

        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPostRequest = new HttpPost(URL);

            StringEntity se;
            se = new StringEntity(user.toString());

            // Set HTTP parameters
            httpPostRequest.setEntity(se);
            httpPostRequest.setHeader("Accept", "application/json");
            httpPostRequest.setHeader("Content-type", "application/json");
            httpPostRequest.setHeader("MedPass-S","2a16a0395a96addd74513c685fd0cea94b28ef26");

            long t = System.currentTimeMillis();
            Log.d(TAG,"Executing Post Request" );
            HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);
            Log.d(TAG, "HTTPResponse received in [" + (System.currentTimeMillis() - t) + "ms]");

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                Log.d(TAG,"Return object not null" );
                // Read the content stream
                InputStream instream = entity.getContent();

                // convert content stream to a String
                String resultString;
                Log.d(TAG,"" );
                resultString = this.convertStreamToString(instream);
                instream.close();
                resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"

                try{
                    result.put("response",resultString);
                }catch (JSONException e) {
                    Log.d(TAG,"Converting response to JSON failed" );
                    e.printStackTrace();
                }

                // Raw DEBUG output of our received JSON object:
                Log.d(TAG,"<JSONObject>\n"+result.toString()+"\n</JSONObject>");


            }

        }
        catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG,"ERROR" );
        }
        return result;
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }



}