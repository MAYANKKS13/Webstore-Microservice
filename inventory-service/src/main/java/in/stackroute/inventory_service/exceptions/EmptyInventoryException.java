package in.stackroute.inventory_service.exceptions;

public class EmptyInventoryException extends RuntimeException{


    public EmptyInventoryException(String message)
    {
        super(message);
    }

}
