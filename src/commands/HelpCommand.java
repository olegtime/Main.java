package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Команда, выводящая список доступных команд
 */
public class HelpCommand extends Command{
    public HelpCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "/home/studs/s367561/jaba/lab5/src/files/help.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Something is wrong with the file or its location.");
        }
    }
}
