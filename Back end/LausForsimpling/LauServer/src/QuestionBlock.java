public class QuestionBlock {
    String answer;
    int points;
    String question;

    public QuestionBlock(String answer, int points, String question) {
        this.answer = answer;
        this.points = points;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionBlock{" +
                "answer='" + answer + '\'' +
                ", points=" + points +
                ", question='" + question + '\'' +
                '}';
    }
}
