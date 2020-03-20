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
        ArrayDeque<Integer> calc = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] symbols = input.split("\\s+");
        calc.push(Integer.parseInt(symbols[0]));
        if (symbols.length == 0) {
            return;
        }

        for (int i = 1; i < symbols.length; i++) {
            String operations = symbols[i];
            int num = Integer.parseInt(symbols[++i]);
            int stackNum =  calc.pop();

            if ("+".equals(operations)){
                calc.push(num+stackNum);
            }else if ("-".equals(operations)){
                calc.push(stackNum-num);
            }

        }
        System.out.print(calc.peek());

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
