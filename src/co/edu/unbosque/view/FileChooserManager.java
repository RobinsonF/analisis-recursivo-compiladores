package co.edu.unbosque.view;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooserManager {

    private JFileChooser fileChooser;

    public FileChooserManager() {
        fileChooser = new JFileChooser();
    }

    public File getSelectedTextFile() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public File getSelectedReadableFile() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Readable Files", "txt", "java", "py", "properties", "c", "cpp", "cs", "go", "js", "m", "php", "pl", "rb", "rs", "swift"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }
}
