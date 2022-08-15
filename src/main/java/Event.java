class Event extends Task {
    public static String FLAG = " /at ";

    public static String extractName(String input) {
        int flagIndex = input.indexOf(Event.FLAG);
        String name = input.substring("event ".length(), flagIndex);
        return name;
    }

    public static String extractTime(String input) {
        int flagIndex = input.indexOf(Event.FLAG);
        String name = input.substring(flagIndex + Event.FLAG.length());
        return name;
    }

    public Event(String input) {
        super(input);
    }

    @Override
    public String toString() {
        String type = "\u001B[34m(EVNT)\u001B[0m";
        return String.format("%s %s", type, super.toString());
    }
}
