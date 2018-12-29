
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class OrtographyPanel extends JPanel implements Runnable{

    private JMenuBar mBar;
    private JMenu styleMenu, fileMenu;
    private JMenuItem odczyt, zapis, kursywa, pogrubienie;
    private JEditorPane textPane;
    private JButton checkButton;

    private String text;
    private Font textFont;
    private File file;


    public OrtographyPanel()
    {
        this.setPreferredSize(new Dimension(600,400));
        //menu
        mBar = new JMenuBar();
        styleMenu = new JMenu("Styl");
        fileMenu = new JMenu("Plik");
        odczyt = new JMenuItem("Odczytaj z ...");
        odczyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(odczyt);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    return;
                }
                file = fileChooser.getSelectedFile();
                try
                {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader br = new BufferedReader(fileReader);

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

            }
        });
        zapis = new JMenuItem("Zapisz do ...");
        kursywa = new JMenuItem("Kursywa");
        pogrubienie = new JMenuItem("Pogrubienie");
        kursywa.setFont(new Font(kursywa.getFont().getFontName(), Font.ITALIC, kursywa.getFont().getSize()));
        pogrubienie.setFont(new Font(pogrubienie.getFont().getFontName(), Font.BOLD, pogrubienie.getFont().getSize()));
        styleMenu.add(kursywa);
        styleMenu.add(pogrubienie);
        fileMenu.add(odczyt);
        fileMenu.add(zapis);
        mBar.add(fileMenu);
        mBar.add(styleMenu);
        //text
        textPane = new JEditorPane();
        //button
        checkButton = new JButton("Sprawdź");
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH,mBar);
        this.add(BorderLayout.CENTER,textPane);
        this.add(BorderLayout.SOUTH,checkButton);
        this.setVisible(true);
    }

    @Override
    public void run() {

    }
}
