package com.fuegoquasar.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MessageServiceTest {

    private final MessageService service = new MessageService();

    @Test
    public void testGetMessage() {
        List<String> messageArray1 = List.of("", "es", "", "", "mensaje");
        List<String> messageArray2 = List.of("", "", "es", "un", "");
        List<String> messageArray3 = List.of("este", "es", "", "", "mensaje");

        Assert.assertEquals("este es un mensaje", service.getMessage(List.of(messageArray1, messageArray2, messageArray3)));
    }
}
