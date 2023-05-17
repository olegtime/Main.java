package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;

/**
 * Абстрактный класс, родитель всех команд
 */
public abstract class Command {
    private CollectionHandler collectionHandler;
    public Command(CollectionHandler collectionHandler){
        this.collectionHandler = collectionHandler;
    }

    /**
     * Метод, возвращающий объект класса, управляющего коллекцией.
     * @return объект класса, управляющего коллекцией.
     */

    public CollectionHandler getCollectionHandler() {
        return collectionHandler;
    }

    /**
     * Метод, реализующий команду
     * @param argument
     */
    public abstract void execute(String argument) throws InvalidArgumentException;
}
