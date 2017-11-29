package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

public class HeaterStatusTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testDeserializeModeAuto() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Mode-Auto.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.Mode.AUTO, status.getMode());
    }

    @Test
    public void testDeserializeModeLearning() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Mode-Learning.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.Mode.SELF_LEARN, status.getMode());
    }

    @Test
    public void testDeserializeModePresence() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Mode-Presence.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.Mode.PRESENCE, status.getMode());
    }

    @Test
    public void testDeserializeModeManual() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Mode-Manual.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.Mode.MANUAL, status.getMode());
    }

    @Test
    public void testDeserializeTempAntiFreeze() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Temp-AntiFreeze.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.SelectedTemp.ICE, status.getSelectedTemp());
    }

    @Test
    public void testDeserializeTempComfort() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Temp-Comfort.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.SelectedTemp.COMFORT, status.getSelectedTemp());
    }

    @Test
    public void testDeserializeTempEco() throws Exception {
        HeaterStatus status = MAPPER.readValue(fixture("fixtures/status-response/Status-Temp-Eco.json"), HeaterStatus.class);
        assertEquals(HeaterStatus.SelectedTemp.ECO, status.getSelectedTemp());
    }

}