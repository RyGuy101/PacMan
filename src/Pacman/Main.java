package Pacman;

/*************************************************
 * ©2012 Ryan Nemiroff
 * version 4.5 2/18/11
 * Git and subversion are both not working! Urgh!
 *************************************************/
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main extends JComponent implements KeyListener, ActionListener, Runnable
{

    public Pacman pacman;
    public JFrame pacFrame;
    public Timer paintTicker;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int width = (int) (height * 0.625);
    private Timer pacManTicker;
    public URL pacSongAddress;
    private AudioClip pacSong;
    private int dNumber = 0;
    private int fNumber = 0;
    private int gNumber = 0;
    private int iNumber = 0;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Main());
    }

    @Override
    public void run()
    {
        pacSongAddress = getClass().getResource("PacManGhosts32.wav");
        setPacSong(Applet.newAudioClip(pacSongAddress));
        pacman = new Pacman();
        paintTicker = new Timer(15, this);
        pacManTicker = new Timer(15, pacman);
        paintTicker.start();
        pacFrame = new JFrame("Pac Man");
        pacFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacFrame.setSize(width, height);
        pacFrame.add(this);
        pacFrame.addKeyListener(this);
        pacFrame.setVisible(true);
        pacman.setFrameHeight(pacFrame.getHeight());
        pacman.makeWallsAndDots();
        if (iNumber == 0)
        {
            pacman.setStartAngle(0);
            pacman.setExtent(360);
            iNumber = 1;
        }
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        pacman.paintSelf(g2);
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        if (pacman.isEnd() == false && pacman.isStart() == true)
        {

            if (pacman.geteNumber() == 1)
            {
                if (e.getKeyCode() == 37)//left
                {
                    pacman.setCheckLeft(1);
                }
                if (e.getKeyCode() == 38)//up
                {
                    pacman.setCheckUp(1);
                }
                if (e.getKeyCode() == 39)//right
                {
                    pacman.setCheckRight(1);
                }
                if (e.getKeyCode() == 40)//down
                {
                    pacman.setCheckDown(1);
                }
            }
        } else
        {
            pacSong.stop();
        }
        if (pacman.getiNumber() == 1)
        {
            gNumber = 0;
        }
        if (e.getKeyCode() == 32 && fNumber == 0)
        {
            pacman.setlNumber(1);
            pacManTicker.start();
            dNumber = 1;
            pacman.setStart(true);
            pacman.setOpening(true);
            pacman.setStartAngle(0);
            pacman.setExtent(360);
            if (pacman.getmNumber() == 1)
            {
                pacman.setReset(true);
                getPacSong().stop();
            }
        }
        if (e.getKeyCode() == 32 && fNumber == 1 && pacman.getiNumber() == 0 && pacman.getmNumber() == 0 && pacman.isPausePlay() == true)
        {
            pacman.setkNumber(1);
            pacManTicker.stop();
            pacman.seteNumber(0);
            getPacSong().stop();
        }
        if (e.getKeyCode() == 32 && gNumber == 1 && fNumber == 1 && pacman.getmNumber() == 0 && pacman.isPausePlay() == true)
        {
            pacman.setkNumber(0);
            pacManTicker.start();
            pacman.seteNumber(1);
            getPacSong().loop();
        }
        if (pacman.getmNumber() == 1)
        {
            fNumber = 0;
            dNumber = 0;
        }
        if (dNumber == 1)
        {
            setfNumber(1);
        }
        if (pacman.geteNumber() == 0)
        {
            gNumber = 1;
        }
        if (pacman.geteNumber() == 1)
        {
            gNumber = 0;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == 37)//left
        {
            pacman.setCheckLeft(0);
        }
        if (e.getKeyCode() == 38)//up
        {
            pacman.setCheckUp(0);
        }
        if (e.getKeyCode() == 39)//right
        {
            pacman.setCheckRight(0);
        }
        if (e.getKeyCode() == 40)//down
        {
            pacman.setCheckDown(0);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        repaint();
        if (pacman.isStart() == false || pacman.isEnd() == true || pacman.getiNumber() == 1 && pacman.geteNumber() == 0)
        {
            pacSong.stop();
        }
        if (pacman.getpNumber() == 100)
        {
            pacSong.loop();
        }
    }

    public Timer getPacManTicker()
    {
        return pacManTicker;
    }

    public void setPacManTicker(Timer pacManTicker)
    {
        this.pacManTicker = pacManTicker;
    }

    public int getfNumber()
    {
        return fNumber;
    }

    public void setfNumber(int fNumber)
    {
        this.fNumber = fNumber;
    }

    public AudioClip getPacSong()
    {
        return pacSong;
    }

    public void setPacSong(AudioClip pacSong)
    {
        this.pacSong = pacSong;
    }
}
