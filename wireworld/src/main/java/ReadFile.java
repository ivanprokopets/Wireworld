import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    private int[][] tabl;
    private Canvas canvasPanel;

    public ReadFile(int[][] tabl, Canvas canvasPanel) {
        this.tabl = tabl;
        this.canvasPanel = canvasPanel;
    }

    public void read() {
        String str = null;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "*.*");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                LineNumberReader lnr = new LineNumberReader(new BufferedReader(new FileReader(fc.getSelectedFile())));
                Pattern p1 = Pattern.compile(".*ElectronHead: (\\d+), (\\d+)");
                Pattern p2 = Pattern.compile(".*ElectronTail: (\\d+), (\\d+)");
                Pattern p3 = Pattern.compile(".*Field: (\\d+), (\\d+)");
                while (((str = lnr.readLine()) != null)) {
                    Matcher m = p1.matcher(str);
                    Matcher m2 = p2.matcher(str);
                    Matcher m3 = p3.matcher(str);
                    if (m.find()) {
                        int l = Integer.parseInt(m.group(1));
                        int k = Integer.parseInt(m.group(2));
                        tabl[l][k] = 3;
                    }
                    if (m2.find()) {
                        int l = Integer.parseInt(m2.group(1));
                        int k = Integer.parseInt(m2.group(2));
                        tabl[l][k] = 2;
                    }
                    if (m3.find()) {
                        int l = Integer.parseInt(m3.group(1));
                        int k = Integer.parseInt(m3.group(2));
                        tabl[l][k] = 1;
                    }
                }
                lnr.close();
            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error in opening FILE\n");
            }
        }
        canvasPanel.repaint();
    }
}