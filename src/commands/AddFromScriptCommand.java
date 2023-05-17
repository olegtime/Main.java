package commands;

import handlers.CollectionHandler;
import worker.*;
import java.time.ZonedDateTime;

/**
 * Программная команда для добавления элемента в коллекцию
 */
public class AddFromScriptCommand extends Command{
    public AddFromScriptCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws NullPointerException {
        boolean[] usedId = getCollectionHandler().getUsedId();
        int id = 1;
        for (int i = 1; i < usedId.length; i++){
            if (!usedId[i]){
                id = i;
                getCollectionHandler().occupyId(id);
                break;
            }
        }
        String[] fields = argument.split(" ");
        if (fields.length != 9) throw new NullPointerException();

        Worker worker = new Worker(id, fields[0],
                new Coordinates(Float.parseFloat(fields[1]), Float.parseFloat(fields[2])),
                ZonedDateTime.now(), Float.parseFloat(fields[3]),
                Position.valueOf(fields[4].trim().toUpperCase()),
                Status.valueOf(fields[5].trim().toUpperCase()),
                new Organization(Long.parseLong(fields[6].trim()), Long.parseLong(fields[7].trim()),
                        new Address(fields[8].trim())));

        getCollectionHandler().getCollection().add(worker);
        System.out.println("The worker has been added.");
        getCollectionHandler().sort();
    }
}
