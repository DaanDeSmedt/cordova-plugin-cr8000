module.exports = {
    scan: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CR8000", "scan", []);
    },
	listen: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CR8000", "listen", []);
    }
};