package Pacman;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Pacman implements ActionListener
{

    JFrame imaginaryFrame;
    private int frameHeight;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int width = (int) (height * 0.625);
    private boolean bumpLeft = false;
    private boolean bumpUp = false;
    private boolean bumpRight = false;
    private boolean bumpDown = false;
    private int bNumber = 0;
    private int cNumber = 0;
    private int eNumber = 0;
    private int hNumber = 0;
    private int iNumber = 0;
    private int jNumber = 0;
    private int kNumber = 0;
    private int lNumber = 0;
    private int mNumber = 0;
    private int nNumber = 0;
    private int oNumber = 0;
    private int pNumber = 0;
    private int goLeft = 0;
    private int goDown = 0;
    private int goRight = 0;
    private int goUp = 0;
    private int ghostLeft2 = 0;
    private int ghostDown2 = 0;
    private int ghostRight2 = 0;
    private int ghostUp2 = 0;
    private int ghostLeft1 = 0;
    private int ghostDown1 = 0;
    private int ghostRight1 = 0;
    private int ghostUp1 = 0;
    private int ghostLeft4 = 0;
    private int ghostDown4 = 0;
    private int ghostRight4 = 0;
    private int ghostUp4 = 0;
    private int ghostLeft3 = 0;
    private int ghostDown3 = 0;
    private int ghostRight3 = 0;
    private int ghostUp3 = 0;
    private int checkLeft = 0;
    private int checkDown = 0;
    private int checkRight = 0;
    private int checkUp = 0;
    private int pacManXposition;
    private int pacManYposition;
    private int ghostXposition1;
    private int ghostXposition2;
    private int ghostXposition3;
    private int ghostXposition4;
    private int ghostYposition1;
    private int ghostYposition2;
    private int ghostYposition3;
    private int ghostYposition4;
    private int startAngle = 25;
    private int extent = 310;
    private int go = 0;
    private int score = 0;
    private int lives = 3;
    private int dotCounter = 0;
    private int offsetLeft;
    private int offsetUp;
    private int offsetRight;
    private int offsetDown;
    private boolean start = false;
    private boolean end = false;
    private boolean reset = false;
    private boolean pacSongPlay = false;
    private boolean pausePlay = true;
    private boolean opening = false;
    private Arc2D.Double pacmanShape;
    private Ellipse2D.Double ghostShape1;
    private Ellipse2D.Double ghostEye1a;
    private Ellipse2D.Double ghostEye1b;
    private Arc2D.Double ghostMouth1;
    private Line2D.Double ghostEyebrow1a;
    private Line2D.Double ghostEyebrow1b;
    private Ellipse2D.Double ghostShape2;
    private Ellipse2D.Double ghostEye2a;
    private Ellipse2D.Double ghostEye2b;
    private Arc2D.Double ghostMouth2;
    private Line2D.Double ghostEyebrow2a;
    private Line2D.Double ghostEyebrow2b;
    private Ellipse2D.Double ghostShape3;
    private Ellipse2D.Double ghostEye3a;
    private Ellipse2D.Double ghostEye3b;
    private Arc2D.Double ghostMouth3;
    private Line2D.Double ghostEyebrow3a;
    private Line2D.Double ghostEyebrow3b;
    private Ellipse2D.Double ghostShape4;
    private Ellipse2D.Double ghostEye4a;
    private Ellipse2D.Double ghostEye4b;
    private Arc2D.Double ghostMouth4;
    private Line2D.Double ghostEyebrow4a;
    private Line2D.Double ghostEyebrow4b;
    private ArrayList<Line2D.Double> lineList = new ArrayList<Line2D.Double>();
    private ArrayList<Rectangle2D.Double> dotList = new ArrayList<Rectangle2D.Double>();
    private Rectangle2D.Double ghostBounds1;
    private Rectangle2D.Double ghostBounds2;
    private Rectangle2D.Double ghostBounds3;
    private Rectangle2D.Double ghostBounds4;
    private int aRemainder;
    private int randomInt1;
    private int randomInt2;
    private int randomInt3;
    private int randomInt4;
    public URL pacChompAdress;
    public AudioClip pacChomp;

    public void makeWallsAndDots()
    {
        height = frameHeight / 18 * 16;
        width = (int) (height * 0.625);
        pacChompAdress = getClass().getResource("PacManChomp2.wav");
        pacChomp = Applet.newAudioClip(pacChompAdress);
        pacManXposition = (int) (width * 0.41);
        pacManYposition = (int) (height * 0.44375);
        ghostXposition1 = (int) (width * 0.01);
        ghostXposition2 = (int) (width * 0.91);
        ghostXposition3 = (int) (width * 0.01);
        ghostXposition4 = (int) (width * 0.91);
        ghostYposition1 = (int) (height * 0.00625);
        ghostYposition2 = (int) (height * 0.00625);
        ghostYposition3 = (int) (height * 0.88125);
        ghostYposition4 = (int) (height * 0.88125);
        pacmanShape = new Arc2D.Double(getPacManXposition(), getPacManYposition(), width * 0.08, height * 0.05, getStartAngle() + getGo(), getExtent(), Arc2D.PIE);
        ghostShape1 = new Ellipse2D.Double(getGhostXposition1(), getGhostYposition1(), width * 0.08, height * 0.05);
        ghostEye1a = new Ellipse2D.Double(getGhostXposition1() + width * 0.02, getGhostYposition1() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye1b = new Ellipse2D.Double(getGhostXposition1() + width * 0.05, getGhostYposition1() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth1 = new Arc2D.Double(getGhostXposition1() + width * 0.02, getGhostYposition1() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow1a = new Line2D.Double(getGhostXposition1() + width * 0.022, getGhostYposition1() + height * 0.00625, getGhostXposition1() + width * 0.034, getGhostYposition1() + height * 0.01375);
        ghostEyebrow1b = new Line2D.Double(getGhostXposition1() + width * 0.046, getGhostYposition1() + height * 0.01375, getGhostXposition1() + width * 0.058, getGhostYposition1() + height * 0.00625);
        ghostShape2 = new Ellipse2D.Double(getGhostXposition2(), getGhostYposition2(), width * 0.08, height * 0.05);
        ghostEye2a = new Ellipse2D.Double(getGhostXposition2() + width * 0.02, getGhostYposition2() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye2b = new Ellipse2D.Double(getGhostXposition2() + width * 0.05, getGhostYposition2() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth2 = new Arc2D.Double(getGhostXposition2() + width * 0.02, getGhostYposition2() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow2a = new Line2D.Double(getGhostXposition2() + width * 0.022, getGhostYposition2() + height * 0.00625, getGhostXposition2() + width * 0.034, getGhostYposition2() + height * 0.01375);
        ghostEyebrow2b = new Line2D.Double(getGhostXposition2() + width * 0.046, getGhostYposition2() + height * 0.01375, getGhostXposition2() + width * 0.058, getGhostYposition2() + height * 0.00625);
        ghostShape3 = new Ellipse2D.Double(getGhostXposition3(), getGhostYposition3(), width * 0.08, height * 0.05);
        ghostEye3a = new Ellipse2D.Double(getGhostXposition3() + width * 0.02, getGhostYposition3() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye3b = new Ellipse2D.Double(getGhostXposition3() + width * 0.05, getGhostYposition3() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth3 = new Arc2D.Double(getGhostXposition3() + width * 0.02, getGhostYposition3() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow3a = new Line2D.Double(getGhostXposition3() + width * 0.022, getGhostYposition3() + height * 0.00625, getGhostXposition3() + width * 0.034, getGhostYposition3() + height * 0.01375);
        ghostEyebrow3b = new Line2D.Double(getGhostXposition3() + width * 0.046, getGhostYposition3() + height * 0.01375, getGhostXposition3() + width * 0.058, getGhostYposition3() + height * 0.00625);
        ghostShape4 = new Ellipse2D.Double(getGhostXposition4(), getGhostYposition4(), width * 0.08, height * 0.05);
        ghostEye4a = new Ellipse2D.Double(getGhostXposition4() + width * 0.02, getGhostYposition4() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye4b = new Ellipse2D.Double(getGhostXposition4() + width * 0.05, getGhostYposition4() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth4 = new Arc2D.Double(getGhostXposition4() + width * 0.02, getGhostYposition4() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow4a = new Line2D.Double(getGhostXposition4() + width * 0.022, getGhostYposition4() + height * 0.00625, getGhostXposition4() + width * 0.034, getGhostYposition4() + height * 0.01375);
        ghostEyebrow4b = new Line2D.Double(getGhostXposition4() + width * 0.046, getGhostYposition4() + height * 0.01375, getGhostXposition4() + width * 0.058, getGhostYposition4() + height * 0.00625);
        ghostBounds1 = new Rectangle2D.Double(ghostXposition1 + width * 0.016, ghostYposition1 + height * 0.001, width * 0.042, height * 0.02625);
        ghostBounds2 = new Rectangle2D.Double(ghostXposition2 + width * 0.016, ghostYposition2 + height * 0.001, width * 0.042, height * 0.02625);
        ghostBounds3 = new Rectangle2D.Double(getGhostXposition3() + width * 0.016, getGhostYposition3() + height * 0.001, width * 0.042, height * 0.02625);
        ghostBounds4 = new Rectangle2D.Double(getGhostXposition4() + width * 0.016, getGhostYposition4() + height * 0.001, width * 0.042, height * 0.02625);
        getLineList().add(new Line2D.Double(width * 0.5, height * 0.4375, width * 0.5, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.5, height * 0.5, width * 0.5, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.6, height * 0.5, width * 0.6, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.6, height * 0.4375, width * 0.6, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.5, width * 0.4, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.4375, width * 0.4, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.4375, width * 0.3, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.7, height * 0.4375, width * 0.6, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.5, width * 0.3, height * 0.5));
        getLineList().add(new Line2D.Double(width * 0.7, height * 0.5, width * 0.6, height * 0.5));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.5, width * 0.8, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.375, width * 0.8, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.375, width * 0.8, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.375, width * 0.2, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.5, width * 0.2, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.5, height * 0.5625, height * 0.5));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.375, width * 0.9, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.375, width * 0.2, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.5, width * 0.2, height * 0.5));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.5625, width * 0.9, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.4375, width * 0.9, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.4375, width * 0.2, height * 0.4375));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.5625, width * 0.2, height * 0.5625));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.1875, width * 0.6, height * 0.1875));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.25, width * 0.4, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.6, height * 0.25, width * 0.6, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.3125, width * 0.6, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.125, width * 0.6, height * 0.125));
        getLineList().add(new Line2D.Double(width * 0.5, height * 0.25, width * 0.5, height * 0.1875));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.625, width * 0.6, height * 0.625));
        getLineList().add(new Line2D.Double(width * 0.5, height * 0.75, width * 0.5, height * 0.6875));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.8125, width * 0.6, height * 0.8125));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.75, width * 0.6, height * 0.75));
        getLineList().add(new Line2D.Double(width * 0.6, height * 0.6875, width * 0.6, height * 0.625));
        getLineList().add(new Line2D.Double(width * 0.4, height * 0.6875, width * 0.4, height * 0.625));
        getLineList().add(new Line2D.Double(width * 0.7, height * 0.125, width * 0.8, height * 0.125));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.125, width * 0.8, height * 0.0625));
        getLineList().add(new Line2D.Double(width * 0.9, height * 0.0625, width * 0.9, height * 0.25));
        getLineList().add(new Line2D.Double(width * 0.7, height * 0.1875, width * 0.9, height * 0.1875));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.8125, width * 0.7, height * 0.8125));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.8125, width * 0.8, height * 0.875));
        getLineList().add(new Line2D.Double(width * 0.9, height * 0.6875, width * 0.9, height * 0.875));
        getLineList().add(new Line2D.Double(width * 0.9, height * 0.75, width * 0.7, height * 0.75));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.0625, width * 0.1, height * 0.25));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.1875, width * 0.3, height * 0.1875));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.125, width * 0.3, height * 0.125));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.125, width * 0.2, height * 0.0625));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.875, width * 0.1, height * 0.6875));
        getLineList().add(new Line2D.Double(width * 0.1, height * 0.75, width * 0.3, height * 0.75));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.8125, width * 0.3, height * 0.8125));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.8125, width * 0.2, height * 0.875));
        getLineList().add(new Line2D.Double(width * 0.3, height * 0.5625, width * 0.3, height * 0.6875));
        getLineList().add(new Line2D.Double(width * 0.3, height * 0.25, width * 0.3, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.7, height * 0.5625, width * 0.7, height * 0.6875));
        getLineList().add(new Line2D.Double(width * 0.7, height * 0.25, width * 0.7, height * 0.375));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.25, width * 0.8, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.25, width * 0.2, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.3125, width * 0.9, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.3125, width * 0.1, height * 0.3125));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.625, width * 0.1, height * 0.625));
        getLineList().add(new Line2D.Double(width * 0.2, height * 0.625, width * 0.2, height * 0.6875));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.625, width * 0.8, height * 0.6875));
        getLineList().add(new Line2D.Double(width * 0.8, height * 0.625, width * 0.9, height * 0.625));
        getLineList().add(new Line2D.Double(width * 0.3, height * 0.875, width * 0.7, height * 0.875));
        getLineList().add(new Line2D.Double(width * 0.3, height * 0.0625, width * 0.7, height * 0.0625));
        getLineList().add(new Line2D.Double(width, 0, width, height * 0.4375));
        getLineList().add(new Line2D.Double(0, 0, 0, height * 0.4375));
        getLineList().add(new Line2D.Double(width, height * 0.9375, width, height * 0.5));
        getLineList().add(new Line2D.Double(0, height * 0.9375, 0, height * 0.5));
        getLineList().add(new Line2D.Double(0, 0, width, 0));
        getLineList().add(new Line2D.Double(0, height * 0.9375, width, height * 0.9375));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.028125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.090625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.153125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.215625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.278125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.340625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.403125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.465625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.528125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.590625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.653125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.715625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.778125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.840625, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.045, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.145, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.245, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.345, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.445, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.545, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.645, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.745, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.845, height * 0.903125, width * 0.01, height * 0.00625));
        dotList.add(new Rectangle2D.Double(width * 0.945, height * 0.903125, width * 0.01, height * 0.00625));
    }

    public void paintSelf(Graphics2D g2)
    {
        g2.setColor(Color.black);
        g2.fillRect(0, 0, width + 1, height + 1);
        if (pacmanShape.intersects(getGhostBounds1()) || pacmanShape.intersects(getGhostBounds2()) || pacmanShape.intersects(ghostBounds3) || pacmanShape.intersects(ghostBounds4))
        {
            setLives(getLives() - 1);
            if (getLives() > 0)
            {
                eNumber = 0;
                startAngle = 0;
                extent = 360;
                pacManXposition = (int) (width * 0.41);
                pacManYposition = (int) (height * 0.44375);
                ghostXposition1 = (int) (width * 0.01);
                ghostXposition2 = (int) (width * 0.91);
                ghostXposition3 = (int) (width * 0.01);
                ghostXposition4 = (int) (width * 0.91);
                ghostYposition1 = (int) (height * 0.00625);
                ghostYposition2 = (int) (height * 0.00625);
                ghostYposition3 = (int) (height * 0.88125);
                ghostYposition4 = (int) (height * 0.88125);
                ghostLeft2 = 0;
                ghostDown2 = 0;
                ghostRight2 = 0;
                ghostUp2 = 0;
                ghostLeft1 = 0;
                ghostDown1 = 0;
                ghostRight1 = 0;
                ghostUp1 = 0;
                ghostLeft4 = 0;
                ghostDown4 = 0;
                ghostRight4 = 0;
                ghostUp4 = 0;
                ghostLeft3 = 0;
                ghostDown3 = 0;
                ghostRight3 = 0;
                ghostUp3 = 0;
                nNumber = 1;
            }
            if (getLives() == 0)
            {
                end = true;
            }
        }
        for (int d = 0; d < dotList.size(); d++)
        {
            Rectangle2D.Double dot = dotList.get(d);
            g2.setColor(Color.green);
            g2.fill(dot);
            if (pacmanShape.intersects(dot))
            {
                score += 50;
                dotCounter += 1;
                dotList.remove(d);
                pacChomp.play();
                if (dotCounter == 149)
                {
                    eNumber = 0;
                    iNumber = 1;
                }
            }
        }
        for (Line2D.Double l : getLineList())
        {
            g2.setColor(Color.red);
            g2.draw(l);
        }
        g2.setColor(Color.white);
        g2.fill(getGhostShape1());
        g2.setColor(Color.black);
        g2.fill(getGhostEye1a());
        g2.fill(getGhostEye1b());
        g2.draw(getGhostEyebrow1a());
        g2.draw(getGhostEyebrow1b());
        g2.setColor(Color.red);
        g2.fill(getGhostMouth1());
        g2.setColor(Color.white);
        g2.fill(getGhostShape2());
        g2.setColor(Color.black);
        g2.fill(getGhostEye2a());
        g2.fill(getGhostEye2b());
        g2.draw(getGhostEyebrow2a());
        g2.draw(getGhostEyebrow2b());
        g2.setColor(Color.red);
        g2.fill(getGhostMouth2());
        g2.setColor(Color.white);
        g2.fill(ghostShape3);
        g2.setColor(Color.black);
        g2.fill(ghostEye3a);
        g2.fill(ghostEye3b);
        g2.draw(ghostEyebrow3a);
        g2.draw(ghostEyebrow3b);
        g2.setColor(Color.red);
        g2.fill(ghostMouth3);
        g2.setColor(Color.white);
        g2.fill(ghostShape4);
        g2.setColor(Color.black);
        g2.fill(ghostEye4a);
        g2.fill(ghostEye4b);
        g2.draw(ghostEyebrow4a);
        g2.draw(ghostEyebrow4b);
        g2.setColor(Color.red);
        g2.fill(ghostMouth4);
        g2.setColor(Color.white);
        g2.fillRect(0, (int) (height * 0.9375 + 1), width, (int) (height * 0.0625));
        g2.setColor(Color.blue);
        g2.setFont(new Font("PacFont Good", Font.PLAIN, (int) (width * 0.08)));
        g2.drawString("Score:" + score, (int) (width * 0.01), (int) (height * 0.9875));
        if (isStart() == false)
        {
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 1000000, 1000000);
            g2.setColor(Color.yellow);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 55));
            g2.drawString("Pac Man", 135, 395);
            g2.setColor(Color.green);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 25));
            g2.drawString("Brought to you by not Namco", 85, 430);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 35));
            g2.drawString("Press the space bar to begin", 30, 635);
        }
        g2.setColor(Color.black);
        if (getbNumber() == 0)
        {
            g2.setColor(Color.yellow);
        }
        g2.fill(getPacmanShape());
        g2.setColor(Color.black);
        g2.fillRect(width + 1, 0, 1000000000, 1000000000);
        g2.fillRect(0, height + 1, 1000000000, 1000000000);
        if (getbNumber() == 1)
        {
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 501, 751);
            g2.setColor(Color.red);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 200));
            g2.drawString("Fail", 88, 448);
            g2.setColor(Color.green);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 25));
            g2.drawString("Press the space bar twice to play again", 30, 635);
            setmNumber(1);
        }
        if (hNumber == 1)
        {
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 501, 751);
            g2.setColor(Color.green);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 50));
            g2.drawString("Congragulations!", 60, 373);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 25));
            g2.drawString("Press the space bar twice to play again", 30, 635);
            g2.setColor(Color.white);
            g2.fillRect(0, 751, 500, 50);
            g2.setColor(Color.blue);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 40));
            g2.drawString("Score:" + score, (int) (width * 0.01), 790);
            setmNumber(1);
        }
        if (nNumber == 1)
        {
            g2.setColor(Color.white);
            g2.fillRect(150, 350, 201, 51);
            g2.setColor(Color.blue);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 50));
            g2.drawString("Lives:" + getLives(), 163, 393);
        }
        if (kNumber == 1)
        {
            g2.setColor(Color.white);
            g2.fillRect(150, 350, 201, 51);
            g2.setColor(Color.blue);
            g2.setFont(new Font("PacFont Good", Font.PLAIN, 50));
            g2.drawString("Paused", 163, 393);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (reset == true)
        {
            bNumber = 0;
            cNumber = 0;
            eNumber = 0;
            hNumber = 0;
            iNumber = 0;
            jNumber = 0;
            kNumber = 0;
            lNumber = 0;
            mNumber = 0;
            nNumber = 0;
            oNumber = 0;
            goLeft = 0;
            goDown = 0;
            goRight = 0;
            goUp = 0;
            ghostLeft2 = 0;
            ghostDown2 = 0;
            ghostRight2 = 0;
            ghostUp2 = 0;
            ghostLeft1 = 0;
            ghostDown1 = 0;
            ghostRight1 = 0;
            ghostUp1 = 0;
            ghostLeft4 = 0;
            ghostDown4 = 0;
            ghostRight4 = 0;
            ghostUp4 = 0;
            ghostLeft3 = 0;
            ghostDown3 = 0;
            ghostRight3 = 0;
            ghostUp3 = 0;
            checkLeft = 0;
            checkDown = 0;
            checkRight = 0;
            checkUp = 0;
            pacManXposition = (int) (width * 0.41);
            pacManYposition = (int) (height * 0.44375);
            ghostXposition1 = (int) (width * 0.01);
            ghostXposition2 = (int) (width * 0.91);
            ghostXposition3 = (int) (width * 0.01);
            ghostXposition4 = (int) (width * 0.91);
            ghostYposition1 = (int) (height * 0.00625);
            ghostYposition2 = (int) (height * 0.00625);
            ghostYposition3 = (int) (height * 0.88125);
            ghostYposition4 = (int) (height * 0.88125);
            startAngle = 25;
            extent = 310;
            go = 0;
            score = 0;
            dotCounter = 0;
            setLives(3);
            start = false;
            end = false;
            reset = false;
            setPacSongPlay(false);
            dotList.removeAll(dotList);
            makeWallsAndDots();
        }
        pacmanShape = new Arc2D.Double(getPacManXposition(), getPacManYposition(), width * 0.08, height * 0.05, getStartAngle() + getGo(), getExtent(), Arc2D.PIE);
        ghostShape1 = new Ellipse2D.Double(getGhostXposition1(), getGhostYposition1(), width * 0.08, height * 0.05);
        ghostEye1a = new Ellipse2D.Double(getGhostXposition1() + width * 0.02, getGhostYposition1() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye1b = new Ellipse2D.Double(getGhostXposition1() + width * 0.05, getGhostYposition1() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth1 = new Arc2D.Double(getGhostXposition1() + width * 0.02, getGhostYposition1() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow1a = new Line2D.Double(getGhostXposition1() + width * 0.022, getGhostYposition1() + height * 0.00625, getGhostXposition1() + width * 0.034, getGhostYposition1() + height * 0.01375);
        ghostEyebrow1b = new Line2D.Double(getGhostXposition1() + width * 0.046, getGhostYposition1() + height * 0.01375, getGhostXposition1() + width * 0.058, getGhostYposition1() + height * 0.00625);
        ghostShape2 = new Ellipse2D.Double(getGhostXposition2(), getGhostYposition2(), width * 0.08, height * 0.05);
        ghostEye2a = new Ellipse2D.Double(getGhostXposition2() + width * 0.02, getGhostYposition2() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye2b = new Ellipse2D.Double(getGhostXposition2() + width * 0.05, getGhostYposition2() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth2 = new Arc2D.Double(getGhostXposition2() + width * 0.02, getGhostYposition2() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow2a = new Line2D.Double(getGhostXposition2() + width * 0.022, getGhostYposition2() + height * 0.00625, getGhostXposition2() + width * 0.034, getGhostYposition2() + height * 0.01375);
        ghostEyebrow2b = new Line2D.Double(getGhostXposition2() + width * 0.046, getGhostYposition2() + height * 0.01375, getGhostXposition2() + width * 0.058, getGhostYposition2() + height * 0.00625);
        ghostShape3 = new Ellipse2D.Double(getGhostXposition3(), getGhostYposition3(), width * 0.08, height * 0.05);
        ghostEye3a = new Ellipse2D.Double(getGhostXposition3() + width * 0.02, getGhostYposition3() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye3b = new Ellipse2D.Double(getGhostXposition3() + width * 0.05, getGhostYposition3() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth3 = new Arc2D.Double(getGhostXposition3() + width * 0.02, getGhostYposition3() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow3a = new Line2D.Double(getGhostXposition3() + width * 0.022, getGhostYposition3() + height * 0.00625, getGhostXposition3() + width * 0.034, getGhostYposition3() + height * 0.01375);
        ghostEyebrow3b = new Line2D.Double(getGhostXposition3() + width * 0.046, getGhostYposition3() + height * 0.01375, getGhostXposition3() + width * 0.058, getGhostYposition3() + height * 0.00625);
        ghostShape4 = new Ellipse2D.Double(getGhostXposition4(), getGhostYposition4(), width * 0.08, height * 0.05);
        ghostEye4a = new Ellipse2D.Double(getGhostXposition4() + width * 0.02, getGhostYposition4() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostEye4b = new Ellipse2D.Double(getGhostXposition4() + width * 0.05, getGhostYposition4() + height * 0.00875, width * 0.01, height * 0.00625);
        ghostMouth4 = new Arc2D.Double(getGhostXposition4() + width * 0.02, getGhostYposition4() + height * 0.02125, width * 0.04, height * 0.0125, 180, 180, Arc2D.PIE);
        ghostEyebrow4a = new Line2D.Double(getGhostXposition4() + width * 0.022, getGhostYposition4() + height * 0.00625, getGhostXposition4() + width * 0.034, getGhostYposition4() + height * 0.01375);
        ghostEyebrow4b = new Line2D.Double(getGhostXposition4() + width * 0.046, getGhostYposition4() + height * 0.01375, getGhostXposition4() + width * 0.058, getGhostYposition4() + height * 0.00625);
        ghostBounds1 = new Rectangle2D.Double(ghostXposition1 + width * 0.016, ghostYposition1 + height * 0.001, width * 0.042, height * 0.02625);
        ghostBounds2 = new Rectangle2D.Double(ghostXposition2 + width * 0.016, ghostYposition2 + height * 0.001, width * 0.042, height * 0.02625);
        ghostBounds3 = new Rectangle2D.Double(getGhostXposition3() + width * 0.016, getGhostYposition3() + height * 0.001, width * 0.042, height * 0.02625);
        ghostBounds4 = new Rectangle2D.Double(getGhostXposition4() + width * 0.016, getGhostYposition4() + height * 0.001, width * 0.042, height * 0.02625);
        if (opening == false)
        {
            pNumber = 0;
        }
        if (opening == true)
        {
            pNumber++;
            pausePlay = false;
        }
        if (getpNumber() == 100)
        {
            eNumber = 1;
            opening = false;
            pausePlay = true;
        }
        if (nNumber == 1)
        {
            setoNumber(getoNumber() + 1);
            pausePlay = false;
        }
        if (getoNumber() == 100)
        {
            nNumber = 0;
            setoNumber(0);
            eNumber = 1;
            pausePlay = true;
        }
        if (end == false && eNumber == 1)
        {
            /**
             * ************************
             * FOUR WAY INTERSECTIONS ************************
             */
            if (ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.13125) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.13125) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.75625) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.75625) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.05) && ghostYposition1 == (int) (height * 0.44375) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.71) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.44375) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.44375) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.44375) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.44375))
            {
                randomInt1 = (int) (Math.random() * 4);
                if (randomInt1 == 0)
                {
                    ghostLeft1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                    ghostRight1 = 0;
                }
                if (randomInt1 == 1)
                {
                    ghostUp1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                    ghostDown1 = 0;
                }
                if (randomInt1 == 2)
                {
                    ghostDown1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                    ghostUp1 = 0;
                }
                if (randomInt1 == 3)
                {
                    ghostRight1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                    ghostLeft1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.13125) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.13125) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.75625) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.75625) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.05) && ghostYposition2 == (int) (height * 0.44375) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.71) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.44375) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.44375) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.44375) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.44375))
            {
                randomInt2 = (int) (Math.random() * 4);
                if (randomInt2 == 0)
                {
                    ghostLeft2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                    ghostRight2 = 0;
                }
                if (randomInt2 == 1)
                {
                    ghostUp2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                    ghostDown2 = 0;
                }
                if (randomInt2 == 2)
                {
                    ghostDown2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                    ghostUp2 = 0;
                }
                if (randomInt2 == 3)
                {
                    ghostRight2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                    ghostLeft2 = 0;
                }
            }
            if (getGhostXposition3() == 155 && getGhostYposition3() == 105 || getGhostXposition3() == 305 && getGhostYposition3() == 105 || getGhostXposition3() == 155 && getGhostYposition3() == 155 || getGhostXposition3() == 305 && getGhostYposition3() == 155 || getGhostXposition3() == 155 && getGhostYposition3() == 605 || getGhostXposition3() == 305 && getGhostYposition3() == 605 || getGhostXposition3() == 155 && getGhostYposition3() == 555 || getGhostXposition3() == 305 && getGhostYposition3() == 555 || getGhostXposition3() == 5 && getGhostYposition3() == 355 || getGhostXposition3() == 105 && getGhostYposition3() == 355 || getGhostXposition3() == 205 && getGhostYposition3() == 355 || getGhostXposition3() == 255 && getGhostYposition3() == 355 || getGhostXposition3() == 355 && getGhostYposition3() == 355 || getGhostXposition3() == 455 && getGhostYposition3() == 355)
            {
                randomInt3 = (int) (Math.random() * 4);
                if (randomInt3 == 0)
                {
                    if (ghostRight3 == 0)
                    {
                        ghostLeft3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    }
                }
                if (randomInt3 == 1)
                {
                    if (ghostDown3 == 0)
                    {
                        ghostUp3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    }
                }
                if (randomInt3 == 2)
                {
                    if (ghostUp3 == 0)
                    {
                        ghostDown3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    }
                }
                if (randomInt3 == 3)
                {
                    if (ghostLeft3 == 0)
                    {
                        ghostRight3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    }
                }
                if (ghostRight3 == 1 && ghostUp3 == 1);
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostUp3 = 0;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostRight3 = 0;
                    }
                }
                if (ghostLeft3 == 1 && ghostUp3 == 1);
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostUp3 = 0;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostLeft3 = 0;
                    }
                }
                if (ghostLeft3 == 1 && ghostDown3 == 1);
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostDown3 = 0;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostLeft3 = 0;
                    }
                }
                if (ghostRight3 == 1 && ghostDown3 == 1);
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostDown3 = 0;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostRight3 = 0;
                    }
                }
            }
            if (getGhostXposition4() == 155 && getGhostYposition4() == 105 || getGhostXposition4() == 305 && getGhostYposition4() == 105 || getGhostXposition4() == 155 && getGhostYposition4() == 155 || getGhostXposition4() == 305 && getGhostYposition4() == 155 || getGhostXposition4() == 155 && getGhostYposition4() == 605 || getGhostXposition4() == 305 && getGhostYposition4() == 605 || getGhostXposition4() == 155 && getGhostYposition4() == 555 || getGhostXposition4() == 305 && getGhostYposition4() == 555 || getGhostXposition4() == 5 && getGhostYposition4() == 355 || getGhostXposition4() == 105 && getGhostYposition4() == 355 || getGhostXposition4() == 205 && getGhostYposition4() == 355 || getGhostXposition4() == 255 && getGhostYposition4() == 355 || getGhostXposition4() == 355 && getGhostYposition4() == 355 || getGhostXposition4() == 455 && getGhostYposition4() == 355)
            {
                randomInt4 = (int) (Math.random() * 4);
                if (randomInt4 == 0)
                {
                    if (ghostRight4 == 0)
                    {
                        ghostLeft4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    }
                }
                if (randomInt4 == 1)
                {
                    if (ghostDown4 == 0)
                    {
                        ghostUp4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    }
                }
                if (randomInt4 == 2)
                {
                    if (ghostUp4 == 0)
                    {
                        ghostDown4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    }
                }
                if (randomInt4 == 3)
                {
                    if (ghostLeft4 == 0)
                    {
                        ghostRight4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    }
                }
                if (ghostRight4 == 1 && ghostUp4 == 1);
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostUp4 = 0;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostRight4 = 0;
                    }
                }
                if (ghostLeft4 == 1 && ghostUp4 == 1);
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostUp4 = 0;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostLeft4 = 0;
                    }
                }
                if (ghostLeft4 == 1 && ghostDown4 == 1);
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostDown4 = 0;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostLeft4 = 0;
                    }
                }
                if (ghostRight4 == 1 && ghostDown4 == 1);
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostDown4 = 0;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostRight4 = 0;
                    }
                }
            }
            /**
             * ************************
             * TWO WAY INTERSECTIONS ************************
             */
            if (ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.00625) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.50625) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.63125) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.63125) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.75625) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.81875))
            {
                if (ghostLeft1 == 0 && ghostUp1 == 0)
                {
                    randomInt1 = (int) (Math.random() * 2);
                    if (randomInt1 == 0)
                    {
                        ghostRight1 = 1;
                    }
                    if (randomInt1 == 1)
                    {
                        ghostDown1 = 1;
                    }
                }
                if (ghostLeft1 == 1)
                {
                    ghostDown1 = 1;
                    ghostLeft1 = 0;
                }
                if (ghostUp1 == 1)
                {
                    ghostRight1 = 1;
                    ghostUp1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.00625) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.50625) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.63125) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.63125) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.75625) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.81875))
            {
                if (ghostLeft2 == 0 && ghostUp2 == 0)
                {
                    randomInt2 = (int) (Math.random() * 2);
                    if (randomInt2 == 0)
                    {
                        ghostRight2 = 1;
                    }
                    if (randomInt2 == 1)
                    {
                        ghostDown2 = 1;
                    }
                }
                if (ghostLeft2 == 1)
                {
                    ghostDown2 = 1;
                    ghostLeft2 = 0;
                }
                if (ghostUp2 == 1)
                {
                    ghostRight2 = 1;
                    ghostUp2 = 0;
                }
            }
            if (ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 5 || ghostXposition3 == 55 && ghostYposition3 == 155 || ghostXposition3 == 255 && ghostYposition3 == 155 || ghostXposition3 == 305 && ghostYposition3 == 405 || ghostXposition3 == 205 && ghostYposition3 == 505 || ghostXposition3 == 405 && ghostYposition3 == 505 || ghostXposition3 == 55 && ghostYposition3 == 605 || ghostXposition3 == 105 && ghostYposition3 == 655)
            {
                if (ghostLeft3 == 0 && ghostUp3 == 0)
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostRight3 = 1;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostDown3 = 1;
                    }
                }
                if (ghostLeft3 == 1)
                {
                    ghostDown3 = 1;
                    ghostLeft3 = 0;
                }
                if (ghostUp3 == 1)
                {
                    ghostRight3 = 1;
                    ghostUp3 = 0;
                }
            }
            if (ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 5 || ghostXposition4 == 55 && ghostYposition4 == 155 || ghostXposition4 == 255 && ghostYposition4 == 155 || ghostXposition4 == 305 && ghostYposition4 == 405 || ghostXposition4 == 205 && ghostYposition4 == 505 || ghostXposition4 == 405 && ghostYposition4 == 505 || ghostXposition4 == 55 && ghostYposition4 == 605 || ghostXposition4 == 105 && ghostYposition4 == 655)
            {
                if (ghostLeft4 == 0 && ghostUp4 == 0)
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostRight4 = 1;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostDown4 = 1;
                    }
                }
                if (ghostLeft4 == 1)
                {
                    ghostDown4 = 1;
                    ghostLeft4 = 0;
                }
                if (ghostUp4 == 1)
                {
                    ghostRight4 = 1;
                    ghostUp4 = 0;
                }
            }
            if (ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.00625) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.50625) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.63125) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.63125) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.75625) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.81875))
            {
                if (ghostRight1 == 0 && ghostUp1 == 0)
                {
                    randomInt1 = (int) (Math.random() * 2);
                    if (randomInt1 == 0)
                    {
                        ghostLeft1 = 1;
                    }
                    if (randomInt1 == 1)
                    {
                        ghostDown1 = 1;
                    }
                }
                if (ghostRight1 == 1)
                {
                    ghostDown1 = 1;
                    ghostRight1 = 0;
                }
                if (ghostUp1 == 1)
                {
                    ghostLeft1 = 1;
                    ghostUp1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.00625) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.50625) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.63125) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.63125) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.75625) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.81875))
            {
                if (ghostRight2 == 0 && ghostUp2 == 0)
                {
                    randomInt2 = (int) (Math.random() * 2);
                    if (randomInt2 == 0)
                    {
                        ghostLeft2 = 1;
                    }
                    if (randomInt2 == 1)
                    {
                        ghostDown2 = 1;
                    }
                }
                if (ghostRight2 == 1)
                {
                    ghostDown2 = 1;
                    ghostRight2 = 0;
                }
                if (ghostUp2 == 1)
                {
                    ghostLeft2 = 1;
                    ghostUp2 = 0;
                }
            }
            if (ghostXposition3 == 455 && ghostYposition3 == 5 || ghostXposition3 == 405 && ghostYposition3 == 155 || ghostXposition3 == 205 && ghostYposition3 == 155 || ghostXposition3 == 155 && ghostYposition3 == 405 || ghostXposition3 == 255 && ghostYposition3 == 505 || ghostXposition3 == 55 && ghostYposition3 == 505 || ghostXposition3 == 405 && ghostYposition3 == 605 || ghostXposition3 == 355 && ghostYposition3 == 655)
            {
                if (ghostRight3 == 0 && ghostUp3 == 0)
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostLeft3 = 1;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostDown3 = 1;
                    }
                }
                if (ghostRight3 == 1)
                {
                    ghostDown3 = 1;
                    ghostRight3 = 0;
                }
                if (ghostUp3 == 1)
                {
                    ghostLeft3 = 1;
                    ghostUp3 = 0;
                }
            }
            if (ghostXposition4 == 455 && ghostYposition4 == 5 || ghostXposition4 == 405 && ghostYposition4 == 155 || ghostXposition4 == 205 && ghostYposition4 == 155 || ghostXposition4 == 155 && ghostYposition4 == 405 || ghostXposition4 == 255 && ghostYposition4 == 505 || ghostXposition4 == 55 && ghostYposition4 == 505 || ghostXposition4 == 405 && ghostYposition4 == 605 || ghostXposition4 == 355 && ghostYposition4 == 655)
            {
                if (ghostRight4 == 0 && ghostUp4 == 0)
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostLeft4 = 1;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostDown4 = 1;
                    }
                }
                if (ghostRight4 == 1)
                {
                    ghostDown4 = 1;
                    ghostRight4 = 0;
                }
                if (ghostUp4 == 1)
                {
                    ghostLeft4 = 1;
                    ghostUp4 = 0;
                }
            }
            if (ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.88125) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.25625) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.25625) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.13125) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == 55)
            {
                if (ghostRight1 == 0 && ghostDown1 == 0)
                {
                    randomInt1 = (int) (Math.random() * 2);
                    if (randomInt1 == 0)
                    {
                        ghostLeft1 = 1;
                    }
                    if (randomInt1 == 1)
                    {
                        ghostUp1 = 1;
                    }
                }
                if (ghostRight1 == 1)
                {
                    ghostUp1 = 1;
                    ghostRight1 = 0;
                }
                if (ghostDown1 == 1)
                {
                    ghostLeft1 = 1;
                    ghostDown1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.88125) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.25625) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.25625) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.13125) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == 55)
            {
                if (ghostRight2 == 0 && ghostDown2 == 0)
                {
                    randomInt2 = (int) (Math.random() * 2);
                    if (randomInt2 == 0)
                    {
                        ghostLeft2 = 1;
                    }
                    if (randomInt2 == 1)
                    {
                        ghostUp2 = 1;
                    }
                }
                if (ghostRight2 == 1)
                {
                    ghostUp2 = 1;
                    ghostRight2 = 0;
                }
                if (ghostDown2 == 1)
                {
                    ghostLeft2 = 1;
                    ghostDown2 = 0;
                }
            }
            if (ghostXposition3 == 455 && ghostYposition3 == 705 || ghostXposition3 == 405 && ghostYposition3 == 555 || ghostXposition3 == 205 && ghostYposition3 == 555 || ghostXposition3 == 155 && ghostYposition3 == 305 || ghostXposition3 == 255 && ghostYposition3 == 205 || ghostXposition3 == 55 && ghostYposition3 == 205 || ghostXposition3 == 405 && ghostYposition3 == 105 || ghostXposition3 == 355 && ghostYposition3 == 55)
            {
                if (ghostRight3 == 0 && ghostDown3 == 0)
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostLeft3 = 1;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostUp3 = 1;
                    }
                }
                if (ghostRight3 == 1)
                {
                    ghostUp3 = 1;
                    ghostRight3 = 0;
                }
                if (ghostDown3 == 1)
                {
                    ghostLeft3 = 1;
                    ghostDown3 = 0;
                }
            }
            if (ghostXposition4 == 455 && ghostYposition4 == 705 || ghostXposition4 == 405 && ghostYposition4 == 555 || ghostXposition4 == 205 && ghostYposition4 == 555 || ghostXposition4 == 155 && ghostYposition4 == 305 || ghostXposition4 == 255 && ghostYposition4 == 205 || ghostXposition4 == 55 && ghostYposition4 == 205 || ghostXposition4 == 405 && ghostYposition4 == 105 || ghostXposition4 == 355 && ghostYposition4 == 55)
            {
                if (ghostRight4 == 0 && ghostDown4 == 0)
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostLeft4 = 1;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostUp4 = 1;
                    }
                }
                if (ghostRight4 == 1)
                {
                    ghostUp4 = 1;
                    ghostRight4 = 0;
                }
                if (ghostDown4 == 1)
                {
                    ghostLeft4 = 1;
                    ghostDown4 = 0;
                }
            }
            if (ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.88125) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.25625) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.25625) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.13125) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == 55)
            {
                if (ghostLeft1 == 0 && ghostDown1 == 0)
                {
                    randomInt1 = (int) (Math.random() * 2);
                    if (randomInt1 == 0)
                    {
                        ghostRight1 = 1;
                    }
                    if (randomInt1 == 1)
                    {
                        ghostUp1 = 1;
                    }
                }
                if (ghostLeft1 == 1)
                {
                    ghostUp1 = 1;
                    ghostLeft1 = 0;
                }
                if (ghostDown1 == 1)
                {
                    ghostRight1 = 1;
                    ghostDown1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.88125) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.25625) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.25625) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.13125) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == 55)
            {
                if (ghostLeft2 == 0 && ghostDown2 == 0)
                {
                    randomInt2 = (int) (Math.random() * 2);
                    if (randomInt2 == 0)
                    {
                        ghostRight2 = 1;
                    }
                    if (randomInt2 == 1)
                    {
                        ghostUp2 = 1;
                    }
                }
                if (ghostLeft2 == 1)
                {
                    ghostUp2 = 1;
                    ghostLeft2 = 0;
                }
                if (ghostDown2 == 1)
                {
                    ghostRight2 = 1;
                    ghostDown2 = 0;
                }
            }
            if (ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 705 || ghostXposition3 == 55 && ghostYposition3 == 555 || ghostXposition3 == 255 && ghostYposition3 == 555 || ghostXposition3 == 305 && ghostYposition3 == 305 || ghostXposition3 == 205 && ghostYposition3 == 205 || ghostXposition3 == 405 && ghostYposition3 == 205 || ghostXposition3 == 55 && ghostYposition3 == 105 || ghostXposition3 == 105 && ghostYposition3 == 55)
            {
                if (ghostLeft3 == 0 && ghostDown3 == 0)
                {
                    randomInt3 = (int) (Math.random() * 2);
                    if (randomInt3 == 0)
                    {
                        ghostRight3 = 1;
                    }
                    if (randomInt3 == 1)
                    {
                        ghostUp3 = 1;
                    }
                }
                if (ghostLeft3 == 1)
                {
                    ghostUp3 = 1;
                    ghostLeft3 = 0;
                }
                if (ghostDown3 == 1)
                {
                    ghostRight3 = 1;
                    ghostDown3 = 0;
                }
            }
            if (ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 705 || ghostXposition4 == 55 && ghostYposition4 == 555 || ghostXposition4 == 255 && ghostYposition4 == 555 || ghostXposition4 == 305 && ghostYposition4 == 305 || ghostXposition4 == 205 && ghostYposition4 == 205 || ghostXposition4 == 405 && ghostYposition4 == 205 || ghostXposition4 == 55 && ghostYposition4 == 105 || ghostXposition4 == 105 && ghostYposition4 == 55)
            {
                if (ghostLeft4 == 0 && ghostDown4 == 0)
                {
                    randomInt4 = (int) (Math.random() * 2);
                    if (randomInt4 == 0)
                    {
                        ghostRight4 = 1;
                    }
                    if (randomInt4 == 1)
                    {
                        ghostUp4 = 1;
                    }
                }
                if (ghostLeft4 == 1)
                {
                    ghostUp4 = 1;
                    ghostLeft4 = 0;
                }
                if (ghostDown4 == 1)
                {
                    ghostRight4 = 1;
                    ghostDown4 = 0;
                }
            }
            /**
             * ************************
             * DEAD ENDS ************************
             */
            if (ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.50625))
            {
                ghostLeft1 = 1;
                ghostRight1 = 0;
            }
            if (ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.50625))
            {
                ghostRight1 = 1;
                ghostLeft1 = 0;
            }
            if (ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.50625))
            {
                ghostLeft2 = 1;
                ghostRight2 = 0;
            }
            if (ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.50625))
            {
                ghostRight2 = 1;
                ghostLeft2 = 0;
            }
            if (ghostXposition3 == 55 && ghostYposition3 == 305 || ghostXposition3 == 55 && ghostYposition3 == 405)
            {
                ghostLeft3 = 1;
                ghostRight3 = 0;
            }
            if (ghostXposition3 == 405 && ghostYposition3 == 305 || ghostXposition3 == 405 && ghostYposition3 == 405)
            {
                ghostRight3 = 1;
                ghostLeft3 = 0;
            }
            if (ghostXposition4 == 55 && ghostYposition4 == 305 || ghostXposition4 == 55 && ghostYposition4 == 405)
            {
                ghostLeft4 = 1;
                ghostRight4 = 0;
            }
            if (ghostXposition4 == 405 && ghostYposition4 == 305 || ghostXposition4 == 405 && ghostYposition4 == 405)
            {
                ghostRight4 = 1;
                ghostLeft4 = 0;
            }
            /*************************
             * THREE WAY INTERSECTIONS 
             *************************/
            if (ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.00625) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.00625) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.00625) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.00625) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.006875) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.006875) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.19375) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.31875))
            {
                randomInt1 = (int) (Math.random() * 3);
                if (randomInt1 == 0)
                {
                    ghostLeft1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                    ghostRight1 = 0;
                }
                if (randomInt1 == 1)
                {
                    ghostRight1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                    ghostLeft1 = 0;
                }
                if (randomInt1 == 2)
                {
                    ghostDown1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                    ghostUp1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.00625) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.00625) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.00625) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.00625) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.006875) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.006875) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.19375) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.31875))
            {
                randomInt2 = (int) (Math.random() * 3);
                if (randomInt2 == 0)
                {
                    ghostLeft2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                    ghostRight2 = 0;
                }
                if (randomInt2 == 1)
                {
                    ghostRight2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                    ghostLeft2 = 0;
                }
                if (randomInt2 == 2)
                {
                    ghostDown2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                    ghostUp2 = 0;
                }
            }
            if (ghostXposition3 == 55 && ghostYposition3 == 5 || ghostXposition3 == 105 && ghostYposition3 == 5 || ghostXposition3 == 355 && ghostYposition3 == 5 || ghostXposition3 == 405 && ghostYposition3 == 5 || ghostXposition3 == 155 && ghostYposition3 == 55 || ghostXposition3 == 305 && ghostYposition3 == 55 || ghostXposition3 == 105 && ghostYposition3 == 155 || ghostXposition3 == 355 && ghostYposition3 == 155 || ghostXposition3 == 205 && ghostYposition3 == 255 || ghostXposition3 == 255 && ghostYposition3 == 255)
            {
                randomInt3 = (int) (Math.random() * 3);
                if (randomInt3 == 0)
                {
                    if (ghostRight3 == 0)
                    {
                        ghostLeft3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    }
                }
                if (randomInt3 == 1)
                {
                    if (ghostLeft3 == 0)
                    {
                        ghostRight3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    }
                }
                if (randomInt3 == 2)
                {
                    if (ghostUp3 == 0)
                    {
                        ghostDown3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    } else
                    {
                        randomInt3 = (int) (Math.random() * 2);
                        if (randomInt3 == 0)
                        {
                            ghostLeft3 = 1;
                            ghostRight3 = 0;
                        }
                        if (randomInt3 == 1)
                        {
                            ghostLeft3 = 0;
                            ghostRight3 = 1;
                        }
                    }
                }
                ghostUp3 = 0;
            }
            if (ghostXposition4 == 55 && ghostYposition4 == 5 || ghostXposition4 == 105 && ghostYposition4 == 5 || ghostXposition4 == 355 && ghostYposition4 == 5 || ghostXposition4 == 405 && ghostYposition4 == 5 || ghostXposition4 == 155 && ghostYposition4 == 55 || ghostXposition4 == 305 && ghostYposition4 == 55 || ghostXposition4 == 105 && ghostYposition4 == 155 || ghostXposition4 == 355 && ghostYposition4 == 155 || ghostXposition4 == 205 && ghostYposition4 == 255 || ghostXposition4 == 255 && ghostYposition4 == 255)
            {
                randomInt4 = (int) (Math.random() * 3);
                if (randomInt4 == 0)
                {
                    if (ghostRight4 == 0)
                    {
                        ghostLeft4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    }
                }
                if (randomInt4 == 1)
                {
                    if (ghostLeft4 == 0)
                    {
                        ghostRight4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    }
                }
                if (randomInt4 == 2)
                {
                    if (ghostUp4 == 0)
                    {
                        ghostDown4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    } else
                    {
                        randomInt4 = (int) (Math.random() * 2);
                        if (randomInt4 == 0)
                        {
                            ghostLeft4 = 1;
                            ghostRight4 = 0;
                        }
                        if (randomInt4 == 1)
                        {
                            ghostLeft4 = 0;
                            ghostRight4 = 1;
                        }
                    }
                }
                ghostUp4 = 0;
            }
            if (ghostXposition1 == (int) (width * 0.11) && ghostYposition1 == (int) (height * 0.88125) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.88125) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.88125) || ghostXposition1 == (int) (width * 0.81) && ghostYposition1 == (int) (height * 0.88125) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.81875) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.81875) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.69375) || ghostXposition1 == (int) (width * 0.41) && ghostYposition1 == (int) (height * 0.56875) || ghostXposition1 == (int) (width * 0.51) && ghostYposition1 == (int) (height * 0.56875))
            {
                randomInt1 = (int) (Math.random() * 3);
                if (randomInt1 == 0)
                {
                    ghostLeft1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                    ghostRight1 = 0;
                }
                if (randomInt1 == 1)
                {
                    ghostRight1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                    ghostLeft1 = 0;
                }
                if (randomInt1 == 2)
                {
                    ghostUp1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                    ghostDown1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.11) && ghostYposition2 == (int) (height * 0.88125) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.88125) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.88125) || ghostXposition2 == (int) (width * 0.81) && ghostYposition2 == (int) (height * 0.88125) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.81875) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.81875) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.69375) || ghostXposition2 == (int) (width * 0.41) && ghostYposition2 == (int) (height * 0.56875) || ghostXposition2 == (int) (width * 0.51) && ghostYposition2 == (int) (height * 0.56875))
            {
                randomInt2 = (int) (Math.random() * 3);
                if (randomInt2 == 0)
                {
                    ghostLeft2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                    ghostRight2 = 0;
                }
                if (randomInt2 == 1)
                {
                    ghostRight2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                    ghostLeft2 = 0;
                }
                if (randomInt2 == 2)
                {
                    ghostUp2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                    ghostDown2 = 0;
                }
            }
            if (ghostXposition3 == 55 && ghostYposition3 == 705 || ghostXposition3 == 105 && ghostYposition3 == 705 || ghostXposition3 == 355 && ghostYposition3 == 705 || ghostXposition3 == 405 && ghostYposition3 == 705 || ghostXposition3 == 155 && ghostYposition3 == 655 || ghostXposition3 == 305 && ghostYposition3 == 655 || ghostXposition3 == 105 && ghostYposition3 == 555 || ghostXposition3 == 355 && ghostYposition3 == 555 || ghostXposition3 == 205 && ghostYposition3 == 455 || ghostXposition3 == 255 && ghostYposition3 == 455)
            {
                randomInt3 = (int) (Math.random() * 3);
                if (randomInt3 == 0)
                {
                    if (ghostRight3 == 0)
                    {
                        ghostLeft3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    }
                }
                if (randomInt3 == 1)
                {
                    if (ghostLeft3 == 0)
                    {
                        ghostRight3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    }
                }
                if (randomInt3 == 2)
                {
                    if (ghostDown3 == 0)
                    {
                        ghostUp3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    } else
                    {
                        randomInt3 = (int) (Math.random() * 2);
                        if (randomInt3 == 0)
                        {
                            ghostLeft3 = 1;
                            ghostRight3 = 0;
                        }
                        if (randomInt3 == 1)
                        {
                            ghostLeft3 = 0;
                            ghostRight3 = 1;
                        }
                    }
                }
                ghostDown3 = 0;
            }
            if (ghostXposition4 == 55 && ghostYposition4 == 705 || ghostXposition4 == 105 && ghostYposition4 == 705 || ghostXposition4 == 355 && ghostYposition4 == 705 || ghostXposition4 == 405 && ghostYposition4 == 705 || ghostXposition4 == 155 && ghostYposition4 == 655 || ghostXposition4 == 305 && ghostYposition4 == 655 || ghostXposition4 == 105 && ghostYposition4 == 555 || ghostXposition4 == 355 && ghostYposition4 == 555 || ghostXposition4 == 205 && ghostYposition4 == 455 || ghostXposition4 == 255 && ghostYposition4 == 455)
            {
                randomInt4 = (int) (Math.random() * 3);
                if (randomInt4 == 0)
                {
                    if (ghostRight4 == 0)
                    {
                        ghostLeft4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    }
                }
                if (randomInt4 == 1)
                {
                    if (ghostLeft4 == 0)
                    {
                        ghostRight4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    }
                }
                if (randomInt4 == 2)
                {
                    if (ghostDown4 == 0)
                    {
                        ghostUp4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    } else
                    {
                        randomInt4 = (int) (Math.random() * 2);
                        if (randomInt4 == 0)
                        {
                            ghostLeft4 = 1;
                            ghostRight4 = 0;
                        }
                        if (randomInt4 == 1)
                        {
                            ghostLeft4 = 0;
                            ghostRight4 = 1;
                        }
                    }
                }
                ghostDown4 = 0;
            }
            if (ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.25625) || ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.50625) || ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.56875) || ghostXposition1 == (int) (width * 0.01) && ghostYposition1 == (int) (height * 0.63125) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.50625) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.31) && ghostYposition1 == (int) (height * 0.56875) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.56875))
            {
                randomInt1 = (int) (Math.random() * 3);
                if (randomInt1 == 0)
                {
                    ghostDown1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                }
                if (randomInt1 == 1)
                {
                    ghostUp1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                }
                if (randomInt1 == 2)
                {
                    ghostRight1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.25625) || ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.50625) || ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.56875) || ghostXposition2 == (int) (width * 0.01) && ghostYposition2 == (int) (height * 0.63125) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.50625) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.31) && ghostYposition2 == (int) (height * 0.56875) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.56875))
            {
                randomInt2 = (int) (Math.random() * 3);
                if (randomInt2 == 0)
                {
                    ghostDown2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                }
                if (randomInt2 == 1)
                {
                    ghostUp2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                }
                if (randomInt2 == 2)
                {
                    ghostRight2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                }
            }
            if (ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 205 || ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 255 || ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 305 || ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 405 || ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 455 || ghostXposition3 == (int) (width * 0.01) && ghostYposition3 == 505 || ghostXposition3 == 105 && ghostYposition3 == 305 || ghostXposition3 == 105 && ghostYposition3 == 405 || ghostXposition3 == 155 && ghostYposition3 == 255 || ghostXposition3 == 155 && ghostYposition3 == 455 || ghostXposition3 == 355 && ghostYposition3 == 255 || ghostXposition3 == 355 && ghostYposition3 == 455)
            {
                randomInt3 = (int) (Math.random() * 3);
                if (randomInt3 == 0)
                {
                    if (ghostUp3 == 0)
                    {
                        ghostDown3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    }
                }
                if (randomInt3 == 1)
                {
                    if (ghostDown3 == 0)
                    {
                        ghostUp3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    }
                }
                if (randomInt3 == 2)
                {
                    if (ghostLeft3 == 0)
                    {
                        ghostRight3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    } else
                    {
                        randomInt3 = (int) (Math.random() * 2);
                        if (randomInt3 == 0)
                        {
                            ghostUp3 = 1;
                            ghostDown3 = 0;
                        }
                        if (randomInt3 == 1)
                        {
                            ghostUp3 = 0;
                            ghostDown3 = 1;
                        }
                    }
                }
                ghostLeft3 = 0;
            }
            if (ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 205 || ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 255 || ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 305 || ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 405 || ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 455 || ghostXposition4 == (int) (width * 0.01) && ghostYposition4 == 505 || ghostXposition4 == 105 && ghostYposition4 == 305 || ghostXposition4 == 105 && ghostYposition4 == 405 || ghostXposition4 == 155 && ghostYposition4 == 255 || ghostXposition4 == 155 && ghostYposition4 == 455 || ghostXposition4 == 355 && ghostYposition4 == 255 || ghostXposition4 == 355 && ghostYposition4 == 455)
            {
                randomInt4 = (int) (Math.random() * 3);
                if (randomInt4 == 0)
                {
                    if (ghostUp4 == 0)
                    {
                        ghostDown4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    }
                }
                if (randomInt4 == 1)
                {
                    if (ghostDown4 == 0)
                    {
                        ghostUp4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    }
                }
                if (randomInt4 == 2)
                {
                    if (ghostLeft4 == 0)
                    {
                        ghostRight4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    } else
                    {
                        randomInt4 = (int) (Math.random() * 2);
                        if (randomInt4 == 0)
                        {
                            ghostUp4 = 1;
                            ghostDown4 = 0;
                        }
                        if (randomInt4 == 1)
                        {
                            ghostUp4 = 0;
                            ghostDown4 = 1;
                        }
                    }
                }
                ghostLeft4 = 0;
            }
            if (ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.25625) || ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.50625) || ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.56875) || ghostXposition1 == (int) (width * 0.91) && ghostYposition1 == (int) (height * 0.63125) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.38125) || ghostXposition1 == (int) (width * 0.71) && ghostYposition1 == (int) (height * 0.50625) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.61) && ghostYposition1 == (int) (height * 0.56875) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.31875) || ghostXposition1 == (int) (width * 0.21) && ghostYposition1 == (int) (height * 0.56875))
            {
                randomInt1 = (int) (Math.random() * 3);
                if (ghostUp1 == 0)
                {
                    ghostDown1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                }
                if (randomInt1 == 1)
                {
                    ghostUp1 = 1;
                    ghostRight1 = 0;
                    ghostLeft1 = 0;
                }
                if (randomInt1 == 2)
                {
                    ghostLeft1 = 1;
                    ghostUp1 = 0;
                    ghostDown1 = 0;
                }
            }
            if (ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.25625) || ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.50625) || ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.56875) || ghostXposition2 == (int) (width * 0.91) && ghostYposition2 == (int) (height * 0.63125) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.38125) || ghostXposition2 == (int) (width * 0.71) && ghostYposition2 == (int) (height * 0.50625) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.61) && ghostYposition2 == (int) (height * 0.56875) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.31875) || ghostXposition2 == (int) (width * 0.21) && ghostYposition2 == (int) (height * 0.56875))
            {
                randomInt2 = (int) (Math.random() * 3);
                if (ghostUp2 == 0)
                {
                    ghostDown2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                }
                if (randomInt2 == 1)
                {
                    ghostUp2 = 1;
                    ghostRight2 = 0;
                    ghostLeft2 = 0;
                }
                if (randomInt2 == 2)
                {
                    ghostLeft2 = 1;
                    ghostUp2 = 0;
                    ghostDown2 = 0;
                }
            }
            if (ghostXposition3 == 455 && ghostYposition3 == 205 || ghostXposition3 == 455 && ghostYposition3 == 255 || ghostXposition3 == 455 && ghostYposition3 == 305 || ghostXposition3 == 455 && ghostYposition3 == 405 || ghostXposition3 == 455 && ghostYposition3 == 455 || ghostXposition3 == 455 && ghostYposition3 == 505 || ghostXposition3 == 355 && ghostYposition3 == 305 || ghostXposition3 == 355 && ghostYposition3 == 405 || ghostXposition3 == 305 && ghostYposition3 == 255 || ghostXposition3 == 305 && ghostYposition3 == 455 || ghostXposition3 == 105 && ghostYposition3 == 255 || ghostXposition3 == 105 && ghostYposition3 == 455)
            {
                randomInt3 = (int) (Math.random() * 3);
                if (randomInt3 == 0)
                {
                    if (ghostUp3 == 0)
                    {
                        ghostDown3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    }
                }
                if (randomInt3 == 1)
                {
                    if (ghostDown3 == 0)
                    {
                        ghostUp3 = 1;
                        ghostRight3 = 0;
                        ghostLeft3 = 0;
                    }
                }
                if (randomInt3 == 2)
                {
                    if (ghostRight3 == 0)
                    {
                        ghostLeft3 = 1;
                        ghostUp3 = 0;
                        ghostDown3 = 0;
                    } else
                    {
                        randomInt3 = (int) (Math.random() * 2);
                        if (randomInt3 == 0)
                        {
                            ghostUp3 = 1;
                            ghostDown3 = 0;
                        }
                        if (randomInt3 == 1)
                        {
                            ghostUp3 = 0;
                            ghostDown3 = 1;
                        }
                    }
                }
                ghostRight3 = 0;
            }
            if (ghostXposition4 == 455 && ghostYposition4 == 205 || ghostXposition4 == 455 && ghostYposition4 == 255 || ghostXposition4 == 455 && ghostYposition4 == 305 || ghostXposition4 == 455 && ghostYposition4 == 405 || ghostXposition4 == 455 && ghostYposition4 == 455 || ghostXposition4 == 455 && ghostYposition4 == 505 || ghostXposition4 == 355 && ghostYposition4 == 305 || ghostXposition4 == 355 && ghostYposition4 == 405 || ghostXposition4 == 305 && ghostYposition4 == 255 || ghostXposition4 == 305 && ghostYposition4 == 455 || ghostXposition4 == 105 && ghostYposition4 == 255 || ghostXposition4 == 105 && ghostYposition4 == 455)
            {
                randomInt4 = (int) (Math.random() * 3);
                if (randomInt4 == 0)
                {
                    if (ghostUp4 == 0)
                    {
                        ghostDown4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    }
                }
                if (randomInt4 == 1)
                {
                    if (ghostDown4 == 0)
                    {
                        ghostUp4 = 1;
                        ghostRight4 = 0;
                        ghostLeft4 = 0;
                    }
                }
                if (randomInt4 == 2)
                {
                    if (ghostRight4 == 0)
                    {
                        ghostLeft4 = 1;
                        ghostUp4 = 0;
                        ghostDown4 = 0;
                    } else
                    {
                        randomInt4 = (int) (Math.random() * 2);
                        if (randomInt4 == 0)
                        {
                            ghostUp4 = 1;
                            ghostDown4 = 0;
                        }
                        if (randomInt4 == 1)
                        {
                            ghostUp4 = 0;
                            ghostDown4 = 1;
                        }
                    }
                }
                ghostRight4 = 0;
            }
            if (ghostDown1 == 1)
            {
                setGhostYposition1(getGhostYposition1() + 1);
            }
            if (ghostLeft1 == 1)
            {
                setGhostXposition1(getGhostXposition1() - 1);
            }
            if (ghostRight1 == 1)
            {
                setGhostXposition1(getGhostXposition1() + 1);
            }
            if (ghostUp1 == 1)
            {
                setGhostYposition1(getGhostYposition1() - 1);
            }
            if (ghostDown2 == 1)
            {
                setGhostYposition2(getGhostYposition2() + 1);
            }
            if (ghostLeft2 == 1)
            {
                setGhostXposition2(getGhostXposition2() - 1);
            }
            if (ghostRight2 == 1)
            {
                setGhostXposition2(getGhostXposition2() + 1);
            }
            if (ghostUp2 == 1)
            {
                setGhostYposition2(getGhostYposition2() - 1);
            }
            if (ghostDown3 == 1)
            {
                setGhostYposition3(getGhostYposition3() + 1);
            }
            if (ghostLeft3 == 1)
            {
                setGhostXposition3(getGhostXposition3() - 1);
            }
            if (ghostRight3 == 1)
            {
                setGhostXposition3(getGhostXposition3() + 1);
            }
            if (ghostUp3 == 1)
            {
                setGhostYposition3(getGhostYposition3() - 1);
            }
            if (ghostDown4 == 1)
            {
                setGhostYposition4(getGhostYposition4() + 1);
            }
            if (ghostLeft4 == 1)
            {
                setGhostXposition4(getGhostXposition4() - 1);
            }
            if (ghostRight4 == 1)
            {
                setGhostXposition4(getGhostXposition4() + 1);
            }
            if (ghostUp4 == 1)
            {
                setGhostYposition4(getGhostYposition4() - 1);
            }
            if (getGhostXposition1() >= width * 1.01)
            {
                setGhostXposition1((int) (width * -0.09));
            } else if (getGhostXposition1() <= width * -0.09)
            {
                setGhostXposition1((int) (width * 1.01));
            }
            if (getGhostXposition2() >= width * 1.01)
            {
                setGhostXposition2((int) (width * -0.09));
            } else if (getGhostXposition2() <= width * -0.09)
            {
                setGhostXposition2((int) (width * 1.01));
            }
            if (getGhostXposition3() >= width * 1.01)
            {
                setGhostXposition3((int) (width * -0.09));
            } else if (getGhostXposition3() <= width * -0.09)
            {
                setGhostXposition3((int) (width * 1.01));
            }
            if (getGhostXposition4() >= width * 1.01)
            {
                setGhostXposition4((int) (width * -0.09));
            } else if (getGhostXposition4() <= width * -0.09)
            {
                setGhostXposition4((int) (width * 1.01));
            }
            if (checkLeft == 1)
            {
                for (Line2D.Double l : lineList)
                {
                    if (l.intersects(getPacManXposition() - width * 0.01, getPacManYposition() + height * 0.00625, width * 0.08, height * 0.0375))
                    {
                        bumpLeft = true;
                    }
                }
                if (bumpLeft == false)
                {
                    goLeft = 1;
                    offsetLeft = (int) ((pacManYposition - height * 0.00625) % (height * 0.0625));
                    if (offsetLeft <= height * 0.01875)
                    {
                        pacManYposition -= offsetLeft;
                    }
                    if (offsetLeft >= height * 0.04375)
                    {
                        pacManYposition += (height * 0.0625 - offsetLeft);
                    }
                }
                bumpLeft = false;
            }
            if (checkUp == 1)
            {
                for (Line2D.Double l : lineList)
                {
                    if (l.intersects(getPacManXposition() + width * 0.01, getPacManYposition() - height * 0.00625, width * 0.06, height * 0.05))
                    {
                        bumpUp = true;
                    }
                }
                if (bumpUp == false)
                {
                    goUp = 1;
                    offsetUp = (int) ((pacManXposition - width * 0.01) % (width * 0.1));
                    if (offsetUp <= width * 0.03)
                    {
                        pacManXposition -= offsetUp;
                    }
                    if (offsetUp >= width * 0.07)
                    {
                        pacManXposition += (width * 0.1 - offsetUp);
                    }
                }
                bumpUp = false;
            }
            if (checkRight == 1)
            {
                for (Line2D.Double l : lineList)
                {
                    if (l.intersects(getPacManXposition() + width * 0.01, getPacManYposition() + height * 0.00625, width * 0.08, height * 0.0375))
                    {
                        bumpRight = true;
                    }
                }
                if (bumpRight == false)
                {
                    goRight = 1;
                    offsetRight = (int) ((pacManYposition - height * 0.00625) % (height * 0.0625));
                    if (offsetRight <= height * 0.01875)
                    {
                        pacManYposition -= offsetRight;
                    }
                    if (offsetRight >= height * 0.04375)
                    {
                        pacManYposition += (height * 0.0625 - offsetRight);
                    }
                }
                bumpRight = false;
            }
            if (checkDown == 1)
            {
                for (Line2D.Double l : lineList)
                {
                    if (l.intersects(getPacManXposition() + width * 0.01, getPacManYposition() + height * 0.00625, width * 0.06, height * 0.05))
                    {
                        bumpDown = true;
                    }
                }
                if (bumpDown == false)
                {
                    goDown = 1;
                    offsetDown = (int) ((pacManXposition - width * 0.01) % (width * 0.1));
                    if (offsetDown <= width * 0.03)
                    {
                        pacManXposition -= offsetDown;
                    }
                    if (offsetDown >= width * 0.07)
                    {
                        pacManXposition += (width * 0.1 - offsetDown);
                    }
                }
                bumpDown = false;
            }
            if (goLeft == 1)
            {
                go = 180;
                pacManXposition--;
                aRemainder = (int) ((pacManXposition - width * 0.01) % (width * 0.1));
                if (aRemainder <= width * 0.05)
                {
                    setStartAngle(aRemainder);
                    setExtent((startAngle * 2 - 360) * -1);
                }
                if (aRemainder > width * 0.05)
                {
                    setStartAngle((aRemainder - (int) (width * 0.1)) * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
                if (aRemainder >= width * -0.05 && aRemainder < 0)
                {
                    setStartAngle(aRemainder * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
            }
            goLeft = 0;
            if (goRight == 1)
            {
                go = 0;
                pacManXposition++;
                aRemainder = (int) ((pacManXposition - width * 0.01) % (width * 0.1));
                if (aRemainder <= width * 0.05 && aRemainder >= 0)
                {
                    setStartAngle(aRemainder);
                    setExtent((startAngle * 2 - 360) * -1);
                }
                if (aRemainder > width * 0.05)
                {
                    setStartAngle((aRemainder - (int) (width * 0.1)) * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
                if (aRemainder >= width * -0.05 && aRemainder < 0)
                {
                    setStartAngle(aRemainder * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
                if (aRemainder < width * -0.05)
                {
                    setStartAngle(((aRemainder * -1) - (int) (width * 0.1)) * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
            }
            goRight = 0;
            if (goDown == 1)
            {
                go = 270;
                pacManYposition++;
                aRemainder = (int) ((getPacManYposition() - height * 0.00625) % (height * 0.0625));
                if (aRemainder <= height * 0.03125)
                {
                    setStartAngle(aRemainder);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
                if (aRemainder > height * 0.03125)
                {
                    setStartAngle((aRemainder - (int) (height * 0.0625)) * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
            }
            goDown = 0;
            if (goUp == 1)
            {
                go = 90;
                pacManYposition--;
                aRemainder = (int) ((getPacManYposition() - height * 0.00625) % (height * 0.0625));
                if (aRemainder <= height * 0.03125)
                {
                    setStartAngle(aRemainder);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
                if (aRemainder > height * 0.03125)
                {
                    setStartAngle((aRemainder - (int) (height * 0.0625)) * -1);
                    setExtent((getStartAngle() * 2 - 360) * -1);
                }
            }
            goUp = 0;
            if (pacManXposition >= width * 1.01)
            {
                pacManXposition = (int) (width * -0.09);
            } else if (pacManXposition <= width * -0.09)
            {
                pacManXposition = (int) (width * 1.01);
            }
        }
        if (iNumber == 1 && jNumber == 0)
        {
            score += getLives() * 50;
        }
        if (getiNumber() == 1)
        {
            jNumber++;
        }





        if (jNumber == 100)
        {
            hNumber = 1;
            start = false;
            end = true;
        }
        if (end == true && hNumber == 0)
        {
            if (getStartAngle() <= 180)
            {
                setStartAngle(getStartAngle() + 2);
                setExtent(getExtent() - 4);
                pausePlay = false;
            } else
            {
                bNumber = 1;
                setLives(3);
            }
        }
    }

    public Ellipse2D.Double getGhostShape1()
    {
        return ghostShape1;


    }

    public void setGhostShape1(Ellipse2D.Double ghostShape)
    {
        this.ghostShape1 = ghostShape;


    }

    public int getPacManXposition()
    {
        return pacManXposition;


    }

    public void setPacManXposition(int pacManXposition)
    {
        this.pacManXposition = pacManXposition;


    }

    public int getGhostXposition1()
    {
        return ghostXposition1;


    }

    public void setGhostXposition1(int ghostXposition1)
    {
        this.ghostXposition1 = ghostXposition1;


    }

    public int getGhostXposition2()
    {
        return ghostXposition2;


    }

    public void setGhostXposition2(int ghostXposition2)
    {
        this.ghostXposition2 = ghostXposition2;


    }

    public int getPacManYposition()
    {
        return pacManYposition;


    }

    public void setPacManYposition(int pacManYposition)
    {
        this.pacManYposition = pacManYposition;


    }

    public int getGhostYposition1()
    {
        return ghostYposition1;


    }

    public void setGhostYposition1(int ghostYposition1)
    {
        this.ghostYposition1 = ghostYposition1;


    }

    public int getGhostYposition2()
    {
        return ghostYposition2;


    }

    public void setGhostYposition2(int ghostYposition2)
    {
        this.ghostYposition2 = ghostYposition2;


    }

    public int getGo()
    {
        return go;


    }

    public void setGo(int go)
    {
        this.go = go;


    }

    public boolean isStart()
    {
        return start;


    }

    public void setStart(boolean start)
    {
        this.start = start;


    }

    public ArrayList<Line2D.Double> getLineList()
    {
        return lineList;


    }

    public void setLineList(ArrayList<Line2D.Double> lineList)
    {
        this.lineList = lineList;


    }

    public Arc2D.Double getPacmanShape()
    {
        return pacmanShape;


    }

    public void setPacmanShape(Arc2D.Double pacmanShape)
    {
        this.pacmanShape = pacmanShape;


    }

    public Ellipse2D.Double getGhostEye1a()
    {
        return ghostEye1a;


    }

    public void setGhostEye1a(Ellipse2D.Double ghostEye1)
    {
        this.ghostEye1a = ghostEye1;


    }

    public Ellipse2D.Double getGhostEye1b()
    {
        return ghostEye1b;


    }

    public void setGhostEye1b(Ellipse2D.Double ghostEye2)
    {
        this.ghostEye1b = ghostEye2;


    }

    public Arc2D.Double getGhostMouth1()
    {
        return ghostMouth1;


    }

    public void setGhostMouth1(Arc2D.Double ghostMouth)
    {
        this.ghostMouth1 = ghostMouth;


    }

    public Line2D.Double getGhostEyebrow1a()
    {
        return ghostEyebrow1a;


    }

    public void setGhostEyebrow1a(Line2D.Double ghostEyebrow1)
    {
        this.ghostEyebrow1a = ghostEyebrow1;


    }

    public Line2D.Double getGhostEyebrow1b()
    {
        return ghostEyebrow1b;


    }

    public void setGhostEyebrow1b(Line2D.Double ghostEyebrow2)
    {
        this.ghostEyebrow1b = ghostEyebrow2;


    }

    public Ellipse2D.Double getGhostShape2()
    {
        return ghostShape2;


    }

    public void setGhostShape2(Ellipse2D.Double ghostShape2)
    {
        this.ghostShape2 = ghostShape2;


    }

    public Ellipse2D.Double getGhostEye2a()
    {
        return ghostEye2a;


    }

    public void setGhostEye2a(Ellipse2D.Double ghostEye3)
    {
        this.ghostEye2a = ghostEye3;


    }

    public Ellipse2D.Double getGhostEye2b()
    {
        return ghostEye2b;


    }

    public void setGhostEye2b(Ellipse2D.Double ghostEye4)
    {
        this.ghostEye2b = ghostEye4;


    }

    public Arc2D.Double getGhostMouth2()
    {
        return ghostMouth2;


    }

    public void setGhostMouth2(Arc2D.Double ghostMouth1)
    {
        this.ghostMouth2 = ghostMouth1;


    }

    public Line2D.Double getGhostEyebrow2a()
    {
        return ghostEyebrow2a;


    }

    public void setGhostEyebrow2a(Line2D.Double ghostEyebrow3)
    {
        this.ghostEyebrow2a = ghostEyebrow3;


    }

    public Line2D.Double getGhostEyebrow2b()
    {
        return ghostEyebrow2b;


    }

    public void setGhostEyebrow2b(Line2D.Double ghostEyebrow4)
    {
        this.ghostEyebrow2b = ghostEyebrow4;


    }

    public boolean isEnd()
    {
        return end;


    }

    public void setEnd(boolean end)
    {
        this.end = end;


    }

    public Rectangle2D.Double getGhostBounds1()
    {
        return ghostBounds1;


    }

    public void setGhostBounds1(Rectangle2D.Double ghostBounds1)
    {
        this.ghostBounds1 = ghostBounds1;


    }

    public Rectangle2D.Double getGhostBounds2()
    {
        return ghostBounds2;


    }

    public void setGhostBounds2(Rectangle2D.Double ghostBounds2)
    {
        this.ghostBounds2 = ghostBounds2;


    }

    public int getcNumber()
    {
        return cNumber;


    }

    public void setcNumber(int cNumber)
    {
        this.cNumber = cNumber;


    }

    public int getGoLeft()
    {
        return goLeft;


    }

    public void setGoLeft(int goLeft)
    {
        this.goLeft = goLeft;


    }

    public int getGoDown()
    {
        return goDown;


    }

    public void setGoDown(int goDown)
    {
        this.goDown = goDown;


    }

    public int getGoRight()
    {
        return goRight;


    }

    public void setGoRight(int goRight)
    {
        this.goRight = goRight;


    }

    public int getGoUp()
    {
        return goUp;


    }

    public void setGoUp(int goUp)
    {
        this.goUp = goUp;


    }

    public int getbNumber()
    {
        return bNumber;


    }

    public void setbNumber(int bNumber)
    {
        this.bNumber = bNumber;


    }

    public int gethNumber()
    {
        return hNumber;


    }

    public void sethNumber(int hNumber)
    {
        this.hNumber = hNumber;

    }

    public int geteNumber()
    {
        return eNumber;


    }

    public void seteNumber(int eNumber)
    {
        this.eNumber = eNumber;


    }

    public int getStartAngle()
    {
        return startAngle;


    }

    public void setStartAngle(int startAngle)
    {
        this.startAngle = startAngle;


    }

    public int getExtent()
    {
        return extent;


    }

    public void setExtent(int extent)
    {
        this.extent = extent;


    }

    public int getiNumber()
    {
        return iNumber;


    }

    public void setiNumber(int iNumber)
    {
        this.iNumber = iNumber;


    }

    public int getCheckLeft()
    {
        return checkLeft;


    }

    public void setCheckLeft(int checkLeft)
    {
        this.checkLeft = checkLeft;


    }

    public int getCheckDown()
    {
        return checkDown;


    }

    public void setCheckDown(int checkDown)
    {
        this.checkDown = checkDown;


    }

    public int getCheckRight()
    {
        return checkRight;


    }

    public void setCheckRight(int checkRight)
    {
        this.checkRight = checkRight;


    }

    public int getCheckUp()
    {
        return checkUp;


    }

    public void setCheckUp(int checkUp)
    {
        this.checkUp = checkUp;


    }

    public int getkNumber()
    {
        return kNumber;


    }

    public void setkNumber(int kNumber)
    {
        this.kNumber = kNumber;


    }

    public int getGhostXposition3()
    {
        return ghostXposition3;


    }

    public void setGhostXposition3(int ghostXposition3)
    {
        this.ghostXposition3 = ghostXposition3;


    }

    public int getGhostXposition4()
    {
        return ghostXposition4;


    }

    public void setGhostXposition4(int ghostXposition4)
    {
        this.ghostXposition4 = ghostXposition4;


    }

    public int getGhostYposition3()
    {
        return ghostYposition3;


    }

    public void setGhostYposition3(int ghostYposition3)
    {
        this.ghostYposition3 = ghostYposition3;


    }

    public int getGhostYposition4()
    {
        return ghostYposition4;


    }

    public void setGhostYposition4(int ghostYposition4)
    {
        this.ghostYposition4 = ghostYposition4;


    }

    public int getlNumber()
    {
        return lNumber;


    }

    public void setlNumber(int lNumber)
    {
        this.lNumber = lNumber;


    }

    /**
     * @return the mNumber
     */
    public int getmNumber()
    {
        return mNumber;


    }

    /**
     * @param mNumber the mNumber to set
     */
    public void setmNumber(int mNumber)
    {
        this.mNumber = mNumber;


    }

    /**
     * @return the reset
     */
    public boolean isReset()
    {
        return reset;


    }

    /**
     * @param reset the reset to set
     */
    public void setReset(boolean reset)
    {
        this.reset = reset;


    }

    /**
     * @return the oNumber
     */
    public int getoNumber()
    {
        return oNumber;


    }

    /**
     * @param oNumber the oNumber to set
     */
    public void setoNumber(int oNumber)
    {
        this.oNumber = oNumber;


    }

    /**
     * @return the pacSongPlay
     */
    public boolean isPacSongPlay()
    {
        return pacSongPlay;


    }

    /**
     * @param pacSongPlay the pacSongPlay to set
     */
    public void setPacSongPlay(boolean pacSongPlay)
    {
        this.pacSongPlay = pacSongPlay;


    }

    /**
     * @return the pausePlay
     */
    public boolean isPausePlay()
    {
        return pausePlay;


    }

    /**
     * @param pausePlay the pausePlay to set
     */
    public void setPausePlay(boolean pausePlay)
    {
        this.pausePlay = pausePlay;


    }

    /**
     * @return the opening
     */
    public boolean isOpening()
    {
        return opening;


    }

    /**
     * @param opening the opening to set
     */
    public void setOpening(boolean opening)
    {
        this.opening = opening;


    }

    /**
     * @return the pNumber
     */
    public int getpNumber()
    {
        return pNumber;


    }

    /**
     * @param pNumber the pNumber to set
     */
    public void setpNumber(int pNumber)
    {
        this.pNumber = pNumber;

    }

    /**
     * @return the lives
     */
    public int getLives()
    {
        return lives;
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(int lives)
    {
        this.lives = lives;
    }

    /**
     * @return the frameHeight
     */
    public int getFrameHeight()
    {
        return frameHeight;
    }

    /**
     * @param frameHeight the frameHeight to set
     */
    public void setFrameHeight(int frameHeight)
    {
        this.frameHeight = frameHeight;
    }
}
