package commands;

import handlers.CollectionHandler;
import worker.*;

import java.time.ZonedDateTime;

/**
 * Программная команда, аналог UpdateCommand
 */

public class UpdateFromScriptCommand extends Command{
    public UpdateFromScriptCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws NullPointerException {
        String[] fields = argument.split(" ");
        if (fields.length != 9) throw new NullPointerException();

        int id = Integer.parseInt(fields[0].trim());
        boolean[] usedId = getCollectionHandler().getUsedId();
        if (!usedId[(int)(id)]) {
            System.out.println("There is no such worker.");
            return;
        }

        Worker worker = new Worker(id, fields[1],
                new Coordinates(Float.parseFloat(fields[2]), Float.parseFloat(fields[3])),
                ZonedDateTime.now(), Float.parseFloat(fields[4]),
                Position.valueOf(fields[5].trim().toUpperCase()),
                Status.valueOf(fields[6].trim().toUpperCase()),
                new Organization(Long.parseLong(fields[7].trim()), Long.parseLong(fields[8].trim()),
                        new Address(fields[9].trim())));

        System.out.println(getCollectionHandler().updateOfCollection(id, worker) ?
                "The worker has been updated." : "There is no such worker.");
        getCollectionHandler().sort();
    }
}
