package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import handlers.InputHandler;
import worker.Status;
import worker.Worker;
import java.util.ArrayList;

/**
 * Пользовательская команда, удаляющая все элементы коллекции, значения поля статуса у которых равно заданному
 */

public class RemoveAllByStatusCommand extends Command{
    public RemoveAllByStatusCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument != null){
            throw new InvalidArgumentException("This command must have an argument.");
        }

        Status status = InputHandler.getStatus();
        ArrayList<Integer> idForDelete = new ArrayList<>();

        for (Worker w : getCollectionHandler().getCollection()){
            if (status.equals(w.getStatus())){
                idForDelete.add(w.getId());
                getCollectionHandler().releaseId(w.getId());
            }
        }

        for (Integer id : idForDelete){
            getCollectionHandler().removeFromCollection(id);
        }
        System.out.println(idForDelete.size() + " workers has been deleted.");
    }
}
