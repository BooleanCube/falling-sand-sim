package com.boole.fallingsandsim.particles;

import com.boole.jgmp.physics.JGMPVelocity;

import java.awt.*;

public interface Particle {

    // Block specific
    public ParticleType type = null;
    public JGMPVelocity velocity = new JGMPVelocity(0f);
    public Color color = null;

    /**
     * Updates the map according to the particle type and position
     * @param map 2d grid of particles
     * @param x x coordinate of particle
     * @param y y coordinate of particle
     */
    public void updateBlock(Particle[][] map, int x, int y);

}
