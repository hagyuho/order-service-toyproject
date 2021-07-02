package springbasic.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springbasic.core.annotation.MainDiscountPolicy;
import springbasic.core.discount.DiscountPolicy;
import springbasic.core.member.Member;
import springbasic.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository ; //  final : 생성자 에서만 값을 넣어줄 수 있음!!
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy  DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
