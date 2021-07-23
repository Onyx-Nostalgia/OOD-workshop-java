public class MyRange {
    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean isStartWithInclude() {
        return this.input.startsWith("[");
    }

    public int getStart() {
        if(this.isStartWithInclude()) {
            return Integer.parseInt(String.valueOf(this.input.charAt(1)));
        }
        return -1; // TODO
    }

    public boolean isEndWithInclude() {
        return this.input.endsWith("]");
    }

    public int getEnd() {
        if(this.isEndWithInclude()) {
            return Integer.parseInt(String.valueOf(this.input.charAt(3)));
        }
        return -1; // TODO
    }
}
