package com.example.sampleclient;

import com.example.sampleclient.controllers.MessageController;
import com.example.sampleclient.models.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MessageControllerTest {

    @Autowired
    private MessageController messageController;

    @Test
    public void testGetMessageCode() {
        int id = 100;
        Message message = messageController.getMessage(id);
        assertNotNull(message, "Expect message but found null");
        assertNotNull(message.getCode(), "Expect message code but found null");
        assertEquals(id, message.getCode(), "Expected 100 but found " + message.getCode());
    }

    @Test
    public void testGetMessageValue() {
        int id = 100;
        Message message = messageController.getMessage(id);
        assertNotNull(message, "Expect message but found null");
        assertNotNull(message.getValue(), "Expect message value but found null");
        assertEquals("Hello World", message.getValue(), "Expected Hello World but found ".concat(message.getValue()));
    }


}
