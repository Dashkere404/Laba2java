import java.util.Scanner;
import java.io.*;
public class FileReaderTest {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path to file without \"\" :");
        String path = sc.nextLine();
        File file = new File(path);
        if (file.exists()) {
            try {
                Reader str = new FileReader(file);
                int c;
                int[] arr = new int[52];
                while ((c = str.read()) != -1) {
                    if (((c - 65) >= 0) && ((c - 65) <= 25)) {
                        arr[c - 65]++;
                    }
                    if (((c - 65) >= 32) && ((c - 65) <= 57)) {
                        arr[c - 71]++;
                    }
                }
                str.close();
                Writer outputer=new FileWriter(file);
                for (int i = 0; i < 26; i++) {
                    outputer.write("Count of letter " + (char) (i + 65) + ": " + arr[i] + "\n");
                }
                for (int i = 26; i < 52; i++) {
                    outputer.write("Count of letter " + (char) (i + 71) + ": " + arr[i] + "\n");
                }
                outputer.close();
                System.out.println("File has been processed successfully");
            } catch (FileNotFoundException fe) {
                System.out.println("File not found");
            } catch (IOException io) {
                System.out.println("Input output error");
            }
        }
        else{
            System.out.println("File with this path does not exist");
        }

    }
}
