import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
    private int[][] tabl;
    private int widht;
    private int hegth;

    public SaveFile(int[][] tabl, int widht, int hegth) {
        this.widht = widht;
        this.hegth = hegth;
        this.tabl = tabl;
        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < hegth; y++) {
                for (int i = 0; i < tabl.length; i++) {
                    this.tabl[i] = tabl[i].clone();
                }
            }
        }
    }

    public void save() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.*");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (FileWriter writer = new FileWriter(fc.getSelectedFile())) {
                for (int x = 0; x < widht; x++) {
                    for (int y = 0; y < hegth; y++) {
                        if ((tabl[x][y]) == 3) {
                            String text = "ElectronHead: " + x + ", " + y + ";";
                            writer.write(text);
                            writer.append('\n');
                            writer.flush();
                        }
                        if ((tabl[x][y]) == 2) {
                            String text = "ElectronTail: " + x + ", " + y + ";";
                            writer.write(text);
                            writer.append('\n');
                            writer.flush();
                        }
                        if ((tabl[x][y]) == 1) {
                            String text = "Field: " + x + ", " + y + ";";
                            writer.write(text);
                            writer.append('\n');
                            writer.flush();
                        }

                    }
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}