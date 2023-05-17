package exceptions;

import worker.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

/**
 * Класс, проверяющий на валидность поля элемента коллекции
 */

public class Validator {
    public static boolean idIsValid(String id){
        long i;
        try {
            i = Integer.parseInt(id.trim());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong number format.");
            return false;
        }
        if (i < 1) {
            System.out.println("Id cannot be less than 1.");
        }
        return true;
    }
    public static boolean nameIsValid(String name){
        if (name.isBlank()){
            System.out.println("Wrong name format.");
            return false;
        }
        return true;
    }

    public static boolean xIsValid(String xc){
        float x;
        try {
            x = Float.parseFloat(xc.trim());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong number format.");
            return false;
        }
        return true;
    }

    public static boolean yIsValid(String yc){
        double y;
        try {
            y = Double.parseDouble(yc.trim());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong number format.");
            return false;
        }
        return true;
    }

    public static boolean dateIsValid(String date){
        ZonedDateTime d;
        try {
            d = ZonedDateTime.parse(date);
        }
        catch (DateTimeParseException e){
            System.out.println("Wrong date format.");
            return false;
        }
        return true;
    }

    public static boolean salaryIsValid(String salary){
        float s;
        try {
            s = Float.parseFloat(salary.trim());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong number format.");
            return false;
        }

        if (s <= 0){
            System.out.println("A worker shouldn't work for free.");
            return false;
        }
        return true;
    }

    public static boolean positionIsValid(String position){
        Position p;
        try {
            p = Position.valueOf(position.trim().toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println("Wrong position.");
            return false;
        }
        return true;
    }

    public static boolean statusIsValid(String status){
        Status s;
        try {
            s = Status.valueOf(status.trim().toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println("Wrong status.");
            return false;
        }
        return true;
    }

    public static boolean annualTurnoverIsValid(String annualTurnover){
        Long at;
        try {
            at = Long.parseLong(annualTurnover.trim());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong number format.");
            return false;
        }

        if (at <= 0){
            System.out.println("the annual turnover should be greater than zero");
            return false;
        }
        return true;
    }

    public static boolean employeesCountIsValid(String annualTurnover){
        long ec;
        try {
            ec = Long.parseLong(annualTurnover.trim());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong number format.");
            return false;
        }

        if (ec <= 0){
            System.out.println("the employees count should be greater than zero");
            return false;
        }
        return true;
    }

    public static boolean postalAddressIsValid(String postalAddress){
        if (postalAddress.length() < 8) {
            System.out.println("The size of address must be longer than 8.");
            return false;
        }
        return true;
    }
}
