public class ProcessGame {

    /**Arrays of each selected door (true/false for car/goat) for each iteration*/
    private boolean[] stayResults, switchResults;
    private int iterations;
    private boolean pleaseDelete;

    /**Creates a game and makes a random selection. Then stores the results in respective array for each iteration
     *
     * @param iterations How many times to run the simulation
     * @param doorCount How many doors in the game
     */
    public ProcessGame(int iterations, int doorCount)
    {
        this.iterations = iterations;
        stayResults = new boolean[iterations];
        switchResults = new boolean[iterations];

        for(int i = 0; i < iterations; i++)
        {
            Game game = new Game(doorCount);

            int selection = (int)(doorCount*Math.random());
            stayResults[i] = game.getDoors().get(selection).getContents();
            switchResults[i] = game.getDoors().get(game.switchDoor(selection)).getContents();
        }
    }

    /** Determines the success rate of the simulation strategy (stay or switch)
     *
     * @param positives How many times was the car door selected or switched to
     * @return The percent value for how often the car door was chosen
     */
    public double calculatePercent(int positives)
    {
        return (double)(positives) / iterations * 100;
    }

    /**Counts the number of cars (true) in the results array
     *
     * @param results Which array to count car door selections in (stay or switch)
     * @return The number of car doors selected or switched to
     */
    public int countCars(boolean[] results)
    {
        int count = 0;
        for(int i = 0; i < iterations; i++)
        {
            if(results[i])
                count++;
        }
        return count;
    }

    /**Gives the results for staying in a boolean array
     *
     * @return Returns the boolean array of stay-at-door results (true/false)
     */
    public boolean[] getStayResults()
    {
        printArray(stayResults, "StayResults");
        return stayResults;
    }

    /**Gives the results for switching in a boolean array
     *
     * @return Returns the boolean array of switch-door results (true/false)
     */
    public boolean[] getSwitchResults()
    {
        printArray(switchResults, "SwitchResults");
        return switchResults;
    }

    /**Prints the results array
     *
     * @param array The result array being printed
     * @param arrayType Which result array is being printed
     */
    public void printArray(boolean[] array, String arrayType)
    {
        System.out.print(arrayType + ": [");
        for(int i = 0; i < array.length-1; i++)
            System.out.print(array[i] + ", ");
        System.out.print(array[array.length-1] + "] \n");
    }
}
