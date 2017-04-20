import java.io.*;
import java.util.Scanner;

/**
 * Created by olwin on 3/13/17.
 */
public class FormatCode {
    File inFile;
    File outFile1;
    File outFile2;
    int[] countAry;

    public FormatCode(File inFile) {
        this.inFile = inFile;
        this.countAry = new int[256];
    }

    public void print(File outFile1) throws FileNotFoundException {
        try {
            Scanner input = new Scanner(inFile);
            this.outFile1 = outFile1;
            PrintWriter output = new PrintWriter(outFile1);
            String word;
            while (input.hasNext()) {
                word = input.next();
                output.write(word);
            }
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void count(File outFile2) throws FileNotFoundException {
        try {
            BufferedReader input = new BufferedReader(new FileReader(outFile1));
            this.outFile2 = outFile2;
            PrintWriter output = new PrintWriter(outFile2);
            int index;
            while ((index = input.read()) != -1) {
                countAry[index]++;
            }
            printOut(output);
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printOut(PrintWriter output) {
        for (int i = 0; i < 256; i++) {
            if (countAry[i] != 0) {
                output.write(((char) i) + "\t" + countAry[i] + "\n");
            }
        }
    }

    public static void main(String args[]) {
        File inFile = new File(args[0]);
        File outFile1 = new File(args[1]);
        File outFile2 = new File(args[2]);
        FormatCode formatter = new FormatCode(inFile);
        try {
            formatter.print(outFile1);
            formatter.count(outFile2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
