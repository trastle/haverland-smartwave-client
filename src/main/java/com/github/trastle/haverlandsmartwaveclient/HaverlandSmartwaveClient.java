package com.github.trastle.haverlandsmartwaveclient;

import com.github.trastle.haverlandsmartwaveclient.filters.AuthHeadersRequestFilter;
import com.github.trastle.haverlandsmartwaveclient.model.AuthResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

public class HaverlandSmartwaveClient {

    private static final String HAVERLAND_SMARTWAVE_API_HOST = "https://api-haverland.helki.com";

    // This is a constant used by the API. Not a secret. This is NOT a user authentication token.
    private static final String HANDSHAKE_AUTH_HEADER = "Basic NTU3OTM4OWJlMzc3ZWQyOTBiMGQ1NTNlOlVMREI2NjRz";
    private static final String HANDSHAKE_CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";

    private static final int MAX_CONNECTIONS = 20;
    private static final int MAX_CONNECTIONS_PER_ROUTE = 5;

    private final ResteasyWebTarget authTarget;

    public HaverlandSmartwaveClient() {
        ResteasyClient authClient = getThreadsafeResteasyClient(1, 1);
        authTarget = authClient.target(UriBuilder.fromPath(HAVERLAND_SMARTWAVE_API_HOST));
    }

    public synchronized AuthResponse authenticate(String username, String password) {
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
        formData.add("username", username);
        formData.add("password", password);
        formData.add("grant_type", "password");

        AuthResponse authResponse = authTarget.path("/client/token")
                .request()
                .header("content-type", HANDSHAKE_CONTENT_TYPE_HEADER)
                .header("authorization", HANDSHAKE_AUTH_HEADER)
                .post(Entity.form(formData), AuthResponse.class);

        return authResponse;
    }

    public HaverlandSmartwaveDeviceClient getServiceProxy(AuthResponse response) {
        ResteasyClient client = getThreadsafeResteasyClient(MAX_CONNECTIONS, MAX_CONNECTIONS_PER_ROUTE);
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(HAVERLAND_SMARTWAVE_API_HOST));
        target.register(new AuthHeadersRequestFilter(response));
        return target.proxy(HaverlandSmartwaveDeviceClient.class);
    }

    private ResteasyClient getThreadsafeResteasyClient(int maxConnections, int maxConnectionsPerRoute) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        cm.setMaxTotal(maxConnections);
        cm.setDefaultMaxPerRoute(maxConnectionsPerRoute);
        ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
        return new ResteasyClientBuilder().httpEngine(engine).build();
    }
}
