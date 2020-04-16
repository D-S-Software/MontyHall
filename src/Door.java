public class Door {

    /**True = car, False = goat*/
    private boolean contents;

    /**Creates a door by setting the contents - either a car (true) or goat (false)
     *
     * @param set true or false
     */
    public Door(boolean set)
    {
        contents = set;
    }

    /**Returns the contents of door
     *
     * @return the contents of the door (true for car and false for goat)
     */
    public boolean getContents()
    {
        return contents;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Door)
        {
            Door door = (Door)other;
            return this.contents == door.contents;
        }
        else return false;
    }

    @Override
    public String toString()
    {
        if(this.contents)
            return "Car";
        else return "Goat";
    }
}
