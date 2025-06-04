import GuessResult.GuessResult;

public class Game {
    public String question;

    public GuessResult guess(String guessNumber){
        assertIllegalArgument(guessNumber);

        if(guessNumber.equals(question)){
            return new GuessResult(true, 3,0);
        }
        else {
            int strikes = 0;
            int balls =0;

            for(int answeridx =0; answeridx < 3; answeridx++) {
                for (int guessidx = 0; guessidx < 3; guessidx++) {
                    if (question.charAt(answeridx) == guessNumber.charAt(guessidx) && answeridx == guessidx) {
                        strikes++;
                    } else if (question.charAt(answeridx) == guessNumber.charAt(guessidx)) balls++;
                }
            }


            return new GuessResult(false, strikes,balls);
        }

    }


    private void assertIllegalArgument(String guessNumber) {
        if(guessNumber == null){
            throw new IllegalArgumentException();
        }

        if(guessNumber.length() != 3){
            throw new IllegalArgumentException();
        }

        for(char number : guessNumber.toCharArray()){
            if(number < '0' || number > '9'){
                throw new IllegalArgumentException();
            }
        }

        if(isDuplicateNumber(guessNumber)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
