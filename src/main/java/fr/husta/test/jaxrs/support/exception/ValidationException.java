package fr.husta.test.jaxrs.support.exception;

public class ValidationException
        extends RuntimeException
{

    public ValidationException()
    {
    }

    public ValidationException(String message)
    {
        super(message);
    }

}
