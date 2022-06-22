package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId){
        // itemId가 "ex"라고 넘어오면 예외 발생하고 저장 불가.
        if (itemId.equals("ex")){
            throw new IllegalStateException("예외 발생!");
        }
        // 정상이면, 상품 저장에 1초 걸린다고 가정
        sleep(1000);
    }
    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
