package springbasic.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int disCountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return disCountFixAmount;
        } else {
            return 0;
        }
    }
}
