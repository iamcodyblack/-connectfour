import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class ConnectFourGame extends JPanel implements MouseListener, MouseMotionListener {
    Image title;
    Image button;
    Image bigButton;
    Image wallpaper;
    Image buttonHover;
    Image board;
    Image RedPiece;
    Image YellowPiece;
    Image OrangePiece;
    Image GreenPiece;
    Image BluePiece;
    Image PurplePiece;
    Image PinkPiece;
    Image BlackPiece;
    Image player1SelectScreen;
    Image player2SelectScreen;
    ImageIcon nessWin;
    ImageIcon kingWin;
    Image winScreen;
    Image restartButton;
    Image homeButton;
    ImageIcon playerOneWin;
    ImageIcon playerTwoWin;
    Image backArrow;
    Image click;
    Image tie;

    Image playerOne;
    Image playerTwo;
    Image blank;

    Image bigRedPiece;
    Image bigYellowPiece;
    Image bigOrangePiece;
    Image bigGreenPiece;
    Image bigBluePiece;
    Image bigPurplePiece;
    Image bigPinkPiece;
    Image bigBlackPiece;

    Image selectedRedPiece;
    Image selectedOrangePiece;
    Image selectedYellowPiece;
    Image selectedGreenPiece;
    Image selectedBluePiece;
    Image selectedPurplePiece;
    Image selectedPinkPiece;
    Image selectedBlackPiece;
    Image selectedBigPiece;

    boolean hoveringTwoPlayer = false;
    boolean hoveringOnePlayer = false;
    int row = 5;
    int c;
    int screen = 1;
    int players;
    static int player = 1;
    int column = -1;
    static boolean redWin;
    static boolean yellowWin;
    static int bestCol;

    static int matrix[][] = { // board array
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    static int weightBoard[][] = { // Board weight array
            {3, 4, 5, 7, 5, 4, 3},
            {4, 6, 8, 10, 8, 6, 4},
            {5, 7, 11, 13, 11, 7, 5},
            {5, 7, 11, 13, 11, 7, 5},
            {4, 6, 8, 10, 8, 6, 4},
            {3, 4, 5, 7, 5, 4, 3}
    };

    public ConnectFourGame() {
        addMouseListener(this);
        addMouseMotionListener(this);

        try {
            title = ImageIO.read(new File("src/ConnectFourTitle.png"));
            board = ImageIO.read(new File("src/board.png"));
            button = ImageIO.read(new File("src/Button.png"));
            winScreen = ImageIO.read(new File("src/WinScreen.png"));
            bigButton = ImageIO.read(new File("src/BigButton.png"));
            buttonHover = ImageIO.read(new File("src/ButtonHover.png"));
            nessWin = new ImageIcon("src/nessWin.gif");
            kingWin = new ImageIcon("src/kingWin.gif");
            wallpaper = ImageIO.read(new File("src/Wallpaper.png"));
            restartButton = ImageIO.read(new File("src/restartButton.jpg"));
            homeButton = ImageIO.read(new File ("src/homeButton.jpg"));
            backArrow = ImageIO.read(new File("src/BackArrow.png"));
            playerOneWin = new ImageIcon("src/PlayerOneWins.gif");
            playerTwoWin = new ImageIcon("src/PlayerTwoWins.gif");
            click = ImageIO.read(new File ("src/Click.png"));
            tie = ImageIO.read(new File ("src/Tie.png"));

            RedPiece = ImageIO.read(new File("src/RedPiece.png"));
            OrangePiece = ImageIO.read(new File("src/OrangePiece.png"));
            YellowPiece = ImageIO.read(new File("src/YellowPiece.png"));
            GreenPiece = ImageIO.read(new File("src/GreenPiece.png"));
            BluePiece = ImageIO.read(new File("src/BluePiece.png"));
            PurplePiece = ImageIO.read(new File("src/PurplePiece.png"));
            PinkPiece = ImageIO.read(new File("src/PinkPiece.png"));
            BlackPiece = ImageIO.read(new File("src/BlackPiece.png"));

            blank = ImageIO.read(new File("src/blank.png"));
            playerTwo = blank;

            bigRedPiece = ImageIO.read(new File("src/bigRedPiece.png"));
            bigOrangePiece = ImageIO.read(new File("src/bigOrangePiece.png"));
            bigYellowPiece = ImageIO.read(new File("src/bigYellowPiece.png"));
            bigGreenPiece = ImageIO.read(new File("src/bigGreenPiece.png"));
            bigBluePiece = ImageIO.read(new File("src/bigBluePiece.png"));
            bigPurplePiece = ImageIO.read(new File("src/bigPurplePiece.png"));
            bigPinkPiece = ImageIO.read(new File("src/bigPinkPiece.png"));
            bigBlackPiece = ImageIO.read(new File("src/bigBlackPiece.png"));

            selectedRedPiece = ImageIO.read(new File("src/SelectedRedPiece.png"));
            selectedOrangePiece = ImageIO.read(new File("src/SelectedOrangePiece.png"));
            selectedYellowPiece = ImageIO.read(new File("src/SelectedYellowPiece.png"));
            selectedGreenPiece = ImageIO.read(new File("src/SelectedGreenPiece.png"));
            selectedBluePiece = ImageIO.read(new File("src/SelectedBluePiece.png"));
            selectedPurplePiece = ImageIO.read(new File("src/SelectedPurplePiece.png"));
            selectedPinkPiece = ImageIO.read(new File("src/SelectedPinkPiece.png"));
            selectedBlackPiece = ImageIO.read(new File("src/SelectedBlackPiece.png"));
            selectedBigPiece = ImageIO.read(new File("src/SelectedBigPiece.png"));

            player1SelectScreen = ImageIO.read(new File("src/player1SelectScreen.png"));
            player2SelectScreen = ImageIO.read(new File("src/player2SelectScreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void paint(Graphics g) {
        if (screen == 1) {
            startScreen(g);
        } else if (screen == 2) {
            selectScreen(g);
        } else if (screen == 3) {
            drawBoard(g);
        }
    }

    public void selectScreen(Graphics g) { // Select Tile Screen
        g.setColor(Color.white);
        g.fillRect(0, 0, 840, 720);


        if (player == 1) {
            g.drawImage(player1SelectScreen, 0, 0, null);
        } else if (player == 2) {
            g.drawImage(player2SelectScreen, 0, 0, null);
        }
        g.drawImage(backArrow, 0, 0, null);

        if (playerOne == RedPiece) {
            g.drawImage(selectedRedPiece, 30, 300, null);
            g.drawImage(selectedBigPiece, 30, 300, null);
        } else {
            g.drawImage(bigRedPiece, 20, 290, null);
        }

        if (playerOne == OrangePiece) {
            g.drawImage(selectedOrangePiece, 235, 300, null);
            g.drawImage(selectedBigPiece, 235, 300, null);
        } else {
            g.drawImage(bigOrangePiece, 225, 290, null);
        }

        if (playerOne == YellowPiece) {
            g.drawImage(selectedYellowPiece, 440, 300, null);
            g.drawImage(selectedBigPiece, 440, 300, null);
        } else {
            g.drawImage(bigYellowPiece, 430, 290, null);
        }

        if (playerOne == GreenPiece) {
            g.drawImage(selectedGreenPiece, 645, 300, null);
            g.drawImage(selectedBigPiece, 645, 300, null);
        } else {
            g.drawImage(bigGreenPiece, 635, 290, null);
        }

        if (playerOne == BluePiece) {
            g.drawImage(selectedBluePiece, 30, 505, null);
            g.drawImage(selectedBigPiece, 30, 505, null);
        } else {
            g.drawImage(bigBluePiece, 20, 495, null);
        }

        if (playerOne == PurplePiece) {
            g.drawImage(selectedPurplePiece, 235, 505, null);
            g.drawImage(selectedBigPiece, 235, 505, null);
        } else {
            g.drawImage(bigPurplePiece, 225, 495, null);
        }

        if (playerOne == PinkPiece) {
            g.drawImage(selectedPinkPiece, 440, 505, null);
            g.drawImage(selectedBigPiece, 440, 505, null);
        } else {
            g.drawImage(bigPinkPiece, 430, 495, null);
        }

        if (playerOne == BlackPiece) {
            g.drawImage(selectedBlackPiece, 645, 505, null);
            g.drawImage(selectedBigPiece, 645, 505, null);
        } else {
            g.drawImage(bigBlackPiece, 635, 495, null);
        }
    }

    public void startScreen(Graphics g) { // Main Title Screen
        g.drawImage(title, 0, 0, null);

        if (hoveringOnePlayer == false) // one player button
        {
            g.drawImage(button, 98, 550, null);
        }
        else if (hoveringOnePlayer == true)
        {
            g.drawImage(bigButton, 91, 546, null);
            g.drawImage(buttonHover, 91, 546, null);
        }

        if (hoveringTwoPlayer == false)
        {
            g.drawImage(button, 518, 550, null);
        }
        else if (hoveringTwoPlayer == true)
        {
            g.drawImage(bigButton, 511, 546, null);
            g.drawImage(buttonHover, 511, 546, null);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Lucida Bright", Font.BOLD, 30));
        g.drawString("ONE PLAYER", 113, 610);
        g.drawString("TWO PLAYER", 533, 610);
    }

    public void drawBoard(Graphics g) // Game Screen
    {
        g.drawImage(wallpaper, 0, 0, null);
        if (!full() && !redWin && !yellowWin)
        { // Piece Hover Over Row
            if (player == 1) {
                if (column >= 0) {
                    g.drawImage(playerOne, (113 + (89 * column)), 5, null);
                }
            } else if (player == 2) {
                if (column >= 0) {
                    g.drawImage(playerTwo, (113 + (89 * column)), 5, null);
                }
            }
        }

        g.drawImage(restartButton, 50, 5, null);
        g.drawImage(homeButton, 5, 5, null);

        for (int i = 0; i < matrix.length; i++) { // Pieces Placed On Board
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    g.drawImage(playerOne, (115 + 89 * j), (120 + 88 * i), null);
                } else if (matrix[i][j] == 2)
                    g.drawImage(playerTwo, (115 + 89 * j), (120 + 88 * i), null);
            }
        }

        g.drawImage(board, 0, 0, null);

        if (redWin || yellowWin || full())// win screen
        {
            g.drawImage(winScreen, 0, 0, null);

            if (redWin)
            {
                g.drawImage(playerOneWin.getImage(), 128, -21, this);
                //g.drawImage(nessWin.getImage(), 260, 100, this);
            }
            else if (yellowWin)
            {
                g.drawImage(playerTwoWin.getImage(), 128, -21, this);
                //g.drawImage(kingWin.getImage(), 180, 100, this);
            }
            else
                g.drawImage(tie, 0, 1,null);

            if (!full())
                g.drawImage(click, 0, 25, null);
        }

    }


    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (screen == 1) // title screen
        {
            if (x >= 518 && x <= 743 && y >= 550 && y <= 650) {
                screen = 2;
                players = 2;
            }
            if (x >= 98 && x <= 323 && y >= 550 && y <= 650) {
                screen = 2;
                players = 1;
            }
        }
        else if (screen == 2) // Select Tile Screen
        {
            if (x <= 50 && y <= 30) {
                home();
                screen = 1;
            }
            if (x >= 20 && x <= 205 && y >= 290 && y <= 475) {
                if (player == 1) {
                    playerOne = RedPiece;
                    player++;
                }
                else if (player == 2 && playerOne != RedPiece) {
                    playerTwo = RedPiece;
                    player--;
                }
            }
            else if (x >= 225 && x <= 410 && y >= 290 && y <= 475) {
                if (player == 1) {
                    playerOne = OrangePiece;
                    player++;
                }
                else if (player == 2 && playerOne != OrangePiece) {
                    playerTwo = OrangePiece;
                    player--;
                }
            }
            else if (x >= 430 && x <= 615 && y >= 290 && y <= 475) {
                if (player == 1) {
                    playerOne = YellowPiece;
                    player++;
                }
                else if (player == 2 && playerOne != YellowPiece) {
                    playerTwo = YellowPiece;
                    player--;
                }
            }
            else if (x >= 635 && x <= 820 && y >= 290 && y <= 475) {
                if (player == 1) {
                    playerOne = GreenPiece;
                    player++;
                }
                else if (player == 2 && playerOne != GreenPiece) {
                    playerTwo = GreenPiece;
                    player--;
                }
            }
            else if (x >= 20 && x <= 205 && y >= 495 && y <= 680) {
                if (player == 1) {
                    playerOne = BluePiece;
                    player++;
                }
                else if (player == 2 && playerOne != BluePiece) {
                    playerTwo = BluePiece;
                    player--;
                }
            }
            else if (x >= 225 && x <= 410 && y >= 495 && y <= 680) {
                if (player == 1) {
                    playerOne = PurplePiece;
                    player++;
                }
                else if (player == 2 && playerOne != PurplePiece) {
                    playerTwo = PurplePiece;
                    player--;
                }
            }
            else if (x >= 430 && x <= 615 && y >= 495 && y <= 680) {
                if (player == 1) {
                    playerOne = PinkPiece;
                    player++;
                }
                else if (player == 2 && playerOne != PinkPiece) {
                    playerTwo = PinkPiece;
                    player--;
                }
            }
            else if (x >= 635 && x <= 820 && y >= 495 && y <= 680) {
                if (player == 1) {
                    playerOne = BlackPiece;
                    player++;
                }
                else if (player == 2 && playerOne != BlackPiece) {
                    playerTwo = BlackPiece;
                    player--;
                }
            }

            if (playerTwo != blank) {
                screen = 3;
            }
        }
        else if (screen == 3) // Game Screen
        {
            if (x >= 5 && x <= 45 && y >= 5 && y <= 45 && !redWin && !yellowWin) {
                home();
                screen = 1;
            } else if (x >= 50 && x <= 90 && y >= 5 && y <= 45 && !redWin && !yellowWin) {
                reset();
                screen = 3;
            }

            if (!yellowWin && !redWin && !full()) // players == 1 && player == 1)
            {
                if (players == 2)
                {
                    if (column >= 0) // on the board
                    {
                        if (matrix[0][column] == 0) // row is not full
                        {
                            while (row >= 0) // board maximum
                            {
                                if (matrix[row][column] == 1 || matrix[row][column] == 2)
                                {
                                    row--;
                                } else if (matrix[row][column] == 0) // piece placed on empty spot
                                {
                                    matrix[row][column] = player;
                                    repaint();
                                    row -= 6;
                                }
                            }
                        }

                        if (player == 1)
                        { // Switch Player
                            redWin = winCheck();
                        } else if (player == 2) {
                            yellowWin = winCheck();
                        }

                        if (full()) {
                            repaint();
                        }

                        if (row != 5) // wont't change players if empty row was clicked
                        {
                            if (player == 1)
                                player++;
                            else if (player == 2)
                                player--;
                        }
                    }
                    row = 5;
                }
                else if (players == 1) // One Player
                {
                    if (column >= 0) // on the board
                    {
                        if (matrix[0][column] == 0) // row is not full
                        {
                            while (row >= 0) // board maximum
                            {
                                if (matrix[row][column] == 1 || matrix[row][column] == 2)
                                {
                                    row--;
                                } else if (matrix[row][column] == 0) // piece placed on empty spot
                                {
                                    matrix[row][column] = player;
                                    redWin = winCheck();
                                    repaint();
                                    row -= 6;
                                }
                            }
                        }
                    }

                    if (row != 5) // wont't change players if empty row was clicked
                    {
                        if (player == 1)
                            player++;
                        else if (player == 2)
                            player--;
                    }

                    if (row != 5 && !redWin) // Bot Player
                    {
                        int bestColumn = bot();
                        for (int r = 5; r >= 0; r--) {
                            if (matrix[r][bestColumn] == 0) {
                                matrix[r][bestColumn] = 2;
                                player = 2;
                                yellowWin = winCheck();
                                if (full())
                                    screen = 4;
                                player = 1;
                                break;
                            }
                        }
                    }
                    player = 1;

                    row = 5;
                }
            }
            else
            {
                if (x >= 0 && y >= 0)
                {
                    player = 1;
                    screen = 1;
                    playerOne = blank;
                    playerTwo = blank;
                    redWin = false;
                    yellowWin = false;
                    hoveringTwoPlayer = false;
                    hoveringOnePlayer = false;

                    for (int r = 5; r >= 0; r--)
                    {
                        for (int c = 0; c < matrix[0].length; c++) {
                            if (matrix[r][c] == 1 || matrix[r][c] == 2)
                                matrix[r][c] = 0;
                        }

                    }
                }
            }
        }
        repaint();
    }

    public void mouseMoved (MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        if (screen == 1) // title screen and win screen
        {
            if (x >= 518 && x <= 743 && y >= 550 && y <= 650) // two player button || Home Button
            {
                hoveringTwoPlayer = true;
                repaint();
            }
            else
            {
                hoveringTwoPlayer = false;
                repaint();
            }
            if (x >= 98 && x<= 323 && y >= 550 && y <= 650) // one player button || Play Again Button
            {
                hoveringOnePlayer = true;
                repaint();
            }
            else
            {
                hoveringOnePlayer = false;
                repaint();
            }
        }

        if (screen == 3) // play screen
        {
            if (x < 95 || x > 750) // off the board
            {
                column = -1;
                repaint();
            }
            else if (players == 2 || players == 1 && player == 1) // each column
            {
                column = ((x - 115) / 90);
                repaint();
            }
        }
    }

    public static boolean winCheck ()
    {
        String play = "";
        play += player;

        for (int r = 5; r >= 0; r--) // Horizontal Wins
        {
            String rowString = "";
            for (int c = 0; c < matrix[0].length; c++)
            {
                rowString += matrix[r][c];
            }
            if (rowString.indexOf(play + play + play + play) != -1)
                return true;
        }

        for (int c = 0; c < matrix[0].length; c++) // Vertical Wins
        {
            String columnString = "";
            for (int r = 5; r >= 0; r--) {
                columnString += matrix[r][c];
            }
            if (columnString.indexOf(play + play + play + play) != -1) {
                return true;
            }
        }

        for (int cs = 3; cs >= 1; cs--)
        {
            String diagonalString = "";
            int c = cs;
            for (int r = 5; r >= (cs - 1); r--)
            {
                diagonalString += matrix[r][c];
                c++;
            }
            if (diagonalString.indexOf(play + play + play + play) != -1)
                return true;
        }
        for (int rs = 5; rs >= 3; rs--)
        {
            String diagonalString = "";
            int r = rs;
            for (int c = 0; c <= rs; c++)
            {
                diagonalString += matrix[r][c];
                r--;
            }
            if (diagonalString.indexOf(play + play + play + play) != -1)
                return true;
        }

        for (int cs = 3; cs <= 5; cs++)
        {
            String diagonalString = "";
            int c = cs;
            for (int r = 5; r >= -(cs - 5); r--)
            {
                diagonalString += matrix[r][c];
                c--;
            }
            if (diagonalString.indexOf(play + play + play + play) != -1)
                return true;
        }
        for (int rs = 5; rs >= 3; rs--)
        {
            String diagonalString = "";
            int r = rs;
            for (int c = 6; c >= -(rs - 6); c--)
            {
                diagonalString += matrix[r][c];
                r--;
            }
            if (diagonalString.indexOf(play + play + play + play) != -1)
                return true;
        }

        return false;
    }

    public static boolean full ()
    {
        int top = 0;
        for (int col = 0; col < matrix[0].length; col++)
        {
            if (matrix [0][col] > 0)
                top += 1;
        }
        if (top == 7)
            return true;
        else
            return false;
    }


    public void home () // Goes Home and resets variables
    {
        player = 1;
        playerOne = blank;
        playerTwo = blank;
        redWin = false;
        yellowWin = false;
        hoveringOnePlayer = false;
        hoveringTwoPlayer = false;

        for (int r = 5; r >= 0; r--)
        {
            for (int c = 0; c < matrix[0].length; c ++)
            {
                if (matrix[r][c] == 1 || matrix[r][c] == 2)
                    matrix[r][c] = 0;
            }
        }

    }

    public void reset () // reset board button
    {
        player = 1;
        redWin = false;
        yellowWin = false;

        for (int r = 5; r >= 0; r--)
        {
            for (int c = 0; c < matrix[0].length; c ++)
            {
                if (matrix[r][c] == 1 || matrix[r][c] == 2)
                    matrix[r][c] = 0;
            }
        }

    }

    public static int bot () // bot player
    {
        // completing four in a row

        for (int c = 0; c < matrix[0].length; c++) // Vertical Wins
        {
            String columnString = "";
            for (int r = 5; r >= 0; r--)
            {
                columnString += matrix [r][c];
            }
            if (columnString.indexOf("2" + "2" + "2" + "0") != -1)
                return c;
        }

        for (int cs = 3; cs >= 1; cs--) //diagonal string
        {
            String diagonalString = "";
            int c = cs;
            for (int r = 5; r >= (cs - 1); r--)
            {
                diagonalString += matrix[r][c];
                c++;
            }
            c--;
            if (cs == 3)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    return c - 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    return c - 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    return c - 3;
                }
            }
            else if (cs == 2)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0)
                    {
                        return c - 1;
                    }
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
            else if (cs == 1)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0)
                        return c - 2;
                    else if (diagonalString.indexOf("2" + "2" + "2" + "0") == 1)
                        return c - 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c - 3;
                    else if (diagonalString.indexOf("2" + "2" + "0" + "2") == 1)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c - 4;
                    else if (diagonalString.indexOf("2" + "0" + "2" + "2") == 1)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c - 5;
                    else if (diagonalString.indexOf("0" + "2" + "2" + "2") == 1)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
        }

        for (int rs = 5; rs >= 3; rs--)
        {
            String diagonalString = "";
            int r = rs;
            int c;
            for (c = 0; c <= rs; c++)
            {
                diagonalString += matrix[r][c];
                r--;
            }
            c--;

            if (rs == 3)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    return c - 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    return c - 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    return c - 3;
                }
            }
            else if (rs == 4)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0) {
                        return c - 1;
                    }
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
            else if (rs == 5)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0)
                        return c - 2;
                    else if (diagonalString.indexOf("2" + "2" + "2" + "0") == 1)
                        return c - 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c - 3;
                    else if (diagonalString.indexOf("2" + "2" + "0" + "2") == 1)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c - 4;
                    else if (diagonalString.indexOf("2" + "0" + "2" + "2") == 1)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c - 5;
                    else if (diagonalString.indexOf("0" + "2" + "2" + "2") == 1)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
        }

        for (int cs = 3; cs <= 5; cs++)
        {
            String diagonalString = "";
            int c = cs;
            for (int r = 5; r >= -(cs - 5); r--)
            {
                diagonalString += matrix[r][c];
                c--;
            }
            c++;

            if (cs == 3)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    return c + 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    return c + 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    return c + 3;
                }
            }
            else if (cs == 4)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
            else if (cs == 5)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0) {
                        System.out.println("print");
                        return c + 2;
                    }
                    else if (diagonalString.indexOf("2" + "2" + "2" + "0") == 1)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0) {
                        return c + 3;
                    }
                    else if (diagonalString.indexOf("2" + "2" + "0" + "2") == 1)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c + 4;
                    else if (diagonalString.indexOf("2" + "0" + "2" + "2") == 1)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c + 5;
                    else if (diagonalString.indexOf("0" + "2" + "2" + "2") == 1)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
        }

        for (int rs = 5; rs >= 3; rs--)
        {
            String diagonalString = "";
            int r = rs;
            int c;
            for (c = 6; c >= -(rs - 6); c--)
            {
                diagonalString += matrix[r][c];
                r--;
            }
            c++;

            if (rs == 3)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    return c + 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    return c + 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    return c + 3;
                }
            }
            else if (rs == 4)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
            else if (rs == 5)
            {
                if (diagonalString.indexOf("2" + "2" + "2" + "0") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "2" + "0") == 0)
                        return c + 2;
                    else if (diagonalString.indexOf("2" + "2" + "2" + "0") == 1)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("2" + "2" + "0" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "2" + "0" + "2") == 0)
                        return c + 3;
                    else if (diagonalString.indexOf("2" + "2" + "0" + "2") == 1)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("2" + "0" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("2" + "0" + "2" + "2") == 0)
                        return c + 4;
                    else if (diagonalString.indexOf("2" + "0" + "2" + "2") == 1)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "2" + "2" + "2") != -1)
                {
                    if (diagonalString.indexOf("0" + "2" + "2" + "2") == 0)
                        return c + 5;
                    else if (diagonalString.indexOf("0" + "2" + "2" + "2") == 1)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
        }

        for (int r = 5; r >= 0; r--) // Horizontal Wins
        {
            String rowString = "";
            int c;

            for (c = 0; c < matrix[0].length; c++)
            {
                rowString += matrix[r][c];
            }
            c--;
            int ind = rowString.indexOf("2" + "2" + "2" + "0");
            int ind2 = rowString.indexOf("2" + "2" + "0" + "2");
            int ind3 = rowString.indexOf("2" + "0" + "2" + "2");
            int ind4 = rowString.indexOf("0" + "2" + "2" + "2");

            if (ind != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind + 3] == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind + 3;
                        }
                    }
                }
            }
            else if (ind2 != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind2 + 2] == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind2 + 2;
                        }
                    }
                }
            }
            else if (ind3 != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind3 + 2] == 0 || rS - r == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind3+ 1;
                        }
                    }
                }
            }
            else if (ind4 != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind4] == 0 || rS - r == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind4;
                        }
                    }
                }
            }
        }


        // blocking 4 in a row
        for (int c = 0; c < matrix[0].length; c++) // Vertical Blocks
        {
            String columnString = "";
            for (int r = 5; r >= 0; r--)
            {
                columnString += matrix [r][c];
            }
            if (columnString.indexOf("1" + "1" + "1" + "0") != -1) {
                return c;
            }
        }

        for (int r = 5; r >= 0; r--) // Horizontal Blocks
        {
            String rowString = "";
            int c;

            for (c = 0; c < matrix[0].length; c++)
            {
                rowString += matrix[r][c];
            }
            c -= 1;
            int ind = rowString.indexOf("1" + "1" + "1" + "0");
            int ind2 = rowString.indexOf("1" + "1" + "0" + "1");
            int ind3 = rowString.indexOf("1" + "0" + "1" + "1");
            int ind4 = rowString.indexOf("0" + "1" + "1" + "1");

            if (ind != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind + 3] == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind + 3;
                        }
                    }
                }
            }
            else if (ind2 != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind2 + 2] == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind2 + 2;
                        }
                    }
                }
            }
            else if (ind3 != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind3 + 2] == 0 || rS - r == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind3+ 1;
                        }
                    }
                }
            }
            else if (ind4 != -1)
            {
                for (int rS = 5; rS >= 0; rS--)
                {
                    if (matrix [rS][ind4] == 0 || rS - r == 0)
                    {
                        if (rS - r >= 1 || rS - r == 0)
                        {
                            return ind4;
                        }
                    }
                }
            }
        }

        for (int cs = 3; cs >= 1; cs--) //diagonal string
        {
            String diagonalString = "";
            int c = cs;
            for (int r = 5; r >= (cs - 1); r--)
            {
                diagonalString += matrix[r][c];
                c++;
            }
            c--;
            if (cs == 3)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    return c - 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    return c - 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    return c - 3;
                }
            }
            else if (cs == 2)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0) {
                        System.out.println("heeeee");
                        return c - 1;
                    }
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
            else if (cs == 1)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0)
                        return c - 2;
                    else if (diagonalString.indexOf("1" + "1" + "1" + "0") == 1)
                        return c - 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c - 3;
                    else if (diagonalString.indexOf("1" + "1" + "0" + "1") == 1)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c - 4;
                    else if (diagonalString.indexOf("1" + "0" + "1" + "1") == 1)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c - 5;
                    else if (diagonalString.indexOf("0" + "1" + "1" + "1") == 1)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
        }


        for (int rs = 5; rs >= 3; rs--)
        {
            String diagonalString = "";
            int r = rs;
            int c;
            for (c = 0; c <= rs; c++)
            {
                diagonalString += matrix[r][c];
                r--;
            }
            c--;

            if (rs == 3)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    return c - 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    return c - 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    return c - 3;
                }
            }
            else if (rs == 4)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0) {
                        return c - 1;
                    }
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1) {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
            else if (rs == 5)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    System.out.println(c - 2);
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0)
                        return c - 2;
                    else if (diagonalString.indexOf("1" + "1" + "1" + "0") == 1)
                        return c - 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c - 3;
                    else if (diagonalString.indexOf("1" + "1" + "0" + "1") == 1)
                        return c - 2;
                    else
                        return c - 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c - 4;
                    else if (diagonalString.indexOf("1" + "0" + "1" + "1") == 1)
                        return c - 3;
                    else
                        return c - 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c - 5;
                    else if (diagonalString.indexOf("0" + "1" + "1" + "1") == 1)
                        return c - 4;
                    else
                        return c - 3;
                }
            }
        }


        for (int cs = 3; cs <= 5; cs++)
        {
            String diagonalString = "";
            int c = cs;
            for (int r = 5; r >= -(cs - 5); r--)
            {
                diagonalString += matrix[r][c];
                c--;
            }
            c++;

            if (cs == 3)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    return c + 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    return c + 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    return c + 3;
                }
            }
            else if (cs == 4)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
            else if (cs == 5)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0)
                        return c + 2;
                    else if (diagonalString.indexOf("1" + "1" + "1" + "0") == 1)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c + 3;
                    else if (diagonalString.indexOf("1" + "1" + "0" + "1") == 1)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c + 4;
                    else if (diagonalString.indexOf("1" + "0" + "1" + "1") == 1)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c + 5;
                    else if (diagonalString.indexOf("0" + "1" + "1" + "1") == 1)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
        }


        for (int rs = 5; rs >= 3; rs--)
        {
            String diagonalString = "";
            int r = rs;
            int c;
            for (c = 6; c >= -(rs - 6); c--)
            {
                diagonalString += matrix[r][c];
                r--;
            }

            c++;

            if (rs == 3)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    return c + 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    return c + 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    return c + 3;
                }
            }
            else if (rs == 4)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
            else if (rs == 5)
            {
                if (diagonalString.indexOf("1" + "1" + "1" + "0") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "1" + "0") == 0)
                        return c + 2;
                    else if (diagonalString.indexOf("1" + "1" + "1" + "0") == 1)
                        return c + 1;
                    else
                        return c;
                }
                else if (diagonalString.indexOf("1" + "1" + "0" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "1" + "0" + "1") == 0)
                        return c + 3;
                    else if (diagonalString.indexOf("1" + "1" + "0" + "1") == 1)
                        return c + 2;
                    else
                        return c + 1;
                }
                else if (diagonalString.indexOf("1" + "0" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("1" + "0" + "1" + "1") == 0)
                        return c + 4;
                    else if (diagonalString.indexOf("1" + "0" + "1" + "1") == 1)
                        return c + 3;
                    else
                        return c + 2;
                }
                else if (diagonalString.indexOf("0" + "1" + "1" + "1") != -1)
                {
                    if (diagonalString.indexOf("0" + "1" + "1" + "1") == 0)
                        return c + 5;
                    else if (diagonalString.indexOf("0" + "1" + "1" + "1") == 1)
                        return c + 4;
                    else
                        return c + 3;
                }
            }
        }



        // 3 in a row
        for (int c = 0; c < matrix[0].length; c++) // Vertical Wins
        {
            String columnString = "";
            for (int r = 5; r >= 0; r--)
            {
                columnString += matrix [r][c];
            }
            if (columnString.indexOf("2" + "2" + "0") != -1)
                return c;
        }

        for (int r = 5; r >= 0; r--) // Horizontal Wins
        {
            String rowString = "";
            for (int c = 0; c < matrix[0].length; c++)
            {
                rowString += matrix[r][c];
            }

            if (rowString.indexOf("2" + "2" + "0") != -1) {
                return rowString.indexOf("2" + "2" + "0") + 3;
            }
            else if (rowString.indexOf("2" + "0" + "2") != -1) {
                return rowString.indexOf("2" + "0" + "2") + 2;
            }
            else if (rowString.indexOf("0" + "2" + "2") != -1) {
                return rowString.indexOf("0” + “2” + “2") + 1;
            }
        }

        //blocking 3 in a row

        for (int c = 0; c < matrix[0].length; c++) // Vertical Wins
        {
            String columnString = "";
            for (int r = 5; r >= 0; r--)
            {
                columnString += matrix [r][c];
            }
            if (columnString.indexOf("1" + "1" + "0") != -1)
                return c;
        }

        for (int r = 5; r >= 0; r--) // Horizontal Wins
        {
            String rowString = "";
            for (int c = 0; c < matrix[0].length; c++)
            {
                rowString += matrix[r][c];
            }

            if (rowString.indexOf("1" + "1" + "0") != -1)
                return rowString.indexOf("1" + "1" + "0") + 2;
            else if (rowString.indexOf("1" + "0" + "1") != -1)
                return rowString.indexOf("1" + "0" + "1") + 1;
            else if (rowString.indexOf("0" + "1" + "1") != -1)
                return rowString.indexOf("0" + "1" + "1");
        }


        int bestCol = 0;
        int bestColWeight = 0;

        for (int c = 0; c <= 6; c++)
        {
            for (int r = 5; r >= 0; r--)
            {
                if (matrix [r][c] == 0)
                {
                    int columnWeight = weightBoard[r][c];

                    if (columnWeight > bestColWeight)
                    {
                        bestCol = c;
                        bestColWeight = weightBoard[r][c];
                    }
                }
            }
        }

        return bestCol;
    }

    public void mouseClicked (MouseEvent e)
    {
    }

    public void mouseReleased (MouseEvent e)
    {
    }

    public void mouseEntered (MouseEvent e)
    {
    }

    public void mouseExited (MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
    }
}