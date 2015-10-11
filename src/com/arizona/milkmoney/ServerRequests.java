package com.arizona.milkmoney;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ServerRequests {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://192.168.112.170:8080/MilkMoney/";

    public ServerRequests(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(User user,String req,
                                          GetUserCallback userCallBack) {
        progressDialog.show();
        new StoreUserDataAsyncTask(user, req,userCallBack).execute();
    }

    public void fetchUserDataAsyncTask(User user, GetUserCallback userCallBack) {
        progressDialog.show();
        new fetchUserDataAsyncTask(user, userCallBack).execute();
    }

    /**
     * parameter sent to task upon execution progress published during
     * background computation result of the background computation
     */

    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void> {
        User user;
        GetUserCallback userCallBack;
        String req;

        public StoreUserDataAsyncTask(User user,String req, GetUserCallback userCallBack) {
            this.user = user;
            this.req=req;
            this.userCallBack = userCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<NameValuePair> dataToSend = new ArrayList<NameValuePair>();
          
         /*   HttpParams httpRequestParams = getHttpRequestParams();

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS
                    + "Login");

            try {
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);
            } catch (Exception e) {
                e.printStackTrace();
            }
*/
            

    		String result = "";
    		Map<String, String> paramsMap = new HashMap<String, String>();
    		paramsMap.put("regId", req);
    		paramsMap.put("fname", user.name);
    		paramsMap.put("username", user.username);
    		paramsMap.put("password", user.password);
    		paramsMap.put("lname", user.lname);
    		paramsMap.put("phone", user.phone);
    		paramsMap.put("email", user.email);
    		paramsMap.put("don", user.don);
    		paramsMap.put("vol", user.vol);
    		paramsMap.put("req", req+ "");

    		URL serverUrl = null;
    		try {
    			serverUrl = new URL(SERVER_ADDRESS+"Login");
    			Log.d("URL PROBLEM", serverUrl.toString());
    		} catch (MalformedURLException e) {
    		}

    		StringBuilder postBody = new StringBuilder();
    		Iterator<Entry<String, String>> iterator = paramsMap.entrySet()
    				.iterator();

    		while (iterator.hasNext()) {
    			Entry<String, String> param = iterator.next();
    			postBody.append(param.getKey()).append('=')
    					.append(param.getValue());
    			if (iterator.hasNext()) {
    				postBody.append('&');
    			}
    		}
    		String body = postBody.toString();
    		byte[] bytes = body.getBytes();
    		HttpURLConnection httpCon = null;
    		try {
    			httpCon = (HttpURLConnection) serverUrl.openConnection();
    			httpCon.setDoOutput(true);
    			httpCon.setUseCaches(false);
    			httpCon.setFixedLengthStreamingMode(bytes.length);
    			httpCon.setRequestMethod("POST");
    			httpCon.setRequestProperty("Content-Type",
    					"application/x-www-form-urlencoded;charset=UTF-8");
    			OutputStream out = httpCon.getOutputStream();
    			out.write(bytes);
    			out.close();

    			int status = httpCon.getResponseCode();
    			if (status == 200) {
    				result =  req;
    			} else {
    				result = "Post Failure." + " Status: " + status;
    			}
    		} 
    		catch (Exception e){
    			Log.d("SOME ERROR", e.toString());
    				httpCon.disconnect();
    			}
    		return null;

            
            //return null;
        }

        private HttpParams getHttpRequestParams() {
            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            return httpRequestParams;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            userCallBack.done(null);
        }

    }

    public class fetchUserDataAsyncTask extends AsyncTask<Void, Void, User> {
        User user;
        GetUserCallback userCallBack;

        public fetchUserDataAsyncTask(User user, GetUserCallback userCallBack) {
            this.user = user;
            this.userCallBack = userCallBack;
        }

        @Override
        protected User doInBackground(Void... params) {
            ArrayList<NameValuePair> dataToSend = new ArrayList<NameValuePair>();
           Map<String, String> paramsMap = new HashMap<String, String>();
    		paramsMap.put("username", user.username);
    		paramsMap.put("password", user.password);
    		
    		URL serverUrl = null;
    		try {
    			serverUrl = new URL(SERVER_ADDRESS+"Login");
    			Log.d("URL PROBLEM", serverUrl.toString());
    		} catch (MalformedURLException e) {
    		}

    		StringBuilder postBody = new StringBuilder();
    		Iterator<Entry<String, String>> iterator = paramsMap.entrySet()
    				.iterator();

    		while (iterator.hasNext()) {
    			Entry<String, String> param = iterator.next();
    			postBody.append(param.getKey()).append('=')
    					.append(param.getValue());
    			if (iterator.hasNext()) {
    				postBody.append('&');
    			}
    		}
    		String body = postBody.toString();
    		byte[] bytes = body.getBytes();
    		HttpURLConnection httpCon = null;
    		try {
    			httpCon = (HttpURLConnection) serverUrl.openConnection();
    			httpCon.setDoOutput(true);
    			httpCon.setUseCaches(false);
    			httpCon.setFixedLengthStreamingMode(bytes.length);
    			httpCon.setRequestMethod("POST");
    			httpCon.setRequestProperty("Content-Type",
    					"application/x-www-form-urlencoded;charset=UTF-8");
    			OutputStream out = httpCon.getOutputStream();
    			out.write(bytes);

    			int status = httpCon.getResponseCode();
    			Map<String,String>data =(Map<String,String>) httpCon.getContent();
    			out.close();

    			if(data !=null)
    			{
    				String data1 =data.get("username").toString();
    				User returnedUser = new User(data1,  "",data1, user.password, "", "", "", "");;
                return returnedUser;
    			}
  
    		} 
    		catch(Exception e)
    		{
    			
    		}
    		

           

            return new User("","","","","","","","");
        }

        @Override
        protected void onPostExecute(User returnedUser) {
            super.onPostExecute(returnedUser);
            progressDialog.dismiss();
            userCallBack.done(returnedUser);
        }
    }

    public void StoreEventDataAsyncTask(EventDetailPOJO er,User user,
            GetUserCallback userCallBack) {
progressDialog.show();
new StoreEventDataAsyncTask(er,user,userCallBack).execute();
}
    
    public class StoreEventDataAsyncTask extends AsyncTask<Void, Void, Void> {
        User user;
        GetUserCallback userCallBack;
        EventDetailPOJO event;

        public StoreEventDataAsyncTask(EventDetailPOJO event,User user, GetUserCallback userCallBack) {
            this.user = user;
            this.userCallBack = userCallBack;
            this.event = event;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<NameValuePair> dataToSend = new ArrayList<NameValuePair>();
            dataToSend.add(new BasicNameValuePair("eventId", event.eventId));
            dataToSend.add(new BasicNameValuePair("userName", user.username));

            HttpParams httpRequestParams = getHttpRequestParams();

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS
                    + "AddEvent.php");

            try {
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
        private HttpParams getHttpRequestParams() {
            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            return httpRequestParams;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            userCallBack.done(null);
        }

    }



    

}
