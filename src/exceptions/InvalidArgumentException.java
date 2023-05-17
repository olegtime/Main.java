package exceptions;

/**
 * Исключение, вызывающееся в случае ввода неверного аргумента команды
 */

public class InvalidArgumentException extends Exception{
    public InvalidArgumentException(String message){
        super(message);
    }
}
