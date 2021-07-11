package com.mir2.client.game;

public class GameLoop implements Runnable {

    private boolean running = false;
    private final double updateRate = 1.0d/60.0d;
    private long nextDetailUpdateTime;
    private int fps, ups;
    private Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTime = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTime;
            lastUpdate = currentTime;

            if(accumulator > updateRate) {
                while (accumulator >= updateRate) {
                    update();
                    accumulator -= updateRate;
                }
                render();
                printFpsDetails();
            }
        }
    }

    private void printFpsDetails() {
        if(System.currentTimeMillis() > nextDetailUpdateTime) {
            System.out.println(String.format("FPS: %d /t UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextDetailUpdateTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
//        System.out.println("calling render");
        game.render();
        fps++;
    }
}
