import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Board
{
    public static LinkedList<Pieces> myPieces = new LinkedList<>();
    public static Pieces chosenPiece = null;
    public static void main(String[] args) throws IOException
    {
        Image[] pieceImage = new Image[6];
        pieceImage[0] = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\302Project\\src\\PieceImages\\piece(0).png"));
        pieceImage[1] = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\302Project\\src\\PieceImages\\piece(1).png"));
        pieceImage[2] = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\302Project\\src\\PieceImages\\piece(2).png"));
        pieceImage[3] = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\302Project\\src\\PieceImages\\piece(3).png"));
        pieceImage[4] = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\302Project\\src\\PieceImages\\piece(4).png"));
        pieceImage[5] = ImageIO.read(new File("C:\\Users\\user\\IdeaProjects\\302Project\\src\\PieceImages\\piece(5).png"));


        Pieces myKing = new Pieces("king",8,1,myPieces);
        Pieces myQueen = new Pieces("queen",8,2,myPieces);
        Pieces myBishop = new Pieces("bishop",8,3,myPieces);
        Pieces myCastle = new Pieces("castle",8,4,myPieces);
        Pieces myKnight = new Pieces("knight",8,5,myPieces);
        Pieces myPawn = new Pieces("pawn",8,6,myPieces);


        JFrame boardFrame = new JFrame();
        boardFrame.setBounds(20,20,665,623);
        JPanel boardPanel = new JPanel()
        {
            @Override
            public void paint(Graphics g)
            {
                boolean white = true;
                for (int i = 0; i < 8; i++)
                {
                    for (int j = 0; j < 8; j++)
                    {
                        if(white)
                        {
                            g.setColor(Color.white);
                        }
                        else
                        {
                            g.setColor(Color.gray);
                        }
                        g.fillRect(i*72,j*72,72,72);
                        white =! white;
                    }
                    white =! white;
                }
//*************************************************************************************************************************************//
                //Bishop
                ArrayList<Move> b = myBishop.bishopPossible();
                for(Move x : b)
                {
                    int a= x.getX();
                    int c= x.getY();


                g.setColor(Color.cyan);
                g.fillRect(a*72,c*72,72,72);

                }

                //King
                ArrayList<Move> k = myKing.kingPossible();
                for(Move x : k)
                {
                    int a= x.getX();
                    int c= x.getY();


                    g.setColor(Color.cyan);
                    g.fillRect(a*72,c*72,72,72);

                }

                //Castle
                ArrayList<Move> c = myCastle.castlePossible();
                for(Move x : c)
                {
                    int a= x.getX();
                    int d= x.getY();


                    g.setColor(Color.cyan);
                    g.fillRect(a*72,d*72,72,72);

                }

                //Queen
                ArrayList<Move> q = myQueen.queenPossible();
                for(Move x : q)
                {
                    int a= x.getX();
                    int d= x.getY();


                    g.setColor(Color.cyan);
                    g.fillRect(a*72,d*72,72,72);

                }

                //Knight
                ArrayList<Move> kn = myKnight.knightPossible();
                for(Move x : kn)
                {
                    int a= x.getX();
                    int d= x.getY();


                    g.setColor(Color.cyan);
                    g.fillRect(a*72,d*72,72,72);

                }

                //Pawn
                ArrayList<Move> p = myPawn.pawnPossible();
                for(Move x : p)
                {
                    int a= x.getX();
                    int d= x.getY();


                    g.setColor(Color.cyan);
                    g.fillRect(a*72,d*72,72,72);

                }

//**********************************************************************************************************************************************//

                for (Pieces x: myPieces)
                {
                    int index = 0;
                    if(x.name.equalsIgnoreCase("King"))
                    {
                        index = 0;
                    }
                    if(x.name.equalsIgnoreCase("Queen"))
                    {
                        index = 1;
                    }
                    if(x.name.equalsIgnoreCase("Bishop"))
                    {
                        index = 2;
                    }
                    if(x.name.equalsIgnoreCase("Castle"))
                    {
                        index = 3;
                    }
                    if(x.name.equalsIgnoreCase("Knight"))
                    {
                        index = 4;
                    }
                    if(x.name.equalsIgnoreCase("Pawn"))
                    {
                        index = 5;
                    }

                    g.drawImage(pieceImage[index],x.x,x.y,this);
                }
            }

        };

        boardFrame.add(boardPanel);
        boardFrame.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if(chosenPiece != null)
                {
                    chosenPiece.x = e.getX()-35;
                    chosenPiece.y = e.getY()-35;
                    boardFrame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });
        boardFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                chosenPiece = getPiece(e.getX(), e.getY());

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                chosenPiece = getPiece(e.getX(), e.getY());
                //System.out.println(getPiece(e.getX(), e.getY()).name);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                chosenPiece.movePiece(e.getX()/73,e.getY()/73);
                boardFrame.repaint();
//                System.out.println(e.getX()/73);
//                System.out.println(e.getY()/73);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        boardFrame.setDefaultCloseOperation(3);
        boardFrame.setVisible(true);
    }

    public static Pieces getPiece(int x, int y)
    {
        int realXPosition = x/73;
        int realYPosition = y/73;

        for (Pieces a: myPieces)
        {
            if(a.xPosition==realXPosition && a.yPosition==realYPosition)
            {
                return a;
            }
        }
        return null;
    }
}
