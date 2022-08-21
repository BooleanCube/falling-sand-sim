package com.boole.fallingsandsim;

import com.boole.fallingsandsim.particles.LavaParticle;
import com.boole.fallingsandsim.particles.SandParticle;
import com.boole.fallingsandsim.particles.WaterParticle;
import com.boole.fallingsandsim.particles.RockParticle;
import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Frame extends JPanel implements MouseMotionListener, MouseListener, KeyListener {

    public static JFrame window;
    static Map map;

    final int width = 1200;
    final int height = 800;

    final int r = 9;

    public static ParticleType currentType;

    public static ScheduledThreadPoolExecutor thread = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {
        new Frame();
        Runnable update = () -> map.update();
        thread.scheduleAtFixedRate(update, 0, 1, TimeUnit.MICROSECONDS);
    }

    public Frame() {
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        window = new JFrame();
        window.setContentPane(this);
        window.setTitle("Falling Sand Simulation");
        window.getContentPane().setPreferredSize(new Dimension(width, height));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);

        map = new Map(width, height);
        currentType = ParticleType.SAND;

        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        if(map == null) return;
        super.paintComponent(g);
        for(int j=0; j<height; j++) {
            for(int i=0; i<width; i++) {
                Particle current = map.get(j, i);
                g.setColor(current.color);
                g.fillRect(i, j, 1, 1);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        for(int i=Math.max(0, y-r); i<Math.min(height, y+r); i++)
            for(int j=Math.max(0, x-r); j<Math.min(width, x+r); j++) {
                if(currentType == ParticleType.SAND) map.set(i, j, new SandParticle());
                if(currentType == ParticleType.WATER) map.set(i, j, new WaterParticle());
                if(currentType == ParticleType.ROCK) map.set(i, j, new RockParticle());
                if(currentType == ParticleType.LAVA) map.set(i, j, new LavaParticle());
            }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        for(int i=Math.max(0, y-r); i<Math.min(height, y+r); i++)
            for(int j=Math.max(0, x-r); j<Math.min(width, x+r); j++) {
                if(currentType == ParticleType.SAND) map.set(i, j, new SandParticle());
                if(currentType == ParticleType.WATER) map.set(i, j, new WaterParticle());
                if(currentType == ParticleType.ROCK) map.set(i, j, new RockParticle());
                if(currentType == ParticleType.LAVA) map.set(i, j, new LavaParticle());
            }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_S) currentType = ParticleType.SAND;
        if(keyEvent.getKeyCode() == KeyEvent.VK_W) currentType = ParticleType.WATER;
        if(keyEvent.getKeyCode() == KeyEvent.VK_R) currentType = ParticleType.ROCK;
        if(keyEvent.getKeyCode() == KeyEvent.VK_L) currentType = ParticleType.LAVA;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
