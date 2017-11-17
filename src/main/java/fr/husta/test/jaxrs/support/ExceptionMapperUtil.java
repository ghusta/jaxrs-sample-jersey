package fr.husta.test.jaxrs.support;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ExceptionMapperUtil
{

    private ExceptionMapperUtil() {
    }

    public static MediaType getResponseAcceptableType(final HttpHeaders headers) {
        List<MediaType> accepts = headers.getAcceptableMediaTypes();
        if (accepts != null && !accepts.isEmpty()) {
            // choose one
            return accepts.get(0);
        } else {
            // return a default one like Application/json
            return null;
        }
    }

}
