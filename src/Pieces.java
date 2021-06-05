import java.util.ArrayList;
import java.util.LinkedList;

//Pieces Super class
public class Pieces
{
    String name;
    int xPosition;
    int yPosition;

    int x;
    int y;
    LinkedList<Pieces> p;

    public Pieces(String name, int xPosition, int yPosition, LinkedList<Pieces> p)
    {
        this.name = name;
        this.xPosition = xPosition;
        x = xPosition*73;
        this.yPosition = yPosition;
        y = yPosition*73;
        this.p = p;
        p.add(this);

    }

    public void  movePiece(int xCoordinate, int yCoordinate)
    {
        if(Board.getPiece(xCoordinate*73,yCoordinate*73) != null)
        {
            if(Board.getPiece(xCoordinate*73,yCoordinate*73)!= Board.getPiece(xCoordinate*73,yCoordinate*73))
            {
                Board.getPiece(xCoordinate*73,yCoordinate*73);
            }
        }
        this.xPosition = xCoordinate;
        x = xPosition*73;
        this.yPosition = yCoordinate;
        y = yPosition*73;
    }


//******************    Bishop Moves

    public ArrayList bishopPossible()
    {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();

        if(xPosition==8)
        {
            allPossibleMoves.add(new Move(9,9));
            return allPossibleMoves;
        }
        else
        {
            allPossibleMoves.addAll(BishoptopRight());
            allPossibleMoves.addAll(BishoptopLeft());
            allPossibleMoves.addAll(BishopbottomLeft());
            allPossibleMoves.addAll(BishopbottomRight());

            return allPossibleMoves;
        }


    }


    private ArrayList<Move> BishopbottomRight()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX > 0 && tempY<7)
        {
            tempX--;
            tempY++;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }

    private ArrayList<Move> BishoptopRight()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX < 7 && tempY < 7)
            {
                tempX++;
                tempY++;
                System.out.println(tempX + " " + tempY);
                moves.add(new Move(tempX, tempY));
            }

        return moves;

    }

    private ArrayList<Move> BishoptopLeft()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX < 7 && tempY>0)
        {
            tempX++;
            tempY--;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }

    private ArrayList<Move> BishopbottomLeft()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX > 0 && tempY>0)
        {
            tempX--;
            tempY--;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }

//**************    King Moves


    public ArrayList<Move> kingPossible()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();

        if (xPosition == 8)
        {
            moves.add(new Move(-1, -1));
            return moves;
        } else
        {
            moves.add(kingDown());
            moves.add(kingRight());
            moves.add(kingUpRight());
            moves.add(kingDownLeft());
            moves.add(kingLeft());
            moves.add(kingUpLeft());
            moves.add(kingUp());
            moves.add(kingDownRight());
            return moves;
        }
    }

    //up + left
    private Move kingDownRight()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempX > 0 && tempY < 7)
        {
            tempX--;
            tempY++;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }
    // down left
    private Move kingDownLeft()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempX > 0 && tempY > 0)
        {
            tempX--;
            tempY--;
            System.out.println(tempX + " " + tempY);
            return new Move(tempX, tempY);
        }
        else
        return new Move(-1,-1);
    }

    // down
    private Move kingDown()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        if (tempY > 0)
        {
            tempY--;
            System.out.println(tempX + " " + tempY);
            return new Move(tempX, tempY);
        }
        return new Move(-1,-1);
    }

    // left
    private Move kingLeft()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempX > 0)
        {
            tempX--;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }

    // right
    private Move kingRight()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempX < 7)
        {
            tempX++;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }

    //up
    private Move kingUp()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempY<7)
        {
            tempY++;
            System.out.println("up"+tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }

    //up + right
    private Move kingUpRight()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempX < 7 && tempY < 7)
        {
            tempX++;
            tempY++;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }

    // down right
    private Move kingUpLeft()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempX < 7 && tempY > 0)
        {
            tempX++;
            tempY--;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }


//********** Castle Possible

    public ArrayList<Move> castlePossible()
    {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();

        if(xPosition==8)
        {
            allPossibleMoves.add(new Move(9,9));
            return allPossibleMoves;
        }
        else
        {
            allPossibleMoves.addAll(castleLeft());
            allPossibleMoves.addAll(castleRight());
            allPossibleMoves.addAll(castleUp());
            allPossibleMoves.addAll(castleDown());
            return allPossibleMoves;
        }
    }

    // down
    private ArrayList<Move> castleDown()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempY > 0)
        {
            tempY--;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }

        return moves;
    }

    // up
    private ArrayList<Move> castleUp()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempY < 7)
        {
            tempY++;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }
        return moves;
    }

    // left
    private ArrayList<Move> castleLeft()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX > 0)
        {
            tempX--;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }
        return moves;
    }

    // right
    private ArrayList<Move> castleRight()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while(tempX < 7)
        {
            tempX++;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }

        return moves;
    }

