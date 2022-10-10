package minijava.errors;

import java.util.*;


public class ErrorHandler {

    static class SortByLinum implements Comparator<Error> {
        public int compare(Error a, Error b) {
            return a.linum - b.linum;
        }
    }

    static List<Error> errors = new ArrayList<>();
    static int linum;

    public static void addError(Error e) {
        errors.add(e);
    }

    public static void printErrors() {
        errors.sort(new SortByLinum());
        for (Error e : errors) {
            e.printError();
        }
    }

    public static void setLinum(int linum) {
        ErrorHandler.linum = linum;
    }

    public static int getLinum() {
        return ErrorHandler.linum;
    }
}
