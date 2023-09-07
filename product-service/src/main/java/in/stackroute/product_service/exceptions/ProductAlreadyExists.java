package in.stackroute.product_service.exceptions;

public class ProductAlreadyExists extends RuntimeException{

    public ProductAlreadyExists(String message)
    {
        super(message);
    }

}
