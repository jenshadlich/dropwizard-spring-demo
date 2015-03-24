package de.jeha.demo.resources;

import com.codahale.metrics.annotation.Timed;
import de.jeha.demo.core.Hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/")
public class HelloWorldResource {

    private String message;
    private final AtomicInteger counter = new AtomicInteger();

    @GET
    @Path("/hello-world")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Object hello(@QueryParam(value = "name") String name) {
        return new Hello(counter.incrementAndGet(), name == null ? getMessage() : getMessage() + ", " + name);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}