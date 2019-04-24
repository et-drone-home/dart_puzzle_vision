# Scoring Bowling

The game consists of 10 frames as shown above.  In each frame the player has
two opportunities to knock down 10 pins.  The score for the frame is the total
number of pins knocked down, plus bonuses for strikes and spares.

A _line_ in bowling is one game.  Below is an example:

|Bowling game scoring|||||||||||
|----------|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:| :--------:|
|Frames =>|1|2|3|4|5|6|7|8|9|10| 
|Rolls => |3    3|4     2|3     /|5     3|    X|4     /|2     0|0     0|0    0|X    3 /|  
|Sean |6|12|27|35|55|67| 69|69|69|89| 


An open frame is when the player rolls twice and knocks down fewer than all ten pins.

A spare (/) is when the player knocks down all 10 pins in two tries.  The bonus for that frame is the number of pins knocked down by the next roll.  

So in the third frame above, we take 12 from the second frame score and add 15 (10 for the pins knocked down in the third frame plus a bonus of 5 from the first roll of the fourth frame).

A strike (X) is when the player knocks down all 10 pins on their first try.  The bonus for that frame is the value of the next two balls rolled.  See frames 5 and 10.

In the tenth frame a player who rolls a spare or strike is allowed to roll the one or two bonus rolls to complete the frame.  However no more than three balls may be rolled in tenth frame.

## Requirements
Write a class named “Game” that has two methods:
 * roll(pins : int) is called each time the player rolls a ball.  The argument is the number of pins knocked down.
 * score() : int is called only at the very end of the game.  It returns the total score for that game.




