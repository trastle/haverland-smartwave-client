package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    @JsonProperty("dev_id")
    private String deviceId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("fw_version")
    private String firmwareVersion;

    @JsonProperty("serial_id")
    private String serialId;

    public String getDeviceId() {
        return deviceId;
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public String getSerialId() {
        return serialId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", name='" + name + '\'' +
                ", productId='" + productId + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                ", serialId='" + serialId + '\'' +
                '}';
    }
}
