package fr.husta.test.jaxrs.json;

import fr.husta.test.jaxrs.dto.Message;
import fr.husta.test.jaxrs.support.exception.ValidationException;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("test-json")
public class TestJsonResource
{

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public Response getMessage(@PathParam("id") int id)
    {
        if (id >= 1 && id <= 10)
        {
            Message message = new Message();
            message.setId(id);
            message.setContent("Hello");

            return Response.ok().entity(message).build();
        }
        if (id < 1)
        {
            // error -> 400
            throw new ValidationException("id < 1");
        }
        else
        {
            // error -> 404
            throw new NotFoundException("id not in [1..10]");
        }
    }

}
