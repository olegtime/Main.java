package commands;

import exceptions.InvalidArgumentException;
import exceptions.Validator;
import handlers.CollectionHandler;
import handlers.InputHandler;
import worker.*;
import java.time.ZonedDateTime;

/**
 * Пользовательская команда, заменяющая элемент коллекции по его ID на введенный
 */
public class UpdateCommand extends Command{
    public UpdateCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument == null){
            throw new InvalidArgumentException("This command must have an argument.");
        }
        if (!Validator.idIsValid(argument)){
            throw new InvalidArgumentException("Id is invalid.");
        }

        int id = Integer.parseInt(argument.trim());
        boolean[] usedId = getCollectionHandler().getUsedId();
        if (!usedId[(int)(id)]) {
            System.out.println("There is no such worker.");
            return;
        }

        Worker worker = new Worker(id, InputHandler.getName(),
                InputHandler.getCoordinates(), ZonedDateTime.now(), InputHandler.getSalary(), InputHandler.getPosition(),
                InputHandler.getStatus(), InputHandler.getOrganization());
        System.out.println(getCollectionHandler().updateOfCollection(id, worker) ?
                "The worker has been updated." : "There is no such worker.");
        getCollectionHandler().sort();
    }
}
