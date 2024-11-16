import config.Database;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryImpl;
import services.TodoListServiceImpl;
import services.TodoListService;
import views.TodoListTerminalViewImpl;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("todo", "root", "", "localhost","3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalViewImpl(todoListService);
        todoListView.run();
    }
}