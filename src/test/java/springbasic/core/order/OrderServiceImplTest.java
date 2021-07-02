package springbasic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springbasic.core.discount.FixDiscountPolicy;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;
import springbasic.core.member.MemberRepository;
import springbasic.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itemA",10000);

        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);
    }
}
