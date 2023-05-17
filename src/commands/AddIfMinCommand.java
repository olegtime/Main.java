package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import handlers.InputHandler;

/**
 * Команда добавления элемента в коллекцию при условии, что тот явлется минимальным
 */
public class AddIfMinCommand extends Command{
    public AddIfMinCommand (CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        boolean[] usedId = getCollectionHandler().getUsedId();
        if (!usedId[1]){
            getCollectionHandler().occupyId(1);
            getCollectionHandler().addToCollection(InputHandler.getWorker(1));
            System.out.println("The worker has been added.");
            getCollectionHandler().sort();
        }
        else {
            System.out.println("The smallest possible element is already in the collection.");
        }
    }
}
