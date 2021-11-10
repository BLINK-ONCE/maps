import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessLauncher processLauncher = new ProcessLauncher();
        boolean trigger = processLauncher.run();

        if (trigger) {
            System.out.println("triggered!");
        } if (!trigger) {
            System.out.println("no reaction");
        }
        System.out.println("program exit");
    }
}
