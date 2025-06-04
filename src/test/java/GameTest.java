import GuessResult.GuessResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private Game game;

    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertillegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertillegalArgument(null);
        assertillegalArgument("12");
        assertillegalArgument("1234");
        assertillegalArgument("12s");
        assertillegalArgument("111");
    }

    @Test
    void returnSolvedResultIfMatchedNumber(){
        game.question = "123";
        GuessResult result = game.guess("123");

        assertThat(result).isNotNull();
        assertThat(result.solved).isEqualTo(true);
        assertThat(result.strikes).isEqualTo(3);
        assertThat(result.balls).isEqualTo(0);


    }

}