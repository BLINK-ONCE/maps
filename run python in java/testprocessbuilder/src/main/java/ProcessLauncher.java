import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessLauncher {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("C:\\Users\\pc\\Desktop\\git-repos\\maps\\run python in java");
        list.add("C:\\Users\\pc\\Desktop\\git-repos\\maps\\run python in java\\SpeechRecognitionGoogleAPI.py");

        ProcessBuilder processBuilder = new ProcessBuilder(list);

        processBuilder.directory(new File("C:\\Users\\pc\\Desktop\\git-repos\\maps\\run python in java\\"));
        System.out.println("command: " + processBuilder.command());

        /*ProcessBuilder processBuilder = new ProcessBuilder(
                "C:\\Users\\pc\\Desktop\\git-repos\\maps\\run python in java\\SpeechRecognitionGoogleAPI.py");
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        Process process = processBuilder.start();
        process.waitFor();*/
    }
}

/*class ProcessBuilderTest {
    ProcessBuilder builder = new ProcessBuilder();
    String homeDir = "C:\\Users\\pc\\Desktop\\git-repos\\maps\\run python in java\\";
    String process = "SpeechRecognitionGoogleAPI";

    builder.command("cmd.exe","/c","homeDir");

    builder.directory(new File(System.getProperty("homeDir")))
}*/
