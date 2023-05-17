package worker;

public enum Status {
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION;

    public static void showFields(){
        System.out.println("You can choose one of:");
        for (Status status: Status.values()){
            System.out.println(status);
        }
    }
}
