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

public class Frame extends JPanel implements MouseMotionListener, MouseListener, MouseWheelListener, KeyListener {

    public static JFrame window;
    public static Graphics2D graphics;
    static Map map;

    final int width = 1200;
    final int height = 800;

    int radius = 15;

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
        addMouseWheelListener(this);
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

        graphics = (Graphics2D) window.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

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
        for(int i = Math.max(0, y- radius); i<Math.min(height, y+ radius); i++)
            for(int j = Math.max(0, x- radius); j<Math.min(width, x+ radius); j++) {
                float distance = (float)Math.sqrt(Math.pow(y-i,2)+Math.pow(x-j,2));
                if(distance> radius || Math.random()<0.3) continue;
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
        for(int i = Math.max(0, y- radius); i<Math.min(height, y+ radius); i++)
            for(int j = Math.max(0, x- radius); j<Math.min(width, x+ radius); j++) {
                float distance = (float)Math.sqrt(Math.pow(y-i,2)+Math.pow(x-j,2));
                if(distance> radius || Math.random()<0.3) continue;
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
        else if(keyEvent.getKeyCode() == KeyEvent.VK_W) currentType = ParticleType.WATER;
        else if(keyEvent.getKeyCode() == KeyEvent.VK_R) currentType = ParticleType.ROCK;
        else if(keyEvent.getKeyCode() == KeyEvent.VK_L) currentType = ParticleType.LAVA;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int direction = -e.getWheelRotation();
        int amt = e.getScrollAmount();
        this.radius += direction*amt;
        this.radius = Math.max(1, this.radius);
    }

}
