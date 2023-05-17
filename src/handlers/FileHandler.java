package handlers;

import exceptions.*;
import worker.*;
import java.io.*;
import java.time.ZonedDateTime;

/**
 * Класс, реализующий работу с файлами
 */

public class FileHandler {
    /**
     * Метод, реализующий чтение из файла
     * @param collectionHandler класс, управляющий коллекцией
     * @param fileName имя файла, в который сохраняется коллекция
     */
    public static void readFromFile(CollectionHandler collectionHandler, String fileName) {
        System.out.println("The loading of elements from the file has started.");

        try (BufferedReader reader = new BufferedReader(new FileReader(
                        "/home/studs/s367561/jaba/lab5/build/" + fileName + ".csv"))) {
            int count = 1;
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(count + ": ");

                String[] fields = line.split(",");
                if (fields.length != 11){
                    System.out.println("Wrong number of arguments.");
                    continue;
                }
                String id = fields[0].substring(1, fields[0].length() - 1);
                String name = fields[1].substring(1, fields[1].length() - 1);
                String x = fields[2].substring(1, fields[2].length() - 1);
                String y = fields[3].substring(1, fields[3].length() - 1);
                String date = fields[4].substring(1, fields[4].length() - 1);
                String salary = fields[5].substring(1, fields[5].length() - 1);
                String position = fields[6].substring(1, fields[6].length() - 1);
                String status = fields[7].substring(1, fields[7].length() - 1);
                String annualTurnover = fields[8].substring(1, fields[8].length() - 1);
                String employeesCount = fields[9].substring(1, fields[9].length() - 1);
                String address = fields[10].substring(1, fields[10].length() - 1);

                if (!Validator.idIsValid(id) ||
                        !Validator.nameIsValid(name) ||
                        !Validator.xIsValid(x) ||
                        !Validator.yIsValid(y) ||
                        !Validator.dateIsValid(date) ||
                        !Validator.salaryIsValid(salary) ||
                        !Validator.positionIsValid(position) ||
                        !Validator.statusIsValid(status) ||
                        !Validator.annualTurnoverIsValid(annualTurnover) ||
                        !Validator.employeesCountIsValid(employeesCount) ||
                        !Validator.postalAddressIsValid(address)
                ){
                    continue;
                }

                Worker worker = new Worker(Integer.parseInt(id), name,
                        new Coordinates(Float.parseFloat(x), Double.parseDouble(y)),
                        ZonedDateTime.parse(date),
                        Float.parseFloat(salary), Position.valueOf(position.toUpperCase()),
                        Status.valueOf(status.toUpperCase()),
                        new Organization(Long.parseLong(annualTurnover), Long.parseLong(employeesCount),
                                new Address(address)));

                collectionHandler.getCollection().add(worker);
                collectionHandler.occupyId(Long.parseLong(id));
                count++;
                System.out.println("Completed.");
            }
        } catch (IOException e) {
            System.out.println("Something is wrong with the file or its location.");
            System.out.println("The collection was not loaded.");
            return;
        }

