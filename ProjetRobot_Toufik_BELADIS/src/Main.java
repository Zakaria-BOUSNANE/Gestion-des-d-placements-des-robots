import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
    	
        // Start my window
        MyWindow3 myWindow = new MyWindow3();
        myWindow.setVisible(true);
        
    }
}