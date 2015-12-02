package com.sdp.plugins.bcr;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class CR8000 extends CordovaPlugin {
	
	// INTENTS
	public static final String ACTION_BCR_TRIGGER = "oem.android.bcr.ACTION_BCR_TRIGGER";
	public static final String ACTION_BCR_TRIGGER_KEYCODE = "oem.android.bcr.ACTION_BCR_TRIGGER_KEYCODE";
	public static final String ACTION_FEEDBACK = "oem.android.bcr.ACTION_FEEDBACK";
	// PHONEGAP ACTIONS 
    private static final String actionStartScanning = "start";
	
	private CallbackContext scanningCallBackContext;
	
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("scan")) {
			// send native device intent to trigger scan start action
			Intent intent = new Intent(ACTION_BCR_TRIGGER);
			// intent.putExtra(ACTION_BCR_TRIGGER_KEYCODE, 118);
			this.cordova.getActivity().getApplicationContext().sendBroadcast(intent);
			// set callbackcontext
			scanningCallBackContext = callbackContext;
			// add intent filter for capturing result
			IntentFilter filter = new IntentFilter();  
			filter.addAction(ACTION_FEEDBACK); 
			this.cordova.getActivity().registerReceiver(mCodeScanReceiver, filter); 
			// return
            return true;
        } else if(action.equals("listen")) {
			// set callbackcontext
			scanningCallBackContext = callbackContext;
			// add intent filter for capturing result
			IntentFilter filter = new IntentFilter();  
			filter.addAction(ACTION_FEEDBACK); 
			this.cordova.getActivity().registerReceiver(mCodeScanReceiver, filter); 
			return true;
		} else {
            return false;
        }
    }
	
	public BroadcastReceiver mCodeScanReceiver = new BroadcastReceiver() {
    	
    	@Override
    	public void onReceive(Context context, Intent intent){
            if (intent.getAction().equals(ACTION_FEEDBACK))
            { 
				String szComData = intent.getStringExtra(Intent.EXTRA_TEXT);
				scanningCallBackContext.success(szComData);
            }
    	}
    };
    
    @Override
	public void onDestroy() 
	{
	    this.cordova.getActivity().unregisterReceiver(mCodeScanReceiver);
	    super.onDestroy();
	}
	
}