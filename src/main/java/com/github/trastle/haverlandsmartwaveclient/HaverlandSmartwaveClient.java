package com.github.trastle.haverlandsmartwaveclient;

import com.github.trastle.haverlandsmartwaveclient.model.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class HaverlandSmartwaveClient {

    // This is a constant used by the API. Not a secret. This is NOT a user authentication token.
    private static final String HANDSHAKE_AUTH_HEADER = "Basic NTU3OTM4OWJlMzc3ZWQyOTBiMGQ1NTNlOlVMREI2NjRz";
    private static final String HANDSHAKE_CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    private static final String HAVERLAND_SMARTWAVE_API_HOST = "https://api-haverland.helki.com";

    private final String userName;
    private final String password;

    private AuthResponse authResponse;

    public HaverlandSmartwaveClient(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public AuthResponse authenticate() {

        Client client = ClientBuilder.newClient();

        MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
        formData.add("username", this.userName);
        formData.add("password", this.password);
        formData.add("grant_type", "password");

        AuthResponse response = client.target(HAVERLAND_SMARTWAVE_API_HOST + "/client/token")
                .request()
                .header("content-type", HANDSHAKE_CONTENT_TYPE_HEADER)
                .header("authorization", HANDSHAKE_AUTH_HEADER)
                .post(Entity.form(formData), AuthResponse.class);

        this.authResponse = response;
        return response;
    }

    public DevicesResponse getDevs() {

        Client client = ClientBuilder.newClient();
        DevicesResponse response = client.target(HAVERLAND_SMARTWAVE_API_HOST + "/api/v2/devs/")
                .request()
                .header("authorization", "Bearer " + this.authResponse.getAccessToken())
                .get(DevicesResponse.class);

        return response;
    }

    public NodesResponse getNodes(String deviceId) {

        Client client = ClientBuilder.newClient();
        NodesResponse response = client.target(HAVERLAND_SMARTWAVE_API_HOST + "/api/v2/devs/")
                .path(deviceId)
                .path("/mgr/nodes")
                .request()
                .header("authorization", "Bearer " + this.authResponse.getAccessToken())
                .get(NodesResponse.class);

        return response;
    }

    public HeaterStatus getHeaterStatus(String deviceId, int address) {

        Client client = ClientBuilder.newClient();
        HeaterStatus response = client.target(HAVERLAND_SMARTWAVE_API_HOST + "/api/v2/devs/")
                .path(deviceId)
                .path("/htr/")
                .path("" + address)
                .path("/status")
                .request()
                .header("authorization", "Bearer " + this.authResponse.getAccessToken())
                .get(HeaterStatus.class);

        return response;
    }

}
