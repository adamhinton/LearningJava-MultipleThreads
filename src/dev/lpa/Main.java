package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {



    }
}

class StopWatch{
    private TimeUnit timeUnit;

    public StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown(int unitCount){
        String threadName = Thread.currentThread().getName();

        ThreadColor threadColor = ThreadColor.ANSI_RESET;
        try{
            threadColor = ThreadColor.valueOf(threadName);
        }
        catch(IllegalArgumentException ignore){
            // Ignore if user passes bad color name
        }

        String color = threadColor.color();
        for (int i=unitCount; i>0; i--){
            try{
                timeUnit.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.printf("%s%s Thread : i = %d%n", color, threadName, i);
        }
    }
}