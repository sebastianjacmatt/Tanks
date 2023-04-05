<h1>SITREPS</h1>
<div>
    <h2>SITREP(03.04.2023)</h2>
    <p>
    Currently game is pretty simple, i used bomberman textures from this <a href="https://www.spriters-resource.com/fullview/7943/">website</a>. This because, another project i am working on at uni needs sprites for a bomberman game and i was really bad at drawing tank sprites.
    </p>
    <h5>TODO List:</h5>
        <ul>
            <li>Implemnet proper sprites, currently sprites kinda not work</li>
            <li>Create simple tank sprites, or buy some</li>
            <li>Implement some sort of map</li>
            <li>Implement collison with map and players, this will probably lead to needed exstension of controller</li>
        </ul>
</div>

<div>
    <h2>SITREP(04.04.2023)</h2>
    <p>Implemented sprite animations in all four directions, player will now constantly animate. I still need idle animation tough :I. Should maybe use enums for animations
    </p>
    <p>
    Tought of different maps and collision detection options, options were : Box2D, Intersector collison, or tilemap attribute collision. I really want to use libgdx tilemaps for easier level creation but the collision system is so bad. I also want efficiency</p>
    <p>
    <p>
        <b>roadmap</b> 
        ---->|Map & Collision|---->|Bullets and turrets|---->|MVP Acheived|---->|Better documentation & UML diagram|---->|
    </p>
        <b>Decision</b> <br>
        I have decided to use tilemaps with collision properties for map collision, and i will use bounding box collision detection for players and tanks.
    </p>
    <h5>DONE List:</h5>
        <ul>
            <li>Implemented proper sprites, can now exstract sprite animations at given row, however only for 16 x 24 sized animation sheets</li>
            <li>implement proper animation shifting</li>
            <li>implement collision with walls, still needs collision with borders and other players, todo this i need refractor to solid principles</li>
            <li>Implement some sort of map</li>
        </ul>
    <h5>TODO List:</h5>
        <ul>
            <li>Create propper animation handler, very limited animation handler in player now</li>
            <li>Create simple tank sprites, or buy some</li>
            <li>Implement collison with players and boundaries, need own Collidable class and follow SOLID principles</li>
        </ul>
</div>
<div>
    <h2>SITREP(05.04.2023)</h2>
    <p>Most of the day has been used trying to implement junit test in the libgdx project, however no progress is made. Also downloaded plantuml for better overview of program<p>
    <p>Created new branch to refractor players and collision. I will Exstract the collision mechanism out of players and into the ApplicationAdapter (Tanks). Then collision will be handled there. The refractored code will then check collision on movement by using newly created Collision Detector class. This class uses a Collidable interface which player1 and player2 implements.</p>
    <h5>DONE List:</h5>
    <ul>
        <li></li>
    </ul>
    <h5>TODO List:</h5>
        <ul>
            <li>Create propper animation handler, very limited animation handler in player now</li>
            <li>Create simple tank sprites, or buy some</li>
            <li>Implement collison with players and boundaries, need own Collidable class and follow SOLID principles</li>
        </ul>
</div>