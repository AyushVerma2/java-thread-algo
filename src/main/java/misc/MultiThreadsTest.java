package misc;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MultiThreadsTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        LocalDateTime start = LocalDateTime.now();
        Info info = new Info();

        //Execution in sequential is very slow.
        /*info.setInfo1(fetchInfo1());
        info.setInfo2(fetchInfo2());
        info.setInfo3(fetchInfo3());*/

        CompletableFuture<String> fetch1 = CompletableFuture
                .supplyAsync(()-> fetchInfo1());

        CompletableFuture<String> fetch2 = CompletableFuture
                .supplyAsync(()-> fetchInfo2());
        CompletableFuture<String> fetch3 = CompletableFuture
                .supplyAsync(()-> fetchInfo3());

        info.setInfo1(fetch1.get());
        info.setInfo2(fetch2.get());
        info.setInfo3(fetch3.get());

        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);

        assertTrue(duration.getSeconds() < 4.1);
        assertEquals("Info1", info.getInfo1());
        assertEquals("Info2", info.getInfo2());
        assertEquals("Info3", info.getInfo3());
    }

    private static String fetchInfo1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Info1";
    }

    private static String fetchInfo2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Info2";
    }

    private static String fetchInfo3() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Info3";
    }

    static class Info {
        String info1;
        String info2;
        String info3;

        public String getInfo1() {
            return info1;
        }

        public void setInfo1(String info1) {
            this.info1 = info1;
        }

        public String getInfo2() {
            return info2;
        }

        public void setInfo2(String info2) {
            this.info2 = info2;
        }

        public String getInfo3() {
            return info3;
        }

        public void setInfo3(String info3) {
            this.info3 = info3;
        }
    }

}




