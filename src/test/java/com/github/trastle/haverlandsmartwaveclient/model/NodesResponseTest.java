package com.github.trastle.haverlandsmartwaveclient.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

public class NodesResponseTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testDeserializeOneNode() throws Exception {
        NodesResponse nodes = MAPPER.readValue(fixture("fixtures/nodes-response/Nodes-1.json"), NodesResponse.class);
        assertEquals(1, nodes.getNodes().size());
    }

    @Test
    public void testDeserializeThreeNodes() throws Exception {
        NodesResponse nodes = MAPPER.readValue(fixture("fixtures/nodes-response/Nodes-3.json"), NodesResponse.class);
        assertEquals(3, nodes.getNodes().size());
    }


}