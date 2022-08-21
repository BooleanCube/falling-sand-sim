package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class WaterParticle extends Particle {

    public WaterParticle() {
        // Block type specific members
        this.type = ParticleType.WATER;
        this.velocity = 1;
        this.color = new Color(101, 187, 199);
    }

    @Override
    public void updateBlock(Particle[][] map, int x, int y) {
        Particle current = map[x][y];
        if(x<map.length-1 && map[x+velocity][y].isEmpty()) {
            map[x+velocity][y] = current;
            map[x][y] = new EmptyParticle();
        } else if(x<map.length-1 && y>0 && map[x+velocity][y-1].isEmpty()) {
            map[x+velocity][y-1] = current;
            map[x][y] = new EmptyParticle();
        } else if(x<map.length-1 && y<map[0].length-1 && map[x+velocity][y+1].isEmpty()) {
            map[x+velocity][y+1] = current;
            map[x][y] = new EmptyParticle();
        } else if(y>0 && map[x][y-1].isEmpty()) {
            map[x][y-1] = current;
            map[x][y] = new EmptyParticle();
        } else if(y<map[0].length-1 && map[x][y+1].isEmpty()) {
            map[x][y+1] = current;
            map[x][y] = new EmptyParticle();
        }
    }

}
