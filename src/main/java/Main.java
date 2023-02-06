import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.Random;

public class Main {
    public static String[] messages = {
        "Time to drink some water!",
        "Make sure you have bo'oh'o'wo'oh on your side",
        "Touch some water",
        "You shall consume the liquid state of dihydrogen monoxide",
        "I'm gonna turn the computer off unless you're gonna drink water!",
        "Be careful not to spill your water on your keyboard",
        "Maybe drink some water now and clean your room, your mom will be proud",
        "Maybe you can also go outside with your water"
    };
    public static Random random = new Random();
    public static long threshold = 1 * 60 * 60 * 1000; // 1 hour
    public static long currentTime = 0;
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        while (true) {
            if (System.currentTimeMillis() - currentTime >= threshold) {
                currentTime = System.currentTimeMillis();
                String message = messages[random.nextInt(messages.length)];
                JOptionPane.showMessageDialog(null, message, "Water", JOptionPane.WARNING_MESSAGE);
            }
            Thread.sleep(1000);
        }
    }
}
