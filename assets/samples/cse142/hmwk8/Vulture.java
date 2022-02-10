import java.awt.*; // for Color

//The Vulture functions much like the Bird. It flies in a clockwise square.
public class Vulture extends Bird {
 
   private boolean hungry;
   
   //Makes the vulture hungry.
   public Vulture() {
      this.hungry = true;
   }
   
   //If the vulture is hungry, it eats and isn't hungry anymore. Returns true if the
   //vulture eats and false if it does not.
   public boolean eat() {
      if (this.hungry) {
         this.hungry = !hungry;
         return true;
      } else {
         return false;
      }
	}
   
   //Returns the same fight pattern as birds, meaning it will roar at an ant,
   //but othewise pounce. The vulture becomes hungry when it fights.
   public Attack fight(String opponent) {
      hungry = true;
      return super.fight(opponent);
	}

   //Returns the color black for vulture critters.
	public Color getColor() {
		return Color.BLACK;
	}

}