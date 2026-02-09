package com.training.api.management.simple;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Path("/hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @POST
    @Path("/bytes")
    public Map<String, Object> calculateBytes(Map<String, String> body) {

        String messaggio = body.get("messaggio");

        if (messaggio == null) {
            throw new BadRequestException("Parametro 'messaggio' mancante");
        }

        int bytes = messaggio.getBytes(StandardCharsets.UTF_8).length;

        return Map.of(
                "messaggio", messaggio,
                "bytes", bytes
        );
    }

}
