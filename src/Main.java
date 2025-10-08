import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();
        System.out.println("Inserisci numero: ");
        int amount = scanner.nextInt();

        apiClient.fetchQuestions(amount, "easy", "multiple");
    }
}