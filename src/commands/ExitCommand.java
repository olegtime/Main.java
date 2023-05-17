package commands;

import handlers.CollectionHandler;

/**
 * Команда, завершающая работу программы
 */
public class ExitCommand extends Command{
    public ExitCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument){
        System.exit(0);
    }
}
