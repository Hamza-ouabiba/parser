public class MainJava {

    public static void main(String[] args) {
        // Example input string for testing
        String input = "cdcbc";

        TokenManager tokenManager = new TokenManager(input);

        Parser parser = new Parser(tokenManager);

        if (parser.validate()) {
            System.out.println("The string \"" + input + "\" is valid.");
        } else {
            System.out.println("The string \"" + input + "\" is not valid.");
        }
    }
}
