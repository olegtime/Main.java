package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import java.util.LinkedList;

/**
 * Команда, выводящаяя список последних 11 команд, вводимых пользователем
 */
public class HistoryCommand extends Command{
    public HistoryCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument != null){
            throw new InvalidArgumentException("This command has no argument.");
        }
        LinkedList<String> history = getCollectionHandler().getHistory();
        if (getCollectionHandler().getHistory().isEmpty()){
            System.out.println("History is empty.");
            return;
        }

        System.out.println("History of the last 11 commands:");
        for (String command : history){
            System.out.println(command);
        }

    }
}
