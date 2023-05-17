package handlers;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;
import exceptions.*;
import worker.*;
import worker.Worker;

/**
 * Класс, реализующий работу с консолью
 */
public class InputHandler {
    public static Scanner scan = new Scanner(System.in);

    /**
     * Метод, реализующий получение элемента коллекции
     * @param index ID
     */
    public static Worker getWorker(int index){
        int id = index;
        String name; //Поле не может быть null, Строка не может быть пустой
        Coordinates coordinates; //Поле не может быть null
        java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        float salary; //Значение поля должно быть больше 0
        Position position; //Поле не может быть null
        Status status; //Поле не может быть null
        Organization organization;

        name = getName();
        coordinates = getCoordinates();
        salary = getSalary();
        position = getPosition();
        status = getStatus();
        organization = getOrganization();

        return new Worker(id, name, coordinates, ZonedDateTime.now(), salary, position, status, organization);
    }

    public static int getId(){
        System.out.println("Enter the worker's id:");
        String id;

            do {
                id = scan.nextLine().trim();
            } while (!Validator.idIsValid(id));

        return Integer.parseInt(id);
    }
    public static String getName() {
        System.out.println("Enter the worker's name:");
        String name;

        do {
            name = scan.nextLine().trim();
        } while (!Validator.nameIsValid(name));


        return name;
    }

    public static float getX(){
        System.out.println("Enter the worker's coordinates:");
        System.out.println("Enter X (one float count):");

        String x;
        do {
            x = scan.nextLine().trim();
        } while (!Validator.xIsValid(x));

        return Float.parseFloat(x.trim());
    }

    public static float getY(){
        System.out.println("Enter Y (one double count):");

        String y;
        do {
            y = scan.nextLine().trim();
        } while (!Validator.yIsValid(y));

        return Float.parseFloat(y.trim());
    }

    public static Coordinates getCoordinates() {
        float x = getX();
        double y = getY();
        return new Coordinates(x, y);
    }

    public static float getSalary() {
        System.out.println("Enter the worker's salary (one float count greater than zero:");
        String salary;

        do {
            salary = scan.nextLine().trim();
        } while (!Validator.salaryIsValid(salary));


        return Float.parseFloat(salary.trim());
    }

    public static Position getPosition() {
        System.out.println("Enter the worker's position:");
        String position;

        do {
            Position.showFields();
            position = scan.nextLine().trim();
        } while (!Validator.positionIsValid(position));


        return Position.valueOf(position.trim().toUpperCase());
    }

    public static Status getStatus(){
        System.out.println("Enter the worker's status:");
        String status;
        do {
            Status.showFields();
            status = scan.nextLine().trim();
        } while(!Validator.statusIsValid(status));

        return Status.valueOf(status.trim().toUpperCase());
    }

    public static Long getAnnualTurnover(){
        System.out.println("Enter the worker's organization:");
        System.out.println("Enter annual turnover (one integer count):");

        String annualTurnover;
        do {
            annualTurnover = scan.nextLine().trim();
        } while (!Validator.annualTurnoverIsValid(annualTurnover));

        return Long.parseLong(annualTurnover.trim());
    }

    public static long getEmployeesCount(){
        System.out.println("Enter employees count (one integer count):");

        String employeesCount;
        do {
            employeesCount = scan.nextLine().trim();
        } while (!Validator.employeesCountIsValid(employeesCount));

        return Long.parseLong(employeesCount.trim());
    }

    public static Address getPostalAddress(){
        System.out.println("Enter postal address (one string longer than 8):");

        String postalAddress;
        do {
            postalAddress = scan.nextLine().trim();
        } while (!Validator.postalAddressIsValid(postalAddress));

        return new Address(postalAddress);
    }
    public static Organization getOrganization(){
        Long annualTurnover = getAnnualTurnover();
        long employeesCount = getEmployeesCount();
        Address address = getPostalAddress();
        return new Organization(annualTurnover, employeesCount, address);
    }

    /**
     * Метод, запускающий работу коллекции
     * @param fileName имя файла, в который сохраняется коллекция
     */
    public static void start(String fileName) {
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.putCommands();
        FileHandler.readFromFile(commandHandler.getCollectionHandler(), fileName);

        String [] command;

        System.out.println("Enter any command:");

        while (true){
            try {
                command = scan.nextLine().trim().split(" ");
                try {
                    ExceptionCatcher.isTheCommandCorrect(command, commandHandler.getCommands());
                    if (command[0].trim().equalsIgnoreCase("exit")) scan.close();
                    if (command[0].trim().equalsIgnoreCase("execute_script")) {
                        try {
                            FileHandler.readTheScript(commandHandler, command[1], fileName);
                        }
                        catch (IOException e){
                            System.out.println("Something is wrong with the file or its location.");
                            System.out.println("The script didn't work.");
                        }
                    }
                    else {
                        commandHandler.getCommands().get(command[0].trim().toLowerCase()).execute(command.length > 1 ? command[1] :
                                (command[0].trim().equalsIgnoreCase("save") ? fileName : null));
                    }
                    commandHandler.getCollectionHandler().putToTheHistory(command[0].trim().toLowerCase());
                }
                catch (NoSuchCommandException | EmptyInputException | InvalidArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Please, restart the program and don't press Ctrl+D anymore.");
                break;
            }
        }
    }
}
