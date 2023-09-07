package in.stackroute.inventory_service.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message)
    {
        super(message);
    }


}
