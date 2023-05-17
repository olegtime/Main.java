package handlers;

import java.util.HashMap;
import java.util.LinkedList;
import commands.*;

/**
 * Класс, управялющий командами
 */
public class CommandHandler {
    private CollectionHandler collectionHandler = new CollectionHandler();
    private final HashMap<String, Command> commands = new HashMap<>();
    private LinkedList<String> usedScripts = new LinkedList<>();
    private Command helpCommand = new HelpCommand(collectionHandler);
    private  Command infoCommand = new InfoCommand(collectionHandler);
    private Command addCommand = new AddCommand(collectionHandler);
    private Command addFromScriptCommand = new AddFromScriptCommand(collectionHandler);
    private Command removeByIdCommand = new RemoveByIdCommand(collectionHandler);
    private Command updateCommand = new UpdateCommand(collectionHandler);
    private Command updateFromScriptCommand = new UpdateFromScriptCommand(collectionHandler);
    private Command saveCommand = new SaveCommand(collectionHandler);
    private Command clearCommand = new ClearCommand(collectionHandler);
    private Command showCommand = new ShowCommand(collectionHandler);
    private Command addIfMinCommand = new AddIfMinCommand(collectionHandler);
    private Command removeGreaterCommand = new RemoveGreaterCommand(collectionHandler);
    private Command removeAllByStatusCommand = new RemoveAllByStatusCommand(collectionHandler);
    private Command removeAllByStatusFromScriptCommand = new RemoveAllByStatusFromScriptCommand(collectionHandler);
    private Command historyCommand = new HistoryCommand(collectionHandler);
    private Command averageOfSalaryCommand = new AverageOfSalaryCommand(collectionHandler);
    private Command minByOrganization = new MinByOrganizationCommand(collectionHandler);
    private Command exitCommand = new ExitCommand(collectionHandler);

    /**
     * Метод, помещающий объекты команд в контейнер
     */
    public void putCommands(){
        commands.put("help", helpCommand);
        commands.put("info", infoCommand);
        commands.put("add", addCommand);
        commands.put("add_from_script", addFromScriptCommand);
        commands.put("remove_by_id", removeByIdCommand);
        commands.put("update", updateCommand);
        commands.put("update_from_script", updateFromScriptCommand);
        commands.put("save", saveCommand);
        commands.put("clear", clearCommand);
        commands.put("show", showCommand);
        commands.put("add_if_min", addIfMinCommand);
        commands.put("remove_greater", removeGreaterCommand);
        commands.put("remove_all_by_status", removeAllByStatusCommand);
        commands.put("remove_all_by_status_from_script", removeAllByStatusFromScriptCommand);
        commands.put("history", historyCommand);
        commands.put("average_of_salary", averageOfSalaryCommand);
        commands.put("min_by_organization", minByOrganization);
        commands.put("exit", exitCommand);
    }

    /**
     * Метод, возвращающий контейнер команд.
     * @return контейнер команд.
     */

    public HashMap<String, Command> getCommands(){
        return commands;
    }

    /**
     * Метод, возвращающий объект класса, управляющего коллекцией.
     * @return объект класса, управляющего коллекцией.
     */

    public CollectionHandler getCollectionHandler() {
        return collectionHandler;
    }

    /**
     * Метод, возвращающий массив с занятыми и свободными ID
     * @return массив с занятыми и свободными ID
     */
    public LinkedList<String> getUsedScripts() {return usedScripts; }
}
