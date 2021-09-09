Barcodescanner PhoneGap native plugin for the Code Reader™ 8000 Scan Engine (CR8000), native android 2D/3D barcode scanner.
https://codecorp.com/products/code-reader-8000


Interface methods for listening / scanning barcodes through the native component.

### Android

- The minimum supported API Level is 11. Make sure that `minSdkVersion` is larger or equal to 11 in `AndroidManifest.xml`.
- Only Android platform is supported for now, since this device is only integrated into Android specific devices
- Latest version on GitHub for easy integration (install & deploy)


### Native interface methods

Invoking the scanner to initialize the scan action.
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


### AngularJS interface methods (demo)

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


### Phonegap include

Using the Cordova CLI and direct Git.

Adding the plugin:
		```cordova plugin add https://github.com/DaanDeSmedt/cordova-plugin-cr8000```

Removing the plugin:
		```cordova remove com.sdp.plugins.bcr```
