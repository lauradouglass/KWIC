import javax.swing.*;
import java.awt.*;

public class fileChooserTest {
    //Create a file chooser
    final JFileChooser fc = new JFileChooser();
    private Component aComponent;
    //In response to a button click:
    int returnVal = fc.showOpenDialog(aComponent);
}
