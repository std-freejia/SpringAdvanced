package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 붙은 필드에 생성자 만들어서 의존관계 주입 자동으로 해줌
public class OrderServiceV1 { // 상품 저장하는 비즈니스로직 하나만 포함.

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){

        TraceStatus status = null; // try 와 catch 블록 둘 다 접근 가능하도록 TraceStatus를 빼놔야 한다.
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId); // 애플리케이션 로직
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw  e; // 예외를 꼭 다시 던져줘야 한다.
        }
    }
}
