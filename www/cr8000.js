module.exports = {
    scan: function (name, successCallback, errorCallback) {
		alert('scanning invoke action on cr8000.js');
		cordova.exec(successCallback, errorCallback, "cr8000", "greet", [name]);
		cordova.exec(successCallback, errorCallback, "CR8000", "greet", [name]);
    }
};
