package exceptions;

/**
 * Исключение, вызывающееся в случае ввода неверной команды
 */

public class NoSuchCommandException extends Exception{
    public NoSuchCommandException(String message){
        super(message);
    }
}
