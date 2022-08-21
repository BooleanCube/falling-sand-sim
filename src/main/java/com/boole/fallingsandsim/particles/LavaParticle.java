package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class LavaParticle extends Particle {

    public LavaParticle() {
        // Block type specific members
        this.type = ParticleType.LAVA;
        this.velocity = 1;
        this.color = new Color(207, 16, 32);
    }

    @Override
    public void updateBlock(Particle[][] map, int x, int y) {
        Particle current = map[x][y];
        if(x<map.length-1 && !map[x+velocity][y].isLava()) {
            if(map[x+velocity][y].type == ParticleType.WATER){
                map[x+velocity][y] = new RockParticle();
                map[x][y] = new EmptyParticle();
            } else if(map[x+velocity][y].type == ParticleType.ROCK && Math.random()<0.03){
                map[x+velocity][y] = current;
                map[x][y] = new EmptyParticle();
            } else {
                map[x+velocity][y] = current;
                map[x][y] = new EmptyParticle();
            }
        } else if(y>0 && !map[x][y-1].isLava()) {
            if(map[x][y-1].type == ParticleType.WATER){
                map[x][y-1] = new RockParticle();
                map[x][y] = new EmptyParticle();
            } else if(map[x][y-1].type == ParticleType.ROCK && Math.random()<0.03){
                map[x][y-1] = current;
                map[x][y] = new EmptyParticle();
            } else {
                map[x][y-1] = current;
                map[x][y] = new EmptyParticle();
            }
        } else if(y<map[0].length-1 && !map[x][y+1].isEmpty()) {
            if(map[x][y+1].type == ParticleType.WATER){
                map[x][y+1] = new RockParticle();
                map[x][y] = new EmptyParticle();
            } else if(map[x][y+1].type == ParticleType.ROCK && Math.random()<0.1){
                map[x][y+1] = current;
                map[x][y] = new EmptyParticle();
            } else {
                map[x][y+1] = current;
                map[x][y] = new EmptyParticle();
            }
        }
    }

}
