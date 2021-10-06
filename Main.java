//Aaqil Khoja
//Assignment 4
//Oct 15th, 2019
//The main class implements the Car class and it's methods to carry out tasks
//main class uses stacks and stack functions

import java.util.Stack;
import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        //initializing the scanner object
        Scanner scan = new Scanner(System.in);

        //Initializing the carGarage and holderCarGarage stack with Car object
        //Car Garage has the cars parked in it
        Stack <Car> carGarage = new Stack();

        //holder car garage acts as a temporary garage while pulling out cars from carGarage
        Stack <Car> holderCarGarage=new Stack();

        //initializing the variable(s)
        String theNumPlate=null;

        //R is a spaceholder so that I can change the type of the car, A.k.a arriving or enterring

        /*car1 through car8 are just cars already in the garage
        and are already initialized with some data for some cars already present*/
        Car car1 = new Car('R', "STR543");
        Car car2 = new Car('R', "AND444");
        Car car3 = new Car('R', "RRD443");
        Car car4 = new Car('R', "GHH444");
        Car car5 = new Car('R', "LLR332");
        Car car6 = new Car('R', "CUSTOM");
        Car car7 = new Car('R', "IMRICH");
        Car car8 = new Car('R', "ANZ443");

        /*carHold is an object that stores a car's data when it is being
        removed to allow other cars to leave. It is initialized irrelevant data*/

        //carHold goes inside the holderCarGarage

        Car carHold = new Car('R',"AAA111");

        //Pushing car1-car8 into the carGarage stack and setting's it type to A for arrive

        car1.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car1.getNumPlate() +" and the type has been set to "+car1.getType());
        carGarage.push(car1);

        car2.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car2.getNumPlate() +" and the type has been set to "+car2.getType());
        carGarage.push(car2);

        car3.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car3.getNumPlate() +" and the type has been set to "+car3.getType());
        carGarage.push(car3);

        car4.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car4.getNumPlate() +" and the type has been set to "+car4.getType());
        carGarage.push(car4);

        car5.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car5.getNumPlate() +" and the type has been set to "+car5.getType());
        carGarage.push(car5);

        car6.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car6.getNumPlate() +" and the type has been set to "+car6.getType());
        carGarage.push(car6);

        car7.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car7.getNumPlate() +" and the type has been set to "+car7.getType());
        carGarage.push(car7);

        car8.setType('A');
        System.out.println("The car has approached the garage and is enterring the garage now. It's number plate is "+car8.getNumPlate() +" and the type has been set to "+car8.getType());
        carGarage.push(car8);
        
        //This line prints the amount of cars currently in the garage
        System.out.println("There are "+ carGarage.size() + " car(s) in the garage.");
        //For loop just so the progam works 20 times
        for(int i=0;i<20;i++){

            //Asking user if they want to enter the garage
            System.out.println("Would you like to enter the Garage? (y/n)");
            //Stores the answer of the user
            String answer = scan.nextLine();

            //to check if there is space in the garage if a car arrives
            //and putting the car in the garage if there is space
            if(answer.equalsIgnoreCase("y")){
                //Checking if the garage is full or not. Garage max capacity is 10 cars
                if(carGarage.size()<10){
                    //Asking the user for their number plate as an ID for the car
                    System.out.println("Please enter number plate number to identify your car when it's time to depart from the garage:");
                    //Storing the number plate of the user in numPlate
                    String numPlate = scan.nextLine();

                    //creating a new Car object to add to the garage and pushing it
                    Car newCar = new Car('A', numPlate);
                    System.out.println("The car with number plate " +newCar.getNumPlate()+" has been parked in the garage. Type set to " +newCar.getType());
                    carGarage.push(newCar);
                    System.out.println("There are " +carGarage.size() + " cars in the garage.");
                }
                //If the garage is full
                else{
                    System.out.println("No more room in the Garage.");
                }
            }

            //Asking a user if they would like to take their car out from the garage
            System.out.println("Would you like to take your car from the garage? (y/n)");
            //Storing the answer of the user
            String answer2 = scan.nextLine();

            //This is loop works if the user wants to take a car out of the garage
            if(answer2.equalsIgnoreCase("y")){
                //asking the user to enter their number plate to fetch the car from the garage (stack)
                System.out.println("Enter the Number Plate:");
                //Storing the number plate into theNumPlate
                theNumPlate = scan.nextLine();

                //Creating a new object with the number plate entered from the user and using 'R' as a placeholder for type
                Car searcher = new Car('R', theNumPlate);

                //while the stack carGarage is not empty, this while loop will work
                while(!carGarage.isEmpty()){

                    //popping a Car object from the stack to compare with the number plate entered by the user
                    carHold=carGarage.pop();

                    //this if statement compares the number plates of popped Car object and the entered number plate
                    //if not true
                    //.equals() compares the number plates as they are both strings
                    if(!searcher.getNumPlate().equals(carHold.getNumPlate())){
                        //increment the amount of times the car has been moved
                        //the amount of times moved will be zero if the car wasn't moved to the holderCarGarage and was directly taken out of the garage
                        carHold.move();
                        //pushing carHold to holderCarGarage
                        holderCarGarage.push(carHold);
                    }

                    else{
                        //If the number plate of the car in the garage matches the car garage
                        carHold.setType('D');
                        System.out.println(carHold.toString());

                        //putting cars back in original stack
                        //while the holderCarGarage stack is not empty, we will push the Cars in the holderCarGarage into the carGarage
                        while(!holderCarGarage.empty()){
                            //popping the Cars in the holderCarGarage stack and pushing them into carGarage
                            carGarage.push(holderCarGarage.pop());
                        }
                        //Printing the amount of cars in carGarage
                        System.out.println("There are " + carGarage.size() + " cars in the garage.");
                        //breaking out of the loop
                        break;
                    }

                    //This if statement works if we have checked the carGarage stack for the desired number plate and still haven't found the desired Car
                    if(carGarage.isEmpty()){
                        //print statement letting the user know their car isn't in the garage
                        System.out.println("Sorry, your car isn't in the garage.");

                        while(!holderCarGarage.empty()){
                            carHold=holderCarGarage.pop();
                            carHold.unMove();
                            carGarage.push(carHold);
                        }
                        break;
                    }
                    //System.out.println((carGarage.pop()).toString());

                }

            }
            //if the answer is n by the user
            else if(answer2.equalsIgnoreCase("n")){

                System.out.println("Okay then, the cars stay.");
            }

        }
    }
}

