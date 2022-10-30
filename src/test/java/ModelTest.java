
import javafx.scene.paint.Color;
import labb3jhr.labb3.model.Model;
import labb3jhr.labb3.model.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ModelTest {
    
    
    @Test
    void callingCreateShapeResultsInShapesListHavingTheSizeOne(){
        Model model = new Model();
        model.createShape(Color.RED, 0,0,50);
        assertEquals(1, model.getShapesList().size());
    }

    @Test
    void callingCreateShapesResultsInCreatingASquare(){
        Model model = new Model();
        model.createShape(Color.RED, 0,0,50);
        assertEquals(Square.class, model.getShapesList().get(0).getClass());
    }
    
}
