import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

public class ProcessLauncher {

    public ProcessLauncher() {

    }

    public boolean run() throws IOException {
        System.out.println("===== Python call =====");
        boolean trigger = false;
        PythonScriptCommand pythonScriptCommand = new PythonScriptCommand();

        while (!trigger) {
            try {
                trigger = execPython(pythonScriptCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println("trigger: " + trigger); // use when you want to check trigger works
        }

        return trigger;
    }

    private boolean execPython(PythonScriptCommand pythonScriptCommand) throws IOException {
        String[] command = new String[2];
        command[0] = pythonScriptCommand.getCommand();
        command[1] = pythonScriptCommand.getScriptPath();
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        String output = outputStream.toString();
        //System.out.println("output: " + output); // use when you check what output is
        if ("1".equals(output.substring(0,1))) {
            return true;
        }
        return false;
    }
}
