package com.boole.fallingsandsim.particles;

import com.boole.fallingsandsim.particles.models.Particle;
import com.boole.fallingsandsim.particles.models.ParticleType;

import java.awt.*;

public class SandParticle extends Particle {

    public SandParticle() {
        // Block type specific members
        this.type = ParticleType.SAND;
        this.velocity = 1;
        this.gravity = 1;
        this.color = new Color(194, 178, 128);
    }

    @Override
    public void updateBlock(Particle[][] map, int x, int y) {
        if(x == map.length-1) return;
        Particle current = map[x][y];
        if(map[x+gravity][y].isEmpty()) {
            map[x+gravity][y] = current;
            map[x][y] = new EmptyParticle();
        } else if(map[x+gravity][y].isLiquid()) {
            Particle p = map[x+gravity][y];
            boolean flag = false;
            for(int i=1; i<map.length; i++) {
                if(y+i<map.length && map[x-1][y+i].isEmpty()) {
                    map[x-1][y+i] = p;
                    break;
                } else if(y-i>-1 && map[x-1][y-i].isEmpty()) {
                    map[x-1][y-i] = p;
                    break;
                }
                if(map[x-1][y-i].isLiquid() || map[x-1][y+i].isLiquid()) {
                    flag = true;
                    break;
                }
            }
            map[x+gravity][y] = current;
            map[x][y] = new EmptyParticle();
            if(!flag) map[x][y] = p;
        }
        else if(map[x+gravity][y].isLava()) map[x][y] = new EmptyParticle();
        else {
            int direction = Math.random()<0.5d ? 1 : -1;
            for(int i=velocity; i>=1; i--) {
                int ny = y+i*direction;
                if(ny>=0 && ny<map[0].length && map[x+gravity][ny].isEmpty()) {
                    map[x+gravity][ny] = current;
                    map[x][y] = new EmptyParticle();
                    break;
                } else if(ny>=0 && ny<map[0].length && map[x+gravity][ny].isLiquid()) {
                    Particle p = map[x+gravity][ny];
                    boolean flag = false;
                    for(int s=1; s<map.length; s++) {
                        if(y+s<map.length && map[x-1][y+s].isEmpty()) {
                            map[x-1][y+s] = p;
                            break;
                        } else if(y-s>-1 && map[x-1][y-s].isEmpty()) {
                            map[x-1][y-s] = p;
                            break;
                        }
                        if(map[x-1][y-s].isLiquid() || map[x-1][y+s].isLiquid()) {
                            flag = true;
                            break;
                        }
                    }
                    map[x+gravity][ny] = current;
                    map[x][y] = new EmptyParticle();
                    if(!flag) map[x][ny] = p;
                    break;
                }
                else if(ny>=0 && ny<map[0].length && map[x+gravity][ny].isLava()) {
                    map[x][y] = new EmptyParticle();
                    break;
                }
            }
        }
    }

}
