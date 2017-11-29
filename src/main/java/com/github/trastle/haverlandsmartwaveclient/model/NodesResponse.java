package com.github.trastle.haverlandsmartwaveclient.model;

import java.util.List;

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
