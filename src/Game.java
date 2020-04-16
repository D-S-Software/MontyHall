import java.util.ArrayList;

public class Game {

    /**Array of possible doors (1 true and the rest false)*/
    private ArrayList<Boolean> rule;
    /**Array of doors in a random order*/
    private ArrayList<Door> doors;

    /** Initializes the array of doors in random order
     *
     * @param doorCount The number of doors in the game
     */
    public Game(int doorCount)
    {
        rule = new ArrayList<>();
        doors = new ArrayList<>();

        //Initializes the rule array
        rule.add(true);
        for(int i = 1; i < doorCount; i++)
        {
            rule.add(false);
        }

        //Initializes the doors array in random order
        for(int i = 0; i < doorCount; i++)
        {
            int randomIndex = (int)(rule.size()*Math.random());
            doors.add(new Door(rule.get(randomIndex)));
            rule.remove(randomIndex);
        }
    }

    /**Gives the array of doors
     *
     * @return The array of doors
     */
    public ArrayList<Door> getDoors()
    {
        return doors;
    }

    /**Takes the door selection and switches it to a goat door (if selected the car door) or a car / goat (if selected a goat door)
     *
     * @param selection The door that was chosen
     * @return The door that was switched to
     */
    public int switchDoor(int selection)
    {
        int carDoor = -1;

        for(int i = 0; i < doors.size(); i++)
            if(doors.get(i).getContents())
                carDoor = i;

        if(carDoor == -1)
            throw new IllegalArgumentException("None of the doors have a car! Time to yell at the game-maker...");

        if(doors.get(selection).getContents())
        {
            //Choose random door that is not the car
            while(doors.get(selection).getContents())
            {
                selection = (int)(doors.size()*Math.random());
            }
            return selection;
        }
        else
        {
            //Return the car door
            return carDoor;
        }
    }
}
