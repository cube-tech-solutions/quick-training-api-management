package com.training.api.management.simple;

import com.training.api.management.simple.client.BarApiClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class OutboundProxyResource {
    @Inject
    @RestClient
    BarApiClient barApiClient;

    @GET
    @Path("/external-info")
    public String callExternalApi() {
        return barApiClient.getWebsiteInfo();
    }

}
