import java.util.Random;

public class Face {
    //Face variables
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //constructor class to set the Face variables
    public Face(int skinColor, int eyeColor, int hairColor, int hairStyle) {
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;
        //call randomize method to set the Face variables
        randomize();
    }
    //randomize the Face variables
    void randomize() {
        //generate 5 random numbers between 1 and 5
        Random ran1 = new Random();
        int skinRan = ran1.nextInt(5-1+1) + 1;
        Random ran2 = new Random();
        int eyeRan = ran2.nextInt(5-1+1) + 1;
        Random ran3 = new Random();
        int hairColorRan = ran3.nextInt(5-1+1) + 1;
        Random ran4 = new Random();
        int hairStyleRan = ran4.nextInt(5-1+1) + 1;
        //set each random value to its given Face variable
        skinColor = skinRan;
        eyeColor = eyeRan;
        hairColor = hairColorRan;
        hairStyle = hairStyleRan;

    }
}