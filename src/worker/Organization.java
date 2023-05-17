package worker;

public class Organization implements Comparable<Organization>{
    private Long annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    private long employeesCount; //Значение поля должно быть больше 0
    private Address postalAddress; //Поле не может быть null

    public Organization(Long annualTurnover, long employeesCount, Address postalAddress){
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.postalAddress = postalAddress;
    }

    public Long getAnnualTurnover(){
        return annualTurnover;
    }

    public long getEmployeesCount(){
        return employeesCount;
    }

    public String getPostalAddress(){
        return postalAddress.getZipCode();
    }

    public int compareTo(Organization o){
        if (this.annualTurnover != o.getAnnualTurnover()){
            return (this.annualTurnover > o.getAnnualTurnover() ? 1 : -1);
        }
        if (this.employeesCount != o.getEmployeesCount()){
            return (this.employeesCount > o.getEmployeesCount() ? 1 : -1);
        }
        return this.postalAddress.getZipCode().compareTo(o.getPostalAddress());
    }

    public String toString(){
        return annualTurnover + " " + annualTurnover + " " + postalAddress.getZipCode();
    }
}
