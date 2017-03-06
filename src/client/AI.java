package client;

import client.model.*;

import java.util.ArrayList;
import java.util.Vector;


/*
  AI class.
  You should fill body of the method {@link #doTurn}.
  Do not change name or modifiers of the methods or fields
  and do not add constructor for this class.
  You can add as many methods or fields as you want!
  Use world parameter to access and modify game's
  See World interface for more details.
 */

class BeetleNeighbors
{
    // neigbors are dependent to the direction of beetle
    //neibor
    private Cell rightCell;
    private Cell leftCell;
    private Cell frontrightCell;
    private Cell frontleftCell;
    private Cell frontCell;


    BeetleNeighbors(Beetle bt, World game)
    {
        //Cell frontleftCell , frontrightCell , frontCell;

        int frontcellX , frontcellY ; // variables for setting frontcell's position
        int frontleftcellX , frontleftcellY;
        int frontrightcellX , frontrightcellY;

        int cellX = bt.getPosition().getX();
        int cellY = bt.getPosition().getY();


        int mapwidth = game.getMap().getWidth();
        int mapheight= game.getMap().getHeight();
//------------------------------------------------------------------------------------------------------------------

        int rightX , rightY , leftX , leftY; //real right and left not front right and front left

        switch (bt.getDirection())
        {
            case Up:
                leftX = cellX;
                rightX = cellX;
                if(cellY>0)
                    leftY = cellY-1;
                else
                    leftY = mapwidth-1;
                if(cellY<mapwidth-1)
                    rightY = cellY+1;
                else
                    rightY=0;

                break;

            case Right:
                leftY=cellY;
                rightY=cellY;
                if(cellX>0)
                    leftX=cellX-1;
                else
                    leftX=mapheight-1;
                if(cellX<mapheight-1)
                    rightX=cellX+1;
                else
                    rightX=0;

                break;

            case Left:
                leftY=cellY;
                rightY=cellY;

                if(cellX>0)
                    rightX=cellX-1;
                else
                    rightX=mapheight-1;

                if(cellX==mapheight-1)
                    leftX=0;
                else
                    leftX=cellX+1;

                break;

            default: //down
                rightX=cellX;
                leftX=cellX;
                if(cellY>0)
                    rightY=cellY-1;
                else
                    rightY=mapwidth-1;
                if(cellY<mapwidth-1)
                    leftY = cellY+1;
                else
                    leftY = 0;

                break;
        }


        switch (bt.getDirection())
        {
            case Up:

                if(cellX>0)
                {
                    frontleftcellX = cellX - 1;
                    frontrightcellX = cellX - 1;
                }
                else
                {
                    frontleftcellX = game.getMap().getHeight() - 1;
                    frontrightcellX = game.getMap().getHeight() - 1;
                }
                if(cellY>0)
                    frontleftcellY = cellY-1;
                else
                    frontleftcellY = game.getMap().getWidth()-1;

                if(cellY<game.getMap().getWidth()-1)
                    frontrightcellY=cellY+1;
                else
                    frontrightcellY=0;

                frontcellY = cellY;
                if(cellX>0)
                    frontcellX = cellX-1;
                else
                    frontcellX = mapheight-1;

                break;
            case Right:
                if(cellY==game.getMap().getWidth()-1)
                {
                    frontrightcellY = 0;
                    frontleftcellY  = 0;
                }
                else
                {
                    frontrightcellY = cellY+1;
                    frontleftcellY = cellY+1;
                }

                if(cellX == 0)
                    frontleftcellX = game.getMap().getHeight()-1;
                else
                    frontleftcellX = cellX-1;

                if(cellX == game.getMap().getHeight()-1)
                    frontrightcellX = 0;
                else
                    frontrightcellX = cellX+1;

                frontcellX = cellX;
                if(cellY==mapwidth-1)
                    frontcellY = 0;
                else
                    frontcellY = cellY+1;

                break;

            case Left:
                //check ...

                if(cellY>0)
                {
                    frontrightcellY = cellY -1;
                    frontleftcellY = cellY-1;
                }
                else
                {
                    frontrightcellY = game.getMap().getWidth()-1;
                    frontleftcellY = game.getMap().getWidth()-1;
                }

                if(cellX > 0)
                    frontrightcellX = cellX-1;
                else
                    frontrightcellX = game.getMap().getHeight()-1;

                if(cellX<game.getMap().getHeight()-1)
                    frontleftcellX = cellX+1;
                else
                    frontleftcellX = 0;

                frontcellX = cellX;
                if(cellY==0)
                    frontcellY = mapwidth-1;
                else
                    frontcellY = cellY-1;

                break;

            default: // for Down state

                if(cellX<game.getMap().getHeight()-1)
                {
                    frontrightcellX = cellX+1;
                    frontleftcellX = cellX+1;
                }
                else
                {
                    frontrightcellX =0;
                    frontleftcellX=0;
                }

                if(cellY>0)
                    frontrightcellY = cellY-1;
                else
                    frontrightcellY=game.getMap().getWidth()-1;

                if(cellY==game.getMap().getWidth()-1)
                    frontleftcellY =0;
                else
                    frontleftcellY = cellY+1;

                frontcellY = cellY;
                if(cellX == mapheight-1)
                    frontcellX =0;
                else
                    frontcellX = cellX+1;


                break;
        }

        frontleftCell = game.getMap().getCell(frontleftcellX,frontleftcellY);
        frontrightCell = game.getMap().getCell(frontrightcellX,frontrightcellY);
        leftCell = game.getMap().getCell(leftX,leftY);
        rightCell = game.getMap().getCell(rightX,rightY);
        frontCell = game.getMap().getCell(frontcellX,frontcellY);


    }

    public Cell getRightCell() {
        return rightCell;
    }

    public Cell getLeftCell() {
        return leftCell;
    }

    public Cell getFrontrightCell() {
        return frontrightCell;
    }

    public Cell getFrontleftCell() {
        return frontleftCell;
    }

    public Cell getFrontCell() {
        return frontCell;
    }

}

class CellNeighbors
{
    private Cell rightCell;
    private Cell leftCell;
    private Cell upCell;
    private Cell downCell;
    private Cell uprightCell;
    private Cell upleftCell;
    private Cell downrightCell;
    private Cell downleftCell;

    public Cell[] getNeighbors()
    {
        Cell c[] = new Cell[8];
        c[0] = upCell;
        c[1] = uprightCell;
        c[2] = rightCell;
        c[3] = downrightCell;
        c[4] = downCell;
        c[5] = downleftCell;
        c[6] = leftCell;
        c[7] = upleftCell;
        return c;
    }

