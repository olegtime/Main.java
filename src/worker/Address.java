package worker;

public class Address {
    private String zipCode; //Длина строки должна быть не меньше 8, Поле может быть null

    public Address(String zipCode){
        this.zipCode = zipCode;
    }

    public String getZipCode(){
        return zipCode;
    }
}
