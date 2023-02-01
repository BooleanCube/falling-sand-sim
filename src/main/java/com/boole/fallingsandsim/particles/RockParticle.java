package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class RockParticle extends Particle {

    public RockParticle() {
        // Block type specific members
        this.type = ParticleType.ROCK;
        this.velocity = 0;
        this.gravity = 0;
        this.color = new Color(45, 44, 44);
    }

}
