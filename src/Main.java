import handlers.InputHandler;

public class Main {
    public static void main(String[] args) {
        InputHandler.start(args.length > 0 ? args[0] : "collection");
    }
}
