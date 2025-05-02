import javax.swing.JFrame;

public class Main
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 840, 720);
        frame.setTitle("Connect Four! By Cody Black");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ConnectFourGame game = new ConnectFourGame();
        frame.add(game);
        frame.setVisible(true);
    }
}
