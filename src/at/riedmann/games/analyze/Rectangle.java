package at.riedmann.games.analyze;

import org.newdawn.slick.Graphics;

public class Rectangle {
    private enum DIRECTION {RIGHT, DOWN, LEFT, UP};
    private float x;
    private float y;
    private float speed;

    public Rectangle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 100,100);
    }

    public void update(int delta){
        this.x += (float) delta/this.speed;
    }
}
