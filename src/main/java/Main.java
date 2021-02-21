import controllers.MainController;
import controllers.StoreController;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create( config -> {
            //set configs
            config.addStaticFiles("/public");

        }).start(7000);

        JavalinRenderer.register(JavalinThymeleaf.INSTANCE, ".html");


        new MainController(app).routesControl();



    }
}
