import java.util.ArrayList;

public class Game {
    ArrayList<QuestionBlock> questionBlocks = new ArrayList<QuestionBlock>();
    ArrayList<Client> clients = new ArrayList<Client>();

    boolean isSelection;
    boolean isQuestion;

    public Game() {
    }

    public Game(ArrayList<QuestionBlock> questionBlocks, ArrayList<Client> clients) {
        this.questionBlocks = questionBlocks;
        this.clients = clients;
    }

    public Game(ArrayList<QuestionBlock> questionBlocks, ArrayList<Client> clients, boolean isSelection, boolean isQuestion) {
        this.questionBlocks = questionBlocks;
        this.clients = clients;
        this.isSelection = isSelection;
        this.isQuestion = isQuestion;
    }

    public ArrayList<QuestionBlock> getQuestionBlocks() {
        return questionBlocks;
    }

    public void setQuestionBlocks(ArrayList<QuestionBlock> questionBlocks) {
        this.questionBlocks = questionBlocks;
    }

    public void addQuestionBlock(QuestionBlock questionBlock) {
        questionBlocks.add(questionBlock);
    }

    public void removeQuestionBlockByIndex(int index) {
        questionBlocks.remove(index);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public boolean isSelection() {
        return isSelection;
    }

    public void setSelection(boolean selection) {
        isSelection = selection;
    }

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setQuestion(boolean question) {
        isQuestion = question;
    }

    @Override
    public String toString() {
        return "Game{" +
                "questionBlocks=" + questionBlocks +
                ", clients=" + clients +
                ", isSelection=" + isSelection +
                ", isQuestion=" + isQuestion +
                '}';
    }
}
