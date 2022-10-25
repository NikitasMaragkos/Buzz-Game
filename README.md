# Buzz-Game
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT "MIT License")

![Buzz cover image](https://github.com/NikitasMaragkos/Buzz-Game/blob/main/Images/Intro.PNG?raw=true)

With this code you can play Buzz! Up to two players, with buttons q,w,e,r for the first player and u,i,o,p for the second one.
After inserting your names you will be asked how many rounds you would like to play.

![Buzz cover image](https://github.com/NikitasMaragkos/Buzz-Game/blob/main/Images/Rounds.PNG?raw=true)

Each round has 5 questions when 2 players are playing but 10 when single play has been chosen.

#### Rounds
There is a variety of rounds that are randomly chosen:

* Correct Answer: For each correct answer the player will receive 100 points.

![Buzz cover image](https://github.com/NikitasMaragkos/Buzz-Game/blob/main/Images/Example.PNG?raw=true)

* Bet Round: Before the question is shown, the player will decide the amount of bet (note that the category of the question is known to the player). After that, he answers the question and if he is right he will take as return the bet. Otherwise, he loses the same amount of points. 

![Buzz cover image](https://github.com/NikitasMaragkos/Buzz-Game/blob/main/Images/Bet.PNG?raw=true)


* Fast Answer: There is a clock, so the player must answer before it reaches 0. The sooner he answers the bigger the amount of points that he will receive.

![Buzz cover image](https://github.com/NikitasMaragkos/Buzz-Game/blob/main/Images/Time.PNG?raw=true)

#### Questions

All the questions are in questionPool.txt and have the following format:

Category//Question//Option1//Option2//Option3//Option4//Correct//Image

with an example Food&Drink//What kind of alcoholic beverage is this?//Rum//Tequila//Vodka//Gin//Rum//Bacardi.jpg
So, you could also add your questions as well following this format and by adding the corresponding image (it can be omitted) at images folder.
