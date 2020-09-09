# WumpusWorld
Graphical version of the Wumpus World

How to play :

The user controls the player and has to navigate his movements to avoid death. 

The player dies if he falls into a pit, a breeze will indicate that the player is close to a pitt. 

The player dies when they land on the wumpus monster and knows its near because of its stench the user can use the fire on his arrow to kill the wumpus and will hear a scream if it dies. 

The player has a bow and arrow can use its fire once to kill the wumpus 


Keyboard Controls : 

'w': up
's': down
'd': right
'a': left
'c': climbs the ladder
'p': if on gold square collect gold
'n': if dead or won game then start new game
'*' : reveals the board after won/dead

–if player has arrow–
'i' : shoots up
'k': shows down
'j': shoots left
'l': shoots right

Project: 

WumpusFrame: Builds the frame of the game

WumpusPanel: translates the 2d array into graphic board and gets the images from the folder for the game grpahics; also has the key typed method which moves the player a specific direction when the key is pressed

WumpusPlayer: defines the player by its row, col, the direction, hasArrow, and if the player has gold 

WumpusMap: contains the 2d array which has all the pits, wumpus, and places all the breezes or stenches near each respective object 

Visuals: 
![](gameVisuals/Screen%20Shot%202020-09-09%20at%204.14.27%20PM.png)
![](gameVisuals/Screen%20Shot%202020-09-09%20at%204.16.42%20PM.png)

