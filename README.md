# Explore with Friends
> [!IMPORTANT]
> This project is under construction. Feel free to look around.
## Run with Gradle
```bash
./gradlew run
```

## The Planned Stack
1. I will be using the Java bindings for [Raylib](https://www.raylib.com/), found [here](https://github.com/electronstudio/jaylib/). This is for the graphics and input.
2. For the networking part of the project, I will likely be using Java networking libraries.
3. If I go with C++ or other for networking instead, I will connect the client (Java) to the local server (C++) using local sockets.
4. For the network, I plan to implement peer-to-peer connection. Hopefully, I will be able to support several players at once.
## Objectives
### Phase 1
- [ ] Get a basic 3D interactive project build up
- [ ] Implement basic FPS style movement
- [ ] Implement basic walls and collisions
- [ ] Implement basic lighting
### Phase 2
- [ ] Establish a basic connection between two programs running remotely
- [ ] Implement advanced networking so players can see each other moving
### Phase 3
- [ ] Create some sort of map and some sort of enemy
- [ ] Create an objective for the players
- [ ] Create main menu
- [ ] Create party system
