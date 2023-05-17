package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import worker.Status;
import worker.Worker;
import java.util.ArrayList;

/**
 * Программная команда, аналог команды RemoveAllByStatusCommand
 */
public class RemoveAllByStatusFromScriptCommand extends Command{
    public RemoveAllByStatusFromScriptCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException {
        ArrayList<Integer> idForDelete = new ArrayList<>();
        System.out.println(argument + "///");


        for (Worker w : getCollectionHandler().getCollection()){
            if (Status.valueOf(argument).equals(w.getStatus())){
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
