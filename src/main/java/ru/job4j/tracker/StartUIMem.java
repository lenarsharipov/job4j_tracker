package ru.job4j.tracker;

import java.util.List;

public class StartUIMem {
    private final Output out;

    public StartUIMem() {
        this.out = new ConsoleOutput();
    }

    public StartUIMem(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleInput()
        );

        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new CreateManyItems(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new DeleteAllItems(output),
                new FindAllAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction()
        );
        new StartUIMem().init(input, tracker, actions);
    }
}
