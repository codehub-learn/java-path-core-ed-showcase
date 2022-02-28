package gr.codelearn.core.showcase.oop.interfaces;

public abstract class SpaceShip extends GameObject {

    public SpaceShip(int x, int y) {
        super(x, y);
    }

//    public void shoot(){
//        System.out.println("SpaceShip: Shoot the gun....");
//    }
    public abstract void shoot();

    public void rotate(int degress) {
        System.out.println("Change heading " + degress + " clockwise...");
    }

}
