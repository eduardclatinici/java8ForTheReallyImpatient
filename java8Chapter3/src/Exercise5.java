import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class Exercise5 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("file:bigShaq.jpg");
        Image transformedImage = transform(image,(x,y,color)->x<=10||x>=image.getWidth()-10||
                                                                y<=10||y>=image.getHeight()-10 ? Color.GRAY : color);
        showImages(primaryStage, new ImageView(image), new ImageView(transformedImage));
    }

    private Image transform(Image in, ColorTransformer t) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        t.apply(x,y,in.getPixelReader().getColor(x, y)));
        return out;
    }

    @FunctionalInterface
    interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }

    private void showImages(Stage stage, ImageView image, ImageView transformedImage){
        stage.setScene(new Scene(new HBox(image,transformedImage)));
        stage.show();
    }
}
