import java.awt.*; // for Color

//Birds show up as blue on the interface. They will move in a clockwise pattern
//around the grid. They will attack by pouncing, or roar if their opponent is
//an ant. Their symbol rotates depending on which direction they are moving. The
//north direction is ^, the south is V, east is >, and west is <. They default
//to the Critter action of never eating when encountering food.
public class Bird extends Critter {
   
   private Direction lastmove;
   private int movecount;
   
   //Sets the last move of the bird object to North and puts their move count at 0.
   public Bird () {
      this.lastmove = Direction.NORTH;
      this.movecount = 0;
   }
   
   //Bird will roar if the opponent is an ant, or pounce otherwise. The attack
   //type is returned.
	public Attack fight(String opponent) {
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
	      return Attack.POUNCE;
      }
	}

   //Returns the color blue for the bird objects.
   public Color getColor() {
   	return Color.BLUE;
	}

   //Each bird will move three times in one direction, moving in a clockwise
   //pattern around the grid. Returns the direction the bird should move next.
	public Direction getMove() {
      if (this.movecount < 3) {
         this.movecount++;
         return this.lastmove;
      } else {
         this.movecount = 1;
         if (this.lastmove == Direction.NORTH) {
            this.lastmove = Direction.EAST;
         } else if (this.lastmove == Direction.EAST) {
            this.lastmove = Direction.SOUTH;
         } else if (this.lastmove == Direction.SOUTH) {
            this.lastmove = Direction.WEST;
         } else { // WEST
            this.lastmove = Direction.NORTH;
         }
         return this.lastmove;
     }
   } 

   //Returns the symbol for the bird, depending on which direction it is moving.
	public String toString() {
      if (this.lastmove == Direction.NORTH) {
         return "^";      
      } else if (this.lastmove == Direction.EAST) {
         return ">";
      } else if (this.lastmove == Direction.SOUTH) {
         return "V";
      } else { // WEST 
         return "<";
      }
	}
}