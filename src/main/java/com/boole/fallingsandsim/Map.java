package com.boole.fallingsandsim;

import com.boole.fallingsandsim.particles.EmptyParticle;
import com.boole.fallingsandsim.particles.models.Particle;

public class Map {

    public Particle[][] map;

    public Map(int x, int y) {
        map = new Particle[y][x];
        for(Particle[] ps : map)
            for(int i=0; i<ps.length; i++)
                ps[i] = new EmptyParticle();
    }

    public Particle get(int x, int y) {
        return this.map[x][y];
    }

    public void set(int x, int y, Particle p) {
        this.map[x][y] = p;
    }

    public void update() {
        for(int i=map.length-1; i>=0; i--)
            for(int j=map[0].length-1; j>=0; j--)
                map[i][j].updateBlock(map, i, j);
        Frame.window.repaint();
    }

}
