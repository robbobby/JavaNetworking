package com.mir2.client.game;

import com.mir2.client.entity.GameObject;
import com.mir2.client.gui.Display;
import com.mir2.client.helpers.Position;
import com.mir2.client.helpers.Size;
import com.mir2.client.player.KeyInput;
import com.mir2.client.player.Player;
import com.mir2.client.controllers.PlayerController;

import java.util.ArrayList;
import java.util.List;

public class Game {

    Display display;
    private Player player;
    private List<GameObject> gameObjects = new ArrayList<>();

    public Game(Display display, KeyInput keyInput) {
        this.display = display;
        player = new Player(new Position(0, 0), new Size(50, 50), new PlayerController(keyInput));
        gameObjects.add(player);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void update() {
        for(int i =0; i < gameObjects.size(); i++) {
            gameObjects.get(i).update();
        }
    }

    public void render() {
        display.render(this);
    }

    public Player getPlayer() {
        return player;
    }
}
