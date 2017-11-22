package fr.husta.test.jaxrs.support.exception.mapper;

import fr.husta.test.jaxrs.support.ExceptionMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class NotFoundExceptionMapper
        implements ExceptionMapper<NotFoundException>
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(NotFoundException exception)
    {
        MediaType responseAcceptableType = ExceptionMapperUtil.getResponseAcceptableType(headers);
        logger.debug("responseAcceptableType: {}", responseAcceptableType);

        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(new fr.husta.test.jaxrs.dto.Error(null, "NOT_FOUND", exception.getMessage()))
                .build();
    }

}
