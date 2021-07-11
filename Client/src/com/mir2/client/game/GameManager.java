package com.mir2.client.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class GameManager extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static final int width = 160;
    public static final int height = 160;
    public static final int scale = 3;
    public static final String name = "Legend of Mir 2";
    private boolean running = false;

    private final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private int tickCount = 0;

    private final JFrame frame;

    public GameManager() {
        setMinimumSize(new Dimension(width * scale, height * scale));
        setMaximumSize(new Dimension(width * scale, height * scale));
        setPreferredSize(new Dimension(width * scale, height * scale));

        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1_000_000_000D/60;

        int ticks = 0;
        int frames = 0;
        long lastTimer = System.currentTimeMillis();
        double deltaTime = 0;
        while (running) {
            long timeNow = System.nanoTime();
            deltaTime += (timeNow - lastTime) / nsPerTick;
            lastTime = timeNow;
            boolean shouldRender = false;
            while(deltaTime >=1) {
                ticks++;
                deltaTime -=1;
                shouldRender = true;
                tick();
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(shouldRender) {
                frames++;
                render();
            }

            if(System.currentTimeMillis() - lastTimer >= 1000) {
                System.out.println(ticks);
                lastTimer += 1000;
                frames = 0;
                ticks = 0;
            }
        }
    }

    public void tick() {
        tickCount++;
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = i * tickCount;
        }
    }

    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0, getWidth(), getHeight());
        graphics.dispose();
        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        bufferStrategy.show();
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {

        this.running = running;
    }
}
