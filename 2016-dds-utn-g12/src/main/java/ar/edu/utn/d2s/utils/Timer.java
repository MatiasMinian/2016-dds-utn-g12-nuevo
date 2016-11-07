package ar.edu.utn.d2s.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class Timer {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public void start() {
        startTime = LocalDateTime.now();
    }

    public void stop() {
        endTime = LocalDateTime.now();
    }

    public long getDuration() {
        return Duration.between(startTime, endTime).getSeconds();
    }
}
