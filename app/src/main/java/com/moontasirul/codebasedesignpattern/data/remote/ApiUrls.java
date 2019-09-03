package com.moontasirul.codebasedesignpattern.data.remote;

public interface ApiUrls {

    /**
     * Base Url
     */
    String BASE_API_URL = "https://api.vlocusbd.com/0000/";

    /**
     * Login API URL
     */
    String LOGIN_API_URL = "api/customer/login";


    /**
     * Registration API URL
     */
    String REGISTRATION_API_URL = "api/customer/registration";


    /**
     * Customer logout API URL
     */
    String CUSTOMER_LOGOUT_API_URL = "api/customer/logout";


    /**
     * get device list
     */
    String GET_DEVICE_LIST = "api/device/deviceList";

    /**
     * invoke add device api
     */
    String ADD_DEVICE_API = "api/device/add";


    /**
     * invoke edit device api
     */
    String EDIT_DEVICE_API = "api/device/edit";


    /**
     * INVOKE add switches
     */
    String ADD_SWITCH_IN_DEVICE_API = "api/device/switch/add";

    /**
     * invoke change password
     */
    String CHANGE_PASSWORD_API = "api/customer/changePassword";


    /**
     * INVOKE REGISTRATION API
     */
    String REGISTRATION_API = "api/registration/EU";

    /**
     * INVOKE REGISTRATION API
     */
    String LOGIN_API = "api/login/EU";


    String OTP_API = "api/otp/EU";

}
