package com.boole.fallingsandsim.particles;

import java.awt.*;

public interface Particle {

    // Block specific
    public ParticleType type = null;
    public int gravity = 0;
    public int velocity = 0;
    public Color color = null;

    /**
     * Updates the map according to the particle type and position
     * @param map 2d grid of particles
     * @param x x coordinate of particle
     * @param y y coordinate of particle
     */
    public void updateBlock(Particle[][] map, int x, int y);

}
