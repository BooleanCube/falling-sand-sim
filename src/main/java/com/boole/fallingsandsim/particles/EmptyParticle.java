package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class EmptyParticle extends Particle {

    public EmptyParticle() {
        // Block type specific members
        this.type = ParticleType.EMPTY;
        this.velocity = 0;
        this.gravity = 0;
        this.color = new Color(55, 55, 55);
    }

}