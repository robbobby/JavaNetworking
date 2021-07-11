package com.mir2.client.controllers;

import com.mir2.client.entity.IInputController;
import com.mir2.client.player.KeyInput;

import java.awt.event.KeyEvent;

public class PlayerController implements IInputController {

    private KeyInput keyInput;

    public PlayerController(KeyInput keyInput) {
        this.keyInput = keyInput;
    }

    @Override
    public boolean isPressingUp() {
        return keyInput.isPressed((KeyEvent.VK_UP));
    }

    @Override
    public boolean isPressingDown() {
        return keyInput.isPressed((KeyEvent.VK_DOWN));
    }

    @Override
    public boolean isPressingLeft() {
        return keyInput.isPressed((KeyEvent.VK_LEFT));
    }

    @Override
    public boolean isPressingRight() {
        return keyInput.isPressed((KeyEvent.VK_RIGHT));
    }
}