//********** Queen Possible

    public ArrayList<Move> queenPossible()
    {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();

        if(xPosition==8)
        {
            allPossibleMoves.add(new Move(9,9));
            return allPossibleMoves;
        }
        else
        {
            allPossibleMoves.addAll(queenLeft());
            allPossibleMoves.addAll(queenRight());
            allPossibleMoves.addAll(queenUp());
            allPossibleMoves.addAll(queenDown());
            allPossibleMoves.addAll(queenbottomLeft());
            allPossibleMoves.addAll(queenbottomRight());
            allPossibleMoves.addAll(queentopLeft());
            allPossibleMoves.addAll(queentopRight());
            return allPossibleMoves;
        }
    }

    // down
    private ArrayList<Move> queenDown()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempY > 0)
        {
            tempY--;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }

        return moves;
    }

    // up
    private ArrayList<Move> queenUp()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempY < 7)
        {
            tempY++;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }
        return moves;
    }

    // left
    private ArrayList<Move> queenLeft()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX > 0)
        {
            tempX--;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }
        return moves;
    }

    // right
    private ArrayList<Move> queenRight()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while(tempX < 7)
        {
            tempX++;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY)) ;
        }

        return moves;
    }

    private ArrayList<Move> queenbottomRight()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX > 0 && tempY<7)
        {
            tempX--;
            tempY++;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }

    private ArrayList<Move> queentopRight()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX < 7 && tempY < 7)
        {
            tempX++;
            tempY++;
            System.out.println(tempX + " " + tempY);
            moves.add(new Move(tempX, tempY));
        }

        return moves;

    }

    private ArrayList<Move> queentopLeft()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX < 7 && tempY>0)
        {
            tempX++;
            tempY--;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }

    private ArrayList<Move> queenbottomLeft()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();
        while (tempX > 0 && tempY>0)
        {
            tempX--;
            tempY--;
            System.out.println(tempX+ " " + tempY);
            moves.add(new Move(tempX,tempY));
        }

        return moves;

    }

//************ Knight Possible

    public ArrayList<Move> knightPossible()
    {
        int tempX = xPosition;
        int tempY = yPosition;
        ArrayList<Move> moves = new ArrayList<>();

        if (xPosition == 8)
        {
            moves.add(new Move(-1, -1));
            return moves;
        } else
        {
            moves.add(knightUpLeft2());
            moves.add(knightUp2Left());
            moves.add(knightUpRight2());
            moves.add(knightUp2Right());
            moves.add(knightDown2Right());
            moves.add(knightDownRight2());
            moves.add(knightDownLeft2());
            moves.add(knightDown2Left());

           return moves;
        }
    }

    //up + left^2 &&
    private Move knightUpLeft2()
    {
        int tempX = xPosition;
        int tempY = yPosition;

        if (tempX > 0 && tempY < 7)
        {
            tempX-=2;
            tempY++;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }
    //up^2 + left
    private Move knightUp2Left()
    {
        int tempX = xPosition;
        int tempY = yPosition;

            if (tempX > 0 && tempY < 7)
            {
                tempX--;
                tempY += 2;
                System.out.println(tempX + " " + tempY);
                return (new Move(tempX, tempY));
            }
            return new Move(-1, -1);

    }

    // down left^2
    private Move knightDownLeft2()
    {
        int tempX = xPosition;
        int tempY = yPosition;

            if (tempX > 0 && tempY < 7)
            {
                tempX-=2;
                tempY--;
                System.out.println(tempX + " " + tempY);
                return (new Move(tempX, tempY));
            }
            return new Move(-1,-1);

        }

    //down^2 left
    private Move knightDown2Left()
    {
        int tempX = xPosition;
        int tempY = yPosition;

        if (tempX > 0 && tempY < 7)
        {
            tempX--;
            tempY-=2;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);

    }

    //up^2 + right
    private Move knightUp2Right()
    {
        int tempX = xPosition;
        int tempY = yPosition;

        if (tempX < 7 && tempY < 7)
        {
            tempX++;
            tempY+=2;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);

    }

    //up + right^2
    private Move knightUpRight2()
    {
        int tempX = xPosition;
        int tempY = yPosition;

        if (tempX < 7 && tempY < 6)
        {
            tempX+=2;
            tempY++;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);

    }

    //down^2 + right
    private Move knightDown2Right()
    {
        int tempX = xPosition;
        int tempY = yPosition;

        if (tempX < 7 && tempY < 7)
        {
            tempX++;
            tempY-=2;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);

    }

    //down + right^2
    private Move knightDownRight2()
    {
        int tempX = xPosition;
        int tempY = yPosition;

        if (tempX < 7 && tempY < 6)
        {
            tempX+=2;
            tempY--;
            System.out.println(tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);

    }

//********** Pawn
    public ArrayList<Move> pawnPossible()
    {
    int tempX = xPosition;
    int tempY = yPosition;
    ArrayList<Move> moves = new ArrayList<>();

    if (xPosition == 8)
    {
        moves.add(new Move(-1, -1));
        return moves;
    } else
    {
        moves.add(pawnUp());
        moves.add(pawnUp2());
        return moves;
    }
}
    //up
    private Move pawnUp()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempY>0)
        {
            tempY--;
            System.out.println("up"+tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }

    //up up
    private Move pawnUp2()
    {

        int tempX = xPosition;
        int tempY = yPosition;
        if (tempY>5 && tempY <=7)
        {
            tempY-=2;
            System.out.println("up"+tempX + " " + tempY);
            return (new Move(tempX, tempY));
        }
        return new Move(-1,-1);
    }


}
