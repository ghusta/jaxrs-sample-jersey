package fr.husta.test.jaxrs.support.exception.mapper;

import fr.husta.test.jaxrs.support.ExceptionMapperUtil;
import fr.husta.test.jaxrs.support.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper
        implements ExceptionMapper<ValidationException>
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(ValidationException exception)
    {
        MediaType responseAcceptableType = ExceptionMapperUtil.getResponseAcceptableType(headers);
        logger.debug("responseAcceptableType: {}", responseAcceptableType);

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new fr.husta.test.jaxrs.dto.Error(null, "VALIDATION", "id < 1"))
                .build();
    }

}
