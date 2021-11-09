Because you need to get started early on Christmas decorations, and to show how much you love writing for-loops, you must write a program that draws an Ascii-art heart, with a size that is specified on standard input. At the bottom of this text, you will find a template program that reads in the size, but always prints out the size 3 heart, shown here:

♡♡♥♥♥♡♡♡♥♥♥♡♡
♡♥♥♥♥♥♡♥♥♥♥♥♡
♥♥♥♥♥♥♥♥♥♥♥♥♥
♡♥♥♥♥♥♥♥♥♥♥♥♡
♡♡♥♥♥♥♥♥♥♥♥♡♡
♡♡♡♥♥♥♥♥♥♥♡♡♡
♡♡♡♡♥♥♥♥♥♡♡♡♡
♡♡♡♡♡♥♥♥♡♡♡♡♡
♡♡♡♡♡♡♥♡♡♡♡♡♡
The size parameter N determines the top part of the heart: The slanted outer sides at the top have N hearts in them. The flat parts at the top have N hearts in them. The gap between the two flat parts is N hearts wide. Here are the first five heart sizes:


When N = 1 the program should print:
♥♡♥
♡♥♡

N = 2
♡♥♥♡♡♥♥♡
♥♥♥♥♥♥♥♥
♡♥♥♥♥♥♥♡
♡♡♥♥♥♥♡♡
♡♡♡♥♥♡♡♡

N = 3
♡♡♥♥♥♡♡♡♥♥♥♡♡
♡♥♥♥♥♥♡♥♥♥♥♥♡
♥♥♥♥♥♥♥♥♥♥♥♥♥
♡♥♥♥♥♥♥♥♥♥♥♥♡
♡♡♥♥♥♥♥♥♥♥♥♡♡
♡♡♡♥♥♥♥♥♥♥♡♡♡
♡♡♡♡♥♥♥♥♥♡♡♡♡
♡♡♡♡♡♥♥♥♡♡♡♡♡
♡♡♡♡♡♡♥♡♡♡♡♡♡

N = 4
♡♡♡♥♥♥♥♡♡♡♡♥♥♥♥♡♡♡
♡♡♥♥♥♥♥♥♡♡♥♥♥♥♥♥♡♡
♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡
♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥
♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡
♡♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡♡
♡♡♡♥♥♥♥♥♥♥♥♥♥♥♥♡♡♡
♡♡♡♡♥♥♥♥♥♥♥♥♥♥♡♡♡♡
♡♡♡♡♡♥♥♥♥♥♥♥♥♡♡♡♡♡
♡♡♡♡♡♡♥♥♥♥♥♥♡♡♡♡♡♡
♡♡♡♡♡♡♡♥♥♥♥♡♡♡♡♡♡♡
♡♡♡♡♡♡♡♡♥♥♡♡♡♡♡♡♡♡

N = 5
♡♡♡♡♥♥♥♥♥♡♡♡♡♡♥♥♥♥♥♡♡♡♡
♡♡♡♥♥♥♥♥♥♥♡♡♡♥♥♥♥♥♥♥♡♡♡
♡♡♥♥♥♥♥♥♥♥♥♡♥♥♥♥♥♥♥♥♥♡♡
♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡
♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥
♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡
♡♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡♡
♡♡♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡♡♡
♡♡♡♡♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♡♡♡♡
♡♡♡♡♡♥♥♥♥♥♥♥♥♥♥♥♥♥♡♡♡♡♡
♡♡♡♡♡♡♥♥♥♥♥♥♥♥♥♥♥♡♡♡♡♡♡
♡♡♡♡♡♡♡♥♥♥♥♥♥♥♥♥♡♡♡♡♡♡♡
♡♡♡♡♡♡♡♡♥♥♥♥♥♥♥♡♡♡♡♡♡♡♡
♡♡♡♡♡♡♡♡♡♥♥♥♥♥♡♡♡♡♡♡♡♡♡
♡♡♡♡♡♡♡♡♡♡♥♥♥♡♡♡♡♡♡♡♡♡♡
♡♡♡♡♡♡♡♡♡♡♡♥♡♡♡♡♡♡♡♡♡♡♡
Hint: It might be helpful to solve the printing of the top and bottom part of the heart separately.