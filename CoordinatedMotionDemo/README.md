## CoordinatedMotionDemo
----------------------------------
In this application more interesting movement is created by animating multiple objects, or even the children of an item as the parent itself moves.

==================================

#### Coordinated Motion - Multiple Elements
In this example, the cards move onto screen at different speeds, helping to convey that
they are separate items.

When doing this, it's key that you do so in a coordinated matter, here we are achieving coordinated motion by using a consistent direction and timing.

All cards move in from the bottom of the screen, from different distances, which causes the closing up effect.

Because they use the same duration and interpolator, the acceleration and deceleration will link
them perceptively, thanks to the gestalt laws of grouping that we looked at earlier.

#### Chaotic Motion - Multiple Chaotic Elements
In this exaggerated example, each card arrives from a different direction, appearing chaotic.

Try sketching out the paths that items will travel upon to check that they are coordinated, avoiding overlapping paths in conflicting directions.
