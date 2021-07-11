package com.mir2.client;

import com.mir2.client.game.Game;
import com.mir2.client.gui.Display;
import com.mir2.client.game.GameLoop;
import com.mir2.client.player.KeyInput;

import java.io.IOException;

public class Main {
    public static final int width = 1080;
    public static final int height = 950;
    public static void main(String[] args) throws IOException {
        KeyInput keyInput = new KeyInput();
        Display display = new Display(width, height, keyInput);
        Game game = new Game(display, keyInput);
        GameLoop gameLoop = new GameLoop(game);

        new Thread(gameLoop).start();
    }
}
