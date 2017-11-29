package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertNotNull;

public class AuthResponseTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testDeserialize() throws Exception {
        AuthResponse authResponse = MAPPER.readValue(fixture("fixtures/auth-response/Auth.json"), AuthResponse.class);
        assertNotNull(authResponse);
    }
}