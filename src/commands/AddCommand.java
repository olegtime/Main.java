package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import handlers.InputHandler;

/**
 * Пользовательская команда добавления элемента в коллекцию
 */

public class AddCommand extends Command{
    public AddCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        boolean[] usedId = getCollectionHandler().getUsedId();
        int id = 1;
        for (int i = 1; i < usedId.length; i++){
            if (!usedId[i]){
                id = i;
                getCollectionHandler().occupyId(id);
                break;
            }
        }
        getCollectionHandler().addToCollection(InputHandler.getWorker(id));
        System.out.println("The worker has been added.");
        getCollectionHandler().sort();
    }
}
