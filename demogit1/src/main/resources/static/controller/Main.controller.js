// Main.controller.js
sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "kavya/util/service",
    "sap/ui/model/json/JSONModel",
    "sap/m/MessageBox"
], function (Controller, service, JSONModel, MessageBox) {
    "use strict";

    return Controller.extend("kavya.controller.Main", {

        onInit: function () {

            var oModel = new JSONModel({
                postPayload: {
                    companyName: "",
                    firstName: "",
                    lastName: "",
                    webSite: "",
                    email: "",
                    status: "",
                    gstNo: ""
                },
                vendor: []
            });

            this.getView().setModel(oModel);
            this.onLoadData();
        },

		onSave: function () {

		    var that = this;
		    var oModel = this.getView().getModel();
		    var payload = oModel.getProperty("/postPayload");

		    console.log("POST Payload:", payload);

		    service.callService("/vendor", "POST", payload)
		        .then(function (data) {

		            console.log("POST Success:", data);
		            sap.m.MessageBox.success("Saved");

		            that.onLoadData();
		        })
		        .catch(function (err) {

		            console.log("POST Error:", err);
		            sap.m.MessageBox.error("Save Failed");
		        });
		},

		onLoadData: function () {

		    var that = this;

		    service.callService("/vendor", "GET")
		        .then(function (data) {

		            console.log("GET Response:", data);

		            var aData = data._embedded ? data._embedded.vendor : data;

		            console.log("Table Data:", aData);

		            that.getView().getModel().setProperty("/vendor", aData);
		        })
				.catch(function (err) {
				                    console.log("GET Error:", err);
				                    MessageBox.error("Load Failed");
				                });
		}

    });
});