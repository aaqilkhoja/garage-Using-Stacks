//Aaqil Khoja
//Assignment 7
//Oct 15th, 2019
//This class is for defining the object Class of Car

public class Car{
    //declaring the variables
    private char carType;
    private String carNumPlate;
    private int movedTimes;

    //default constructor
    public Car(){
        carType='z';
        carNumPlate="null";
    }

    //conversion constructor
    public Car(char type, String aNumPlate){
        carType = type;
        carNumPlate = aNumPlate;
    }

    //Copy constructor
    public Car(Car oldCar){
        carType = oldCar.carType;
        carNumPlate = oldCar.carNumPlate;
    }

    //this method increments the amount of times a car is moved out of the garage
    public int move(){

        movedTimes++;
        return movedTimes;
    }

    //this method decrements the amount of times a car is moved out of the garage
    public int unMove(){
        movedTimes--;
        return movedTimes;
    }

    //Accessor for carType
    public char getType(){
        return carType;
    }

    //Accessor for carNumPlate
    public String getNumPlate(){
        return carNumPlate;
    }

    //Mutator for carType
    public void setType(char newType){
        carType= newType;
    }

    //Mutator for carNumPlate
    public void setNumPlate(String newNumPlate)
    {
        carNumPlate= newNumPlate;
    }

    //toString method for printing out the data in the object
    public String toString(){
        return "Car Type: " + carType + "\nCar Number Plate: " + carNumPlate +"\nMoved "+movedTimes + " times to allow other cars to leave the garage.";
    }

}
