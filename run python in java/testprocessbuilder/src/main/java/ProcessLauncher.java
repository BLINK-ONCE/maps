import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

public class ProcessLauncher {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Python call");
        String[] command = new String[4];
        command[0] = "python";
        command[1] = "C:/Users/pc/Desktop/git-repos/maps/run python in java/test.py";
        command[2] = "10";
        command[3] = "20";

        try {
            execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        System.out.println("result: " + result);
        System.out.println("output: " + outputStream.toString());
    }
}
