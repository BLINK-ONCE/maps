import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriggerDetector {
    public TriggerDetector() throws IOException, InterruptedException {//when adim create TriggerDetector Object, it start soon.
        String command = "C:\\Users\\NCS\\anaconda3\\envs\\py\\python.exe";
        String arg1 = "C:\\Users\\NCS\\Desktop\\git-repos\\open-sw-dev\\TriggerWordDetection\\triggerDetection.py";
        ProcessBuilder builder = new ProcessBuilder(command, arg1);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        int exitVal = process.waitFor();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(">>>   " + line);
        }
        if (exitVal != 0) {
            System.out.println("비정상 종료");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new TriggerDetector();
    }
}
