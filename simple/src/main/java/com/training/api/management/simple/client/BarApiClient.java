package com.training.api.management.simple.client;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/public/website")
@RegisterRestClient(configKey = "bar-api")
@Produces(MediaType.APPLICATION_JSON)
public interface BarApiClient {
    @GET
    @Path("/info-website")
    String getWebsiteInfo();
}
