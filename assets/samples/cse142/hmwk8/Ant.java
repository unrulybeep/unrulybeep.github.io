import java.awt.*;

//Create an Ant critter that shows as a red % on the interface. Each ant will walk
//in a repeating pattern of North or South, then East depending on what the
//walkSouth parameter determines. Ants will always eat when encountering food, and
//they will always scratch when attacked.
public class Ant extends Critter {

   private boolean walkSouth;
   private Direction lastmove;

   //Receives boolean parameter walkSouth, which determines whether the ant will
   //move South or North as a default. Gives each ant object created a last move. 
   public Ant (boolean walkSouth) {
      this.walkSouth = walkSouth;
      this.lastmove = Direction.EAST;
   }

   //Returns true so that an ant will eat everytime it encounters food.   
   public boolean eat() {
		return true;
	}
   
   //Returns the attack type scratch whenever an ant is in battle.
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
   
   // Returns red as the the color of ant critters.
	public Color getColor() {
		return Color.RED;
	}
   
   //Returns the direction the ant will move. If the last direction it went was
   //east, then it moves the ant north or south depending on if the ant walkSouth
   //field. If the last diretion was north or south, the ant goes east. 
   public Direction getMove() {   
      if (this.lastmove == Direction.EAST) {
         if (this.walkSouth) {
            this.lastmove = Direction.SOUTH;
            return this.lastmove;
         } else {
            this.lastmove = Direction.NORTH;
            return this.lastmove;
         }
      } else {
         this.lastmove = Direction.EAST;
         return this.lastmove; 
	   }
   }

	// Returns % as a string to symbolize an ant on the interface.
	public String toString() {
		return "%";
	}
}