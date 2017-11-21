package fr.husta.test.jaxrs.text;

import fr.husta.test.jaxrs.dto.Error;
import fr.husta.test.jaxrs.support.ExceptionMapperUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource
{

    @Context
    private HttpHeaders headers;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt()
    {
        return "Got it!";
    }

    @GET
    @Path("error-test")
    public Response testError()
    {
        // no entity / no response body
        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }

    @GET
    @Path("error-test-xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response testErrorXmlType()
    {
        // no entity / no response body
        MediaType responseAcceptableType = ExceptionMapperUtil.getResponseAcceptableType(headers);
        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(responseAcceptableType)
                .build();
    }

    @GET
    @Path("error-test-xml-body")
    @Produces(MediaType.APPLICATION_XML)
    public Response testErrorXmlWithBody()
    {
        MediaType responseAcceptableType = ExceptionMapperUtil.getResponseAcceptableType(headers);
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity( new Error("Erreur !") )
                // .type(responseAcceptableType)
                .type(MediaType.APPLICATION_XML)
                .build();
    }

}
