package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {

    @JsonProperty("type")
    private String type;

    @JsonProperty("addr")
    private int address;

    @JsonProperty("installed")
    private boolean installed;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lost")
    private boolean lost;

    public String getType() {
        return type;
    }

    public int getAddress() {
        return address;
    }

    public boolean getInstalled() {
        return installed;
    }

    public String getName() {
        return name;
    }

    public boolean getLost() {
        return lost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "type='" + type + '\'' +
                ", address=" + address +
                ", installed=" + installed +
                ", name='" + name + '\'' +
                ", lost=" + lost +
                '}';
    }
}
