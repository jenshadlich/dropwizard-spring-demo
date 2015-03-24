package de.jeha.demo.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloWorldResource {

    private String message;

    @GET
    @Path("/hello-world")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Object hello(@QueryParam(value = "name") String name){
        return name == null ? getMessage() : getMessage() + ", " + name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}