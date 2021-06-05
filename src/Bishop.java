import java.util.ArrayList;
import java.util.LinkedList;

public class Bishop extends Pieces
{
    public Bishop(String name, int xPosition, int yPosition, LinkedList<Pieces> p)
    {
        super(name, xPosition, yPosition, p);
    }

    public ArrayList bishopPossible()
    {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(BishoptopRight());

        return allPossibleMoves;

    }

    public ArrayList<Move> BishoptopRight()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX < 7 && tempY<7)
        {
            tempX++;
            tempY++;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }
    public void topLeft()
    {

    }
    public void bottomRight()
    {

    }
    public void bottomLeft()
    {

    }

    public static void main(String[] args)
    {
        LinkedList p = new LinkedList();
        Bishop b = new Bishop("j",3,4,p);

        b.BishoptopRight();
    }

}
