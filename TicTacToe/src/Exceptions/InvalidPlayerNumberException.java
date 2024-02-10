package Exceptions;

public class InvalidPlayerNumberException extends Exception{
    public InvalidPlayerNumberException(){
        super("Invalid players are entered");
    }
}
