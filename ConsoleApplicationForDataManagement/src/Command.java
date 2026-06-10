public class Command {
    private  Action action; //будет содержать дейтсвия которые пользователь ввел
    private String data; //будет содержать даные которые пользователь ввел

    public Command(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public String getData() {
        return data;
    }

    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }
}
