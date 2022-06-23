package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId){


        TraceStatus status = null; // try 와 catch 블록 둘 다 접근 가능하도록 TraceStatus를 빼놔야 한다.
        try{
            status = trace.begin("OrderRepository.save()");

            // 저장 로직
            if (itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!");
            }

            trace.end(status);
            sleep(1000); // 정상이면, 상품 저장에 1초 걸린다고 가정

        }catch (Exception e){ // itemId가 "ex"라고 넘어오면 예외 발생하고 저장 불가.
            trace.exception(status, e);
            throw  e; // 예외를 꼭 다시 던져줘야 한다.
        }
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
