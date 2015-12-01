package com.example.plugin;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Hello extends CordovaPlugin {
	
	// INTENTS
	public static final String ACTION_BCR_TRIGGER = "oem.android.bcr.ACTION_BCR_TRIGGER";
    public static final String ACTION_BCR_TRIGGER_KEYCODE = "oem.android.bcr.ACTION_BCR_TRIGGER_KEYCODE";
	// PHONEGAP ACTIONS 
    private static final String actionStartScanning = "start";

	
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("scan")) {
			
			Intent intent = new Intent(ACTION_BCR_TRIGGER);
			intent.putExtra(ACTION_BCR_TRIGGER_KEYCODE, 118);
			this.cordova.getActivity().getApplicationContext().sendBroadcast(intent);
			
            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
