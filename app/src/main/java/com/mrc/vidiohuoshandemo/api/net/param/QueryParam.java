package com.mrc.vidiohuoshandemo.api.net.param;

/**
 *
 */

public class QueryParam {

    public String live_sdk_version;
    public String device_type;
    public String device_brand;

    public QueryParam() {
        this.device_brand = "samsung";
        this.device_type = "GT-P5210";
        this.live_sdk_version = "273";
    }
}
