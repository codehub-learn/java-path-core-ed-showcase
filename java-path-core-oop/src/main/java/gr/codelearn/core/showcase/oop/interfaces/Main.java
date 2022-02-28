
package gr.codelearn.core.showcase.oop.interfaces;


public class Main {

    public static void main(String[] args) {

//        HeroShip hero = new HeroShip(22, 100, 100);
//        System.out.println(hero);

        SpaceShip hero = new HeroShip(22, 100, 100);
        SpaceShip enemy = new EnemyShip(5, 23, 45);

        GameObject ship = new HeroShip(52, 10, 10);
//        ship.shoot(); // static check error...

        hero.shoot();
        enemy.rotate(58);
        hero.rotate(100);

        GameObject rock = new Rock(100, RockType.ASTEROID, 34, 67);
        GameObject equalRock = new Rock(100, RockType.ASTEROID, 34, 67);

        System.out.println(rock == equalRock);
        System.out.println(rock.equals(equalRock));
    }
}