package at.riedmann.games.introduction;

import org.newdawn.slick.*;

public class ObjectsDemo extends BasicGame {
    private float rectX;
    private float rectY;
    private float speed;
    private float ovX;
    private float ovY;
    private float circleX;
    private float circleY;
    int rectangleDirection;
    int ovalDirection;
    int circleDirection;

    public ObjectsDemo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.speed = 5;
        this.rectX = 50;
        this.rectY = 50;
        this.ovX = 50;
        this.ovY = 50;
        this.circleX = 50;
        this.circleY = 50;
        this.rectangleDirection = 1;
        this.ovalDirection = 1;
        this.circleDirection = 1;

    }
    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //move right
        if (this.rectX == 50 && this.rectY == 50){
            this.rectangleDirection = 1;
        }

        if (this.rectX < 650 && this.rectY == 50 && this.rectangleDirection == 1){
            this.rectX += (float) delta/this.speed;

        }
            else if (this.rectangleDirection == 1){
                this.rectX = 650;
                this.rectangleDirection = 2;
        }

        //move down
        if (this.rectX == 650 && this.rectY < 650 && this.rectangleDirection == 2){
            this.rectY += (float) delta/this.speed;
        }
         else if (this.rectangleDirection == 2){
             this.rectY = 650;
             this.rectangleDirection = 3;
        }

         //move left
        if (this.rectX > 50 && this.rectY == 650 && this.rectangleDirection == 3){
            this.rectX -= (float) delta/this.speed;
        }
        else if (this.rectangleDirection == 3){
            this.rectX = 50;
            this.rectangleDirection = 4;
        }

        //move up
        if (this.rectX == 50 && this.rectY >50 && this.rectangleDirection == 4){
            this.rectY -= (float) delta/this.speed;
        }
        else if (this.rectangleDirection == 4) {
            this.rectY = 50;
            this.rectangleDirection = 1;
        }
        //oval
        if (this.ovX <= 650 && ovalDirection == 1){
            this.ovX += (float) delta/this.speed;
        }
        else if (this.ovX >= 50){
            this.ovX -= (float) delta/this.speed;
            ovalDirection = 0;
        }
        else {
            ovalDirection = 1;
        }

        //circle
        if (this.circleY <= 650 && circleDirection == 1){
            this.circleY += (float) delta/this.speed;
        }
        else if (this.circleY >= 50){
            this.circleY -= (float) delta/this.speed;
            circleDirection = 0;
        }
        else {
            circleDirection = 1;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.rectX, this.rectY, 100,100);
        graphics.drawOval(this.ovX, this.ovY, 100, 20);
        graphics.drawOval(this.circleX, this.circleY, 100,100);
        graphics.drawString("This is done way to complicated!", 50,750);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsDemo("Demo by Noel"));
            container.setDisplayMode(800,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
