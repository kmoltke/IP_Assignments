
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StdIOTest {
    static char ESC = 27;

    public static void main(String[] args) throws IOException {
        var oldin = System.in;
        var oldout = System.out;
        var newline = System.lineSeparator();
        var infiles = new File(".").list((dir, name) -> name.endsWith(".in"));
        Arrays.sort(infiles);
        for (var infile : infiles) {
            var ansfile = new File(infile.substring(0, infile.length() - 2) + "ans");
            if (ansfile.exists()) {
                var expect = String.join(newline, Files.readAllLines(ansfile.toPath()));
                System.setIn(new FileInputStream(new File(infile)));
                var outstream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outstream));
                Main.main(new String[0]);
                System.setOut(oldout);
                System.setIn(oldin);
                var actual = String.join(newline, outstream.toString().lines().collect(Collectors.toList()));
                if (expect.equals(actual)) {
                    System.out.println("[" + ESC + "[32mPASS" + ESC + "[0m] " + infile);
                } else {
                    System.out.println("[" + ESC + "[31mFAIL" + ESC + "[0m] " + infile);
                    System.out.println("\nExpected:\n" + expect);
                    System.out.println("\nActual:\n" + actual);
                    return;
                }
            } else {
                System.err.println(ansfile + " not found. Testcase skipped.");
            }
        }
    }
}
