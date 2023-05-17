package commands;

import exceptions.InvalidArgumentException;
import exceptions.Validator;
import handlers.CollectionHandler;

/**
 * Команда, удаляющая элемент из коллекции по его ID
 */
public class RemoveByIdCommand extends Command{

    public RemoveByIdCommand(CollectionHandler collectionHandler){
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
        System.out.println(getCollectionHandler().removeFromCollection(Integer.parseInt(argument.trim())) ?
                "The worker has been removed." : "There is no such worker.");
        getCollectionHandler().releaseId(Long.parseLong(argument.trim()));
    }
}