    public Cell getUprightCell() {
        return uprightCell;
    }

    public Cell getUpleftCell() {
        return upleftCell;
    }

    public Cell getDownrightCell() {
        return downrightCell;
    }

    public Cell getDownleftCell() {
        return downleftCell;
    }

    public Cell getDownCell() {
        return downCell;
    }

    public Cell getRightCell() {
        return rightCell;
    }

    public Cell getLeftCell() {
        return leftCell;
    }

    public Cell getUpCell() {
        return upCell;
    }

    CellNeighbors(Cell c, World game)
    {
        int mapwidth = game.getMap().getWidth();
        int mapheight = game.getMap().getHeight();

        int cellX = c.getX();
        int cellY = c.getY();

        int rightX , rightY , leftX , leftY,upX,upY, downX , downY ;
        int upleftcellX,upleftcellY , uprightcellX,uprightcellY , downleftcellX,downleftcellY ,downrightcellX,downrightcellY ;

        leftX = cellX;
        rightX = cellX;
        if(cellY>0)
            leftY = cellY-1;
        else
            leftY = mapwidth-1;
        //----
        if(cellY<mapwidth-1)
            rightY = cellY+1;
        else
            rightY=0;
        //----
        if(cellX>0)
            upX = cellX-1;
        else
            upX =0;

        upY = cellY;
        //----
        if(cellX==mapheight-1)
            downX=0;
        else
            downX=cellX+1;
        downY=cellY;
        //----

        if(cellX>0)
        {
            upleftcellX = cellX - 1;
            uprightcellX = cellX - 1;
        }
        else
        {
            upleftcellX = game.getMap().getHeight() - 1;
            uprightcellX = game.getMap().getHeight() - 1;
        }
        if(cellY>0)
            upleftcellY = cellY-1;
        else
            upleftcellY = game.getMap().getWidth()-1;

        if(cellY<game.getMap().getWidth()-1)
            uprightcellY=cellY+1;
        else
            uprightcellY=0;
        //----------
        if(cellX<game.getMap().getHeight()-1)
        {
            downrightcellX = cellX+1;
            downleftcellX = cellX+1;
        }
        else
        {
            downrightcellX =0;
            downleftcellX=0;
        }

        if(cellY>0)
            downrightcellY = cellY-1;
        else
            downrightcellY=game.getMap().getWidth()-1;

        if(cellY==game.getMap().getWidth()-1)
            downleftcellY =0;
        else
            downleftcellY = cellY+1;


        rightCell = game.getMap().getCell(rightX,rightY);
        leftCell  = game.getMap().getCell(leftX,leftY);
        upCell = game.getMap().getCell(upX,upY);
        downCell = game.getMap().getCell(downX,downY);
        uprightCell = game.getMap().getCell(uprightcellX,uprightcellY);
        upleftCell = game.getMap().getCell(upleftcellX,upleftcellY);
        downleftCell = game.getMap().getCell(downleftcellX,downleftcellY);
        downrightCell = game.getMap().getCell(downrightcellX,downrightcellY);

    }

}



public class AI {


    public void GetOutOfSlipper(World game, boolean changed[][][][], ArrayList<Beetle> hadDeterMove)
    {
        for (Cell slipperCell :
                game.getMap().getSlipperCells()) {

            if (slipperCell == null) continue;


            CellNeighbors slipperCellneighbors = new CellNeighbors(slipperCell,game);

            if(slipperCell.getBeetle()!=null)  // is there any beetle in the center of slipper ?!
            {
                boolean status=false;
                // searching for a teleport

                for (Cell cnbs :
                        slipperCellneighbors.getNeighbors()) {
                    if (cnbs.getTeleport() != null)
                    {
                        status = true;
                        if(!mybeetlemove(game,changed,((Beetle)slipperCell.getBeetle()),cnbs.getX(),cnbs.getY()))
                            mydeterministicmove(game,changed,((Beetle)slipperCell.getBeetle()),cnbs.getX(),cnbs.getY(),hadDeterMove);
                        break;
                    }
                }


                if(!status) // there is not any teleport around the beetle
                {
                    Beetle bt = (Beetle)slipperCell.getBeetle();
                    BeetleNeighbors btnbrs = new BeetleNeighbors(bt,game);
                    if(btnbrs.getFrontCell().getBeetle()==null)
                    {
                        if(!mybeetlemove(game,changed,bt,btnbrs.getFrontCell().getX(),btnbrs.getFrontCell().getY()))
                            mydeterministicmove(game,changed,bt,btnbrs.getFrontCell().getX(),btnbrs.getFrontCell().getY(),hadDeterMove);
                    }
                    else if(btnbrs.getRightCell().getBeetle()==null)
                    {
                        if(!mybeetlemove(game,changed,bt,btnbrs.getRightCell().getX(),btnbrs.getRightCell().getY()))
                            mydeterministicmove(game,changed,bt,btnbrs.getRightCell().getX(),btnbrs.getRightCell().getY(),hadDeterMove);
                    }
                    else
                    {
                        if(!mybeetlemove(game,changed,bt,btnbrs.getLeftCell().getX(),btnbrs.getLeftCell().getY()))
                            mydeterministicmove(game,changed,bt,btnbrs.getLeftCell().getX(),btnbrs.getLeftCell().getY(),hadDeterMove);
                    }
                }
            }

            if(slipperCellneighbors.getRightCell().getBeetle()!=null) // Beetle in right cell
            {
                CellNeighbors rightneighbor = new CellNeighbors(slipperCellneighbors.getRightCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getRightCell().getBeetle(),rightneighbor.getRightCell().getX(),rightneighbor.getRightCell().getY()))
                    mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getRightCell().getBeetle(),rightneighbor.getRightCell().getX(),rightneighbor.getRightCell().getY(),hadDeterMove);

            }

