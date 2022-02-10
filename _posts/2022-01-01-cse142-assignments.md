---
layout: post
title: "CSE142 Assignments"
---

[Course Webpage](https://courses.cs.washington.edu/courses/cse142/17wi)

[Homework](https://courses.cs.washington.edu/courses/cse142/17wi/homework.shtml) Code Examples
### Song
A cumulative song is one where each verse builds upon previous verses. Examples of cumulative songs are "The House That Jack Built" and "There Was An Old Lady Who Swallowed A Fly." [Song Java File](/assets/smaples/cse142/hmwk1/Song.java)
### ASCII Art / Space Needle
#### Part A: ASCII Art
The first part of your assignment is to write a program that produces any text art (sometimes called "ASCII art") picture you like. Write a Java class named AsciiArt in a file named AsciiArt.java. Your program can produce any text picture you like, with the following restrictions and details:
- The picture should be your own creation, not an ASCII image you found on the Internet or elsewhere.
- The number of lines drawn should be at least 3 but no more than 200, and no more than 100 characters / line.
- The picture should not include hateful, offensive, or otherwise inappropriate images.
- The code should use at least one for loop or static method, but should not contain infinite loops.
- The picture must not be identical to your solution for Part B or consist entirely of reused Part B code.
- Your code should not use material beyond Ch. 3 of the book.
#### Park B: Space Needle
The second part of your assignment is to produce a specific text figure that is sup- posed to look like Seattle's Space Needle.
[Part A: Ascii Java file](/assets/smaples/cse142/hmwk2/AsciiArt.java)

[Part B: Ascii Java file w/o constant](/assets/smaples/cse142/hmwk2/asciiArtsimple.java)

[Part A: Space Needle Java file](/assets/smaples/cse142/hmwk2/SpaceNeedle.java)

[Part B: Space Needle Java file w/o constant](/assets/smaples/cse142/hmwk2/SpaceNeedleW.java)
### Circles/Doodle
#### Part A: Doodle
You may draw any figure you like that is at least 100 x 100 pixels, contains at least three shapes i.e. three calls to draw...( ) or fill...( ), uses at least two distinct colors, is your own work, and is not highly similar to your figure for Part B. Your program also should not have any infinite loops and should not read any user input.
#### Part B: Circles
The second part of this assignment asks you to turn in a file named Circles.java that draws a specific figure of grids of concentric circles. Your program should exactly reproduce the image at left. This image has several levels of structure. There is a basic "subfigure" that occurs throughout, containing concentric circles inside it. The sub- figure is repeated to form grids.
[Part A: Doodle Java file](/assets/smaples/cse142/hmwk3/SpaceNeedle.java)

[Part B: Circles Java file](/assets/smaples/cse142/hmwk3/SpaceNeedleW.java)

![Visual reprensetation of what the program should do](/assets/smaples/cse142/hmwk3/expected_output.png)

### Birthday
The program prompts for today's date and the user's birthday. Each prompt lists the range of values from which to choose. Notice that the range of days printed is based upon the number of days in the month the user typed.
The program prints the "absolute day of the year" for today and the birthday. This is a date's place within the year from 1 to 365. January 1st is absolute day #1 and December 31st is #365. Lastly the program prints the number of days until the user's next birthday. Different messages appear if the birthday is today or tomorrow. [Birthday Java file](/assets/smaples/cse142/hmwk4/Birthday.java)

### Guessing Game
Your program allows the user to play a game in which the program thinks of a random integer and accepts guesses from the user until the user guesses the number correctly. After each incorrect guess, you will tell the user whether the correct answer is higher or lower. Your program must exactly reproduce the format and behavior of the logs in this document. [Guessing Game Java file](/assets/smaples/cse142/hmwk5/Birthday.java)

### Mad Libs
"Mad Libs" are short stories that have blanks called placeholders to be filled in. In the non-computerized version of this game, one person asks a second person to fill in each of the placeholders without the second person knowing the overall story. Once all placeholders are filled in, the second person is shown the resulting story, often with humorous results.
In this assignment you present a menu to the user with three options: create a new mad lib, view a previously created mad lib, or quit. These are shown as C, V, and Q, case-insensitively. If any other command is typed, the user is re-prompted. [Mad Libs Java file](/assets/smaples/cse142/hmwk6/MadLibs.java)

### DNA
The assignment involves processing data from genome files. Your program should work with the two given input files. If you are curious (this is not required), the National Center for Biotechnology Information publishes many other bacteria genome files. The last page tells you how to use your program to process other published genome files.
[DNA Java file](/assets/smaples/cse142/hmwk7/DNA.java)

### Critters
You are provided with several client program classes that implement a graphical simulation of a 2D world of animals. You will write classes that define the behavior of those animals. Animals move and behave in different ways. Your classes will define the unique behaviors for each animal.
The critter world is divided into cells with integer coordinates. The world is 60 cells wide and 50 cells tall. The upper-left cell has coordinates (0, 0); x increases to the right and y increases downward.
[Ant Java file](/assets/smaples/cse142/hmwk8/Ant.java)
[Bird Java file](/assets/smaples/cse142/hmwk8/Bird.java)
[Hippo Java file](/assets/smaples/cse142/hmwk8/Hippo.java)
[Vulture Java file](/assets/smaples/cse142/hmwk8/Vulture.java)
[Husky Java file](/assets/smaples/cse142/hmwk8/Husky.java)
[Critter Java file](/assets/smaples/cse142/hmwk8/Critter.java)
[Critter Main Java file](/assets/smaples/cse142/hmwk8/CritterMain.java)
[Mini Main Java file](/assets/smaples/cse142/hmwk8/MiniMain.java)
[Stone Java file](/assets/smaples/cse142/hmwk8/Stone.java)
