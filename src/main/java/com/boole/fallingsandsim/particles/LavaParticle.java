package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class LavaParticle extends Particle {

    public LavaParticle() {
        // Block type specific members
        this.type = ParticleType.LAVA;
        this.velocity = 1;
        this.gravity = 1;
        this.color = new Color(207, 16, 32);
    }

    @Override
    public void updateBlock(Particle[][] map, int x, int y) {
        Particle current = map[x][y];
        if(x==map.length-1) map[x][y] = new EmptyParticle();
        if(x<map.length-1 && !map[x+gravity][y].isLava()) {
            if(map[x+gravity][y].type == ParticleType.WATER){
                map[x+gravity][y] = new RockParticle();
                map[x][y] = new EmptyParticle();
            } else if(map[x+gravity][y].type == ParticleType.ROCK && Math.random()<0.03){
                map[x+gravity][y] = current;
                map[x][y] = new EmptyParticle();
            } else {
                map[x+gravity][y] = current;
                map[x][y] = new EmptyParticle();
            }
        } else {
            int direction = Math.random()<0.5d ? 1 : -1;
            for(int i=velocity; i>=1; i--) {
                int ny = y+i*direction;
                if(ny>=0 && !map[x][ny].isLava()) {
                    if(map[x][ny].type == ParticleType.WATER){
                        map[x][ny] = new RockParticle();
                        map[x][y] = new EmptyParticle();
                        break;
                    } else if(map[x][ny].type == ParticleType.ROCK && Math.random()<0.53){
                        map[x][ny] = current;
                        map[x][ny] = new EmptyParticle();
                        break;
                    } else {
                        map[x][ny] = current;
                        map[x][y] = new EmptyParticle();
                        break;
                    }
                }
            }
        }
    }

}
