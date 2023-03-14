package at.riedmann.games.analyze;

import at.riedmann.games.introduction.ObjectsDemo;
import org.newdawn.slick.*;

public class ObjectsGames extends BasicGame {
    private Rectangle rectangle;
    private Rectangle rectangle2;

    public ObjectsGames(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangle = new Rectangle(100, 100, 5);
        this.rectangle2 = new Rectangle(50,400,2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.rectangle.update(delta);
        this.rectangle2.update(delta);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.rectangle.render(graphics);
        this.rectangle2.render(graphics);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGames("Analyzing"));
            container.setDisplayMode(800,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
