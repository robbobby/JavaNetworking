package com.mir2.client.gui;

import com.mir2.client.game.Game;

import java.awt.*;

public class Renderer {
    private Graphics graphics;

    public Renderer(Graphics drawGraphics) {
        graphics = drawGraphics;
    }

    public void render(Game game, Graphics graphics) {
        this.graphics = graphics;
        game.getGameObjects().forEach(object -> graphics.drawImage(object.getImage(), object.getPosition().getX(),
                object.getPosition().getY(), null));
    }
}
