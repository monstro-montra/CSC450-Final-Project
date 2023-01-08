#include <iostream>
#include <thread>
#include <chrono>


void count(int amt, char whichWay, int speed){

    switch(whichWay){
        case 'f': //f stands for forward. when it whichWay is set to 'f' count forward.
            for (int i = 0; i <= amt; i++){ //start at 0 until i > amt. increment starting at 0
                std::cout << i << " ";
                std::this_thread::sleep_for(std::chrono::milliseconds (speed)); //tell the thread to wait for 500 milliseconds
            }
            std::cout << "Thread " << std::this_thread::get_id() << " finished!" << std::endl;
            break; //break from case

        case 'r': //if whichWay is set to 'r', count backwards
            for (int i = amt; i >= 0; i--){ //start at amt until i == 0. decrement starting at amt.
                std::cout << i << " ";
                std::this_thread::sleep_for(std::chrono::milliseconds (speed)); //tell the thread to wait for 500 milliseconds
            }
            std::cout << "Thread " << std::this_thread::get_id() << " finished!" << std::endl;
            break; //break from case

        default: //default case
            std::cout << "Wrong input." << std::endl;
            break;
    }
}

int main() {

    std::thread thread1{&count, 20, 'f', 250}; //create a new thread that calls the count function. this will immediately call the function.
    std::cin.get(); //wait for user to press enter.
    thread1.join(); //syncs functions and returns the thread.

    std::thread thread2(&count, 20, 'r', 250); //create a new thread that calls the count function. this will immediately call the function.
    std::cin.get(); //wait for user to press enter.
    thread2.join(); //syncs functions and returns the thread.

    return 0;
}
