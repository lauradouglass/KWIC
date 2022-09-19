# KWIC
KWIC indexing:
HOW TO USE PROGRAM.

1.if you have stop words file, leave 2 empty lines after the last word to indicate end of file
2.copy and past your input file path on line 10 of Main.java
3.if you have stop words file, copy and paste file path in line 23 of Main.java, else, continue to step 4
4.you can now run the files, if using intellij idea, simply run Main.java (all file must be in the project src folder)
5.if running in tux, enter the following command (after steps 1-3 have been completed):
    cd [into the directory that holds all the source code] file eg. cd src
    javac Main.java //to compile
    java Main
    follow prompts and view or save your results
    to re-run, simply type "java Main" again
    if you saved your output to file simply type the following command to view your results:
    vi kwix.txt
6.to close, delete 'kwic.txt'  (rm kwic.txt [in terminal] or right click and delete [in intelliJ idea]
NB: step 6 is optional (as file is overwritten at every run) but recommended
7.close terminal/intellij idea
