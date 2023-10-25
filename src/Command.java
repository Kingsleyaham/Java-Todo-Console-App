import java.util.Scanner;

public class Command {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Print lists of commands to be used in todo app and their usage
     */
    public static void printCommandsAndTheirUsage() {
        System.out.println("These are our lists of Commands and their Usage: \n");
        System.out.printf("%-20s \t%s", "-help", "list all commands and their usage\n");
        System.out.printf("%-20s \t%s", "-exit", "terminate todo application in terminal\n");
        System.out.printf("%-20s \t%s", "show --all", "list all todos\n");
        System.out.printf("%-20s \t%s", "show --active", "list all active todos\n");
        System.out.printf("%-20s \t%s", "show --completed", "list all completed todos\n");
        System.out.printf("%-20s \t%s", "remove- <todoID | todoName>", "removes the todo e.g 'remove- 2' or 'remove- wash plate' deletes the todo from todo list\n");
        System.out.printf("%-20s \t%s", "remove --all", "remove all  todos\n");
        System.out.printf("%-20s \t%s", "remove --completed", "clear all completed todos\n");
        System.out.printf("%-20s \t%s", "completed- <todoID | todoName>", "marks the todo completed e.g 'completed- 2' or 'completed- wash plate', marks the todo completed\n\n");
    }

    /**
     * Runs todo app
     */
    static void runTodoApp() {
        System.out.print("Please enter a list item to add or a command to perform: ");

        try {
            String str = scanner.nextLine().trim().toLowerCase();

            if (!str.isEmpty()) {
                if (!str.contains("-") && !str.startsWith("completed")) {
                    if (Todo.addTodo(str)) {
                        System.out.println("Todo added successfully\n");
                        runTodoApp();
                    }

                    System.out.println("Todo already exist in todos\n");
                    runTodoApp();
                }

                runCommand(str);
            }

            runTodoApp();
        }
        catch (Exception e) {
            System.out.println(ConsoleColors.RED + e.getMessage() + ConsoleColors.RESET);
        }

    }

    /**
     * Perform an action based on a command given to it
     *
     * @param str a string illustrating command to perform
     */
    private static void runCommand(String str) {
        String command = (str.contains("remove-")) ? "remove-" : (str.contains("completed-")) ? "completed-" : str;

        switch (command) {
            case "-help" -> printCommandsAndTheirUsage();
            case "-exit" -> exitTodoApp();
            case "show --all" -> Todo.printTodos();
            case "show --active" -> Todo.printTodos(false);
            case "show --completed" -> Todo.printTodos(true);
            case "remove --all" -> Todo.clearAllTodos();
            case "remove --completed" -> {
                Todo.clearCompletedTodos();
                System.out.println("Completed Todos cleared successfully");
            }
            case "remove-" -> {
                String substr = str.substring(7).trim();
                try {
                    int todoIndex = Todo.getIndex(Integer.parseInt(substr));
                    if (todoIndex >= 0) {
                        Todo.removeTodo(todoIndex);
                        System.out.println("todo removed successfully");
                    } else {
                        throw new IndexOutOfBoundsException("Invalid todo id or name provided");
                    }

                } catch (NumberFormatException e) {
                    int todoIndex = Todo.getIndex(substr);
                    if (todoIndex >= 0) {
                        Todo.removeTodo(todoIndex);
                        System.out.println("todo removed successfully");
                    } else {
                        throw new IndexOutOfBoundsException("Invalid todo id or name provided");
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println(ConsoleColors.RED +  e.getMessage() + ConsoleColors.RESET);
                }
            }
            case "completed-" -> {
                String substr = str.substring(10).trim();
                try {
                    int todoIndex = Todo.getIndex(Integer.parseInt(substr));

                    if (todoIndex >= 0) {
                        Todo.markTodoCompleted(todoIndex);
                        System.out.println("todo marked completed");
                    } else {
                        throw new IndexOutOfBoundsException("Invalid todo id or name provided");
                    }
                } catch (NumberFormatException e) {
                    int todoIndex = Todo.getIndex(substr);
                    if (todoIndex >= 0) {
                        Todo.removeTodo(todoIndex);
                        System.out.println("todo marked completed");
                    } else {
                        throw new IndexOutOfBoundsException("Invalid todo id or name provided");
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println(ConsoleColors.RED +  e.getMessage() + ConsoleColors.RESET);
                }
            }
            default -> System.out.println(ConsoleColors.RED +  "invalid command" + ConsoleColors.RESET);
        }

        runTodoApp();
    }

    public static void welcomeUser() {
        System.out.print("Please Enter your username: ");
        String username = scanner.nextLine();

        if (!username.isEmpty()) {
            System.out.printf("%nWelcome %s to our Todo Console App with Complete Todo Functionality\n\n", username);
        } else {
            welcomeUser();
        }
    }

    private static void exitTodoApp() {
        throw new RuntimeException("todo app stopped abruptly");
    }
}
