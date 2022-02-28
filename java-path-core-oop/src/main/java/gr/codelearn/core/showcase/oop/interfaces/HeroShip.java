package gr.codelearn.core.showcase.oop.interfaces;

public class HeroShip extends SpaceShip implements Explodable {

    private int bullets;

    public HeroShip(int bullets, int x, int y) {
        super(x, y);
        this.bullets = bullets;
    }

//    Move the code to the parent class
//    // works in inheritance but not if polymorphism
    @Override
    public void shoot() {
        System.out.println("HeroShip: Shoot the gun....");
    }
    
//    
//    public void rotate(int degress){
//        System.out.println("Change heading " + degress + " clockwise...");
//    }

    @Override
    public void explode() {
        System.out.println("HeroShip... Just exploded...");
    }

//    Access parent class methods    
//    1.
//    @Override
//    public String toString() {
//        return "HeroShip{" + "bullets=" + bullets + '}';
//    }    
//    
//    2.
//    @Override
//    public String toString() {
//        return "HeroShip{GameObject{" + "x=" + getX() + ", y=" + getY() + '}' + "bullets=" + bullets + '}';
//    }
//    3.
    @Override
    public String toString() {
        return super.toString() + " HeroShip{" + "bullets=" + bullets + '}';
    }

}
