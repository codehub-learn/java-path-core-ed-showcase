package gr.codelearn.core.showcase.oop.interfaces;

public class EnemyShip extends SpaceShip implements Movable, Explodable {

    private int size;

    public EnemyShip(int size, int x, int y) {
        super(x, y);
        this.size = size;
    }

    @Override
    public void shoot() {
        System.out.println("EnemyShip: Shoot the gun....");
    }

    @Override
    public void spaceJump(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void increaseSpeed(int speed) {
        System.out.println("Speed's changed to: " + speed);
    }

    
    @Override
    public void explode() {
        System.out.println("Rock... Just exploded...");
    }

}
