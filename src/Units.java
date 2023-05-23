import java.awt.*;
public class Units {
    private int xCoord;
    private int yCoord;
    private int width;
    private int height;
    private int speed;
    private int damage;
    private int health;
    private Rectangle hitBox;
    private boolean collison = false;
    GamePanel gP;
    public Units(){}

    public Units(int x, int y, int w, int h, GamePanel g){
        xCoord = x;
        yCoord = y;
        width = w;
        height = h;
        gP = g;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public boolean isCollison() {
        return collison;
    }

    public void setCollison(boolean collison) {
        this.collison = collison;
    }
}
