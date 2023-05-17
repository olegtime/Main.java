package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import worker.Worker;

/**
 * Команда, выводящая список элементов коллекции в их строковых представлениях
 */
public class ShowCommand extends Command{

    public ShowCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        if (getCollectionHandler().getCollection().size() == 0) {
            System.out.println("The collection is empty.");
        }
        for (Worker w : getCollectionHandler().getCollection()){
            System.out.println(w.toString());
        }
    }
}
