package Exceptions;

public class InvalidWinningStrategyNumber extends Exception{
    public InvalidWinningStrategyNumber(){
        super("Enter a valid strategy Number");
    }
}
