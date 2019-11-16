import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
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
        fillButton.addActionListener(new Process.FillButtonListener());

        JButton dropButton = new JButton(GetName());
        dropButton.addActionListener(new Process.DropButtonListener());

        JButton saveButton = new JButton(SaveStart());
        saveButton.addActionListener(new Process.SaveButtonListener());

        JButton readButton = new JButton(ReadStart());
        readButton.addActionListener(new Process.ReadButtonListener());

        final JCheckBox checkBoxRight = new JCheckBox("DiodaRight");
        final JCheckBox checkBoxLeft = new JCheckBox("DiodaLeft");

        final JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlayGeneration = !PlayGeneration;
                playButton.setText(PlayGeneration ? "Stop" : "Play");
            }
        });
        canvasPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int z = e.getX() / 10;
                int q = e.getY() / 10;
                if (e.getButton() == MOUSE_BUTTON_LEFT) {
                    if (checkBoxRight.isSelected()) {
                        lifeGeneration[z][q] = 1;
                        lifeGeneration[z + 2][q] = 1;
                        lifeGeneration[z + 3][q] = 1;
                        lifeGeneration[z + 4][q] = 1;
                        lifeGeneration[z + 5][q] = 1;
                        lifeGeneration[z + 6][q] = 1;
                        lifeGeneration[z - 1][q] = 1;
                        lifeGeneration[z - 2][q] = 1;
                        lifeGeneration[z - 3][q] = 1;
                        lifeGeneration[z - 4][q] = 1;
                        lifeGeneration[z - 5][q] = 1;
                        lifeGeneration[z + 1][q] = 0;
                        lifeGeneration[z][q + 1] = 1;
                        lifeGeneration[z + 1][q + 1] = 1;
                        lifeGeneration[z][q - 1] = 1;
                        lifeGeneration[z + 1][q - 1] = 1;
                    }
                    else if (checkBoxLeft.isSelected()) {
                        lifeGeneration[z][q] = 1;
                        lifeGeneration[z + 1][q] = 1;
                        lifeGeneration[z + 2][q] = 1;
                        lifeGeneration[z + 3][q] = 1;
                        lifeGeneration[z + 4][q] = 1;
                        lifeGeneration[z + 5][q] = 1;
                        lifeGeneration[z - 1][q] = 1;
                        lifeGeneration[z - 2][q] = 1;
                        lifeGeneration[z - 3][q] = 1;
                        lifeGeneration[z - 4][q] = 1;
                        lifeGeneration[z - 5][q] = 1;
                        lifeGeneration[z - 6][q] = 1;
                        lifeGeneration[z - 1][q] = 0;
                        lifeGeneration[z][q - 1] = 1;
                        lifeGeneration[z - 1][q - 1] = 1;
                        lifeGeneration[z][q + 1] = 1;
                        lifeGeneration[z - 1][q + 1] = 1;
                    } else {
                        lifeGeneration[z][q] = 1;
                    }

                    if (e.getClickCount() == 2) {
                        lifeGeneration[z][q] = 0;
                    }

                }
                if (e.getButton() == MOUSE_BUTTON_RIGHT) {
                    lifeGeneration[z][q] = 2;
                    if (e.getClickCount() == 2) {
                        lifeGeneration[z][q] = 3;
                    }
                }
                canvasPanel.repaint();
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(fillButton);
        btnPanel.add(slider);
        btnPanel.add(playButton);
        btnPanel.add(dropButton);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(readButton);
        buttonPanel.add(checkBoxRight);
        buttonPanel.add(checkBoxLeft);

        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.getContentPane().add(BorderLayout.NORTH, btnPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.setVisible(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                Speed = source.getValue();
            }
        });

        while (true) {
            if (PlayGeneration) {
                ProcessOfLife processOfLife = new ProcessOfLife(lifeGeneration, nextGeneration, LIFE_SIZE, LIFE_SIZE, canvasPanel);
                processOfLife.processOfLife();
                canvasPanel.repaint();
                try {
                    Thread.sleep(Speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String newGame = "New Game";
    private String startGame = "Step";
    private String saveGame = "Save";
    private String readGame = "Upload";

    public String GetName() {
        return newGame;
    }

    public String GetStart() {
        return startGame;
    }

    public String SaveStart() {
        return saveGame;
    }

    public String ReadStart() {
        return readGame;
    }

    public class FillButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            ProcessOfLife processOfLife = new ProcessOfLife(lifeGeneration, nextGeneration, LIFE_SIZE, LIFE_SIZE, canvasPanel);
            processOfLife.processOfLife();
        }
    }

    public class DropButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            NewLife newLife = new NewLife(lifeGeneration, LIFE_SIZE, LIFE_SIZE, canvasPanel);
            newLife.newLife();
        }
    }

    public class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            SaveFile saveFile = new SaveFile(lifeGeneration, LIFE_SIZE, LIFE_SIZE);
            saveFile.save();
        }
    }

    public class ReadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            ReadFile readFile = new ReadFile(lifeGeneration, canvasPanel);
            readFile.read();
        }
    }

    public class DiodaListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            ReadFile readFile = new ReadFile(lifeGeneration, canvasPanel);
            readFile.read();
        }
    }

}

