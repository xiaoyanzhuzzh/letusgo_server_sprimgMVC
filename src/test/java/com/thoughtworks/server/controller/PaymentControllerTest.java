package com.thoughtworks.server.controller;

import com.thoughtworks.server.service.PaymentService;
import com.thoughtworks.server.service.PaymentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaymentControllerTest {
    PaymentService paymentServiceImpl;
    PaymentController paymentController;

    @Before
    public void init_PaymentController(){
        paymentServiceImpl = mock(PaymentServiceImpl.class);

        paymentController = new PaymentController();
        ReflectionTestUtils.setField(paymentController, "paymentServiceImpl", paymentServiceImpl);
    }

    @Test
    public void can_delete_all_cartItems(){
        paymentController.deleteCartItems();
        verify(paymentServiceImpl).deleteCartItems();
    }
}
