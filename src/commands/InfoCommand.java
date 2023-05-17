package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import worker.Worker;
import java.util.LinkedList;

/**
 * Команда, выводящая общую информацию о коллекции
 */
public class InfoCommand extends Command{
    public InfoCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        LinkedList<Worker> collection = getCollectionHandler().getCollection();
        System.out.println("TYPE OF COLLECTION: " + collection.getClass().getSimpleName());
        System.out.println("TYPE OF COLLECTION'S ELEMENTS: Worker");
        System.out.println("COUNTS OF ELEMENTS: " + collection.size());
        System.out.println("INITIALISATION DATE: " + getCollectionHandler().getInitializationDate());
    }
}
