package com.sdp.barcodescanner.cr8000;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class CR8000 extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("greet")) {
            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);
            return true;
        } else {
            return false;
        }
    }
}
