sap.ui.define([
    "sap/ui/thirdparty/jquery"
], function (jQuery) {
    "use strict";

    return {

        callService: function (sUrl, sMethod, oPayload) {

            return new Promise(function (resolve, reject) {

                jQuery.ajax(sUrl,{
                    type: sMethod,
                    contentType: "application/json",
                    data: sMethod === "GET" ? null : JSON.stringify(oPayload),

                    success: function (data) {
                        resolve(data);
                    },

                    error: function (err) {
                        reject(err);
                    }
                });

            });

        }

    };

});