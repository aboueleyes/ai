import State;

public class Parser {


    public State parse(String initialState) {
        String input = "50;" +
                "22,22,22;" +
                "50,60,70;" +
                "30,2;19,1;15,1;" +
                "300,5,7,3,20;" +
                "500,8,6,3,40;";

        // Split the input string by semicolon and comma
        String[] parts = input.split("[;,]");
        int initialProsperity = Integer.parseInt(parts[0]);
        int[] initialResources = { Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]) };
        State initialState = new State();
    }
    
}
