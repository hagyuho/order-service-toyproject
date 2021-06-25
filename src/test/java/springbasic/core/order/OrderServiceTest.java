package springbasic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbasic.core.AppConfig;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;
import springbasic.core.member.MemberService;
import springbasic.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        //given
        Long memberId = 1L;
        Member member = new Member(memberId,"memverA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId,"itemA",10000);

        //then
        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);
    }
}
