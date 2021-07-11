package com.mir2.client.player;

import com.mir2.client.Main;
import com.mir2.client.controllers.PlayerController;
import com.mir2.client.entity.GameObject;
import com.mir2.client.helpers.Position;
import com.mir2.client.helpers.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private BufferedImage image;
    private PlayerController playerController;

    public Player(Position position, Size size, PlayerController playerController) {
        super(position, size);
        this.playerController = playerController;
    }

    @Override
    public void update() {
        if(playerController.isPressingUp() && getPosition().getY() > 0) {
            setPositionY(getPosition().getY() - 1);
        }
        if (playerController.isPressingDown() && getPosition().getY()+ getSize().getHeight() < Main.height) {
            setPositionY(getPosition().getY() + 1);
        }
        if (playerController.isPressingRight() && getPosition().getX() + getSize().getWidth() < Main.width) {
            setPositionX(getPosition().getX() + 1);
        }
        if (playerController.isPressingLeft() && getPosition().getX() > 0) {
            setPositionX(getPosition().getX() - 1);
        }
    }

    @Override
    public Image getImage() {
        image = new BufferedImage(getSize().getWidth(), getSize().getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0, getSize().getWidth(), getSize().getHeight());
        graphics.dispose();
        return image;
    }
}
