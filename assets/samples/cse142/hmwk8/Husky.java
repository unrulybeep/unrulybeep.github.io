import java.awt.*; // for Color
import java.util.*; // for Random

public class Husky extends Critter {
   private static Attack[] attacks = {Attack.ROAR, Attack.SCRATCH, Attack.POUNCE};
   private static Direction[] directions = {Direction.NORTH, Direction.EAST,
                                            Direction.SOUTH, Direction.WEST};
   private static Color gold = new Color(255, 215, 0);
   private static Color purple = new Color(104, 34, 139);

   private int moves;
   private Random rand = new Random();
   
   public Husky() {
      moves = 0;
   }

   //Returns a random attack.
   private Attack randomAttack() {
      return attacks[rand.nextInt(3)];
   }
   
   //Returns a randomly selected direction.
   private Direction randomDirection() {
      return this.directions[rand.nextInt(4)];
   }
      
	public Attack fight(String opponent) {
      String naturalDigits = "123456789";
      String birds = "^v<>";
   
      // Bird and vulture roars at ants (%) and pounce otherwise
      // Ants always scratch
      if (opponent.toString().equals("0")) {
         // Full hippo will pounce
         return Attack.SCRATCH;
      } else if (naturalDigits.contains(opponent.toString())) {
         // Hungry hippo will scratch
         return Attack.ROAR;
      } else if (birds.contains(opponent.toString())) {
         // Vulture or Bird will always pounce
         return Attack.SCRATCH;
      } else if (opponent.toString().equals("%")) {
         // Ant will always scratch
         return Attack.ROAR;
      } else {
         // Unknown animal
         return randomAttack();
      }
	}
   
   //Never eat; we ate in the morning.
   public boolean eat() {
      return false;
	}

	public Color getColor() {   
      if (toString().equals("U")) {
         return purple;
      } else {
         return gold;
      }
	}

   public boolean isFoe(Direction direction) {
      String neighbor = getNeighbor(direction);
      return !" .UW".contains(neighbor);
   }

	public Direction getMove() {
      boolean foundNeighbor = false;
      String neighbor;
      Direction neighborThere = Direction.CENTER;
      int j = 0;
      
      //Find a foe.
      while (!foundNeighbor && j < 4) {
         neighborThere = directions[j];
         if (isFoe(directions[j])) {
            foundNeighbor = true;
         }
         j++;
      }

      //Attack neighbor or moves randomly.
      moves++;      
      if (foundNeighbor) {
         return neighborThere;
      } else {
         return randomDirection();
      }
	}

	public String toString() {
      if (this.moves % 2 == 0) {
         return "U";
      } else {
		   return "W";
	   }
   }
}