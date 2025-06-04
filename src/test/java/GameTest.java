import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private Game game;

    @Test
    void createGame(){
        assertNotNull(game);
    }

    @Test
    void  throwExceptionWhenInputIsNull(){
        assertThrows(IllegalArgumentException.class, () ->{
            game.guess(null);
        });
    }
}