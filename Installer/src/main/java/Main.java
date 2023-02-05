import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            JOptionPane.showMessageDialog(null, "This installer is Windows only.\n\nIt basically just makes the app run on startup\nso I'm sure theres a way on your machine.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Welcome to the Water Reminder installer.\nOnce you click \"OK\", the installation will begin.", "Water Reminder Installer", JOptionPane.INFORMATION_MESSAGE);
        File file = new File(System.getProperty("user.home") + "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/WaterReminder.jar");

        InputStream in = Main.class.getResourceAsStream("/WaterReminder.jar");
        OutputStream out = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, bytesRead);
        }
        out.close();

        if (JOptionPane.showConfirmDialog(null, "The installation is successful!\nWould you like to run the app?", "Water Reminder Installer", JOptionPane.YES_NO_OPTION) == 0) {
            Runtime.getRuntime().exec("java -jar \"" + file.getAbsolutePath() + "\"");
        }
    }
}
