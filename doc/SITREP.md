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
    <h5>DONE List:</h5>
        <ul>
            <li>Implemented proper sprites, can now exstract sprite animations at given row, however only for 16 x 24 sized animation sheets</li>
            <li>implement proper animation shifting</li>
        </ul>
    <h5>TODO List:</h5>
        <ul>
            <li>Create propper animation handler, very limited animation handler in player now</li>
            <li>Create simple tank sprites, or buy some</li>
            <li>Implement some sort of map</li>
            <li>Implement collison with map and players, this will probably lead to needed exstension of controller</li>
        </ul>
</div>