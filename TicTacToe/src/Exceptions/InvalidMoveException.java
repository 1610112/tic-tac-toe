package Exceptions;

public class InvalidMoveException extends Exception{
    public InvalidMoveException(){
        super("Entered a wrong move");
    }
}
