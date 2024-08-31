public class TokenManager {
    private String input;
    private int index = 0;
    
    public TokenManager(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        this.input = input;
    }
    
    public char next() {
        if (index < input.length()) {
            return input.charAt(index++);
        }
        return '#';
    }
}
