package com.github.trastle.haverlandsmartwaveclient;

import com.github.trastle.haverlandsmartwaveclient.model.DevicesResponse;
import com.github.trastle.haverlandsmartwaveclient.model.HeaterStatus;
import com.github.trastle.haverlandsmartwaveclient.model.NodesResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface HaverlandSmartwaveDeviceClient {

    @GET
    @Path("/api/v2/devs/")
    @Produces({ MediaType.APPLICATION_JSON})

    DevicesResponse getDevices();

    @GET
    @Path("/api/v2/devs/{deviceId}/mgr/nodes")
    @Produces({ MediaType.APPLICATION_JSON})
    NodesResponse getNodes(@PathParam("deviceId") String deviceId);

    @GET
    @Path("/api/v2/devs/{deviceId}/htr/{address}/status")
    @Produces({ MediaType.APPLICATION_JSON})
    HeaterStatus getHeaterStatus(@PathParam("deviceId") String deviceId, @PathParam("address") long address);
}