import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class Process {
    final int POINT_RADIUS = 10;
    final int LIFE_SIZE = 50;
    final int FIELD_SIZE = (LIFE_SIZE + 1) * POINT_RADIUS + 3;
    final int BTN_PANEL = 50;
    final int MOUSE_BUTTON_LEFT = 1;
    final int MOUSE_BUTTON_RIGHT = 3;
    int Speed = 350;

    int[][] lifeGeneration = new int[LIFE_SIZE][LIFE_SIZE];
    int[][] nextGeneration = new int[LIFE_SIZE][LIFE_SIZE];
    volatile boolean PlayGeneration = false;

    JFrame frame;
    Canvas canvasPanel;

    void go() {
        frame = new JFrame("WireWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FIELD_SIZE - 13, FIELD_SIZE + BTN_PANEL + 7);
        frame.setLocation(450, 100);
        frame.setResizable(false);


        canvasPanel = new Canvas(lifeGeneration, LIFE_SIZE, LIFE_SIZE, canvasPanel, POINT_RADIUS);
        canvasPanel.setBackground(Color.white);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 700, 350);

        //Create the label table
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer(50), new JLabel("Fast"));
        labelTable.put(new Integer(650), new JLabel("Slow"));
        slider.setLabelTable(labelTable);

        slider.setPaintLabels(true);

        JButton fillButton = new JButton(GetStart());
        fillButton.addActionListener(new gra.Process.FillButtonListener());

        JButton dropButton = new JButton(GetName());
        dropButton.addActionListener(new gra.Process.DropButtonListener());

        JButton saveButton = new JButton(SaveStart());
        saveButton.addActionListener(new gra.Process.SaveButtonListener());

        JButton readButton = new JButton(ReadStart());
        readButton.addActionListener(new gra.Process.ReadButtonListener());

        JCheckBox checkBoxRight = new JCheckBox("DiodaRight");
        JCheckBox checkBoxLeft = new JCheckBox("DiodaLeft");

        final JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlayGeneration = !PlayGeneration;
                playButton.setText(PlayGeneration ? "Stop" : "Play");
            }
        });

    }
}
