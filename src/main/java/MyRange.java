import java.util.stream.IntStream;

public class MyRange {
    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean isStartWithInclude() {
        return this.input.startsWith("[");
    }

    public int getStart() {
        int number = Integer.parseInt(String.valueOf(this.input.charAt(1)));
        if(this.isStartWithInclude()) {
            return number;
        }
        return number +1;
    }

    public boolean isEndWithInclude() {
        return this.input.endsWith("]");
    }

    public int getEnd() {
        int number = Integer.parseInt(String.valueOf(this.input.charAt(3)));
        if(this.isEndWithInclude()) {
            return number;
        }
        return number - 1;
    }

    public String getResult() {
        int startNumber = getStart();
        int endNumber = getEnd();
        String result = String.join(",",
                IntStream.rangeClosed(startNumber, endNumber).mapToObj(String::valueOf).toArray(String[]::new));
        return result;
    }
}
