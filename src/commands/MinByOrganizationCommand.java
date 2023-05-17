package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import worker.Worker;
import java.util.LinkedList;

/**
 * Команда, выводящая элемент, минимальный по значению поля организации
 */
public class MinByOrganizationCommand extends Command{
    public MinByOrganizationCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        LinkedList<Worker> collection = getCollectionHandler().getCollection();
        if (collection.size() == 0){
            System.out.println("Collection is empty.");
            return;
        }
        Worker min = collection.get(0);
        for (Worker w : collection){
            if (min.getOrganization().compareTo(w.getOrganization()) > 0){
                min = w;
            }
        }

        System.out.println("The worker with a minimal organization is: ");
        System.out.println(min.toString());
    }
}
