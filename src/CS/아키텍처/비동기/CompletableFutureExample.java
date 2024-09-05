package CS.아키텍처.비동기;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("비동기 작업 시작");

        // 비동기 작업 실행
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // 2초 대기, 실제 I/O 작업을 시뮬레이션
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "결과 반환";
        });

        // 비동기 작업 결과를 처리
        future.thenAccept(result -> {
            System.out.println("비동기 작업 결과: " + result);
        });

        // 메인 스레드 작업
        System.out.println("다른 작업 수행 중...");

        // 비동기 작업 결과 대기 (필요할 경우)
        future.get(); // 결과를 기다림 (선택적)

        System.out.println("모든 작업 완료");
    }
}
