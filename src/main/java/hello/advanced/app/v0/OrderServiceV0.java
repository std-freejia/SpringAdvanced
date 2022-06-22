package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 붙은 필드에 생성자 만들어서 의존관계 주입 자동으로 해줌
public class OrderServiceV0 { // 상품 저장하는 비즈니스로직 하나만 포함.

    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId){
        orderRepository.save(itemId);
    }
}
