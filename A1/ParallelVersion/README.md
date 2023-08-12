Parallelizing Monte Carlo Function Optimisation 
CSC2002S 2023 Assignment 1
By Danisha Naidoo (NDXDAN019)

Project Description:
This project involves testing the effects of parallelization on the execution time and accuracy of a program and comparing it to that of the serial version. The code used for this project is a program that defines a grid area and uses the Monte Carlo method to search for the minimum point in a two-dimensional space. 

Project Contents:
Makefile for compilation
src/MonteCarloMini folder containing the java source code
bin/MonteCarloMini containing the java class files
README.md 


How to Run:
Step 1: 
This program can be run from your local computer by downloading the main folder containing all the code. This will include the source code, class files and Makefile. 

Step 2: 
Through an Ubuntu terminal, enter into the main folder using the "cd" command. This will be the folder containing the "src" and "bin" folders as well as the Makefile.

Step 3:
Compile the code in the terminal using the "make" command.

Step 4:
Once compiled enter the "make run" command along with the necessary command line inputs. The command line inputs are rows, columns, xmin, xmax, ymin, ymax and search density in that order.
Here, the rows and columns represent the number of rows and columns in the discrete grid, the xmin, xmax, ymin and ymax represent the boundaries of the terrain area, and the search density defines how many searches are performed per grid point. 

Step 5:
If the above steps were followed successfully, the program will output data showing the command line inputs, the execution time, the number of grid point visited and evaluated, and the global minimum.

Examples of Use:
 $ cd ParallelVersion
 $ make
 $ make run ARGS="100 100 1 100 1 100 0.2"

Acknowledgements:
The code for the serial version that was used for benchmarking and for the parallel modification was provided by Michelle Kuttle.  

