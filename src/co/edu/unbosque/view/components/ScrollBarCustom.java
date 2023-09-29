package co.edu.unbosque.view.components;



import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;


public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(23, 69, 23));
        setBackground(Color.WHITE);
    }
}
