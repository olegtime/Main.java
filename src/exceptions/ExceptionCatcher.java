package exceptions;

import commands.Command;

import java.util.HashMap;

/**
 * Класс, обрабатывающий ряд исключений, касающихся ввода команды
 */
public class ExceptionCatcher {
    public static void isTheCommandCorrect(String[] command, HashMap<String, Command> commands) throws NoSuchCommandException, EmptyInputException{
        if (command[0].equals("")) throw new EmptyInputException("Input is empty.");
        if (command.length < 1 || command.length > 2) throw new NoSuchCommandException("Wrong entering of command.");
        if (command[0].trim().equalsIgnoreCase("execute_script") && command.length != 2) throw new NoSuchCommandException("Missing file name.");
        if (!command[0].trim().equalsIgnoreCase("execute_script") &&
                !commands.containsKey(command[0].trim().toLowerCase()))
            throw new NoSuchCommandException("No such command.");
    }

}
