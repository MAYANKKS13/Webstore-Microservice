package in.stackroute.exceptions;

public class ProductAlreadyExists extends RuntimeException{

    public ProductAlreadyExists(String message)
    {
        super(message);
    }

}