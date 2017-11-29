package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DevicesResponseTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testDeserializeOneDevice() throws Exception {
        DevicesResponse deviceResponse = MAPPER.readValue(fixture("fixtures/devices-respose/Devices-1.json"), DevicesResponse.class);
        assertNotNull(deviceResponse);
        assertEquals(1, deviceResponse.getDevices().size());
    }

    @Test
    public void testDeserializeTwoDevices() throws Exception {
        DevicesResponse deviceResponse = MAPPER.readValue(fixture("fixtures/devices-respose/Devices-2.json"), DevicesResponse.class);
        assertNotNull(deviceResponse);
        assertEquals(2, deviceResponse.getDevices().size());
    }

}