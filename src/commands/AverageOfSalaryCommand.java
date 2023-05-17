package commands;

import exceptions.InvalidArgumentException;
import handlers.CollectionHandler;
import worker.Worker;

/**
 * Команда, выводящая среднюю зарпалату среди элементов коллекции
 */
public class AverageOfSalaryCommand extends Command{
    public AverageOfSalaryCommand(CollectionHandler collectionHandler){
        super(collectionHandler);
    }

    @Override
    public void execute(String argument) throws InvalidArgumentException{
        if (argument != null){
            throw new InvalidArgumentException("This command must have an argument.");
        }

        double sum = 0;
        for (Worker w : getCollectionHandler().getCollection()){
            sum += w.getSalary();
        }
        System.out.println("The average salary among workers is: ");
        System.out.printf("%f7", sum / getCollectionHandler().getCollection().size());
        System.out.println("");
    }
}
