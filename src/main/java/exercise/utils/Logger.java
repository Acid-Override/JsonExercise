package exercise.utils;

public class Logger
{
    public static void log(String label, String value, long totalTime){
        System.out.print(label + ": ");
        System.out.println(value);
        System.out.println("Total time: " + totalTime + "ms");
        //System.out.println("---------------");
        System.out.println();
    }
}
