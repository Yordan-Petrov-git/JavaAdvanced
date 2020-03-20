import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static BufferedReader reader =
            new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )

            );

    public static void main(String[] args) throws IOException {
        //=========Exc 1
       // browserHistroy();
        //=========Exc  
    }

    private static void browserHistroy() {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        ArrayDeque<String> history = new ArrayDeque<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            switch (line) {
                case "back":
                    if (history.size() <= 1) {
                        output = "no previous URLs";
                    } else {
                        history.pop();
                        output = history.peek();
                    }
                    break;

                case "Home":
                    return;

                default:
                    output = line;
                    history.push(line);
                    break;
            }
            System.out.println(output);
        }
    }


}
