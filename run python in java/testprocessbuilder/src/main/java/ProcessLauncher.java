import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

public class ProcessLauncher {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessLauncher processLauncher = new ProcessLauncher();
        processLauncher.run();

    }

    public ProcessLauncher() {

    }

    public void run() throws IOException {
        System.out.println("Python call");
        boolean trigger = false;
        String[] command = new String[2];
        command[0] = "python";
        command[1] = "C:/Users/pc/Desktop/git-repos/maps/run python in java/SpeechRecognitionGoogleAPI.py";

        while (!trigger) {
            try {
                trigger = execPython(command);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("trigger: " + trigger);
        }
    }

    public boolean execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        //System.out.println("result: " + result);
        String output = outputStream.toString();
        System.out.println("output: " + output);
        if ("1".equals(output.substring(0,1))) {
            return true;
        }
        return false;
    }
}