        System.out.println("The loading from \"" + fileName + "\" has completed.\n");
    }

    /**
     * Метод, реализующий запись в файл
     * @param collectionHandler класс, управляющий коллекцией
     * @param fileName имя файла, в который сохраняется коллекция
     */
    public static void writeToFile(CollectionHandler collectionHandler, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(
                "/home/studs/s367561/jaba/lab5/build/" + fileName + ".csv"));
        for (Worker w : collectionHandler.getCollection()) {
            String id = "\"" + w.getId() + "\"";
            String name = "\"" + w.getName() + "\"";
            String x = "\"" + w.getCoordinates().getX() + "\"";
            String y = "\"" + w.getCoordinates().getY() + "\"";
            String date = "\"" + w.getCreationDate() + "\"";
            String salary = "\"" + w.getSalary() + "\"";
            String position = "\"" + w.getPosition() + "\"";
            String status = "\"" + w.getStatus() + "\"";
            String annualTurnover = "\"" + w.getOrganization().getAnnualTurnover() + "\"";
            String employeesCount = "\"" + w.getOrganization().getEmployeesCount() + "\"";
            String address = "\"" + w.getOrganization().getPostalAddress() + "\"";

            writer.write(id + "," + name + "," + x + "," + y + "," +
                    date + "," + salary + "," + position + "," +
                    status + "," + annualTurnover + "," +
                    employeesCount + "," + address + ",\n");
        }
        writer.close();
    }

    /**
     * Метод, реализующий чтение из исполняющего файла
     * @param commandHandler класс, управляющий командами
     * @param executeName имя исполняемого файла
     * @param fileName имя файла, в который сохраняется коллекция
     */
    public static void readTheScript(CommandHandler commandHandler, String executeName, String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(
                "/home/studs/s367561/jaba/lab5/build/" + executeName));
            commandHandler.getUsedScripts().add(executeName.trim().toLowerCase());
            String line;
            String [] command;
            while ((line = reader.readLine()) != null) {
                command = line.trim().split(" ");
                try {
                    ExceptionCatcher.isTheCommandCorrect(command, commandHandler.getCommands());
                    System.out.println(command[0].trim().toLowerCase() + ":");
                    if (command[0].trim().equalsIgnoreCase("add")) {
                        String fields = "";
                        try {
                            line = reader.readLine().trim();
                            if (Validator.nameIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.xIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.yIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.salaryIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.positionIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.statusIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.annualTurnoverIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.employeesCountIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.postalAddressIsValid(line)) fields += line + " ";

                            commandHandler.getCommands().get("add_from_script").execute(fields);
                        }
                        catch (IOException | NullPointerException e){
                            System.out.println("Incorrect data was entered. The element has not been added.");
                        }
                    }
                    else if (command[0].trim().equalsIgnoreCase("update")) {
                        String fields = "";
                        try {
                            if (Validator.idIsValid(command[1])) fields += command[1] + " ";
                            line = reader.readLine().trim();
                            if (Validator.nameIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.xIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.yIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.salaryIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.positionIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.statusIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.employeesCountIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.employeesCountIsValid(line)) fields += line + " ";
                            line = reader.readLine().trim();
                            if (Validator.postalAddressIsValid(line)) fields += line + " ";

                            commandHandler.getCommands().get("update_from_script").execute(fields);
                        }
                        catch (IOException | NullPointerException e){
                            System.out.println("Incorrect data was entered. The element has not been updated.");
                        }
                    }
                    else if (command[0].trim().equalsIgnoreCase("remove_all_by_status")) {
                        String status = "";
                        try {
                            line = reader.readLine().trim();
                            if (Validator.statusIsValid(line)) status = line.toUpperCase();

                            commandHandler.getCommands().get("remove_all_by_status_from_script").execute(status);
                        }
                        catch (IOException | NullPointerException e){
                            System.out.println("Incorrect data was entered. The element has not been removed.");
                        }
                    }
                    else if (command[0].trim().equalsIgnoreCase("execute_script")) {
                        if (commandHandler.getUsedScripts().contains(command[1].trim().toLowerCase())) {
                            System.out.println("Repeated execution of the file \"" +
                                    command[1].trim().toLowerCase() + "\" will lead to recursion.");
                            continue;
                        }
                        FileHandler.readTheScript(commandHandler, command[1], fileName);
                    }
                    else {
                        commandHandler.getCommands().get(command[0].trim().toLowerCase()).execute(command.length > 1 ?
                                command[1] : (command[0].trim().equalsIgnoreCase("save") ? fileName : null));
                        commandHandler.getCollectionHandler().putToTheHistory(command[0].trim().toLowerCase());
                    }
                }
                catch (NoSuchCommandException | EmptyInputException | InvalidArgumentException e){
                    System.out.println(e.getMessage());
                }
                finally {
                    System.out.println("");
                }
            }
        commandHandler.getUsedScripts().remove(executeName);
    }
}
