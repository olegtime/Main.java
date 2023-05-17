package worker;

import java.time.ZonedDateTime;

/**
 * Класс, элементы которого хранятся в коллекции
 */

public class Worker implements Comparable<Worker> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Поле может быть null, Значение поля должно быть больше 0
    private Position position; //Поле может быть null
    private Status status; //Поле может быть null
    private Organization organization; //Поле может быть null

    public Worker(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, float salary, Position position, Status status, Organization organization){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    public Worker(){

    }

    public String toString(){
        return "ID: " + id + ";  NAME: " + name + ";  COORDINATES: " + coordinates.getX() + ", " +
                coordinates.getY() + ";  DATE: " + creationDate + ";  SALARY: " + salary +
                ";  POSITION: " + position.toString().toLowerCase() + ";  STATUS: " + status.toString().toLowerCase() + ";  ORGANIZATION'S ANNUAL TURNOVER: " +
                organization.getAnnualTurnover() + ";  ORGANIZATION'S EMPLOYEES COUNT: " + organization.getEmployeesCount() +
                ";  ORGANIZATION'S POSTAL ADDRESS: " + organization.getPostalAddress();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public ZonedDateTime getCreationDate(){
        return creationDate;
    }

    public float getSalary(){
        return salary;
    }

    public Position getPosition(){
        return position;
    }

    public Status getStatus(){
        return status;
    }

    public Organization getOrganization(){
        return organization;
    }

    @Override
    public int compareTo(Worker w){
        return this.getId() - w.getId();
    }
}
