package gr.codelearn.core.showcase.oop.interfaces;

import java.util.Objects;

public class Rock extends GameObject implements Movable, Explodable {

    private int mass;
    private RockType type;

    public Rock(int mass, RockType type, int x, int y) {
        super(x, y);
        this.mass = mass;
        this.type = type;
    }

    @Override
    public void spaceJump(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void explode() {
        System.out.println("Rock... Just exploded...");
    }


}
