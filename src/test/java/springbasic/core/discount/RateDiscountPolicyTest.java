package springbasic.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vIP 10% 할인적용")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIPx 할인적용x")
    void vip_x(){
        //given
        Member member = new Member(2L,"memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}