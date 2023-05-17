package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import handlers.InputHandler;
import worker.Worker;
import java.util.ArrayList;

/**
 * Команда, удаляющая все элементы коллекции, превышающие заданный
 */
public class RemoveGreaterCommand extends Command{
    public RemoveGreaterCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        int id = InputHandler.getId();
        ArrayList<Integer> indexForDelete = new ArrayList<>();

        for (Worker w : getCollectionHandler().getCollection()){
            if (id < w.getId()){
                indexForDelete.add(getCollectionHandler().getCollection().indexOf(w));
                getCollectionHandler().releaseId(w.getId());
            }
        }

        for (Integer index : indexForDelete){
            getCollectionHandler().removeFromCollection(index);
        }
        System.out.println(indexForDelete.size() + " workers has been deleted.");
    }
}
