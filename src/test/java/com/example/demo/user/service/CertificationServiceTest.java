package com.example.demo.user.service;

import com.example.demo.mock.FakeMailSender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CertificationServiceTest {

    @Test
    void 이메일_컨텐츠_제대로_보내진건지_테스트한다() {

        //given
        FakeMailSender fakeMailSender = new FakeMailSender();
        CertificationService certificationService = new CertificationService(fakeMailSender);

        //when
        String email = "abc@gmail.com";
        Long userId = 1L;
        String certificationCode = "aaaaaa-aaaa-aaaa-aaaaaaa";
        certificationService.send(email, userId, certificationCode);

        //then
        assertThat(fakeMailSender.email).isEqualTo(email);
        assertThat(fakeMailSender.title).isEqualTo("Please certify your email address");
        assertThat(fakeMailSender.content).isEqualTo("Please click the following link to certify your email address: http://localhost:8080/api/users/1/verify?certificationCode=aaaaaa-aaaa-aaaa-aaaaaaa");

    }
}