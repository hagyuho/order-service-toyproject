package springbasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbasic.core.discount.DiscountPolicy;
import springbasic.core.discount.FixDiscountPolicy;
import springbasic.core.discount.RateDiscountPolicy;
import springbasic.core.member.MemberRepository;
import springbasic.core.member.MemberService;
import springbasic.core.member.MemberServiceImpl;
import springbasic.core.member.MemoryMemberRepository;
import springbasic.core.order.OrderService;
import springbasic.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){ //역할
        return new MemberServiceImpl(memberRepository()); //구현
    }
    @Bean
    public OrderService orderService(){ //역할
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //구현
    }

    @Bean
    public MemberRepository memberRepository(){ //역할
        return new MemoryMemberRepository(); //구현
    }
    @Bean
    public DiscountPolicy discountPolicy(){ //역할
        return new FixDiscountPolicy(); //구현
    }
}
