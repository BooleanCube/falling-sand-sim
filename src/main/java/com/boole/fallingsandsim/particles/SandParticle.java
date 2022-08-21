package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class SandParticle extends Particle {

    public SandParticle() {
        // Block type specific members
        this.type = ParticleType.SAND;
        this.velocity = 1;
        this.color = new Color(194, 178, 128);
    }

    @Override
    public void updateBlock(Particle[][] map, int x, int y) {
        if(x == map.length-1) return;
        Particle current = map[x][y];
        if(map[x+velocity][y].isEmpty()) {
            map[x+velocity][y] = current;
            map[x][y] = new EmptyParticle();
        } else if(map[x+velocity][y].isLiquid()) {
            Particle p = map[x+velocity][y];
            map[x+velocity][y] = current;
            map[x][y] = p;
        }
        else if(map[x+velocity][y].isLava()) map[x][y] = new EmptyParticle();
        else if(y>0 && map[x+velocity][y-1].isEmpty()) {
            map[x+velocity][y-1] = current;
            map[x][y] = new EmptyParticle();
        } else if(y>0 && map[x+velocity][y-1].isLiquid()) {
            Particle p = map[x+velocity][y-1];
            map[x+velocity][y-1] = current;
            map[x][y] = p;
        }
        else if(y>0 && map[x+velocity][y-1].isLava()) map[x][y] = new EmptyParticle();
        else if(y<map[0].length-1 && map[x+velocity][y+1].isEmpty()) {
            map[x+velocity][y+1] = current;
            map[x][y] = new EmptyParticle();
        } else if(y<map[0].length-1 && map[x+velocity][y+1].isLiquid()) {
            Particle p = map[x+velocity][y+1];
            map[x+velocity][y+1] = current;
            map[x][y] = p;
        }
        else if(y<map[0].length-1 && map[x+velocity][y+1].isLava()) map[x][y] = new EmptyParticle();
    }

}
