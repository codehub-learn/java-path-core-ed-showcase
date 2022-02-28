package gr.codelearn.core.showcase.oop.interfaces;
public interface Movable {
    public void  spaceJump(int x, int y);
    
    default void increaseSpeed(int speed){
        System.out.println("Speed's changed to: " + speed);
    }
    
}
