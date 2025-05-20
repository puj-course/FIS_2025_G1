package com.ecotributario.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelegramBotTest {

    @Test
    public void testTokenPresente() {
        assertNotNull(TelegramBot.TOKEN);
        assertFalse(TelegramBot.TOKEN.isEmpty());
    }
}
