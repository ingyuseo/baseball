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
        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfUnMatchedNumber(){
        game.question = "123";
        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    @Test
    void returnSolvedResultIf_2strike_0ball(){
        game.question = "123";
        assertMatchedNumber(game.guess("125"), false, 2, 0);
    }

    @Test
    void returnSolvedResultIf_1strike_2ball(){
        game.question = "123";
        assertMatchedNumber(game.guess("132"), false, 1, 2);
    }

    @Test
    void returnSolvedResultIf_1strike_1ball(){
        game.question = "123";
        assertMatchedNumber(game.guess("137"), false, 1, 1);
    }

    private void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }
}