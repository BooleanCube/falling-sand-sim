package com.boole.fallingsandsim.particles.models;

import com.boole.fallingsandsim.particles.EmptyParticle;
import com.boole.jgmp.math.vectors.JGMPVector2;

import java.awt.*;

public class Particle {

    // Block type specific members
    public ParticleType type;
    public int velocity;
    public Color color;

    public void updateBlock(Particle[][] map, int x, int y) {
        Particle current = map[x][y];
        map[x][y+velocity] = current;
        if(velocity>0) map[x][y] = new EmptyParticle();
    }

    public boolean isEmpty() {
        return this.type == ParticleType.EMPTY;
    }

    public boolean isLava() {
        return this.type == ParticleType.LAVA;
    }

    public boolean isLiquid() {
        return this.type == ParticleType.WATER;
    }

    public boolean isSolid() {
        return this.type == ParticleType.SAND || this.type == ParticleType.ROCK;
    }

}
