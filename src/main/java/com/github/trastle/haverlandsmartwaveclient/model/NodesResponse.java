package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NodesResponse {

    private List<Node> nodes;

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "NodesResponse{" +
                "nodes=" + nodes +
                '}';
    }
}
