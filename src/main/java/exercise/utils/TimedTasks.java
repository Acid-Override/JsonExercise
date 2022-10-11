package exercise.utils;

import java.time.Duration;
import java.time.Instant;

public class TimedTasks
{
    static Instant start;
    static Instant stop;

    public static void startTimer(){
        start = Instant.now();
    }

    public static void stopTimer(){
        stop = Instant.now();
    }

    public static Duration getDuration(){
        return Duration.between(start,stop);
    }

    public static long getDurationInMilliseconds(){
        return Duration.between(start,stop).toMillis();
    }
}
