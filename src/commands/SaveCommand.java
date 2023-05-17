package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import handlers.FileHandler;

import java.io.IOException;

/**
 * Команда, сохраняющая коллекцию в файл
 */
public class SaveCommand extends Command{
    public SaveCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument == null){
            throw new InvalidArgumentException("This command must have an argument.");
        }
        try {
            FileHandler.writeToFile(getCollectionHandler(), argument);
            System.out.println("Collection has been saved.");
        }
        catch (IOException e){
            System.out.println("Something is wrong with the file or its location.");
            System.out.println("Еhe collection was not saved.");
        }
    }
}
