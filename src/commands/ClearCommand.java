package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;

/**
 * Команда, очищающая коллекцию
 */

public class ClearCommand extends Command{
    public ClearCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        getCollectionHandler().clearCollection();
        System.out.println("The collection has been cleared.");
    }
}
