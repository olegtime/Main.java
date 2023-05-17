package exceptions;

/**
 * Исключение, вызывающееся при пустом вводе в консоль или файл
 */

public class EmptyInputException extends Exception{
    public EmptyInputException(String message){
        super(message);
    }
}
