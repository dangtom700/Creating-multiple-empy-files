#include <bits/stdc++.h>
#include <iostream>
#include <sys/stat.h>
#include <sys/types.h>
#include <string>
#include <fstream>
#include <ctime>
//Put this file at VScode directory before runnine it
void create_dir(const std::string& path){
    const char* dir_name = path.c_str();
    if (mkdir(dir_name, 0777) == -1)
        std::cerr<<"Error :  "<< strerror(errno)<<"\n";
 
    else
        std::cout<<"Directory created\n";
}
void create_files(const std::string& dir_level2,const int& year, const int& date,std::string& tail){
    std::string dir_level3a=dir_level2+"/CPP_Advent_of_code"+std::to_string(year)+"_"+std::to_string(date)+tail;
    std::ofstream file(dir_level3a);
    file.close();
    std::cout<<"File created\n";
    std::cout << "File created : " << dir_level3a << std::endl;
}
int get_current_year(){
    time_t current_time;
    current_time = time(NULL);
    int currentYear = 1970 + current_time / 31537970; 
    return currentYear;
}
void createAllCalendars(const std::string& mainRoot, const std::vector<std::string>& tails){
    const int CurrenYear = get_current_year();
    for (int year=2015; year<=CurrenYear; year++){
        std::string dir_level1=mainRoot+"/Advent_of_code_"+std::to_string(year);
        create_dir(dir_level1);
        for(int date=1;date<=25;date++){
            std::string dir_level2 = dir_level1+"/Advent_of_code_"+std::to_string(year)+"_"+std::to_string(date);
            create_dir(dir_level2);
            for(std::string tail : tails){
                create_files(dir_level2,year,date,tail);
            }
        }
    }
}
void createOneCalendar(const std::string& mainRoot, const std::vector<std::string>& tails, const int& year){
    std::string dir_level1=mainRoot+"/Advent_of_code_"+std::to_string(year);
        create_dir(dir_level1);
        for(int date=1;date<=25;date++){
            std::string dir_level2 = dir_level1+"/Advent_of_code_"+std::to_string(year)+"_"+std::to_string(date);
            create_dir(dir_level2);
            for(std::string tail : tails){
                create_files(dir_level2,year,date,tail);
            }
        }
}
int main(){
    const std::vector<std::string> tails = {"output.cpp","output.py","output.java","PuzzleInput.txt"};
    const std::string mainRoot = "AdventOfCode";
    const int year  = 2024;
    createOneCalendar(mainRoot,tails,year);
}