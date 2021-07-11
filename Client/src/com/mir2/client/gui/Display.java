package com.mir2.client.gui;

import com.mir2.client.game.Game;
import com.mir2.client.player.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    public Renderer renderer;
    private Canvas canvas;
    BufferStrategy bufferStrategy;
    Graphics graphics;
    KeyInput keyInput;

    public Display(int width, int height, KeyInput keyInput) {
        setTitle("Legend of mir 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        pack();
        canvas.createBufferStrategy(2);
        this.keyInput = keyInput;
        addKeyListener(keyInput);

        setLocationRelativeTo(null);
        setVisible(true);
        bufferStrategy = canvas.getBufferStrategy();
        renderer = new Renderer(bufferStrategy.getDrawGraphics());
    }

    public void render(Game game) {
        graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, getWidth(), getHeight());
        renderer.render(game, graphics);

        graphics.dispose();
        bufferStrategy.show();
    }
}
