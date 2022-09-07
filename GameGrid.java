import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {
    int counter = 1;
    LinkedList oLinked = new LinkedList();

    public void run() {
        System.out.println();
        int aiGrid[][] = new int[10][10];

        SecureRandom oRand = new SecureRandom();

        int iWallChance = 10;

        for (int y = 0; y < aiGrid[0].length; y++) {
            for (int x = 0; x < aiGrid.length; x++) {
                int iChance = oRand.nextInt(100);
                //if the randomly generated number between 0 and 99 is less than 10, the cell is
                //set to 1. thus, theres a 10% chance a cell will be set to 1.
                if (iChance < iWallChance) {
                    aiGrid[x][y] = 1;
                } else {
                    aiGrid[x][y] = 0;
                }
            }
        }
        aiGrid[0][0] = 0;

        //These variables represent the user's position
        int iUserCol = 0;
        int iUserRow = 0;

        //bool for the loop to know when to exit
        boolean bBool1 = false;
        boolean Running = true;
        Scanner scan = new Scanner(System.in);
        while (Running) {

            //************************************************************
            /*In the while loop, use the iUserRow and iUserCol values to call the addHeadNode method on
              the LinkedList instance to add a node for every user move.*/
            oLinked.addNode(iUserCol, iUserRow);

            System.out.println("You're at [" + iUserRow + "][" + iUserCol + "]");
            System.out.println("Where do you want to move? ");
            System.out.println("1. Right");
            System.out.println("2. Down");
            int iOption = scan.nextInt();

            if (iOption == 1) {
                iUserCol++;
            } else if (iOption == 2) {
                iUserRow++;
            }

            if (iUserCol == 9 || iUserRow == 9){
                System.out.println("You win. ");
                Running = false;
            }
            if (aiGrid[iUserCol][iUserRow] == 1) {
                System.out.println("Sorry, you failed. ");
                Running = false;
            }
        }
        //******************************************************************************
        // Create second while loop:  AFTER the existing while loop exits but BEFORE the grid print out.
        while (oLinked.headNode.nextNode != null) {

            /*n the loop, call the removeHeadNode method on the LinkedList instance and use the
            returned node's xPosition and yPosition to update the grid at that position with any
            number you choose besides 0 and 1. */

            int xPos = oLinked.headNode.xPosition;
            int yPos = oLinked.headNode.yPosition;

            oLinked.removeNode();

            aiGrid[xPos][yPos] = 2;

            counter++;
                    /*You can also use this loop to count the number of player moves.
                    Print out the total number of player moves at the end when printing the grid.*/
        }

        for (int y = 0; y < aiGrid[0].length; y++) {
            for (int x = 0; x < aiGrid.length; x++) {
                if(iUserRow == y && iUserCol == x ){
                    System.out.print("X ");
                } else {
                    System.out.print(aiGrid[x][y] + " ");
                }

            }
            System.out.println();
        }
        System.out.println("Amount of moves:" + counter);
    }
}


