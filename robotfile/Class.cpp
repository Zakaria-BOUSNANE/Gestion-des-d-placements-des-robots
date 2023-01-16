//#include <iostream>
#include <string>
#include<vector>
using namespace std;
#include <iostream>
#include <fstream>
//using namespace std;




//class declaration 
class car 
{

    //Public
    public:
string brand;
string color;
int year;
car(string x, string y, int z) { // Constructor with parameters
      brand = x;
      color = y;
      year = z;
    };

    //privée
    private:
int speed(int maxSpeed);
};


int car::speed(int maxSpeed) {
  return maxSpeed;
}

//main 
int main() 
{
    car ob1 ("oo","op",4); // Create an object of Car
    ob1.brand = "Chevrolet";
    ob1.color= "yello";
    ob1.year= 2006;*/
   // cout << ob1.brand << " " << ob1.color << " " << ob1.year << "\n";
    cout << ob1.speed(200)<< "\n"; // Call the method with an argument
}

/* Base class
class Vehicle {
  public:
    string brand = "Ford";
    void honk() {
      cout << "Tuut, tuut! \n" ;
    }
};

// Derived class
class Car: public Vehicle {
  public:
    string model = "Mustang";
};*/
/*
int main() {
  Car myCar;
  myCar.brand="palalala";
  myCar.honk();
  cout << myCar.brand + " " + myCar.model;
  return 0;
  }
*/
