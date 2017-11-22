package fr.husta.test.jaxrs.mediatype;

import org.glassfish.jersey.message.internal.AcceptableMediaType;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

public class MediaTypeComparatorTest
{

    @Test
    public void compareApplicationXmlWithApplicationJson() throws Exception
    {
        // which one wins ?
        MediaType mediaTypeAppXml = MediaType.APPLICATION_XML_TYPE;
        MediaType mediaTypeAppJson = MediaType.APPLICATION_JSON_TYPE;

        int testCompare = AcceptableMediaType.COMPARATOR.compare(AcceptableMediaType.valueOf(mediaTypeAppXml),
                AcceptableMediaType.valueOf(mediaTypeAppJson));
        System.out.println(testCompare);
    }

    @Test
    public void compareApplicationXmlWithApplicationJson_byQuality() throws Exception
    {
        // which one wins ?
        MediaType mediaTypeAppXml = MediaType.APPLICATION_XML_TYPE;
        MediaType mediaTypeAppJson = MediaType.APPLICATION_JSON_TYPE;

        int testCompare = AcceptableMediaType.COMPARATOR.compare(AcceptableMediaType.valueOf(mediaTypeAppXml),
                new AcceptableMediaType(mediaTypeAppJson.getType(), mediaTypeAppJson.getSubtype(), 1500,
                        null));
        System.out.println(testCompare);
    }

    @Test
    public void compareApplicationXmlWithWildcard() throws Exception
    {
        // which one wins ?
        MediaType mediaTypeAppXml = MediaType.APPLICATION_XML_TYPE;
        MediaType mediaTypeWildcard = MediaType.WILDCARD_TYPE;

        // le more specific wins
        int testCompare = AcceptableMediaType.COMPARATOR.compare(AcceptableMediaType.valueOf(mediaTypeAppXml),
                AcceptableMediaType.valueOf(mediaTypeWildcard));
        System.out.println(testCompare);
    }

    @Test
    public void compareMediaTypes_byQuality() throws Exception
    {
        // which one wins ?
        MediaType mediaTypeAppJson = MediaType.valueOf("application/json");
        MediaType mediaTypeAppCompany = MediaType.valueOf("application/vnd-mycompany-error");

        MediaType mediaTypeAppJsonQualityLower = MediaType.valueOf("application/json;q=0.9");
        MediaType mediaType1 = MediaType.APPLICATION_JSON_TYPE;
        MediaType mediaType2 = new AcceptableMediaType("application", "vnd-mycompany-error", 1100, null);

        int testCompare;

        System.out.println(mediaTypeAppJsonQualityLower);
        System.out.println(mediaType2);

        testCompare = AcceptableMediaType.COMPARATOR.compare(
                AcceptableMediaType.valueOf(mediaTypeAppJson),
                AcceptableMediaType.valueOf(mediaTypeAppCompany));
        System.out.println("comp = " + testCompare);

        testCompare = AcceptableMediaType.COMPARATOR.compare(
                AcceptableMediaType.valueOf(mediaTypeAppJsonQualityLower),
                AcceptableMediaType.valueOf(mediaType1));
        System.out.println("comp = " + testCompare);

    }

}
