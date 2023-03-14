package at.riedmann.games.analyze;

import at.riedmann.games.introduction.ObjectsDemo;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGames extends BasicGame {
    private Rectangle rectangle;
    private Rectangle rectangle2;
    private List<Rectangle> rectangleList;

    public ObjectsGames(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangle2 = new Rectangle(50, 400, 2);
        this.rectangleList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), 50);
            rectangleList.add(rectangle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.rectangle2.update(delta);
        for (Rectangle rectangle : this.rectangleList) {
            rectangle.update(delta);
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.rectangle2.render(graphics);
        for (Rectangle rectangle : this.rectangleList) {
            rectangle.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGames("Analyzing"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
