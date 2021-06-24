package springbasic.core.discount;

import springbasic.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return
     * */
    int discount(Member member, int price);
}
