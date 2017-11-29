package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DevicesResponse {

    @JsonProperty("devs")
    private List<Device> devices;

    public List<Device> getDevices() {
        return devices;
    }

    @Override
    public String toString() {
        return "DevicesResponse{" +
                "devices=" + devices +
                '}';
    }
}
