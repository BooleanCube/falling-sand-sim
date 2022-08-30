# Falling Sand Simulation
> This project is a falling sand simulation to figure out and simulate each and every pixel according to its behaviors in physics. This simple sand falling algorithm can be very useful in game development and is a very interesting theory to play around with.

![FallingSandSim](https://user-images.githubusercontent.com/47650058/185774857-29b7124a-0de6-4f9f-a3a6-7bdcadff2b2e.png)

There are many types of particles in this project symbolized by the different colored pixels:
- Sand (YELLOW - RGB(194, 178, 128))
- Wwater (AQUA - RGB(101, 187, 199))
- Rock (BLACK - RGB(45, 44, 44))
- Lava (RED - RGB(207, 16, 32))

Sand flows like a normal solid with normal physics whereas rock in this simulation is like a static pixel and will remain static and in place until lava runs it over. Rocks do not react to physics like they do in real life and stay stationary. <br>
Water flows like a normal fluid and searches for lava and upon meeting lava creates rock residue which can be eaten by even more lava. <br>
Lava flows like a normal fluid similarly to water but destroys and erases anything in it's path. However, if water shows up the lava creates small amounts of rock particles and starts to disintegrate slowly. Lava serves as an eraser tool for the falling sand simulation project.

### Usage
- Click or Mouse Drag across the screen to add 81 pixels worth of particles to the screen around the cursor's coordinates.
- Press S Key to choose sand particles
- Press W Key to choose water particles
- Press R Key to choose rock particles
- Press L Key to choose lava particles

### Installation
*NOTE: You need to be running Java 11 or higher to be able to run the `.jar` file.*

1. Visit the [releases page](https://github.com/BooleanCube/falling-sand-sim/releases) to find a list of all the releases.
2. Download the `jar` file in the list of downloadable assets in the latest release.
3. If you are on linux, you have to give execution permission to the downloaded `jar` file before executing the `jar` file. You can run the `jar` file and boot the application by running these commands:
```shell
$ chmod -x path/to/jar/fallingsandsim.jar #This makes the `jar` file executable (only for linux).
$ java -jar path/to/jar/fallingsandsim.jar
```

----

*Created by BooleanCube :]*
