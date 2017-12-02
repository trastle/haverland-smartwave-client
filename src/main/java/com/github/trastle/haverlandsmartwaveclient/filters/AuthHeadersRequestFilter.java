package com.github.trastle.haverlandsmartwaveclient.filters;

import com.github.trastle.haverlandsmartwaveclient.model.AuthResponse;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

/**
 * Created by tastle on 01/12/2017.
 */
public class AuthHeadersRequestFilter implements ClientRequestFilter {

    private final String authToken;

    public AuthHeadersRequestFilter(AuthResponse authResponse) {
        authToken = authResponse.getAccessToken();
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("Authorization", "Bearer " + authToken);
    }
}