Barcodescanner PhoneGap native plugin for the Code Reader 8000 (CR8000) Scanner Android integration.
Native functions are available to listen / scan.

### Android

- The minimum supported API Level is 11. Make sure that `minSdkVersion` is larger or equal to 11 in `AndroidManifest.xml`.
- Only Android platform is supported for now, since this device is only integrated into Android specific devices
- Latest version on GitHub for easy integration (install & deploy)


### Methods

Invoke scanner to initialize.
When result is scanned, the successCallback is invoked.

scan: function (successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, "CR8000", "scan", []);
}

Invoke scanner to listen for results.
When result is scanned, the successCallback is invoked.
This method can be used when the device keyCode is pressed (function button).

listen: function (successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, "CR8000", "listen", []);
}

/* button bind event */
$scope.launchBarcodeScanner = function(){
	cr8000.scan(function(barcodeResult){
		$scope.addBarcode({value:barcodeResult});
	}, function(){});
};

/* listen for keyinput */
document.addEventListener('keydown', getInput, false);
$scope.$on("$destroy", function() { document.removeEventListener('keydown', getInput); });
function getInput(e){
	if(e.which == $rootScope.getPropertyByName('barcodeKeyInitialize')) {
		cr8000.listen(function(barcodeResult){
			$scope.addBarcode({value:barcodeResult});
		}, function(){});
	}
}

### Installation

Using the Cordova CLI make use of the known commands.

Adding the plugin:
cordova plugin add https://github.com/DaanDeSmedt/cordova-plugin-cr8000

Removing the plugin:
cordova remove com.sdp.plugins.bcr