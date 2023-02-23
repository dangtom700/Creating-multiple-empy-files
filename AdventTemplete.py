import os
import datetime

TAIL_FILE=("output.cpp","output.py","output.java","PuzzleInput.txt")
MAIN_ROOT="AdventOfCode"
YEAR=2024

def create_directory(directory):
    if not os.path.exists(directory):
        os.makedirs(directory)
        print("Directory created")
    else:
        print("Directory already exists")
def create_file(file_name):
    if not os.path.exists(file_name):
        with open(file_name, "w") as f:
            f.write("")
        print("File created")
    else:
        print("File already exists")
def createAllCalendars():
    for year in range(2015, datetime.datetime.now().year+1):
        dir_level1=MAIN_ROOT+"/Advent_of_code_"+str(year)
        create_directory(dir_level1)
        for date in range(1,25+1):
            dir_level2=dir_level1+"/Advent_of_code_"+str(year)+"_"+str(date)
            create_directory(dir_level2)
            #open this dir and add an empty file
            RootFile=dir_level2+"/Advent_of_code_"+str(year)+"_"+str(date)
            for tail in TAIL_FILE:
                create_file(RootFile+tail)
def createOneCalendar():
    dir_level1=MAIN_ROOT+"/Advent_of_code_"+str(YEAR)
    create_directory(dir_level1)
    for date in range(1,25+1):
        dir_level2=dir_level1+"/Advent_of_code_"+str(YEAR)+"_"+str(date)
        create_directory(dir_level2)
        #open this dir and add an empty file
        RootFile=dir_level2+"/Advent_of_code_"+str(YEAR)+"_"+str(date)
        for tail in TAIL_FILE:
            create_file(RootFile+tail)