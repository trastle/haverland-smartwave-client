package com.github.trastle.haverlandsmartwaveclient;

import com.github.trastle.haverlandsmartwaveclient.model.AuthResponse;
import com.github.trastle.haverlandsmartwaveclient.model.DevicesResponse;
import com.github.trastle.haverlandsmartwaveclient.model.HeaterStatus;
import com.github.trastle.haverlandsmartwaveclient.model.NodesResponse;

public class HaverlandSmartwaveClientExample {

    public static void main(String[] args) {

        HaverlandSmartwaveClient client = new HaverlandSmartwaveClient();
        AuthResponse auth = client.authenticate("user@email.com", "password");

        HaverlandSmartwaveDeviceClient deviceClient = client.getServiceProxy(auth);
        DevicesResponse devices = deviceClient.getDevices();
        System.out.println(devices);

        String deviceId = devices.getDevices().get(0).getDeviceId();
        NodesResponse nodes = deviceClient.getNodes(deviceId);
        System.out.println(nodes);

        int nodeAddress = nodes.getNodes().get(0).getAddress();
        HeaterStatus status = deviceClient.getHeaterStatus(deviceId, nodeAddress);
        System.out.println(status);
    }
}