import java.util.ArrayList;
import java.util.Random;

public class Todo {
    private final String name;
    private final int id;
    private final boolean completed;

    static ArrayList<Todo> todos = new ArrayList<>();
    static Random random = new Random();

    public Todo(String name, int id, boolean completed) {
        this.name = name;
        this.id = id;
        this.completed = completed;
    }

    /**
     * Add new todo to todo list
     *
     * @param todo new todo to be added to todo list
     * @return
     */
    public static boolean addTodo(String todo) {
        if (!todoAlreadyExist(todo)) {
            int todoId = random.nextInt(1000) + 1;
            Todo newTodo = new Todo(todo, todoId, false);

            todos.add(newTodo);

            return true;
        }

        return false;
    }

    /**
     * Remove an existing todo from todo list using todo index.
     * @param todoIndex todo index in todo list
     * @return {@link true} or {@link false}
     */
    public static boolean removeTodo(int todoIndex) {
        if (todoIndex > 0) {
            todos.remove(todoIndex);

            return true;
        }

        return false;
    }

    /**
     * Marks a todo completed
     *
     * @param todoIndex todo index in todo list
     * @return {@link true} or {@link false}
     */
    public static boolean markTodoCompleted(int todoIndex) {
        if (todoIndex >= 0) {
            Todo todo = todos.get(todoIndex);

            Todo updatedTodo = new Todo(todo.name, todo.id, true);
            todos.set(todoIndex, updatedTodo);

            return true;
        }

        return false;
    }

    /**
     * Removes completed todos from todo list
     */
    public static void clearCompletedTodos() {
        ArrayList<Todo> filteredTodos = new ArrayList<>();

        for (Todo todo : todos) {
            if (!todo.completed) filteredTodos.add(todo);
        }

        todos = filteredTodos;
    }

    /**
     * Clear all todos
     */
    public static void clearAllTodos() {
        todos.clear();
        System.out.println("Todos items has been cleared successfully");
    }


    /**
     * Returns "Completed" or "Active" depending on todo status
     *
     * @param status todo.completed status i.e true or false
     * @return "Completed" or "Active"
     */
    public static String getTodoStatus(boolean status) {
        return status ? "Completed" : "Active";
    }

    /**
     * Checks if a todo already exist in todo list
     *
     * @param todo todo to check
     * @return {@link true} if todo already exist in todos otherwise {@link false}
     */
    public static boolean todoAlreadyExist(String todo) {
        if (!todo.isEmpty()) {
            for (Todo item : todos) {
                return item.getName().equalsIgnoreCase(todo);
            }
        }

        return false;
    }

    /**
     * Returns todo index using todo name
     *
     * @param todo todo name
     * @return todo index
     */
    public static int getIndex(String todo) {
        int todoIndex = -1;
        for (int index = 0; index < todos.size(); index++) {
            Todo item = todos.get(index);

            if (item.getName().equalsIgnoreCase(todo)) {
                todoIndex = index;
            }
        }

        return todoIndex;
    }

    /**
     * Returns a todo index using todo id
     *
     * @param todoId todo id
     * @return todo index
     */
    public static int getIndex(int todoId) {
        int todoIndex = -1;

        for (int index = 0; index < todos.size(); index++) {
            Todo item = todos.get(index);

            if (item.getID() == todoId) {
                todoIndex = index;
            }
        }

        return todoIndex;
    }

    /**
     * Print todos
     */
    public static void printTodos() {
        displayTodos(todos);
    }


    /**
     * Print todos
     *
     * @param status status of todos to print e.g completed or active
     */
    public static void printTodos(boolean status) {
        ArrayList<Todo> filteredTodo = new ArrayList<>();

        for (Todo todo : todos) {
            if (todo.completed == status) filteredTodo.add(todo);
        }

        displayTodos(filteredTodo);
    }

    /**
     * Displays todos in a tabular form
     *
     * @param todos todos to loop through and display
     */
    private static void displayTodos(ArrayList<Todo> todos) {
        System.out.println("\n******************************************TODO LIST******************************************\n");

        if (!todos.isEmpty()) {
            System.out.printf("%-10s\t %-15s\t %-50s\t %s\n", "S/N", "ID", "TASK", "STATUS");

            for (int index = 0; index < todos.size(); index++) {
                Todo todo = todos.get(index);
                System.out.printf("\n%-10d\t %-15d\t %-50s\t %s\n", index + 1, todo.id, todo.name.toUpperCase(), getTodoStatus(todo.completed).toUpperCase());
            }
        } else {
            System.out.println("You currently do not have any items in your todos");
        }

        System.out.println("\n*********************************************************************************************\n");
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    /**
     * Starts the todo app
     */
    public static void startApp() {
        Command.welcomeUser();
        Command.printCommandsAndTheirUsage();

        Command.runTodoApp();
    }
}