            if(slipperCellneighbors.getDownrightCell().getBeetle()!=null) // Beetle in down right cell
            {
                CellNeighbors downrightneighbor = new CellNeighbors(slipperCellneighbors.getDownrightCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getDownrightCell().getBeetle(),downrightneighbor.getDownCell().getX(),downrightneighbor.getDownCell().getY()))
                    if(!mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getDownrightCell().getBeetle(),downrightneighbor.getDownCell().getX(),downrightneighbor.getDownCell().getY(),hadDeterMove))
                        if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getDownrightCell().getBeetle(),downrightneighbor.getRightCell().getX(),downrightneighbor.getRightCell().getY()))
                            mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getDownrightCell().getBeetle(),downrightneighbor.getRightCell().getX(),downrightneighbor.getRightCell().getY(),hadDeterMove);


            }

            if(slipperCellneighbors.getDownCell().getBeetle()!=null) // Beetle in down cell
            {
                CellNeighbors downneighbor = new CellNeighbors(slipperCellneighbors.getDownCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getDownCell().getBeetle(),downneighbor.getDownCell().getX(),downneighbor.getDownCell().getY()))
                    mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getDownCell().getBeetle(),downneighbor.getDownCell().getX(),downneighbor.getDownCell().getY(),hadDeterMove);
            }

            if(slipperCellneighbors.getDownleftCell().getBeetle()!=null) // Beetle in downleft cell
            {
                CellNeighbors downleftneighbor = new CellNeighbors(slipperCellneighbors.getDownleftCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getDownleftCell().getBeetle(),downleftneighbor.getDownCell().getX(),downleftneighbor.getDownCell().getY()))
                    if(!mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getDownleftCell().getBeetle(),downleftneighbor.getDownCell().getX(),downleftneighbor.getDownCell().getY(),hadDeterMove))
                        if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getDownleftCell().getBeetle(),downleftneighbor.getLeftCell().getX(),downleftneighbor.getLeftCell().getY()))
                            mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getDownleftCell().getBeetle(),downleftneighbor.getLeftCell().getX(),downleftneighbor.getLeftCell().getY(),hadDeterMove);

            }

            if(slipperCellneighbors.getLeftCell().getBeetle()!=null) // Beetle in left cell
            {
                CellNeighbors leftneighbor = new CellNeighbors(slipperCellneighbors.getLeftCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getLeftCell().getBeetle(),leftneighbor.getLeftCell().getX(),leftneighbor.getLeftCell().getY()))
                    mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getLeftCell().getBeetle(),leftneighbor.getLeftCell().getX(),leftneighbor.getLeftCell().getY(),hadDeterMove);
            }

            if(slipperCellneighbors.getUpleftCell().getBeetle()!=null) // Beetle in upleft cell
            {
                CellNeighbors upleft = new CellNeighbors(slipperCellneighbors.getUpleftCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getUpleftCell().getBeetle(),upleft.getUpCell().getX(),upleft.getUpCell().getY()))
                    if(!mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getUpleftCell().getBeetle(),upleft.getUpCell().getX(),upleft.getUpCell().getY(),hadDeterMove))
                        if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getUpleftCell().getBeetle(),upleft.getLeftCell().getX(),upleft.getLeftCell().getY()))
                            mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getUpleftCell().getBeetle(),upleft.getLeftCell().getX(),upleft.getLeftCell().getY(),hadDeterMove);
            }

            if(slipperCellneighbors.getUpCell().getBeetle()!=null) // Beetle in up cell
            {
                CellNeighbors up = new CellNeighbors(slipperCellneighbors.getUpCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getUpCell().getBeetle(),up.getUpCell().getX(),up.getUpCell().getY()))
                    mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getUpCell().getBeetle(),up.getUpCell().getX(),up.getUpCell().getY(),hadDeterMove);
            }

            if(slipperCellneighbors.getUprightCell().getBeetle()!=null)  //upright
            {
                CellNeighbors upright = new CellNeighbors(slipperCellneighbors.getUprightCell(),game);
                if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getUprightCell().getBeetle(),upright.getUpCell().getX(),upright.getUpCell().getY()))
                    if(!mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getUprightCell().getBeetle(),upright.getUpCell().getX(),upright.getUpCell().getY(),hadDeterMove))
                        if(!mybeetlemove(game,changed,(Beetle)slipperCellneighbors.getUprightCell().getBeetle(),upright.getRightCell().getX(),upright.getRightCell().getY()))
                            mydeterministicmove(game,changed,(Beetle)slipperCellneighbors.getUprightCell().getBeetle(),upright.getRightCell().getX(),upright.getRightCell().getY(),hadDeterMove);
            }
        }
    }

    public CellState[] BeetleStatus(World game , Beetle bt) // returns beetle's left front right status ...
    {
        CellState ans[] = new CellState[3]; // right - front - left

        ArrayList<Cell> MyCells = new ArrayList<>();
        for (Cell c :
                game.getMap().getMyCells()) {
            if (c == null)
                continue;
            MyCells.add(c);
        }

        Cell frontleftCell , frontrightCell , frontCell;

        int frontcellX , frontcellY ; // variables for setting frontcell's position
        int frontleftcellX , frontleftcellY;
        int frontrightcellX , frontrightcellY;

        int cellX = bt.getPosition().getX();
        int cellY = bt.getPosition().getY();

        switch (bt.getDirection())
        {
            case Up:

                if(cellX>0)
                {
                    frontleftcellX = cellX - 1;
                    frontrightcellX = cellX - 1;
                }
                else
                {
                    frontleftcellX = game.getMap().getHeight() - 1;
                    frontrightcellX = game.getMap().getHeight() - 1;
                }
                if(cellY>0)
                    frontleftcellY = cellY-1;
                else
                    frontleftcellY = game.getMap().getWidth()-1;

                if(cellY<game.getMap().getWidth()-1)
                    frontrightcellY=cellY+1;
                else
                    frontrightcellY=0;

                frontcellX = bt.getPosition().getX();
                frontcellY = bt.getPosition().getY();
                while (true)
                {
                    frontcellX -= 1;

                    if(frontcellX < 0)
                        frontcellX = game.getMap().getHeight()-1;

                    if(game.getMap().getCell(frontcellX,frontcellY).getBeetle() != null)
                    {
                        frontCell = game.getMap().getCell(frontcellX,frontcellY);
                        break;
                    }
                }
                break;

            case Right:
                if(cellY==game.getMap().getWidth()-1)
                {
                    frontrightcellY = 0;
                    frontleftcellY  = 0;
                }
                else
                {
                    frontrightcellY = cellY+1;
                    frontleftcellY = cellY+1;
                }

                if(cellX == 0)
                    frontleftcellX = game.getMap().getHeight()-1;
                else
                    frontleftcellX = cellX-1;

                if(cellX == game.getMap().getHeight()-1)
                    frontrightcellX = 0;
                else
                    frontrightcellX = cellX+1;

                frontcellX = bt.getPosition().getX();
                frontcellY = bt.getPosition().getY();
                while (true)
                {
                    frontcellY += 1;

                    if(frontcellY>=game.getMap().getWidth())
                        frontcellY = 0;

                    if(game.getMap().getCell(frontcellX,frontcellY).getBeetle()!=null)
                    {
                        frontCell = game.getMap().getCell(frontcellX,frontcellY);
                        break;
                    }
                }


                break;

            case Left:
                //check ...

                if(cellY>0)
                {
                    frontrightcellY = cellY -1;
                    frontleftcellY = cellY-1;
                }
                else
                {
                    frontrightcellY = game.getMap().getWidth()-1;
                    frontleftcellY = game.getMap().getWidth()-1;
                }

                if(cellX > 0)
                    frontrightcellX = cellX-1;
                else
                    frontrightcellX = game.getMap().getHeight()-1;

                if(cellX<game.getMap().getHeight()-1)
                    frontleftcellX = cellX+1;
                else
                    frontleftcellX = 0;

                frontcellX = bt.getPosition().getX();
                frontcellY = bt.getPosition().getY();
                while (true)
                {
                    frontcellY-=1;

                    if(frontcellY<0)
                        frontcellY = game.getMap().getWidth()-1;

                    if(game.getMap().getCell(frontcellX,frontcellY).getBeetle()!=null)
                    {
                        frontCell = game.getMap().getCell(frontcellX,frontcellY);
                        break;
                    }
                }

                break;

            default: // for Down state

                if(cellX<game.getMap().getHeight()-1)
                {
                    frontrightcellX = cellX+1;
                    frontleftcellX = cellX+1;
                }
                else
                {
                    frontrightcellX =0;
                    frontleftcellX=0;
                }

                if(cellY>0)
                    frontrightcellY = cellY-1;
                else
                    frontrightcellY=game.getMap().getWidth()-1;

                if(cellY==game.getMap().getWidth()-1)
                    frontleftcellY =0;
                else
                    frontleftcellY = cellY+1;


                frontcellX = bt.getPosition().getX();
                frontcellY = bt.getPosition().getY();

                while (true)
                {
                    frontcellX+=1;

                    if (frontcellX >= game.getMap().getHeight())
                        frontcellX = 0;

                    if(game.getMap().getCell(frontcellX,frontcellY).getBeetle()!=null)
                    {
                        frontCell = game.getMap().getCell(frontcellX,frontcellY);
                        break;
                    }
                }
                break;
        }

        frontleftCell = game.getMap().getCell(frontleftcellX,frontleftcellY);
        frontrightCell = game.getMap().getCell(frontrightcellX,frontrightcellY);
        //System.out.println("rightcellX : " + rightcellX +"\nrightcellY : " + rightcellY);

        if(frontrightCell.getBeetle()==null)
            ans[0] = CellState.Blank;
        else if(MyCells.contains(frontrightCell))
            ans[0] = CellState.Ally;
        else
            ans[0]=CellState.Enemy;
        //--------------------------------
        if(MyCells.contains(frontCell))
            ans[1] = CellState.Ally;
        else
            ans[1]=CellState.Enemy;
        //--------------------------------
        if(frontleftCell.getBeetle()==null)
            ans[2] = CellState.Blank;
        else if(MyCells.contains(frontleftCell))
            ans[2] = CellState.Ally;
        else
            ans[2]=CellState.Enemy;

        return  ans;

    }

    public boolean mydeterministicmove(World game , boolean changed[][][][],Beetle bt , int destX,int destY,ArrayList<Beetle> hadDeterMove)
    {

        CellState beetlestatus[] = BeetleStatus(game,bt);

        // Normal X and Y
        int PathX1 = Math.abs(bt.getPosition().getX() - destX);     // Path 1
        int PathY1 = Math.abs(bt.getPosition().getY() - destY);
        // Normal Y and circulate X
        int PathX2 = game.getMap().getHeight() - PathX1;             // Path 2
        int PathY2 = PathY1;
        // Normal X and circulate Y
        int PathX3 = PathX1;                                          //Path 3
        int PathY3 = game.getMap().getWidth() - PathY1;
        // circulate X and Y
        int PathX4 = game.getMap().getHeight() - PathX1;              //Path 4
        int PathY4 = game.getMap().getWidth() - PathY1;

        int NearestPath = 1;
        int minX = PathX1;
        int minY = PathY1;
        if((PathX2+PathY2) < (minX+minY))
        {
            minX = PathX2;
            minY = PathY2;
            NearestPath = 2;
        }
        if((PathX3+PathY3) < (minX + minY))
        {
            minX = PathX3;
            minY = PathY3;
            NearestPath = 3;
        }
        if((PathX4 + PathY4) < (minX+minY)) {
            minX = PathX4;
            minY = PathY4;
            NearestPath = 4;
        }


        Move final_state = Move.stepForward; // beetle's decided movement
        if(bt.getPosition().getX()==destX && bt.getPosition().getY()==destY) // dadash dari eshtebah mizani!!!
            return false;

        switch (NearestPath)
        {
            case 1:
                if( bt.getPosition().getX() == destX)
                {
                    if(bt.getPosition().getY()>destY)
                    {
                        if(bt.getDirection()==Direction.Up)
                            final_state=Move.turnLeft;
                        else if(bt.getDirection()==Direction.Down || bt.getDirection()==Direction.Right)
                            final_state=Move.turnRight;
                        else
                            final_state=Move.stepForward;
                    }
                    else
                    {
                        if(bt.getDirection()==Direction.Up)
                            final_state=Move.turnRight;
                        else if(bt.getDirection()==Direction.Down || bt.getDirection()==Direction.Left)
                            final_state=Move.turnLeft;
                        else
                            final_state=Move.stepForward;
                    }
                }
                else
                {
                    if(bt.getPosition().getX()>destX)
                    {
                        if(bt.getDirection()==Direction.Up)
                            final_state=Move.stepForward;
                        else if(bt.getDirection()==Direction.Down || bt.getDirection()==Direction.Right)
                            final_state=Move.turnLeft;
                        else
                            final_state=Move.turnRight;
                    }
                    else
                    {
                        if(bt.getDirection()==Direction.Down)
                            final_state=Move.stepForward;
                        else if(bt.getDirection()==Direction.Right || bt.getDirection()==Direction.Up)
                            final_state=Move.turnRight;
                        else
                            final_state=Move.turnLeft;
                    }
                }
                break;


            // Normal Y and circulate X   So always bt.getposition.getX != destX
            case 2:
                if(bt.getPosition().getX() > destX)
                {

                    if(bt.getDirection() == Direction.Left)
                        final_state = Move.turnLeft;
                    else if(bt.getDirection() == Direction.Right  ||  bt.getDirection()==Direction.Up)
                        final_state = Move.turnRight;
                    else
                        final_state = Move.stepForward;

                }
                else if(bt.getPosition().getX() < destX)
                {
                    if(bt.getDirection() == Direction.Right)
                        final_state = Move.turnLeft;
                    else if(bt.getDirection() == Direction.Left || bt.getDirection() == Direction.Down)
                        final_state = Move.turnRight;
                    else
                        final_state = Move.stepForward;

                }
                break;


            // Normal X and circulate Y   So always bt.getposition.getY != destY
            case 3:
                if(bt.getPosition().getY() > destY)
                {
                    if(bt.getDirection() == Direction.Up )
                        final_state = Move.turnRight;
                    else if(bt.getDirection() == Direction.Down || bt.getDirection() == Direction.Left)
                        final_state = Move.turnLeft;
                    else
                        final_state = Move.stepForward;
                }
                else if(bt.getPosition().getY() < destY)
                {
                    if(bt.getDirection() == Direction.Up)
                        final_state = Move.turnLeft;
                    else if(bt.getDirection() == Direction.Down || bt.getDirection()==Direction.Right)
                        final_state = Move.turnRight;
                    else
                        final_state = Move.stepForward;
                }
                break;



            // circulate X and Y so always bt.getposition.getY != destY   and bt.getposition.getX != destX
            // it's enough to set one of X or Y equal together
            // Set Equal bt.getposition.getY and dest Y
            case 4:
                if(bt.getPosition().getX() > destX)
                {
                    if(bt.getPosition().getY() > destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnLeft;
                        else if(bt.getDirection() == Direction.Up || bt.getDirection() == Direction.Left)
                            final_state = Move.turnRight;
                        else
                            final_state = Move.stepForward;


                    }
                    else if(bt.getPosition().getY() < destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnRight;
                        else if(bt.getDirection() == Direction.Up || bt.getDirection() == Direction.Right)
                            final_state = Move.turnLeft;
                        else
                            final_state = Move.stepForward;
                    }

                }
                else if(bt.getPosition().getX() < destX)
                {
                    if(bt.getPosition().getY() > destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnLeft;
                        else if(bt.getDirection() == Direction.Up || bt.getDirection() == Direction.Left)
                            final_state = Move.turnRight;
                        else
                            final_state = Move.stepForward;

                    }
                    else if(bt.getPosition().getY() < destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnRight;
                        else  if (bt.getDirection() == Direction.Right || bt.getDirection() == Direction.Up)
                            final_state = Move.turnLeft;
                        else
                            final_state = Move.stepForward;

                    }

                }
                break;

            default:
                final_state = Move.stepForward;
                break;
        }


        //check if this beetle is already under slipper for the next if condition ...
        ArrayList<Cell> underslippercells = new ArrayList<>();
        for (Cell c :
                game.getMap().getSlipperCells()) {
            if (c == null) continue;

            CellNeighbors nbr = new CellNeighbors(c,game);
            for (Cell x :
                    nbr.getNeighbors()) {
                underslippercells.add(x);
            }
            underslippercells.add(c);
        }

        if((!hadDeterMove.contains(bt)))
        {
            hadDeterMove.add(bt);
            game.deterministicMove(bt,final_state);
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean mybeetlemove(World game , boolean changed[][][][],Beetle bt , int destX,int destY)
    {
        // TODO: 26/02/2017 set all path to : first equal X of two point and then set equal Y
        /*
            first of all set X position and after that Y position
         */

        CellState beetlestatus[] = BeetleStatus(game,bt);



        // Normal X and Y
        int PathX1 = Math.abs(bt.getPosition().getX() - destX);     // Path 1
        int PathY1 = Math.abs(bt.getPosition().getY() - destY);
        // Normal Y and circulate X
        int PathX2 = game.getMap().getHeight() - PathX1;             // Path 2
        int PathY2 = PathY1;
        // Normal X and circulate Y
        int PathX3 = PathX1;                                          //Path 3
        int PathY3 = game.getMap().getWidth() - PathY1;
        // circulate X and Y
        int PathX4 = game.getMap().getHeight() - PathX1;              //Path 4
        int PathY4 = game.getMap().getWidth() - PathY1;

        int NearestPath = 1;
        int minX = PathX1;
        int minY = PathY1;
        if((PathX2+PathY2) < (minX+minY))
        {
            minX = PathX2;
            minY = PathY2;
            NearestPath = 2;
        }
        if((PathX3+PathY3) < (minX + minY))
        {
            minX = PathX3;
            minY = PathY3;
            NearestPath = 3;
        }
        if((PathX4 + PathY4) < (minX+minY)) {
            minX = PathX4;
            minY = PathY4;
            NearestPath = 4;
        }

        ////System.out.println("Min Path" + (minX + minY));
        ////System.out.println(" Path Select" + NearestPath);

        Move final_state = Move.stepForward; // beetle's decided movement
        if(bt.getPosition().getX()==destX && bt.getPosition().getY()==destY) // dadash dari eshtebah mizani!!!
            return false;

        int front , right , left;

        switch (NearestPath)
        {
            case 1:
                if( bt.getPosition().getX() == destX)
                {
                    if(bt.getPosition().getY()>destY)
                    {
                        if(bt.getDirection()==Direction.Up)
                            final_state=Move.turnLeft;
                        else if(bt.getDirection()==Direction.Down || bt.getDirection()==Direction.Right)
                            final_state=Move.turnRight;
                        else
                            final_state=Move.stepForward;
                    }
                    else
                    {
                        if(bt.getDirection()==Direction.Up)
                            final_state=Move.turnRight;
                        else if(bt.getDirection()==Direction.Down || bt.getDirection()==Direction.Left)
                            final_state=Move.turnLeft;
                        else
                            final_state=Move.stepForward;
                    }
                }
                else
                {
                    if(bt.getPosition().getX()>destX)
                    {
                        if(bt.getDirection()==Direction.Up)
                            final_state=Move.stepForward;
                        else if(bt.getDirection()==Direction.Down || bt.getDirection()==Direction.Right)
                            final_state=Move.turnLeft;
                        else
                            final_state=Move.turnRight;
                    }
                    else
                    {
                        if(bt.getDirection()==Direction.Down)
                            final_state=Move.stepForward;
                        else if(bt.getDirection()==Direction.Right || bt.getDirection()==Direction.Up)
                            final_state=Move.turnRight;
                        else
                            final_state=Move.turnLeft;
                    }
                }
                break;


            // Normal Y and circulate X   So always bt.getposition.getX != destX
            case 2:
                if(bt.getPosition().getX() > destX)
                {

                    if(bt.getDirection() == Direction.Left)
                        final_state = Move.turnLeft;
                    else if(bt.getDirection() == Direction.Right  ||  bt.getDirection()==Direction.Up)
                        final_state = Move.turnRight;
                    else
                        final_state = Move.stepForward;

                }
                else if(bt.getPosition().getX() < destX)
                {
                    if(bt.getDirection() == Direction.Right)
                        final_state = Move.turnLeft;
                    else if(bt.getDirection() == Direction.Left || bt.getDirection() == Direction.Down)
                        final_state = Move.turnRight;
                    else
                        final_state = Move.stepForward;

                }
                break;


            // Normal X and circulate Y   So always bt.getposition.getY != destY
            case 3:
                if(bt.getPosition().getY() > destY)
                {
                    if(bt.getDirection() == Direction.Up )
                        final_state = Move.turnRight;
                    else if(bt.getDirection() == Direction.Down || bt.getDirection() == Direction.Left)
                        final_state = Move.turnLeft;
                    else
                        final_state = Move.stepForward;
                }
                else if(bt.getPosition().getY() < destY)
                {
                    if(bt.getDirection() == Direction.Up)
                        final_state = Move.turnLeft;
                    else if(bt.getDirection() == Direction.Down || bt.getDirection()==Direction.Right)
                        final_state = Move.turnRight;
                    else
                        final_state = Move.stepForward;
                }
                break;



            // circulate X and Y so always bt.getposition.getY != destY   and bt.getposition.getX != destX
            // it's enough to set one of X or Y equal together
            // Set Equal bt.getposition.getY and dest Y
            case 4:
                if(bt.getPosition().getX() > destX)
                {
                    if(bt.getPosition().getY() > destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnLeft;
                        else if(bt.getDirection() == Direction.Up || bt.getDirection() == Direction.Left)
                            final_state = Move.turnRight;
                        else
                            final_state = Move.stepForward;


                    }
                    else if(bt.getPosition().getY() < destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnRight;
                        else if(bt.getDirection() == Direction.Up || bt.getDirection() == Direction.Right)
                            final_state = Move.turnLeft;
                        else
                            final_state = Move.stepForward;
                    }

                }
                else if(bt.getPosition().getX() < destX)
                {
                    if(bt.getPosition().getY() > destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnLeft;
                        else if(bt.getDirection() == Direction.Up || bt.getDirection() == Direction.Left)
                            final_state = Move.turnRight;
                        else
                            final_state = Move.stepForward;

                    }
                    else if(bt.getPosition().getY() < destY)
                    {
                        if(bt.getDirection() == Direction.Down)
                            final_state = Move.turnRight;
                        else  if (bt.getDirection() == Direction.Right || bt.getDirection() == Direction.Up)
                            final_state = Move.turnLeft;
                        else
                            final_state = Move.stepForward;

                    }

                }
                break;

            default:
                final_state = Move.stepForward;
                break;

        }

        if(Strategies[bt.getBeetleType().getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()] == final_state)
        {
            changed[bt.getBeetleType().getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()]=true;
            return true;
        }

        if(changed[bt.getBeetleType().getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()] == true) // it has changed ):
        {

            BeetleType new_type;
            if(bt.getBeetleType()==BeetleType.HIGH)
                new_type = BeetleType.LOW;
            else
                new_type = BeetleType.HIGH;
            if(!changed[new_type.getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()])
            {
                game.changeType(bt, new_type);
            }
            else
            {
                return false;
            }
        }


        game.changeStrategy(bt.getBeetleType(),beetlestatus[0],beetlestatus[1],beetlestatus[2],final_state);
        Strategies[bt.getBeetleType().getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()] = final_state;
        changed[bt.getBeetleType().getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()] =true;

        return true;
    }


    public int NumberOfCycle(World game , Beetle beetle , Cell end)
    {
        Cell start = beetle.getPosition();

        // Normal X and Y
        int PathX1 = Math.abs(start.getX() - end.getX());     // Path 1
        int PathY1 = Math.abs(start.getY() - end.getY());
        // Normal Y and circulate X
        int PathX2 = game.getMap().getHeight() - PathX1;             // Path 2
        int PathY2 = PathY1;
        // Normal X and circulate Y
        int PathX3 = PathX1;                                          //Path 3
        int PathY3 = game.getMap().getWidth() - PathY1;
        // circulate X and Y
        int PathX4 = game.getMap().getHeight() - PathX1;              //Path 4
        int PathY4 = game.getMap().getWidth() - PathY1;

        int NearestPath = 1;
        int minX = PathX1;
        int minY = PathY1;
        if((PathX2+PathY2) < (minX+minY))
        {
            minX = PathX2;
            minY = PathY2;
            NearestPath = 2;
        }
        if((PathX3+PathY3) < (minX + minY))
        {
            minX = PathX3;
            minY = PathY3;
            NearestPath = 3;
        }
        if((PathX4 + PathY4) < (minX+minY)) {
            minX = PathX4;
            minY = PathY4;
            NearestPath = 4;
        }

        //int dist=Math.abs( start.getX() - end.getX()) + Math.abs(start.getY() + end.getY());
        int dist = minX + minY;
        int turn = 0;





    switch (NearestPath) {
    case 1:
        if (start.getX() == end.getX())
        {
            if (start.getY() < end.getY()) {
                if (beetle.getDirection() == Direction.Up || beetle.getDirection() == Direction.Down)
                    turn++;
                else if (beetle.getDirection() == Direction.Left)
                    turn += 2;

            } else if (start.getY() > end.getY()) {
                if (beetle.getDirection() == Direction.Up || beetle.getDirection() == Direction.Down)
                    turn++;
                else if (beetle.getDirection() == Direction.Right)
                    turn += 2;
            }

        } else {
            if(start.getY() != end.getY())
            {
                turn++;  // turn when start.getY == end.getY
                if(start.getX() > end.getX())
                {
                    //first set both X equal
                    if(beetle.getDirection() == Direction.Left || beetle.getDirection() == Direction.Right)
                        turn ++;
                    else if(beetle.getDirection() == Direction.Down)
                        turn += 2;
                }
                else if (start.getX() < end.getX())
                {
                    if(beetle.getDirection() == Direction.Left || beetle.getDirection() == Direction.Right)
                        turn ++;
                    else if(beetle.getDirection() == Direction.Up)
                        turn += 2;
                }
            }
            else if (start.getY() == end.getY())
            {

                if(beetle.getDirection() == Direction.Right || beetle.getDirection() == Direction.Left)
                    turn++;
                else if(start.getX() > end.getX())
                {
                         if(beetle.getDirection() == Direction.Down)
                              turn += 2;
                }
                else if(start.getX() < end.getX())
                {
                         if(beetle.getDirection() == Direction.Up )
                              turn+=2;
                }
            }
        }
        break;

    case 2:     // Normal Y and circulate X

            if(start.getX() > end.getX())
            {
                if(start.getY() != end.getY())
                    turn++;
                if(beetle.getDirection() == Direction.Left || beetle.getDirection() == Direction.Right)
                    turn++;
                else if(beetle.getDirection() == Direction.Up)
                    turn += 2;

            }
            else if(start.getX() < end.getX())
            {
                if(start.getY() != end.getY())
                    turn++;   // turn when beetle.X == end.X
                if(beetle.getDirection() == Direction.Left || beetle.getDirection() == Direction.Right)
                    turn++;
                else if(beetle.getDirection() == Direction.Down)
                    turn += 2;
            }
            break;


    case 3:     // Normal X and circulate Y

        if(start.getY() > end.getY())
        {
            if(start.getX() != end.getX())
                turn++;
            if(beetle.getDirection() == Direction.Down || beetle.getDirection() == Direction.Up)
                turn ++;
            else if(beetle.getDirection() == Direction.Left)
                turn += 2;
        }
        else if (start.getY() < end.getY())
        {
            if(start.getX() != end.getX())
                turn++;
            if(beetle.getDirection() == Direction.Down || beetle.getDirection() == Direction.Up)
                turn ++;
            else if(beetle.getDirection() == Direction.Right)
                turn += 2;


        }
        break;


    case 4:     // circulate Y and X
        if(start.getX() > end.getX())
        {
            if(start.getY() > end.getY() || start.getY() < end.getY())
            {
                turn++;
                if(beetle.getDirection() == Direction.Left || beetle.getDirection() == Direction.Right)
                    turn ++;
                else if (beetle.getDirection() == Direction.Up)
                    turn += 2;
            }

        }
        else if(start.getX()  < end.getX())
        {
            if(start.getY() > end.getY() || start.getY() < end.getY())
            {
                turn++;
                if (beetle.getDirection() == Direction.Right || beetle.getDirection() == Direction.Left)
                    turn++;
                else if (beetle.getDirection() == Direction.Down)
                    turn += 2;
            }
        }
        break;
        }
        return turn + dist;
    }

    public void GetNearestBeetleToFood(World game , boolean changed[][][][],ArrayList<Beetle> hadDeterMove)
    {

        Cell[] food = game.getMap().getFoodCells();
        Vector<Cell> mapFoods = new Vector<>();
        for (Cell c:
                food) {
            mapFoods.addElement(c);
        }
        foodDecide foodTable = new foodDecide();
        Vector<Cell> mycells = getmycells(game.getMap().getMyCells());   // position of my beetles

        // Nearest Food to a Beetle
        for (Cell c :
                mapFoods)
        {
            int minX = game.getMap().getHeight() ;
            int minY =  game.getMap().getWidth();

            int BeetleIndex=0;
            if(mapFoods.size() == 0)
                continue;

            for(int i=0;i<mycells.size();i++){

                // Normal X and Y
                int tmpX1 = Math.abs(mycells.elementAt(i).getX() - c.getX());
                int tmpY1 = Math.abs(mycells.elementAt(i).getY() - c.getY());
                // Normal Y and circulate X
                int tmpX2 = game.getMap().getHeight() - tmpX1;
                int tmpY2 = tmpY1;
                // Normal X and circulate Y
                int tmpX3 = tmpX1;
                int tmpY3 = game.getMap().getWidth() - tmpY1;
                // circulate X and Y
                int tmpX4 = game.getMap().getHeight() - tmpX1;
                int tmpY4 = game.getMap().getWidth() - tmpY1;

                if ((tmpX1 + tmpY1) < (minX + minY)) {
                    minX = tmpX1;
                    minY = tmpY1;
                    BeetleIndex = i;
                }

                if ((tmpX2 + tmpY2) < (minX + minY)) {
                    minX = tmpX2;
                    minY = tmpY2;
                    BeetleIndex= i;
                }
                if ((tmpX3 + tmpY3) < (minX + minY)) {
                    minX = tmpX3;
                    minY = tmpY3;
                    BeetleIndex = i;
                }
                if ((tmpX4 + tmpY4) < (minX + minY)) {
                    minX = tmpX4;
                    minY = tmpY4;
                    BeetleIndex= i;
                }
            }
//            System.out.println("Food Position : " + mapFoods.elementAt(foodIndex).getX() + " , " + mapFoods.elementAt(foodIndex).getY());

            if( NumberOfCycle(game,(Beetle)mycells.elementAt(BeetleIndex).getBeetle() , c.getItem().getPosition() )  > ((Food)c.getItem()).getRemainingTurns()) {
                continue;
            }

            boolean cond = false;
            for(int i=0;i<foodTable.foods.size();i++)
            {
                if(foodTable.beetles.elementAt(i).getBeetle() == mycells.elementAt(BeetleIndex).getBeetle() )
                {
                    if( (minX+minY) < foodTable.dist.elementAt(i) )
                    {
                        foodTable.foods.set(i , c);
                        foodTable.dist.set(i , minX + minY);
                        cond = true;
                    }
                    else if( (minX+minY) == foodTable.dist.elementAt(i) && ((Beetle) mycells.elementAt(BeetleIndex).getBeetle()).has_winge()==true &&  ((Beetle)foodTable.beetles.elementAt(i).getBeetle()).has_winge() == false )
                    {
                        foodTable.foods.set(i , c);
                        foodTable.dist.set(i , minX + minY);
                        cond = true;
                    }
                    else
                        cond = true;
                }

            }

            if(cond == false)
            foodTable.set(c,mycells.elementAt(BeetleIndex),minX+minY);
        }
            for(int i=0 ; i<foodTable.beetles.size() ; i++)
            {
                if(((Beetle)(foodTable.beetles.elementAt(i).getBeetle())).has_winge() == true)
                {
                    if( !mybeetlemove(game,changed,(Beetle)foodTable.beetles.elementAt(i).getBeetle() , foodTable.foods.elementAt(i).getX() , foodTable.foods.elementAt(i).getY()) )
                        mydeterministicmove(game,changed,(Beetle)foodTable.beetles.elementAt(i).getBeetle(),foodTable.foods.elementAt(i).getX() , foodTable.foods.elementAt(i).getY(),hadDeterMove);
                    foodTable.remove(i);
                }
            }

            for(int i=0 ; i<foodTable.beetles.size() ; i++)
            {
                mybeetlemove(game, changed, (Beetle) foodTable.beetles.elementAt(i).getBeetle(), foodTable.foods.elementAt(i).getX(), foodTable.foods.elementAt(i).getY());
            }
    }

    public class foodDecide
    {
        Vector<Cell> foods = new Vector<>();
        Vector<Cell> beetles = new Vector<>();
        Vector<Integer> dist = new Vector<>();

        void set ( Cell food , Cell beetle , int distance)
        {
            foods.addElement(food);
            beetles.addElement(beetle);
            dist.addElement(distance);
        }

        int getIndex (Beetle beetle)
        {
            for (int i = 0 ; i<beetles.size();i++)
            {
                if(beetles.elementAt(i).getItem() == beetle)
                {
                    return i;
                }
            }
            return 0;
        }

        void remove (int index)
        {
            foods.removeElementAt(index);
            beetles.removeElementAt(index);
            dist.removeElementAt(index);
        }
    }

    public Vector<Cell> getmycells(Cell[] gamecells)
    {
        Vector<Cell> mycells = new Vector<Cell>(1);
        for (Cell c:
                gamecells) {
            if(c!=null)
                mycells.addElement(c);
        }
        return mycells;
    }


    public boolean willFightOnNextMove(World w, Beetle b) {
        ArrayList<Cell> enemyCells = getOccupiedCells(w.getMap().getOppCells());
        int sumPower = 0;
        for (Cell c : enemyCells) {
            Beetle enemy = (Beetle) w.getMap().getCell(c.getX(), c.getY()).getBeetle();
            int newX = c.getX(), newY = c.getY();
            if (enemy.getDirection() == Direction.Up)
                --newX;
            else if (enemy.getDirection() == Direction.Down)
                ++newX;
            else if (enemy.getDirection() == Direction.Left)
                --newY;
            else if (enemy.getDirection() == Direction.Right)
                ++newY;
            if (Math.abs(c.getX() - b.getPosition().getX()) <= 1 && Math.abs(c.getY() - b.getPosition().getY()) <= 1)
                sumPower += ((Beetle) c.getBeetle()).getPower();
        }
        return sumPower < b.getPower();
    }

    public ArrayList<Cell> getOccupiedCells(Cell[] array) {
        ArrayList<Cell> occupied = new ArrayList<>();
        for (Cell c : array)
            if (c != null)
                occupied.add(c);
        return occupied;
    }

    class MyBeetle {
        Beetle beetle;
        int power;

        MyBeetle(Beetle b) {
            power = b.getPower();
            beetle = b;
        }
    }


    public void moveSickBeetle(World w, Beetle b, ArrayList<Beetle> hadDeterMove) {
        if (b.is_sick()) {
            int rows = w.getMap().getHeight(), columns = w.getMap().getWidth();
            int[][] density = new int[(int) Math.ceil(rows / Math.sqrt(rows))][(int) Math.ceil(columns / Math.sqrt(columns))];
            ArrayList<Cell> enemies = getOccupiedCells(w.getMap().getOppCells());
            for (Cell c : enemies)
                ++density[(int) (c.getX() / Math.sqrt(rows))][(int) (c.getY() / Math.sqrt(columns))];
            int maxDensity = 0, bestRow = 0, bestColumn = 0;
            for (int i = 0; i < density.length; i++)
                for (int j = 0; j < density[i].length; j++)
                    if (density[i][j] > maxDensity) {
                        maxDensity = density[i][j];
                        bestRow = i;
                        bestColumn = j;
                    }
            int destX = bestRow * (int) Math.sqrt(rows), destY = bestColumn * (int) Math.sqrt(columns);
            //System.out.println(b.getPosition().getX() + " " + b.getPosition().getY());
            mybeetlemove(w, new boolean[2][3][2][3], b, destX, destY);
        }
    }


    Move Strategies [][][][]= new Move [2][3][2][3];

    public void doTurn(World game) {


        ArrayList<Beetle> hadDeterMove = new ArrayList<>();  // for checking if a beetle have had determove, do not send an determove order again
        hadDeterMove.clear();



       // System.out.println( " *************************************NEXT SIKL : " + game.getCurrentTurn());
       // boolean freq_changed = false;  // show that frequency has changed in this cycle or not

        if(game.getCurrentTurn()==0)
        {
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 2; k++)
                        for (int q = 0; q < 3; q++)
                            Strategies[i][j][k][q] = Move.stepForward;
        }


        boolean changed[][][][] = new boolean[2][3][2][3];
        /*

                                                           frequency :  low || high
                                                           right     :  ally | enemy | blank
                                                           front     :  ally | enemy |
                                                           left      :  ally | enemy | blank

                                                           */
        // this array is for checking if an index of update function has changed already or not
        // if it has changed one time it must not change again
        // or maybe in next steps, in case of conflict check witch one has upper priority


        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 2; k++)
                    for (int q = 0; q < 3; q++)
                        changed[i][j][k][q] = false;


        GetOutOfSlipper(game, changed, hadDeterMove);
        GetNearestBeetleToFood(game,changed,hadDeterMove);


        Beetle beetle2 = null;
        for (Cell c:
                game.getMap().getMyCells()) {
            if(((Beetle)c.getBeetle()).is_sick() == true)
            {
                CellState beetlestatus[] = BeetleStatus(game,(Beetle)c.getBeetle());
                if(!changed[((Beetle) c.getBeetle()).getBeetleType().getValue()][beetlestatus[0].getValue()][beetlestatus[1].getValue()][beetlestatus[2].getValue()] )
                    beetle2 = (Beetle)c.getBeetle();
            }
        }
        if(beetle2 != null) {
           moveSickBeetle(game,beetle2,hadDeterMove);

        }

    }

}
