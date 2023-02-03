package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class WaterParticle extends Particle {

    public WaterParticle() {
        // Block type specific members
        this.type = ParticleType.WATER;
        this.velocity = 4;
        this.gravity = 1;
        this.color = new Color(101, 187, 199);
    }

    @Override
    public void updateBlock(Particle[][] map, int x, int y) {
        Particle current = map[x][y];
        if(x<map.length-1 && map[x+gravity][y].isEmpty()) {
            map[x+gravity][y] = current;
            map[x][y] = new EmptyParticle();
        } else {
            int direction = Math.random()<0.5d ? 1 : -1;
            for(int i=velocity; i>=1; i--) {
                int ny = y+i*direction;
                if(x<map.length-1 && ny>=0 && ny<map[0].length && map[x+gravity][ny].isEmpty()) {
                    map[x+gravity][ny] = current;
                    map[x][y] = new EmptyParticle();
                    break;
                } else if(ny>=0 && ny<map[0].length && map[x][ny].isEmpty()) {
                    map[x][ny] = current;
                    map[x][y] = new EmptyParticle();
                    break;
                }
            }
        }
    }

}
