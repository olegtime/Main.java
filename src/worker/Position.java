package worker;

public enum Position {
    DIRECTOR,
    MANAGER,
    BAKER,
    CLEANER;

    public static void showFields(){
        System.out.println("You can choose one of:");
        for (Position position : Position.values()){
            System.out.println(position);
        }
    }
}
