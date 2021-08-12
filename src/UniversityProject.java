import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UniversityProject {
    static int someWidth = 430;
    static int someHeight = 600;

    //set distance for grid
    static Integer XGridDistance = 170;
    static Integer YGridDistance = 220;
    static Integer SquareSize = 25;
    static Integer OutlineSquareSize = 28;
    static Integer XDistanceApart = 52;
    static Integer YDistanceApart = 53;
    static Integer CountmoveRight = 0;
    static Integer CountmoveDown = 0;
    static Integer TotalMoveCounter = 0;

    public static void main(String[] args) {

        /** The following segment is for the first handin */

        Boolean GameOver = false;
        Boolean BlueWins = false;
        Boolean GreenWins = false;
        Boolean ThreeInRowBlue = false;
        Boolean ThreeInRowGreen = false;

        //2d array of board
        String[][] coord = new String[16][16];

        for (int j = 1; j <= 4; j++)
            for (int k = 1; k <= 4; k++) {
                coord[j][k] = "__";
            }
        /** The following segment is for the final handin */
        if (args.length == 0) {
            //Display empty board at start
            System.out.println();
            System.out.println("   c1" + " c2" + " c3" + " c4");
            System.out.println("r1 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
            System.out.println("r2 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
            System.out.println("r3 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
            System.out.println("r4 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
            //print board

            StdDraw.setCanvasSize(someWidth, someHeight);
            StdDraw.setXscale(70, someWidth);
            StdDraw.setYscale(0, someHeight);
            StdDraw.show(0);
            StdDraw.setPenColor(StdDraw.BLACK);

            Font font = new Font("Arial", Font.BOLD, 16);
            StdDraw.setFont(font);
            //test

            //set background color to Gray
            StdDraw.clear(StdDraw.GRAY);
            //Prevent GUI showed being built, only shows final product
            StdDraw.show(0);
            //GUI Layout

            StdDraw.text(220, 540, "Have Fun!");
            StdDraw.text(192, 490, "A");
            StdDraw.text(250, 490, "B");
            StdDraw.text(310, 490, "C");
            StdDraw.text(130, 450, "Stacks:");
            //Stack 1 circle
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(192, 450, 25);
            StdDraw.setPenColor(StdDraw.CYAN);
            StdDraw.filledCircle(192, 450, 23);
            //Stack 2 circle
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(250, 450, 25);
            StdDraw.setPenColor(StdDraw.CYAN);
            StdDraw.filledCircle(250, 450, 23);
            //Stack 3 circle
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(310, 450, 25);
            StdDraw.setPenColor(StdDraw.CYAN);
            StdDraw.filledCircle(310, 450, 23);
            //main black border
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + 77.5, 140, 114);
            //Row 1 Images
            //column 1
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(170, 390, "t");
            StdDraw.text(225, 390, "b");
            StdDraw.text(275, 390, "r");
            StdDraw.text(325, 390, "p");
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance, YGridDistance + 70, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance, YGridDistance + 70, SquareSize);
            StdDraw.picture(XGridDistance, YGridDistance + 70, "transporter.png", 45, 45);
            //column 2
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance + 70, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance + 70, SquareSize);
            StdDraw.picture(XGridDistance + XDistanceApart * 1, YGridDistance + 70, "bomb.png", 45, 45);
            //column 3
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance + 70, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance + 70, SquareSize);
            StdDraw.picture(XGridDistance + XDistanceApart * 2, YGridDistance + 70, "shifter.png", 45, 45);
            //column 4
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance + 70, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance + 70, SquareSize);
            StdDraw.picture(XGridDistance + XDistanceApart * 3, YGridDistance + 70, "paintbrush.png", 45, 45);

            //Row 2 Images
            //column 1
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance, YGridDistance + 123, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance, YGridDistance + 123, SquareSize);
            StdDraw.picture(XGridDistance, YGridDistance + 123, "transporter.png", 45, 45);
            //column 2
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance + 123, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance + 123, SquareSize);
            StdDraw.picture(XGridDistance + XDistanceApart * 1, YGridDistance + 123, "bomb.png", 45, 45);
            //column 3
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance + 123, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance + 123, SquareSize);
            StdDraw.picture(XGridDistance + XDistanceApart * 2, YGridDistance + 123, "shifter.png", 45, 45);

            //column 4
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance + 123, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance + 123, SquareSize);
            StdDraw.picture(XGridDistance + XDistanceApart * 3, YGridDistance + 123, "paintbrush.png", 45, 45);

            //First row
            //column 1
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
            //column 2
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
            //column 3
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
            //column 4
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

            //Second row
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
            //column 2
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
            //column 3
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
            //column 4
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

            //Third row
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
            //column 2
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
            //column 3
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
            //column 4
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

            //Fourth row
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
            //column 2
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
            //column 3
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
            //column 4
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);

            StdDraw.show();

            Integer CountmoveRight = 0;

            Integer CountmoveDown = 0;
            Integer TotalMoveCounter = 0;
            Integer EnterPressed = 0;
            Integer bluestack1 = 0;
            Integer bluestack2 = 0;
            Integer bluestack3 = 0;
            Integer greenstack1 = 0;
            Integer greenstack2 = 0;
            Integer greenstack3 = 0;
            Integer CountEnterMovingPiece = 0;
            Integer CurrentCoordX = 0;
            Integer CurrentCoordY = 0;
            Integer OldCoordX = 0;
            Integer OldCoordY = 0;
            Integer OldCoordXTransporter = 0;
            Integer OldCoordYTransporter = 0;
            Integer OldCoordX1 = 0;
            Integer OldCoordY1 = 0;
            Integer CountEnter = 0;
            Integer Enter = 0;
            Integer Enter1 = 0;
            Integer SmallestManhattanDistance = 10;
            Integer CurrentSmallestManhattanDistance = 10;
            String LastStackUsed = "";
            Boolean FirstMoveABC = false;
            Boolean MovingPiece = false;
            Boolean Transporter = false;
            Boolean Bomb = false;
            Boolean Shifter = false;

            ArrayList < Integer > CoordX = new ArrayList < Integer > ();
            ArrayList < Integer > CoordY = new ArrayList < Integer > ();
            ArrayList < Integer > CoordGreenX = new ArrayList < Integer > ();
            ArrayList < Integer > CoordGreenY = new ArrayList < Integer > ();
            ArrayList < Integer > CoordBlueX = new ArrayList < Integer > ();
            ArrayList < Integer > CoordBlueY = new ArrayList < Integer > ();
            ArrayList < Integer > SizeofPieces = new ArrayList < Integer > ();
            ArrayList < Integer > BorderSizeofPieces = new ArrayList < Integer > ();
            ArrayList < Integer > BorderSizeofPiecesGreen = new ArrayList < Integer > ();
            ArrayList < Integer > BorderSizeofPiecesBlue = new ArrayList < Integer > ();
            ArrayList < Integer > SizeofPiecesGreen = new ArrayList < Integer > ();
            ArrayList < Integer > SizeofPiecesBlue = new ArrayList < Integer > ();

            while (GameOver != true) {
                if (!StdDraw.hasNextKeyTyped())

                    while (!StdDraw.hasNextKeyTyped()) {
                        //wait
                    }

                char input = StdDraw.nextKeyTyped();

                if (input == 'A' || input == 'B' || input == 'C') {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    FirstMoveABC = true;
                    TotalMoveCounter += 1;
                    //count if Blue player used stack 1
                    if (TotalMoveCounter % 2 != 0 && input == 'A') {
                        bluestack1 += 1;
                        BorderSizeofPieces.add(23 - 6 * (bluestack1 - 1));
                        SizeofPieces.add(21 - 6 * (bluestack1 - 1));
                        LastStackUsed = "B" + bluestack1.toString();
                        BorderSizeofPiecesBlue.add(23 - 6 * (bluestack1 - 1));
                        SizeofPiecesBlue.add(21 - 6 * (bluestack1 - 1));
                    }

                    //count if Blue player used stack 2
                    if (TotalMoveCounter % 2 != 0 && input == 'B') {
                        bluestack2 += 1;
                        BorderSizeofPieces.add(23 - 6 * (bluestack2 - 1));
                        SizeofPieces.add(21 - 6 * (bluestack2 - 1));
                        LastStackUsed = "B" + bluestack2.toString();
                        BorderSizeofPiecesBlue.add(23 - 6 * (bluestack2 - 1));
                        SizeofPiecesBlue.add(21 - 6 * (bluestack2 - 1));
                    }

                    //count if Blue player used stack 3
                    if (TotalMoveCounter % 2 != 0 && input == 'C') {
                        bluestack3 += 1;
                        BorderSizeofPieces.add(23 - 6 * (bluestack3 - 1));
                        SizeofPieces.add(21 - 6 * (bluestack3 - 1));
                        LastStackUsed = "B" + bluestack3.toString();
                        BorderSizeofPiecesBlue.add(23 - 6 * (bluestack3 - 1));
                        SizeofPiecesBlue.add(21 - 6 * (bluestack3 - 1));
                    }
                    //count if Green player used stack 1
                    if (TotalMoveCounter % 2 == 0 && input == 'A') {
                        greenstack1 += 1;
                        BorderSizeofPieces.add(23 - 6 * (greenstack1 - 1));
                        SizeofPieces.add(21 - 6 * (greenstack1 - 1));
                        LastStackUsed = "G" + greenstack1.toString();
                        BorderSizeofPiecesGreen.add(23 - 6 * (greenstack1 - 1));
                        SizeofPiecesGreen.add(21 - 6 * (greenstack1 - 1));
                    }
                    //count if Green player used stack 2
                    if (TotalMoveCounter % 2 == 0 && input == 'B') {
                        greenstack2 += 1;
                        BorderSizeofPieces.add(23 - 6 * (greenstack2 - 1));
                        SizeofPieces.add(21 - 6 * (greenstack2 - 1));
                        LastStackUsed = "G" + greenstack2.toString();
                        BorderSizeofPiecesGreen.add(23 - 6 * (greenstack2 - 1));
                        SizeofPiecesGreen.add(21 - 6 * (greenstack2 - 1));
                    }
                    //count if Green player used stack 3
                    if (TotalMoveCounter % 2 == 0 && input == 'C') {
                        greenstack3 += 1;
                        BorderSizeofPieces.add(23 - 6 * (greenstack3 - 1));
                        SizeofPieces.add(21 - 6 * (greenstack3 - 1));
                        LastStackUsed = "G" + greenstack3.toString();
                        BorderSizeofPiecesGreen.add(23 - 6 * (greenstack3 - 1));
                        SizeofPiecesGreen.add(21 - 6 * (greenstack3 - 1));
                    }
                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();
                }
                if (input == 'q') {
                    System.out.println();
                    System.out.println("Quit, draw!");
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledSquare(220, 540, 35);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(220, 540, "Quit, draw!");

                    StdDraw.show(2000);
                    StdDraw.close();
                }
                if (input == 't') {

                    Transporter = true;
                }
                if (input == 'r') {
                    Enter1 += 1;
                    Shifter = true;
                }

                if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && Bomb == true) {

                    if (Enter % 2 != 0) {
                        //Bomb image black
                        if (CountEnter % 2 != 1) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance + 70, SquareSize);
                        } else {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance + 123, SquareSize);
                            Bomb = false;
                            MovingPiece = false;
                        }
                    }

                } //case user plays shifter
                if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && Shifter == true) {

                    if (Enter1 % 2 != 0) {
                        //Shifter image black
                        if (CountEnter % 2 != 1) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance + 70, SquareSize);
                        } else {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance + 123, SquareSize);
                            Shifter = false;
                            MovingPiece = false;
                        }
                    }

                } //case user plays transporter
                if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && Transporter == true) {
                    Integer CoordXOfManhattan = 0;
                    Integer CoordYOfManhattan = 0;
                    Integer CountOpenSpaces = 0;

                    Integer XSum = 0;
                    Integer YSum = 0;

                    MovingPiece = false;

                    CountEnter += 1;

                    XSum = XGridDistance + XDistanceApart * CountmoveRight;
                    YSum = YGridDistance - YDistanceApart * CountmoveDown;
                    //row 1 coordinates
                    if (XSum == 170 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 220) {

                        CurrentCoordX = 1;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 4;
                    }

                    //row 2 coordinates
                    if (XSum == 170 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 4;
                    }

                    //row 3 coordinates
                    if (XSum == 170 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 4;
                    }

                    //row 4 coordinates
                    if (XSum == 170 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 4;
                    }

                    OldCoordXTransporter = CurrentCoordX;
                    OldCoordYTransporter = CurrentCoordY;

                    //Manhattan distance calculations
                    for (int i = 4; i >= 0; i--)
                        for (int k = 4; k >= 0; k--) {

                            if (coord[i][k] == ("__")) {
                                CountOpenSpaces += 1;
                                SmallestManhattanDistance = Math.abs(OldCoordXTransporter - i) + Math.abs(OldCoordYTransporter - k);
                                //System.out.println(SmallestManhattanDistance);
                                if (SmallestManhattanDistance <= CurrentSmallestManhattanDistance && SmallestManhattanDistance != 0) {
                                    CurrentSmallestManhattanDistance = SmallestManhattanDistance;
                                    CoordXOfManhattan = i;
                                    CoordYOfManhattan = k;
                                }
                            }
                        }

                    //set coordinate of old coordinate to Manhattan coordinates
                    coord[CoordXOfManhattan][CoordYOfManhattan] = coord[OldCoordXTransporter][OldCoordYTransporter];
                    coord[OldCoordXTransporter][OldCoordYTransporter] = "__";

                    //search coordinates for blue to move chosen stack to Manhattan distance
                    if (EnterPressed % 2 == 0) {
                        for (int r = 0; r < CoordBlueX.size(); r++) {
                            if (CoordBlueX.get(r) - OldCoordXTransporter == 0 && CoordBlueY.get(r) - OldCoordYTransporter == 0) {
                                CoordBlueX.set(r, CoordXOfManhattan);
                                CoordBlueY.set(r, CoordYOfManhattan);

                            }
                        }
                    } else {
                        //search coordinates for green to move chosen stack to manhattan distance
                        for (int r = 0; r < CoordGreenX.size(); r++) {
                            if (CoordGreenX.get(r) - OldCoordXTransporter == 0 && CoordGreenY.get(r) - OldCoordYTransporter == 0) {
                                CoordGreenX.set(r, OldCoordXTransporter);
                                CoordGreenY.set(r, OldCoordYTransporter);

                            }
                        }
                    }

                    StdDraw.show(0);
                    //reset board so piece moves visibly
                    //First row
                    //column 1
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

                    //Second row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

                    //Third row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

                    //Fourth row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);
                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();
                    //transporter image black
                    if (CountEnter % 2 != 1) {
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledSquare(XGridDistance, YGridDistance + 70, SquareSize);
                    } else {
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledSquare(XGridDistance, YGridDistance + 123, SquareSize);
                        Transporter = false;
                        MovingPiece = false;
                    }
                } //Used to determine if user wants to move a piece
                if (input == 'a' || input == 'w' || input == 's' || input == 'd') {
                    MovingPiece = true;

                }
                //Case that the user presses the enter button
                //Coordinates of current selection added to array list
                if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && FirstMoveABC == true) {
                    Integer XSum = 0;
                    Integer YSum = 0;

                    Boolean InvalidMove = false;
                    FirstMoveABC = false;
                    CoordX.add(XGridDistance + XDistanceApart * CountmoveRight);
                    CoordY.add(YGridDistance - YDistanceApart * CountmoveDown);
                    EnterPressed += 1;

                    //change the stack circle of images color every time a move is played to Blue
                    if (EnterPressed % 2 != 0) {
                        StdDraw.show(0);

                        //Stack A circle

                        if (greenstack1 == 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 25);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(192, 450, 23);
                        } else if (greenstack1 == 1) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 20);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(192, 450, 18);
                        } else if (greenstack1 == 2) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 15);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(192, 450, 13);
                        } else if (greenstack1 == 3) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 10);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(192, 450, 8);
                        } else if (greenstack1 == 4) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                        }
                        // else if(greenstack>4 {invalidmove
                        //Stack B circles
                        if (greenstack2 == 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 25);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(250, 450, 23);
                        } else if (greenstack2 == 1) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 20);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(250, 450, 18);
                        } else if (greenstack2 == 2) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 15);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(250, 450, 13);
                        } else if (greenstack2 == 3) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 10);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(250, 450, 8);
                        } else if (greenstack2 == 4) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                        }
                        //Stack C circle
                        if (greenstack3 == 0) {

                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 25);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(310, 450, 23);
                        } else if (greenstack3 == 1) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 20);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(310, 450, 18);
                        } else if (greenstack3 == 2) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 15);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(310, 450, 13);
                        } else if (greenstack3 == 3) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 10);
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(310, 450, 8);
                        } else if (greenstack3 == 4) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                        }
                        StdDraw.show();
                        //Collect Blue piece coordinates
                        CoordBlueX.add(XGridDistance + XDistanceApart * CountmoveRight);
                        XSum = XGridDistance + XDistanceApart * CountmoveRight;
                        CoordBlueY.add(YGridDistance - YDistanceApart * CountmoveDown);
                        YSum = YGridDistance - YDistanceApart * CountmoveDown;
                    }
                    //change the stack circle of images color every time a move is played to Blue

                    if (EnterPressed % 2 == 0) {
                        StdDraw.show(0);

                        //Stack A circle

                        if (bluestack1 == 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 25);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(192, 450, 23);
                        } else if (bluestack1 == 1) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 20);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(192, 450, 18);
                        } else if (bluestack1 == 2) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 15);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(192, 450, 13);
                        } else if (bluestack1 == 3) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(192, 450, 10);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(192, 450, 8);
                        } else if (bluestack1 == 4) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(192, 450, 30);
                        }
                        //Stack B circles
                        if (bluestack2 == 0) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 25);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(250, 450, 23);
                        } else if (bluestack2 == 1) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 20);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(250, 450, 18);
                        } else if (bluestack2 == 2) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 15);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(250, 450, 13);
                        } else if (bluestack2 == 3) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(250, 450, 10);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(250, 450, 8);
                        } else if (bluestack2 == 4) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(250, 450, 30);
                        }
                        //Stack C circle
                        if (bluestack3 == 0) {

                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 25);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(310, 450, 23);
                        } else if (bluestack3 == 1) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 20);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(310, 450, 18);
                        } else if (bluestack3 == 2) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 15);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(310, 450, 13);
                        } else if (bluestack3 == 3) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(310, 450, 10);
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(310, 450, 8);
                        } else if (bluestack3 == 4) {
                            StdDraw.setPenColor(StdDraw.GRAY);
                            StdDraw.filledCircle(310, 450, 30);
                        }
                        StdDraw.show();
                        //Collect Green piece coordinates
                        CoordGreenX.add(XGridDistance + XDistanceApart * CountmoveRight);
                        XSum = XGridDistance + XDistanceApart * CountmoveRight;
                        CoordGreenY.add(YGridDistance - YDistanceApart * CountmoveDown);
                        YSum = YGridDistance - YDistanceApart * CountmoveDown;
                    }

                    //assigning pieces placed on board to my 2d array of coordinates

                    //purpose of this is to reuse code from first hand in for ease of use
                    //row 1 coordinates
                    if (XSum == 170 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 220) {

                        CurrentCoordX = 1;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 4;
                    }

                    //row 2 coordinates
                    if (XSum == 170 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 4;
                    }

                    //row 3 coordinates
                    if (XSum == 170 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 4;
                    }

                    //row 4 coordinates
                    if (XSum == 170 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 4;
                    }

                    //checking if Three In A Row for blue row 1
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[1][2].matches("B1|B2|B3|B4") && coord[1][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 1
                    if (coord[1][2].matches("B1|B2|B3|B4") && coord[1][3].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 2
                    if (coord[2][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 2
                    if (coord[2][2].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 3
                    if (coord[3][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 3
                    if (coord[3][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 4
                    if (coord[4][1].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  row 4
                    if (coord[4][2].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 4 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 1
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][1].matches("B1|B2|B3|B4") && coord[3][1].matches("B1|B2|B3|B4") && (CurrentCoordY == 1 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 1
                    if (coord[2][1].matches("B1|B2|B3|B4") && coord[3][1].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (CurrentCoordY == 1 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 2
                    if (coord[1][2].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && (CurrentCoordY == 2 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 2
                    if (coord[2][2].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && (CurrentCoordY == 2 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 3
                    if (coord[1][3].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && (CurrentCoordY == 3 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 3
                    if (coord[2][3].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (CurrentCoordY == 3 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 4
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (CurrentCoordY == 4 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  column 4
                    if (coord[2][4].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordY == 4 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 3 && CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[2][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 3 && CurrentCoordY == 3 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[4][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordX == 2 && CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 4 || CurrentCoordX == 2 && CurrentCoordY == 3 || CurrentCoordX == 3 && CurrentCoordY == 2)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[2][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordX == 4 && CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[4][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 4 && CurrentCoordY == 2 || CurrentCoordX == 3 && CurrentCoordY == 3 || CurrentCoordX == 2 && CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[1][2].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 2 || CurrentCoordX == 2 && CurrentCoordY == 3 || CurrentCoordX == 3 && CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //checking if Three In A Row for blue  diagonal
                    if (coord[3][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[1][3].matches("B1|B2|B3|B4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 1 && CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordY == 4 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordY == 4 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][3].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (CurrentCoordY == 3 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][3].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (CurrentCoordY == 3 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][2].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && (CurrentCoordY == 2 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][2].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && (CurrentCoordY == 2 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][1].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (CurrentCoordY == 1 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[3][1].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (CurrentCoordY == 1 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[1][2].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[1][3].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[2][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[2][1].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[3][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[3][1].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[4][1].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row with gaps between Blue
                    if (coord[4][1].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row diagonal gaps Blue
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row diagonal gaps Blue
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordX == 3 && CurrentCoordY == 3 || CurrentCoordX == 3 && CurrentCoordY == 3)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row diagonal gaps Blue
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 4 || CurrentCoordX == 2 && CurrentCoordY == 3 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;

                    } //Three in row diagonal gaps Blue
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (CurrentCoordX == 1 && CurrentCoordY == 4 || CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowBlue = true;
                    }
                    //Three in row green
                    //checking if Three In A Row for green row 1
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[1][2].matches("G1|G2|G3|G4") && coord[1][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 1
                    if (coord[1][2].matches("G1|G2|G3|G4") && coord[1][3].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 2
                    if (coord[2][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 2
                    if (coord[2][2].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 3
                    if (coord[3][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 3
                    if (coord[3][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 4
                    if (coord[4][1].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  row 4
                    if (coord[4][2].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 4 && CurrentCoordY == 2 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 1
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][1].matches("G1|G2|G3|G4") && coord[3][1].matches("G1|G2|G3|G4") && (CurrentCoordY == 1 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 1
                    if (coord[2][1].matches("G1|G2|G3|G4") && coord[3][1].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (CurrentCoordY == 1 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 2
                    if (coord[1][2].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && (CurrentCoordY == 2 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 2
                    if (coord[2][2].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && (CurrentCoordY == 2 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 3
                    if (coord[1][3].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && (CurrentCoordY == 3 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 3
                    if (coord[2][3].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (CurrentCoordY == 3 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 4
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (CurrentCoordY == 4 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  column 4
                    if (coord[2][4].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordY == 4 && CurrentCoordX == 2 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }

                    //checking if Three In A Row for green  diagonal
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 3 && CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[2][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 3 && CurrentCoordY == 3 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[4][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordX == 2 && CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 4 || CurrentCoordX == 2 && CurrentCoordY == 3 || CurrentCoordX == 3 && CurrentCoordY == 2)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[2][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordX == 4 && CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[4][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 4 && CurrentCoordY == 2 || CurrentCoordX == 3 && CurrentCoordY == 3 || CurrentCoordX == 2 && CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[1][2].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 2 || CurrentCoordX == 2 && CurrentCoordY == 3 || CurrentCoordX == 3 && CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //checking if Three In A Row for green  diagonal
                    if (coord[3][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[1][3].matches("G1|G2|G3|G4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 1 && CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordY == 4 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordY == 4 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][3].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (CurrentCoordY == 3 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][3].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (CurrentCoordY == 3 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][2].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && (CurrentCoordY == 2 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][2].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && (CurrentCoordY == 2 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][1].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (CurrentCoordY == 1 && CurrentCoordX == 1 || CurrentCoordX == 2 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[3][1].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (CurrentCoordY == 1 && CurrentCoordX == 1 || CurrentCoordX == 3 || CurrentCoordX == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[1][2].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[1][3].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[2][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[2][1].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 2 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[3][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[3][1].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 3 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[4][1].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordY == 2 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row with gaps between Green
                    if (coord[4][1].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 4 && CurrentCoordY == 1 || CurrentCoordY == 3 || CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }

                    //Three in row diagonal gaps Green
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordX == 2 && CurrentCoordY == 2 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row diagonal gaps Green
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 1 || CurrentCoordX == 3 && CurrentCoordY == 3 || CurrentCoordX == 3 && CurrentCoordY == 3)) {
                        ThreeInRowGreen = true;
                    }
                    //Three in row diagonal gaps Green
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 4 || CurrentCoordX == 2 && CurrentCoordY == 3 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;

                    } //Three in row diagonal gaps Green
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (CurrentCoordX == 1 && CurrentCoordY == 4 || CurrentCoordX == 3 && CurrentCoordY == 2 || CurrentCoordX == 4 && CurrentCoordY == 4)) {
                        ThreeInRowGreen = true;
                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("B1|B2|B3|B4") && LastStackUsed.matches("G4")) {
                        InvalidMove = true;

                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("B1|B2|B3") && LastStackUsed.matches("G3|G4")) {
                        InvalidMove = true;
                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("B1|B2") && LastStackUsed.matches("G2|G3|G4")) {
                        InvalidMove = true;
                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("B1") && LastStackUsed.matches("G1|G2|G3|G4")) {
                        InvalidMove = true;
                    }

                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("G1|G2|G3|G4") && LastStackUsed.matches("B4")) {
                        InvalidMove = true;
                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("G1|G2|G3") && LastStackUsed.matches("B3|B4")) {
                        InvalidMove = true;
                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("G1|G2") && LastStackUsed.matches("B2|B3|B4")) {
                        InvalidMove = true;
                    }
                    //error checking to see if piece that is covering opponents piece is bigger than opponents piece
                    if (coord[CurrentCoordX][CurrentCoordY].matches("G1") && LastStackUsed.matches("B1|B2|B3|B4")) {
                        InvalidMove = true;
                    }

                    //error checking Three in a row is valid for Blue
                    if (coord[CurrentCoordX][CurrentCoordY].matches("B1|B2|B3|B4") && ThreeInRowBlue != true) {
                        InvalidMove = true;
                    }
                    //error checking Three in a row is valid for Green
                    if (coord[CurrentCoordX][CurrentCoordY].matches("G1|G2|G3|G4") && ThreeInRowGreen != true) {
                        InvalidMove = true;
                    }

                    if (InvalidMove != false) {

                        //CoordX.remove(CoordX.size() - 1);
                        //	CoordY.remove(CoordX.size() - 1);
                        //	BorderSizeofPieces.remove(BorderSizeofPieces.size() - 1);
                        //SizeofPieces.remove(SizeofPieces.size() - 1);
                        StdDraw.setPenColor(StdDraw.GRAY);
                        StdDraw.filledSquare(220, 540, 35);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(220, 540, "Invalid move");
                        StdDraw.show(2000);
                        StdDraw.setPenColor(StdDraw.GRAY);
                        StdDraw.filledSquare(220, 540, 40);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(220, 540, "Have Fun!");
                        StdDraw.show();
                        System.out.println();
                        System.out.println("Invalid move");
                    } else
                        coord[CurrentCoordX][CurrentCoordY] = LastStackUsed;

                    //Winning configuration for Blue in row 1
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[1][2].matches("B1|B2|B3|B4") && coord[1][3].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in row 2
                    if (coord[2][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in row 3
                    if (coord[3][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in row 4
                    if (coord[4][1].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in column 1
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][1].matches("B1|B2|B3|B4") && coord[3][1].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in column 2
                    if (coord[1][2].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in column 3
                    if (coord[1][3].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in column 4
                    if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }

                    //Winning configuration for Blue in major diagonal
                    if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }
                    //Winning configuration for Blue in minor diagonal
                    if (coord[4][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4")) {
                        BlueWins = true;
                    }

                    //Winning configuration for Green in row 1
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[1][2].matches("G1|G2|G3|G4") && coord[1][3].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in row 2
                    if (coord[2][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in row 3
                    if (coord[3][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in row 4
                    if (coord[4][1].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in column 1
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][1].matches("G1|G2|G3|G4") && coord[3][1].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in column 2
                    if (coord[1][2].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in column 3
                    if (coord[1][3].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in column 4
                    if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }

                    //Winning configuration for Green in major diagonal
                    if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }
                    //Winning configuration for Green in minor diagonal
                    if (coord[4][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4")) {
                        GreenWins = true;
                    }

                    //print board to console
                    if (InvalidMove != true) {
                        System.out.println();
                        System.out.println("   c1" + " c2" + " c3" + " c4");
                        System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                        System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                        System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                        System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    }
                    //printing stack onto grid
                    /*
                     * if (InvalidMove!=false) { StdDraw.setPenColor(StdDraw.BLACK);
                     * StdDraw.filledCircle(XGridDistance + XDistanceApart * CountmoveRight,
                     * YGridDistance - YDistanceApart * CountmoveDown, 25); if (EnterPressed % 2 ==
                     * 0) StdDraw.setPenColor(StdDraw.GREEN); else
                     * StdDraw.setPenColor(StdDraw.CYAN); StdDraw.filledCircle(XGridDistance +
                     * XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart *
                     * CountmoveDown, 23); }
                     */
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, SquareSize);
                    // StdDraw.disableDoubleBuffering();
                    CountmoveRight = 0;
                    CountmoveDown = 0;
                    //prevent invalid piece from being placed on stack green
                    if (InvalidMove != false && EnterPressed % 2 != 0) {

                        CoordBlueX.remove(CoordBlueX.size() - 1);
                        CoordBlueY.remove(CoordBlueY.size() - 1);
                        BorderSizeofPiecesBlue.remove(BorderSizeofPiecesBlue.size() - 1);
                        SizeofPiecesBlue.remove(SizeofPiecesBlue.size() - 1);
                    }
                    //prevent invalid piece from being placed on stack blue
                    if (InvalidMove != false && EnterPressed % 2 == 0) {

                        CoordGreenX.remove(CoordGreenX.size() - 1);
                        CoordGreenY.remove(CoordGreenY.size() - 1);
                        BorderSizeofPiecesGreen.remove(BorderSizeofPiecesGreen.size() - 1);
                        SizeofPiecesGreen.remove(SizeofPiecesGreen.size() - 1);
                    }
                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();
                    //Print that blue wins
                    if (BlueWins != false) {
                        System.out.println("Blue Wins!");
                        StdDraw.setPenColor(StdDraw.GRAY);
                        StdDraw.filledSquare(220, 540, 35);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(220, 540, "Blue wins!");

                        StdDraw.show(2000);
                        StdDraw.close();
                    }
                    //Print that green wins
                    if (GreenWins != false) {
                        System.out.println("Green Wins!");
                        StdDraw.setPenColor(StdDraw.GRAY);
                        StdDraw.filledSquare(220, 540, 35);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(220, 540, "Green wins!");

                        StdDraw.show(2000);
                        StdDraw.close();
                    }
                    //case user presses the enter button and they are moving a piece
                } else if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && MovingPiece != false) {
                    Integer XSum = 0;
                    Integer YSum = 0;

                    CountEnterMovingPiece += 1;
                    if (EnterPressed % 2 == 0) {
                        //Collect Blue piece coordinates
                        //  CoordBlueX.add(XGridDistance + XDistanceApart * CountmoveRight);
                        XSum = XGridDistance + XDistanceApart * CountmoveRight;
                        //  CoordBlueY.add(YGridDistance - YDistanceApart * CountmoveDown);
                        YSum = YGridDistance - YDistanceApart * CountmoveDown;

                    } else {
                        //Collect Green piece coordinates
                        //CoordGreenX.add(XGridDistance + XDistanceApart * CountmoveRight);
                        XSum = XGridDistance + XDistanceApart * CountmoveRight;
                        //CoordGreenY.add(YGridDistance - YDistanceApart * CountmoveDown);
                        YSum = YGridDistance - YDistanceApart * CountmoveDown;
                    }
                    //row 1 coordinates
                    if (XSum == 170 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 220) {

                        CurrentCoordX = 1;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 220) {
                        CurrentCoordX = 1;
                        CurrentCoordY = 4;
                    }

                    //row 2 coordinates
                    if (XSum == 170 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 167) {
                        CurrentCoordX = 2;
                        CurrentCoordY = 4;
                    }

                    //row 3 coordinates
                    if (XSum == 170 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 114) {
                        CurrentCoordX = 3;
                        CurrentCoordY = 4;
                    }

                    //row 4 coordinates
                    if (XSum == 170 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 1;
                    } else if (XSum == 222 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 2;
                    } else if (XSum == 274 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 3;
                    } else if (XSum == 326 && YSum == 61) {
                        CurrentCoordX = 4;
                        CurrentCoordY = 4;
                    }

                    if (CountEnterMovingPiece % 2 != 0) {
                        //assigning coordinates when enter pressed
                        OldCoordX = XSum;
                        OldCoordY = YSum;

                        //assigning temporary coordinates
                        OldCoordX1 = CurrentCoordX;
                        OldCoordY1 = CurrentCoordY;

                    }

                    if (CountEnterMovingPiece % 2 == 0) {

                        if (EnterPressed % 2 == 0) {
                            //searching through coodinates to replace old coordinates with new coordinates
                            for (int i = 0; i < CoordBlueX.size(); i++) {

                                if (CoordBlueX.get(i) - OldCoordX == 0 && CoordBlueY.get(i) - OldCoordY == 0) {
                                    CoordBlueX.set(i, XSum);
                                    CoordBlueY.set(i, YSum);
                                    coord[CurrentCoordX][CurrentCoordY] = coord[OldCoordX1][OldCoordY1];
                                    coord[OldCoordX1][OldCoordY1] = "__";

                                }
                            }
                        } else {
                            //searching through coodinates to replace old coordinates with new coordinates
                            for (int i = 0; i < CoordGreenX.size(); i++) {

                                if (CoordGreenX.get(i) - OldCoordX == 0 && CoordGreenY.get(i) - OldCoordY == 0) {
                                    CoordGreenX.set(i, XSum);
                                    CoordGreenY.set(i, YSum);
                                    coord[CurrentCoordX][CurrentCoordY] = coord[OldCoordX1][OldCoordY1];
                                    coord[OldCoordX1][OldCoordY1] = "__";

                                }
                            }
                        }
                    }
                    StdDraw.show(0);
                    //reset board so piece moves visibly
                    //First row
                    //column 1
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

                    //Second row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

                    //Third row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

                    //Fourth row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);
                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();

                    //user tries to play a bomb
                } else if (input == 'b') {
                    Enter += 1;
                    Bomb = true;
                }

                //used to navigate grid with focus box
                else if (input == 'w') {
                    StdDraw.show(0);
                    //First row
                    //column 1
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

                    //Second row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

                    //Third row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

                    //Fourth row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);

                    CountmoveDown -= 1;
                    if (CountmoveDown < 0)
                        CountmoveDown += 1;

                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, SquareSize);

                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();

                    //used to navigate grid with focus box
                } else if (input == 'a') {
                    StdDraw.show(0);
                    //First row
                    //column 1
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

                    //Second row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

                    //Third row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

                    //Fourth row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);

                    CountmoveRight -= 1;
                    if (CountmoveRight < 0)
                        CountmoveRight = 3;
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, SquareSize);

                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();

                    //used to navigate grid with focus box
                } else if (input == 'd') {
                    StdDraw.show(0);
                    //First row
                    //column 1
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

                    //Second row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

                    //Third row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

                    //Fourth row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);

                    CountmoveRight += 1;
                    if (CountmoveRight > 3)
                        CountmoveRight = 0;
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, SquareSize);

                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();

                    //used to navigate grid with focus box
                    StdDraw.show();
                } else if (input == 's') {

                    StdDraw.show(0);
                    //First row
                    //column 1
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance, SquareSize);

                    //Second row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 1, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 1, SquareSize);

                    //Third row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 2, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 2, SquareSize);

                    //Fourth row
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 2
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 1, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 3
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 2, YGridDistance - YDistanceApart * 3, SquareSize);
                    //column 4
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * 3, YGridDistance - YDistanceApart * 3, SquareSize);

                    CountmoveDown += 1;

                    if (CountmoveDown > 3)
                        CountmoveDown -= 1;

                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, OutlineSquareSize);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(XGridDistance + XDistanceApart * CountmoveRight, YGridDistance - YDistanceApart * CountmoveDown, SquareSize);

                    //if loop used to print the green piece if bigger on top of smaller blue piece
                    if (EnterPressed % 2 != 0) {
                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                        //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                    } else { //print Blue pieces on board
                        for (int i = 0; i < CoordBlueX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), BorderSizeofPiecesBlue.get(i));
                            StdDraw.setPenColor(StdDraw.CYAN);
                            StdDraw.filledCircle(CoordBlueX.get(i), CoordBlueY.get(i), SizeofPiecesBlue.get(i));
                        }

                        //print Green pieces on board
                        for (int i = 0; i < CoordGreenX.size(); i++) {
                            StdDraw.setPenColor(StdDraw.BLACK);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), BorderSizeofPiecesGreen.get(i));
                            StdDraw.setPenColor(StdDraw.GREEN);
                            StdDraw.filledCircle(CoordGreenX.get(i), CoordGreenY.get(i), SizeofPiecesGreen.get(i));

                        }
                    }
                    StdDraw.show();
                }
            }

            //use textmode and call textmode with method
        } else if (args.length == 1) {
            textmode(args);
        } else {
            System.out.println("Incorrect number of command line arguments provided");
            System.exit(0);
        }
    }
    public static void textmode(String[] args) {
        //initialize variables
        int counter = 0;
        int bluestack1 = -1;
        int bluestack2 = -1;
        int bluestack3 = -1;
        int greenstack1 = -1;
        int greenstack2 = -1;
        int greenstack3 = -1;

        //Arraylist for stats
        ArrayList < String > Stat = new ArrayList < String > ();

        Boolean Winner = false;
        Boolean Quit = false;
        Boolean BlueWins = false;
        Boolean GreenWins = false;
        Boolean ThreeInRowGreen = false;
        Boolean ThreeInRowBlue = false;
        Boolean InvalidMove = false;

        //Integers to list stacks used
        int BlueStackList1 = 0;
        int BlueStackList2 = 0;
        int BlueStackList3 = 0;
        int GreenStackList1 = 0;
        int GreenStackList2 = 0;
        int GreenStackList3 = 0;
        Integer SmallestManhattanDistance = 10;
        Integer CurrentSmallestManhattanDistance = 10;

        Integer inputInt = 0;
        Integer inputInt1 = 0;
        Integer inputInt2 = 0;

        String sObstaclePiece = "";

        //Display empty board at start
        System.out.println();
        System.out.println("   c1" + " c2" + " c3" + " c4");
        System.out.println("r1 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
        System.out.println("r2 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
        System.out.println("r3 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");
        System.out.println("r4 " + "__" + "|" + "__" + "|" + "__" + "|" + "__" + "|");

        //2d array of board
        String[][] coord = new String[16][16];

        for (int j = 1; j <= 4; j++)
            for (int k = 1; k <= 4; k++) {
                coord[j][k] = "__";
            }

        //2d array of stacks
        String[][] stacksBlue = {
                {
                        "B1",
                        "B2",
                        "B3",
                        "B4"
                },
                {
                        "B1",
                        "B2",
                        "B3",
                        "B4"
                },
                {
                        "B1",
                        "B2",
                        "B3",
                        "B4"
                }
        };

        String[][] stacksGreen = {
                {
                        "G1",
                        "G2",
                        "G3",
                        "G4"
                },
                {
                        "G1",
                        "G2",
                        "G3",
                        "G4"
                },
                {
                        "G1",
                        "G2",
                        "G3",
                        "G4"
                }
        };
        //Read from textfile
        if (args.length == 1) {
            In in = new In(args[0]);

            while ( in .hasNextLine()) {
                //read in inputs
                inputInt = in .readInt();
                //quit move
                if (inputInt == -1) {
                    System.out.println();
                    System.out.println("Quit");
                    Quit = true;
                    break;
                }

                if (inputInt == 5) {
                    sObstaclePiece = in .readString();
                } else
                    inputInt1 = in .readInt();
                if (inputInt1 == -1) {
                    System.out.println();
                    System.out.println("Quit");
                    Quit = true;
                    break;
                }

                inputInt2 = in .readInt();
                if (inputInt2 == -1) {
                    System.out.println();
                    System.out.println("Quit");
                    Quit = true;
                    break;
                }

                counter += 1;

                //3 in a row, row 1 Blue
                if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[1][2] == "B1" || coord[1][2] == "B2" || coord[1][2] == "B3" || coord[1][2] == "B4") && (coord[1][3] == "B1" || coord[1][3] == "B2" ||
                        coord[1][3] == "B3" || coord[1][3] == "B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[1][3])) {
                    ThreeInRowBlue = true;

                } else if ((coord[1][2] == "B1" || coord[1][2] == "B2" || coord[1][2] == "B3" || coord[1][2] == "B4") && (coord[1][3] == "B1" || coord[1][3] == "B2" || coord[1][3] == "B3" || coord[1][3] == "B4") && (coord[1][4] == "B1" || coord[1][4] == "B2" ||
                        coord[1][4] == "B3" || coord[1][4] == "B4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[1][4])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row, row 2 Blue
                else if ((coord[2][1] == "B1" || coord[2][1] == "B2" || coord[2][1] == "B3" || coord[2][1] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" ||
                        coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[2][3])) {
                    ThreeInRowBlue = true;
                } else if ((coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" || coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[2][4] == "B1" || coord[2][4] == "B2" ||
                        coord[2][4] == "B3" || coord[2][4] == "B4") && (coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowBlue = true;
                }

                //3 in a row, row 3 Blue
                else if ((coord[3][1] == "B1" || coord[3][1] == "B2" || coord[3][1] == "B3" || coord[3][1] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" || coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" ||
                        coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowBlue = true;
                } else if ((coord[3][2] == "B1" || coord[3][2] == "B2" || coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" || coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[3][4] == "B1" || coord[3][4] == "B2" ||
                        coord[3][4] == "B3" || coord[3][4] == "B4") && (coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row, row 4 Blue
                else if ((coord[4][1] == "B1" || coord[4][1] == "B2" || coord[4][1] == "B3" || coord[4][1] == "B4") && (coord[4][2] == "B1" || coord[4][2] == "B2" || coord[4][2] == "B3" || coord[4][2] == "B4") && (coord[4][3] == "B1" || coord[4][3] == "B2" ||
                        coord[4][3] == "B3" || coord[4][3] == "B4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[4][2] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowBlue = true;
                } else if ((coord[4][2] == "B1" || coord[4][2] == "B2" || coord[4][2] == "B3" || coord[4][2] == "B4") && (coord[4][3] == "B1" || coord[4][3] == "B2" || coord[4][3] == "B3" || coord[4][3] == "B4") && (coord[4][4] == "B1" || coord[4][4] == "B2" ||
                        coord[4][4] == "B3" || coord[4][4] == "B4") && (coord[inputInt1][inputInt2] == coord[4][3] || coord[inputInt1][inputInt2] == coord[4][3] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row, column 1 Blue
                else if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[2][1] == "B1" || coord[2][1] == "B2" || coord[2][1] == "B3" || coord[2][1] == "B4") && (coord[3][1] == "B1" || coord[3][1] == "B2" ||
                        coord[3][1] == "B3" || coord[3][1] == "B4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[3][1])) {
                    ThreeInRowBlue = true;
                } else if ((coord[2][1] == "B1" || coord[2][1] == "B2" || coord[2][1] == "B3" || coord[2][1] == "B4") && (coord[3][1] == "B1" || coord[3][1] == "B2" ||
                        coord[3][1] == "B3" || coord[3][1] == "B4") && (coord[4][1] == "B1" || coord[4][1] == "B2" ||
                        coord[4][1] == "B3" || coord[4][1] == "B4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row, column 2 Blue
                else if ((coord[1][2] == "B1" || coord[1][2] == "B2" || coord[1][2] == "B3" || coord[1][2] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" ||
                        coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][2])) {
                    ThreeInRowBlue = true;
                } else if ((coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" ||
                        coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[4][2] == "B1" || coord[4][2] == "B2" ||
                        coord[4][2] == "B3" || coord[4][2] == "B4") && (coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][2])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row, column 3 Blue
                else if ((coord[1][3] == "B1" || coord[1][3] == "B2" || coord[1][3] == "B3" || coord[1][3] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" || coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" ||
                        coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowBlue = true;
                } else if ((coord[2][3] == "B1" || coord[2][3] == "B2" || coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" ||
                        coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[4][3] == "B1" || coord[4][3] == "B2" ||
                        coord[4][3] == "B3" || coord[4][3] == "B4") && (coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row, column 4 Blue
                else if ((coord[1][4] == "B1" || coord[1][4] == "B2" || coord[1][4] == "B3" || coord[1][4] == "B4") && (coord[2][4] == "B1" || coord[2][4] == "B2" || coord[2][4] == "B3" || coord[2][4] == "B4") && (coord[3][4] == "B1" || coord[3][4] == "B2" ||
                        coord[3][4] == "B3" || coord[3][4] == "B4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[2][4] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowBlue = true;
                } else if ((coord[2][4] == "B1" || coord[2][4] == "B2" || coord[2][4] == "B3" || coord[2][4] == "B4") && (coord[3][4] == "B1" || coord[3][4] == "B2" ||
                        coord[3][4] == "B3" || coord[3][4] == "B4") && (coord[4][4] == "B1" || coord[4][4] == "B2" ||
                        coord[4][4] == "B3" || coord[4][4] == "B4") && (coord[inputInt1][inputInt2] == coord[2][4] || coord[inputInt1][inputInt2] == coord[3][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                } //3 in a row,diagonal Blue
                if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" ||
                        coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" ||
                        coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowBlue = true;
                }
                if ((coord[2][2] == "B1" || coord[2][2] == "B2" ||
                        coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" ||
                        coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[4][4] == "B1" || coord[4][4] == "B2" || coord[4][4] == "B3" || coord[4][4] == "B4") && (coord[inputInt1][inputInt2] == coord[4][4] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row,diagonal Blue
                if ((coord[4][1] == "B1" || coord[4][1] == "B2" || coord[4][1] == "B3" || coord[4][1] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" ||
                        coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" ||
                        coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[2][3])) {
                    ThreeInRowBlue = true;
                }
                if ((coord[1][4] == "B1" || coord[1][4] == "B2" || coord[1][4] == "B3" || coord[1][4] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" ||
                        coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" ||
                        coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[2][3])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row,diagonal Blue
                if ((coord[2][1] == "B1" || coord[2][1] == "B2" || coord[2][1] == "B3" || coord[2][1] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" ||
                        coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[4][3] == "B1" || coord[4][3] == "B2" ||
                        coord[4][3] == "B3" || coord[4][3] == "B4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row,diagonal Blue
                if ((coord[4][2] == "B1" || coord[4][2] == "B2" || coord[4][2] == "B3" || coord[4][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" ||
                        coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[2][4] == "B1" || coord[2][4] == "B2" ||
                        coord[2][4] == "B3" || coord[2][4] == "B4") && (coord[inputInt1][inputInt2] == coord[4][2] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row,diagonal Blue
                if ((coord[1][2] == "B1" || coord[1][2] == "B2" || coord[1][2] == "B3" || coord[1][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" ||
                        coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[3][4] == "B1" || coord[3][4] == "B2" ||
                        coord[3][4] == "B3" || coord[3][4] == "B4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowBlue = true;
                }
                //3 in a row,diagonal Blue
                if ((coord[3][1] == "B1" || coord[3][1] == "B2" || coord[3][1] == "B3" || coord[3][1] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" ||
                        coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[1][3] == "B1" || coord[1][3] == "B2" ||
                        coord[1][3] == "B3" || coord[1][3] == "B4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[1][3])) {
                    ThreeInRowBlue = true;
                } //Three in row with gaps between Blue
                if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[2][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][4].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[3][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][3].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][3].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][2].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[4][2])) {
                    //  ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][2].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][2])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][1].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][1].matches("B1|B2|B3|B4") && coord[3][1].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][1].matches("B1|B2|B3|B4") && coord[1][2].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[1][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[1][1].matches("B1|B2|B3|B4") && coord[1][3].matches("B1|B2|B3|B4") && coord[1][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[1][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[2][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[2][1].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[2][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[3][1].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[3][1].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[3][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[4][1].matches("B1|B2|B3|B4") && coord[4][2].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[4][2] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row with gaps between Blue
                if (coord[4][1].matches("B1|B2|B3|B4") && coord[4][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[4][3] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row diagonal gaps Blue
                if (coord[1][1].matches("B1|B2|B3|B4") && coord[2][2].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row diagonal gaps Blue
                if (coord[1][1].matches("B1|B2|B3|B4") && coord[3][3].matches("B1|B2|B3|B4") && coord[4][4].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowBlue = true;
                }
                //Three in row diagonal gaps Blue
                if (coord[1][4].matches("B1|B2|B3|B4") && coord[2][3].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowBlue = true;

                } //Three in row diagonal gaps Blue
                if (coord[1][4].matches("B1|B2|B3|B4") && coord[3][2].matches("B1|B2|B3|B4") && coord[4][1].matches("B1|B2|B3|B4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowBlue = true;
                }

                //3 in a row, row 1 Green
                if ((coord[1][1] == "G1" || coord[1][1] == "G2" || coord[1][1] == "G3" || coord[1][1] == "G4") && (coord[1][2] == "G1" || coord[1][2] == "G2" || coord[1][2] == "G3" || coord[1][2] == "G4") && (coord[1][3] == "G1" || coord[1][3] == "G2" ||
                        coord[1][3] == "G3" || coord[1][3] == "G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[1][3])) {
                    ThreeInRowGreen = true;

                }
                if ((coord[1][2] == "G1" || coord[1][2] == "G2" || coord[1][2] == "G3" || coord[1][2] == "G4") && (coord[1][3] == "G1" || coord[1][3] == "G2" || coord[1][3] == "G3" || coord[1][3] == "G4") && (coord[1][4] == "G1" || coord[1][4] == "G2" ||
                        coord[1][4] == "G3" || coord[1][4] == "G4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[1][4])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row, row 2 Green
                if ((coord[2][1] == "G1" || coord[2][1] == "G2" || coord[2][1] == "G3" || coord[2][1] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" ||
                        coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[2][3])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" || coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[2][4] == "G1" || coord[2][4] == "G2" ||
                        coord[2][4] == "G3" || coord[2][4] == "G4") && (coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowGreen = true;
                }

                //3 in a row, row 3 Green
                if ((coord[3][1] == "G1" || coord[3][1] == "G2" || coord[3][1] == "G3" || coord[3][1] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" || coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" ||
                        coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[3][2] == "G1" || coord[3][2] == "G2" || coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" || coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[3][4] == "G1" || coord[3][4] == "G2" ||
                        coord[3][4] == "G3" || coord[3][4] == "G4") && (coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row, row 4 Green
                if ((coord[4][1] == "G1" || coord[4][1] == "G2" || coord[4][1] == "G3" || coord[4][1] == "G4") && (coord[4][2] == "G1" || coord[4][2] == "G2" || coord[4][2] == "G3" || coord[4][2] == "G4") && (coord[4][3] == "G1" || coord[4][3] == "G2" ||
                        coord[4][3] == "G3" || coord[4][3] == "G4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[4][2] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[4][2] == "G1" || coord[4][2] == "G2" || coord[4][2] == "G3" || coord[4][2] == "G4") && (coord[4][3] == "G1" || coord[4][3] == "G2" || coord[4][3] == "G3" || coord[4][3] == "G4") && (coord[4][4] == "G1" || coord[4][4] == "G2" ||
                        coord[4][4] == "G3" || coord[4][4] == "G4") && (coord[inputInt1][inputInt2] == coord[4][3] || coord[inputInt1][inputInt2] == coord[4][3] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row, column 1 Green
                if ((coord[1][1] == "G1" || coord[1][1] == "G2" || coord[1][1] == "G3" || coord[1][1] == "G4") && (coord[2][1] == "G1" || coord[2][1] == "G2" || coord[2][1] == "G3" || coord[2][1] == "G4") && (coord[3][1] == "G1" || coord[3][1] == "G2" ||
                        coord[3][1] == "G3" || coord[3][1] == "G4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[3][1])) {
                    ThreeInRowGreen = true;
                } else if ((coord[2][1] == "G1" || coord[2][1] == "G2" || coord[2][1] == "G3" || coord[2][1] == "G4") && (coord[3][1] == "G1" || coord[3][1] == "G2" ||
                        coord[3][1] == "G3" || coord[3][1] == "G4") && (coord[4][1] == "G1" || coord[4][1] == "G2" ||
                        coord[4][1] == "G3" || coord[4][1] == "G4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row, column 2 Green
                if ((coord[1][2] == "G1" || coord[1][2] == "G2" || coord[1][2] == "G3" || coord[1][2] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" ||
                        coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][2])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" ||
                        coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[4][2] == "G1" || coord[4][2] == "G2" ||
                        coord[4][2] == "G3" || coord[4][2] == "G4") && (coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][2])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row, column 3 Green
                if ((coord[1][3] == "G1" || coord[1][3] == "G2" || coord[1][3] == "G3" || coord[1][3] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" || coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" ||
                        coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[2][3] == "G1" || coord[2][3] == "G2" || coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" ||
                        coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[4][3] == "G1" || coord[4][3] == "G2" ||
                        coord[4][3] == "G3" || coord[4][3] == "G4") && (coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row, column 4 Green
                if ((coord[1][4] == "G1" || coord[1][4] == "G2" || coord[1][4] == "G3" || coord[1][4] == "G4") && (coord[2][4] == "G1" || coord[2][4] == "G2" || coord[2][4] == "G3" || coord[2][4] == "G4") && (coord[3][4] == "G1" || coord[3][4] == "G2" ||
                        coord[3][4] == "G3" || coord[3][4] == "G4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[2][4] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[2][4] == "G1" || coord[2][4] == "G2" || coord[2][4] == "G3" || coord[2][4] == "G4") && (coord[3][4] == "G1" || coord[3][4] == "G2" ||
                        coord[3][4] == "G3" || coord[3][4] == "G4") && (coord[4][4] == "G1" || coord[4][4] == "G2" ||
                        coord[4][4] == "G3" || coord[4][4] == "G4") && (coord[inputInt1][inputInt2] == coord[2][4] || coord[inputInt1][inputInt2] == coord[3][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                } //3 in a row,diagonal Green
                if ((coord[1][1] == "G1" || coord[1][1] == "G2" || coord[1][1] == "G3" || coord[1][1] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" ||
                        coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" ||
                        coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[2][2] == "G1" || coord[2][2] == "G2" ||
                        coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" ||
                        coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[4][4] == "G1" || coord[4][4] == "G2" || coord[4][4] == "G3" || coord[4][4] == "G4") && (coord[inputInt1][inputInt2] == coord[4][4] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[3][3])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row,diagonal Green
                if ((coord[4][1] == "G1" || coord[4][1] == "G2" || coord[4][1] == "G3" || coord[4][1] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" ||
                        coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" ||
                        coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[2][3])) {
                    ThreeInRowGreen = true;
                }
                if ((coord[1][4] == "G1" || coord[1][4] == "G2" || coord[1][4] == "G3" || coord[1][4] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" ||
                        coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" ||
                        coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[2][3])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row,diagonal Green
                if ((coord[2][1] == "G1" || coord[2][1] == "G2" || coord[2][1] == "G3" || coord[2][1] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" ||
                        coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[4][3] == "G1" || coord[4][3] == "G2" ||
                        coord[4][3] == "G3" || coord[4][3] == "G4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row,diagonal Green
                if ((coord[4][2] == "G1" || coord[4][2] == "G2" || coord[4][2] == "G3" || coord[4][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" ||
                        coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[2][4] == "G1" || coord[2][4] == "G2" ||
                        coord[2][4] == "G3" || coord[2][4] == "G4") && (coord[inputInt1][inputInt2] == coord[4][2] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row,diagonal Green
                if ((coord[1][2] == "G1" || coord[1][2] == "G2" || coord[1][2] == "G3" || coord[1][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" ||
                        coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[3][4] == "G1" || coord[3][4] == "G2" ||
                        coord[3][4] == "G3" || coord[3][4] == "G4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowGreen = true;
                }
                //3 in a row,diagonal Green
                if ((coord[3][1] == "G1" || coord[3][1] == "G2" || coord[3][1] == "G3" || coord[3][1] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" ||
                        coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[1][3] == "G1" || coord[1][3] == "G2" ||
                        coord[1][3] == "G3" || coord[1][3] == "G4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[1][3])) {
                    ThreeInRowGreen = true;
                } //Three in row with gaps between Green
                if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[2][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][4].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[3][4] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][3].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][3].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[4][3])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][2].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[4][2])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][2].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][2])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][1].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][1].matches("G1|G2|G3|G4") && coord[3][1].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][1].matches("G1|G2|G3|G4") && coord[1][2].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[1][2] || coord[inputInt1][inputInt2] == coord[1][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[1][1].matches("G1|G2|G3|G4") && coord[1][3].matches("G1|G2|G3|G4") && coord[1][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[1][3] || coord[inputInt1][inputInt2] == coord[1][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[2][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[2][1].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[2][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[2][1] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[2][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[3][1].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[3][1].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[3][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[3][1] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[3][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[4][1].matches("G1|G2|G3|G4") && coord[4][2].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[4][2] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row with gaps between Green
                if (coord[4][1].matches("G1|G2|G3|G4") && coord[4][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[4][1] || coord[inputInt1][inputInt2] == coord[4][3] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;

                } //Three in row diagonal gaps Green
                if (coord[1][1].matches("G1|G2|G3|G4") && coord[2][2].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[2][2] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row diagonal gaps Green
                if (coord[1][1].matches("G1|G2|G3|G4") && coord[3][3].matches("G1|G2|G3|G4") && coord[4][4].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][1] || coord[inputInt1][inputInt2] == coord[3][3] || coord[inputInt1][inputInt2] == coord[4][4])) {
                    ThreeInRowGreen = true;
                }
                //Three in row diagonal gaps Green
                if (coord[1][4].matches("G1|G2|G3|G4") && coord[2][3].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[2][3] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowGreen = true;

                } //Three in row diagonal gaps Green
                if (coord[1][4].matches("G1|G2|G3|G4") && coord[3][2].matches("G1|G2|G3|G4") && coord[4][1].matches("G1|G2|G3|G4") && (coord[inputInt1][inputInt2] == coord[1][4] || coord[inputInt1][inputInt2] == coord[3][2] || coord[inputInt1][inputInt2] == coord[4][1])) {
                    ThreeInRowGreen = true;
                }

                // print invalid move if input invalid
                if (inputInt < 1 || inputInt > 5) {
                    System.out.println("Invalid move");
                    InvalidMove = true;

                }

                if ((inputInt1 > 4 || inputInt1 < 1)) {
                    System.out.println("Invalid move");
                    InvalidMove = true;
                    break;
                }

                if (inputInt2 > 4 || inputInt2 < 1) {
                    System.out.println("Invalid move");
                    InvalidMove = true;
                    break;
                }

                //counter for each blue stack
                if (counter % 2 != 0 && inputInt == 1)
                    bluestack1 += 1;
                else if (counter % 2 != 0 && inputInt == 2)
                    bluestack2 += 1;
                else if (counter % 2 != 0 && inputInt == 3)
                    bluestack3 += 1;

                //counter for each green stack
                if (counter % 2 == 0 && inputInt == 1)
                    greenstack1 += 1;
                else if (counter % 2 == 0 && inputInt == 2)
                    greenstack2 += 1;
                else if (counter % 2 == 0 && inputInt == 3)
                    greenstack3 += 1;

                //read  odd lines blue
                if (counter % 2 != 0) {
                    switch (inputInt) {
                        case 1:

                            //Check to see if piece is bigger
                            if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "G1") && (stacksBlue[0][bluestack1] == "B2" || stacksBlue[0][bluestack1] == "B3" || stacksBlue[0][bluestack1] == "B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "G2") && (stacksBlue[0][bluestack1] == "B3" || stacksBlue[0][bluestack1] == "B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "G3") && stacksBlue[0][bluestack1] == "B4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //error checking for 3 in row
                            else if ((coord[inputInt1][inputInt2] == "G1" || coord[inputInt1][inputInt2] == "G2" || coord[inputInt1][inputInt2] == "G3" || coord[inputInt1][inputInt2] == "G4") && ThreeInRowGreen != true) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //checking if stacks are less than 4
                            else if (BlueStackList1 > 3) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }

                            coord[inputInt1][inputInt2] = stacksBlue[0][bluestack1];
                            Stat.add(stacksBlue[0][bluestack1]);
                            BlueStackList1 += 1;
                            InvalidMove = false;
                            break;

                        case 2:
                            //Check to see if piece is bigger
                            if (coord[inputInt1][inputInt2] == "B1" && (stacksBlue[1][bluestack2] == "B2" || stacksBlue[1][bluestack2] == "B3" || stacksBlue[1][bluestack2] == "B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if (coord[inputInt1][inputInt2] == "B2" && (stacksBlue[1][bluestack2] == "B3" || stacksBlue[1][bluestack2] == "B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if (coord[inputInt1][inputInt2] == "B3" && stacksBlue[1][bluestack2] == "B4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }

                            //error checking for 3 in row
                            else if ((coord[inputInt1][inputInt2] == "G1" || coord[inputInt1][inputInt2] == "G2" || coord[inputInt1][inputInt2] == "G3" || coord[inputInt1][inputInt2] == "G4") && ThreeInRowGreen != true) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //checking if stacks are less than 4
                            else if (BlueStackList2 == 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else

                                coord[inputInt1][inputInt2] = stacksBlue[1][bluestack2];

                            Stat.add(stacksBlue[1][bluestack2]);
                            BlueStackList2 += 1;
                            InvalidMove = false;
                            break;
                        case 3:

                            //Check to see if piece is bigger need to go next line after break
                            if (coord[inputInt1][inputInt2] == "B1" && (stacksBlue[2][bluestack3] == "B2" || stacksBlue[2][bluestack3] == "B3" || stacksBlue[2][bluestack3] == "B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if (coord[inputInt1][inputInt2] == "B2" && (stacksBlue[2][bluestack3] == "B3" || stacksBlue[2][bluestack3] == "B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if (coord[inputInt1][inputInt2] == "B3" && stacksBlue[2][bluestack3] == "B4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //error checking for 3 in row
                            else if ((coord[inputInt1][inputInt2] == "G1" || coord[inputInt1][inputInt2] == "G2" || coord[inputInt1][inputInt2] == "G3" || coord[inputInt1][inputInt2] == "G4") && ThreeInRowGreen != true) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //checking if stacks are less than 4
                            else if (BlueStackList3 == 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else
                                coord[inputInt1][inputInt2] = stacksBlue[2][bluestack3];
                            Stat.add(stacksBlue[2][bluestack3]);
                            BlueStackList3 += 1;
                            InvalidMove = false;
                            break;

                        case 4:

                            int inputInt3 = in .readInt();
                            int inputInt4 = in .readInt();
                            //quit game if -1
                            if (inputInt3 == -1 || inputInt4 == -1) {
                                System.out.println();
                                System.out.println("Quit");
                                Quit = true;
                                break;
                            }
                            //Prevent player from moving opponents move
                            if (coord[inputInt1][inputInt2] == "G1" || coord[inputInt1][inputInt2] == "G2" || coord[inputInt1][inputInt2] == "G3" || coord[inputInt1][inputInt2] == "G4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //check not moving to same location
                            else if (inputInt1 == inputInt3 && inputInt1 == inputInt4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }

                            //checking inputInt3 and inputInt4 are valid
                            else if (inputInt3 < 1 || inputInt3 > 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if (inputInt4 < 1 || inputInt4 > 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } //make sure piece thats moved is bigger
                            if (coord[inputInt3][inputInt4].matches("G1|G2|G3|G4") && coord[inputInt1][inputInt2].matches("B4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                            } //make sure piece thats moved is bigger
                            if (coord[inputInt3][inputInt4].matches("G1|G2|G3") && coord[inputInt1][inputInt2].matches("B3")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                            } //make sure piece thats moved is bigger
                            if (coord[inputInt3][inputInt4].matches("G1|G2") && coord[inputInt1][inputInt2].matches("B2")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                            } //make sure piece thats moved is bigger
                            if (coord[inputInt3][inputInt4].matches("G1") && coord[inputInt1][inputInt2].matches("B1")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                            }

                            coord[inputInt3][inputInt4] = coord[inputInt1][inputInt2];
                            coord[inputInt1][inputInt2] = "__";
                            InvalidMove = false;
                            break;
                        //Transporter
                        case 5:

                            if (sObstaclePiece.matches("T")) {
                                Integer CoordXOfManhattan = 0;
                                Integer CoordYOfManhattan = 0;
                                Integer CountOpenSpaces = 0;

                                /* try { */
                                inputInt3 = in .readInt();
                                inputInt4 = in .readInt();

                                //error checking to ensure that transporter used on valid piece
                                if (coord[inputInt2][inputInt3].matches("__")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }
                                //error checking to ensure that transporter used on opponents piece
                                if (coord[inputInt2][inputInt3].matches("B1|B2|B3|B4")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }
                                //user tries to move more pieces than available on stack
                                if (inputInt4 > 2) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }

                                //manhattan distance calculations
                                for (int i = 4; i >= 0; i--)
                                    for (int k = 4; k >= 0; k--) {

                                        if (coord[i][k] == ("__")) {

                                            CountOpenSpaces += 1;
                                            SmallestManhattanDistance = Math.abs(inputInt2 - i) + Math.abs(inputInt3 - k);
                                            //System.out.println(SmallestManhattanDistance);
                                            if (SmallestManhattanDistance <= CurrentSmallestManhattanDistance && SmallestManhattanDistance != 0) {
                                                CurrentSmallestManhattanDistance = SmallestManhattanDistance;
                                                CoordXOfManhattan = i;
                                                CoordYOfManhattan = k;
                                            }
                                        }

                                    }
                                //determine whether there is an open space
                                if (CountOpenSpaces == 0) {
                                    InvalidMove = true;

                                    break;
                                }

                                //quit game if -1
                                if (inputInt3 == -1 || inputInt4 == -1) {
                                    System.out.println();
                                    System.out.println("Quit");
                                    Quit = true;
                                    break;
                                }
                                InvalidMove = false;

                                coord[CoordXOfManhattan][CoordYOfManhattan] = coord[inputInt2][inputInt3];
                                coord[inputInt2][inputInt3] = "__";

                                break;

                            }
                            //player uses shifter
                            else if (sObstaclePiece.matches("S")) {
                                String Temp1 = "";
                                String Temp2 = "";
                                String Temp3 = "";
                                String Temp4 = "";
                                String Temp5 = "";
                                String Temp6 = "";
                                String Temp7 = "";
                                String Temp8 = "";
                                inputInt3 = in .readInt();
                                inputInt4 = in .readInt();

                                //ensure shifter placed on an empty square
                                if (coord[inputInt3][inputInt4].matches("B1|B2|B3|B4") || coord[inputInt3][inputInt4].matches("G1|G2||G3|G4")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;

                                }

                                Integer TempX = inputInt2;
                                Integer TempY = inputInt3;
                                //if statements used for correct wrapping
                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                Temp1 = coord[TempX - 1][TempY - 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX - 1 < 1)
                                    TempX = 5;
                                Temp2 = coord[TempX - 1][TempY];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (TempY + 1 > 4)
                                    TempY = 0;
                                Temp3 = coord[TempX - 1][TempY + 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                Temp4 = coord[TempX][TempY + 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY + 1 > 4)
                                    TempY = 0;
                                Temp5 = coord[TempX + 1][TempY + 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                Temp6 = coord[TempX + 1][TempY];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                Temp7 = coord[TempX + 1][TempY - 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY - 1 < 1)
                                    TempY = 5;
                                Temp8 = coord[TempX][TempY - 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                //anti clockwise rotation
                                if (inputInt4 == 1) {
                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX - 1][TempY - 1] = Temp2;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    coord[TempX - 1][TempY] = Temp3;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX - 1][TempY + 1] = Temp4;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX][TempY + 1] = Temp5;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    coord[TempX + 1][TempY + 1] = Temp6;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    coord[TempX + 1][TempY] = Temp7;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    coord[TempX + 1][TempY - 1] = Temp8;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX][TempY - 1] = Temp1;
                                    TempX = inputInt2;
                                    TempY = inputInt3;
                                }

                                //clockwise rotation
                                if (inputInt4 == 0) {
                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX - 1][TempY - 1] = Temp8;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    coord[TempX - 1][TempY] = Temp1;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX - 1][TempY + 1] = Temp2;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX][TempY + 1] = Temp3;

                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX + 1][TempY + 1] = Temp4;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    coord[TempX + 1][TempY] = Temp5;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX + 1][TempY - 1] = Temp6;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX][TempY - 1] = Temp7;
                                    TempX = inputInt2;
                                    TempY = inputInt3;
                                }
                                break;
                                //player uses bomb
                            } else if (sObstaclePiece.matches("B")) {
                                //bomb obstacle
                                inputInt3 = in .readInt();

                                Integer TempX = inputInt2;
                                Integer TempY = inputInt3;

                                //error checking to ensure bomb is placed on one of own pieces
                                if (coord[inputInt2][inputInt3].matches("G1|G2|G3|G4|__|SH")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }

                                //return piece to external stack
                                if (coord[inputInt2][inputInt3].matches("B1") && BlueStackList1 > 0)
                                    BlueStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B1") && BlueStackList2 > 0)
                                    BlueStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B1") && BlueStackList3 > 0)
                                    BlueStackList3 -= 1;

                                if (coord[inputInt2][inputInt3].matches("B2") && BlueStackList1 > 1)
                                    BlueStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B2") && BlueStackList2 > 1)
                                    BlueStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B2") && BlueStackList3 > 1)
                                    BlueStackList3 -= 1;

                                if (coord[inputInt2][inputInt3].matches("B3") && BlueStackList1 > 2)
                                    BlueStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B3") && BlueStackList2 > 2)
                                    BlueStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B3") && BlueStackList3 > 2)
                                    BlueStackList3 -= 1;

                                if (coord[inputInt2][inputInt3].matches("B4") && BlueStackList1 > 3)
                                    BlueStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B4") && BlueStackList2 > 3)
                                    BlueStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("B4") && BlueStackList3 > 3)
                                    BlueStackList3 -= 1;

                                coord[inputInt2][inputInt3] = "__";
                                //if statements used for correct wrapping
                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                if (coord[TempX - 1][TempY - 1] != "__")
                                    coord[TempX - 1][TempY - 1] = "__";
                                else
                                    coord[TempX - 1][TempY - 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (coord[TempX - 1][TempY] != "__")
                                    coord[TempX - 1][TempY] = "__";
                                else coord[TempX - 1][TempY] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (coord[TempX - 1][TempY + 1] != "__")
                                    coord[TempX - 1][TempY + 1] = "__";
                                else coord[TempX - 1][TempY + 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (coord[TempX][TempY + 1] != "__")
                                    coord[TempX][TempY + 1] = "__";
                                else
                                    coord[TempX][TempY + 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (coord[TempX + 1][TempY + 1] != "__")
                                    coord[TempX + 1][TempY + 1] = "__";
                                else
                                    coord[TempX + 1][TempY + 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (coord[TempX + 1][TempY] != "__")
                                    coord[TempX + 1][TempY] = "__";
                                else
                                    coord[TempX + 1][TempY] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                if (coord[TempX + 1][TempY - 1] != "__")
                                    coord[TempX + 1][TempY - 1] = "__";
                                else
                                    coord[TempX + 1][TempY - 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY - 1 < 1)
                                    TempY = 5;
                                if (coord[TempX][TempY - 1] != "__")
                                    coord[TempX][TempY - 1] = "__";
                                else
                                    coord[TempX][TempY - 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                            }
                            break;
                    }

                } else
                    //read even lines green
                    switch (inputInt) {
                        case 1:
                            //Check to see if piece is bigger
                            if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "G1") && (stacksGreen[0][greenstack1] == "G2" || stacksGreen[0][greenstack1] == "G3" || stacksGreen[0][greenstack1] == "G4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "G2") && (stacksGreen[0][greenstack1] == "G3" || stacksGreen[0][greenstack1] == "G4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "G3") && stacksGreen[0][greenstack1] == "G4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //error checking for 3 in row
                            else if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "B4") && ThreeInRowBlue != true) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //checking if stacks are less than 4
                            else if (GreenStackList1 == 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else
                                coord[inputInt1][inputInt2] = stacksGreen[0][greenstack1];
                            Stat.add(stacksGreen[0][greenstack1]);
                            GreenStackList1 += 1;
                            InvalidMove = false;
                            break;
                        case 2:
                            //Check to see if piece is bigger
                            if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "G1") && (stacksGreen[1][greenstack2] == "G2" || stacksGreen[1][greenstack2] == "G3" || stacksGreen[1][greenstack2] == "G4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "G2") && (stacksGreen[1][greenstack2] == "G3" || stacksGreen[1][greenstack2] == "G4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "G3") && stacksGreen[1][greenstack2] == "G4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //error checking for 3 in row
                            else if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "B4") && ThreeInRowBlue != true) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //checking if stacks are less than 4
                            else if (GreenStackList2 == 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;

                            } else
                                coord[inputInt1][inputInt2] = stacksGreen[1][greenstack2];
                            Stat.add(stacksGreen[1][greenstack2]);
                            GreenStackList2 += 1;
                            InvalidMove = false;
                            break;
                        case 3:
                            //Check to see if piece is bigger
                            if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "G1") && (stacksGreen[2][greenstack3] == "G2" || stacksGreen[2][greenstack3] == "G3" || stacksGreen[2][greenstack3] == "G4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "G2") && (stacksGreen[2][greenstack3] == "G3" || stacksGreen[2][greenstack3] == "G4")) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else if ((coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "G3") && stacksGreen[2][greenstack3] == "G4") {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //error checking for 3 in row
                            else if ((coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "B4") && ThreeInRowBlue != true) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //checking if stacks are less than 4
                            else if (GreenStackList3 == 4) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            } else
                                coord[inputInt1][inputInt2] = stacksGreen[2][greenstack3];
                            Stat.add(stacksGreen[2][greenstack3]);
                            GreenStackList3 += 1;
                            InvalidMove = false;
                            break;

                        case 4:

                            try {
                                int inputInt3 = in .readInt();
                                int inputInt4 = in .readInt();

                                //quit game if -1
                                if (inputInt3 == -1 || inputInt4 == -1) {
                                    System.out.println();
                                    System.out.println("Quit");
                                    Quit = true;
                                    break;
                                }
                                //Prevent player from moving opponents move
                                if (coord[inputInt1][inputInt2] == "B1" || coord[inputInt1][inputInt2] == "B2" || coord[inputInt1][inputInt2] == "B3" || coord[inputInt1][inputInt2] == "B4") {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                    break;
                                }
                                //check not moving to same location
                                else if (inputInt1 == inputInt3 && inputInt2 == inputInt4) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                    break;
                                }
                                //checking inputInt3 and inputInt4 are valid
                                else if (inputInt3 < 1 || inputInt3 > 4) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                    break;
                                } else if (inputInt4 < 1 || inputInt4 > 4) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                    break;
                                }
                                //make sure piece thats moved is bigger
                                if (coord[inputInt3][inputInt4].matches("B1|B2|B3|B4") && coord[inputInt1][inputInt2].matches("G4")) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                } //make sure piece thats moved is bigger
                                if (coord[inputInt3][inputInt4].matches("B1|B2|B3") && coord[inputInt1][inputInt2].matches("G3")) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                } //make sure piece thats moved is bigger
                                if (coord[inputInt3][inputInt4].matches("B1|B2") && coord[inputInt1][inputInt2].matches("G2")) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                } //make sure piece thats moved is bigger
                                if (coord[inputInt3][inputInt4].matches("B1") && coord[inputInt1][inputInt2].matches("G1")) {
                                    System.out.println("Invalid move");
                                    InvalidMove = true;
                                } else if (InvalidMove != true) {

                                    coord[inputInt3][inputInt4] = coord[inputInt1][inputInt2];
                                    coord[inputInt1][inputInt2] = "__";
                                    InvalidMove = false;
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid move");
                                InvalidMove = true;
                                break;
                            }
                            //transporter
                        case 5:

                            if (sObstaclePiece.matches("T")) {
                                Integer CoordXOfManhattan = 0;
                                Integer CoordYOfManhattan = 0;
                                Integer CountOpenSpaces = 0;

                                int inputInt3 = in .readInt();
                                int inputInt4 = in .readInt();

                                //ensure shifter placed on an empty square
                                if (coord[inputInt3][inputInt4].matches("B1|B2|B3|B4") || coord[inputInt3][inputInt4].matches("G1|G2||G3|G4")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;

                                }

                                //error checking to ensure that transporter used on valid piece
                                if (coord[inputInt2][inputInt3].matches("__")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }

                                //error checking to ensure that transporter used on opponents piece

                                if (coord[inputInt2][inputInt3].matches("G1|G2|G3|G4")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }

                                //manhattan distance calculation
                                for (int i = 4; i >= 0; i--)
                                    for (int k = 4; k >= 0; k--) {

                                        if (coord[i][k] == ("__")) {
                                            CountOpenSpaces += 1;
                                            SmallestManhattanDistance = Math.abs(inputInt2 - i) + Math.abs(inputInt3 - k);
                                            //System.out.println(SmallestManhattanDistance);
                                            if (SmallestManhattanDistance <= CurrentSmallestManhattanDistance && SmallestManhattanDistance != 0) {
                                                CurrentSmallestManhattanDistance = SmallestManhattanDistance;
                                                CoordXOfManhattan = i;
                                                CoordYOfManhattan = k;
                                            }
                                        }
                                    }

                                //Make sure the board is not full
                                if (CountOpenSpaces == 0) {
                                    InvalidMove = true;

                                    break;
                                }
                                //user tries to move more pieces than available on stack
                                if (inputInt4 > 2) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }
                                //quit game if -1
                                if (inputInt3 == -1 || inputInt4 == -1) {
                                    System.out.println();
                                    System.out.println("Quit");
                                    Quit = true;
                                    break;
                                }
                                InvalidMove = false;

                                coord[CoordXOfManhattan][CoordYOfManhattan] = coord[inputInt2][inputInt3];
                                coord[inputInt2][inputInt3] = "__";

                                break;
                            }

                            //player uses shifter
                            else if (sObstaclePiece.matches("S")) {
                                String Temp1 = "";
                                String Temp2 = "";
                                String Temp3 = "";
                                String Temp4 = "";
                                String Temp5 = "";
                                String Temp6 = "";
                                String Temp7 = "";
                                String Temp8 = "";
                                int inputInt3 = in .readInt();
                                int inputInt4 = in .readInt();

                                Integer TempX = inputInt2;
                                Integer TempY = inputInt3;

                                //if statements used for correct wrapping
                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                Temp1 = coord[TempX - 1][TempY - 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX - 1 < 1)
                                    TempX = 5;
                                Temp2 = coord[TempX - 1][TempY];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (TempX - 1 < 1)
                                    TempX = 5;
                                Temp3 = coord[TempX - 1][TempY + 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                Temp4 = coord[TempX][TempY + 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY + 1 > 4)
                                    TempY = 0;
                                Temp5 = coord[TempX + 1][TempY + 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                Temp6 = coord[TempX + 1][TempY];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                Temp7 = coord[TempX + 1][TempY - 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY - 1 < 1)
                                    TempY = 5;
                                Temp8 = coord[TempX][TempY - 1];
                                TempX = inputInt2;
                                TempY = inputInt3;

                                //anti clockwise rotation

                                if (inputInt4 == 1) {
                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX - 1][TempY - 1] = Temp2;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    coord[TempX - 1][TempY] = Temp3;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX - 1][TempY + 1] = Temp4;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX][TempY + 1] = Temp5;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    coord[TempX + 1][TempY + 1] = Temp6;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    coord[TempX + 1][TempY] = Temp7;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    coord[TempX + 1][TempY - 1] = Temp8;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX][TempY - 1] = Temp1;
                                }
                                TempX = inputInt2;
                                TempY = inputInt3;

                                //clockwise rotation
                                if (inputInt4 == 0) {
                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX - 1][TempY - 1] = Temp8;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    coord[TempX - 1][TempY] = Temp1;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX - 1 < 1)
                                        TempX = 5;
                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX - 1][TempY + 1] = Temp2;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX][TempY + 1] = Temp3;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    if (TempY + 1 > 4)
                                        TempY = 0;
                                    coord[TempX + 1][TempY + 1] = Temp4;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    coord[TempX + 1][TempY] = Temp5;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempX + 1 > 4)
                                        TempX = 0;
                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX + 1][TempY - 1] = Temp6;
                                    TempX = inputInt2;
                                    TempY = inputInt3;

                                    if (TempY - 1 < 1)
                                        TempY = 5;
                                    coord[TempX][TempY - 1] = Temp7;
                                    TempX = inputInt2;
                                    TempY = inputInt3;
                                }
                                break;
                            }
                            //player uses bomb
                            else if (sObstaclePiece.matches("B")) {

                                int inputInt3 = in .readInt();

                                Integer TempX = inputInt2;
                                Integer TempY = inputInt3;

                                //error checking to ensure bomb is placed on one of own pieces
                                if (coord[inputInt2][inputInt3].matches("B1|B2|B3|B4|__|SH")) {
                                    InvalidMove = true;
                                    System.out.println("Invalid move");
                                    break;
                                }

                                //return piece to external stack
                                if (coord[inputInt2][inputInt3].matches("G1") && GreenStackList1 > 0)
                                    GreenStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G1") && GreenStackList2 > 0)
                                    GreenStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G1") && GreenStackList3 > 0)
                                    GreenStackList3 -= 1;

                                if (coord[inputInt2][inputInt3].matches("G2") && GreenStackList1 > 1)
                                    GreenStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G2") && GreenStackList2 > 1)
                                    GreenStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G2") && GreenStackList3 > 1)
                                    GreenStackList3 -= 1;

                                if (coord[inputInt2][inputInt3].matches("G3") && GreenStackList1 > 2)
                                    GreenStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G3") && GreenStackList2 > 2)
                                    GreenStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G3") && GreenStackList3 > 2)
                                    GreenStackList3 -= 1;

                                if (coord[inputInt2][inputInt3].matches("G4") && GreenStackList1 > 3)
                                    GreenStackList1 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G4") && GreenStackList2 > 3)
                                    GreenStackList2 -= 1;
                                else if (coord[inputInt2][inputInt3].matches("G4") && GreenStackList3 > 3)
                                    GreenStackList3 -= 1;

                                coord[inputInt2][inputInt3] = "__";
                                //if statements used for correct wrapping of the board and calculations to determine if a sinkhole is placed

                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                if (coord[TempX - 1][TempY - 1] != "__")
                                    coord[TempX - 1][TempY - 1] = "__";
                                else
                                    coord[TempX - 1][TempY - 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (coord[TempX - 1][TempY] != "__")
                                    coord[TempX - 1][TempY] = "__";
                                else coord[TempX - 1][TempY] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (TempX - 1 < 1)
                                    TempX = 5;
                                if (coord[TempX - 1][TempY + 1] != "__")
                                    coord[TempX - 1][TempY + 1] = "__";
                                else coord[TempX - 1][TempY + 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (coord[TempX][TempY + 1] != "__")
                                    coord[TempX][TempY + 1] = "__";
                                else
                                    coord[TempX][TempY + 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY + 1 > 4)
                                    TempY = 0;
                                if (coord[TempX + 1][TempY + 1] != "__")
                                    coord[TempX + 1][TempY + 1] = "__";
                                else
                                    coord[TempX + 1][TempY + 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (coord[TempX + 1][TempY] != "__")
                                    coord[TempX + 1][TempY] = "__";
                                else
                                    coord[TempX + 1][TempY] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempX + 1 > 4)
                                    TempX = 0;
                                if (TempY - 1 < 1)
                                    TempY = 5;
                                if (coord[TempX + 1][TempY - 1] != "__")
                                    coord[TempX + 1][TempY - 1] = "__";
                                else
                                    coord[TempX + 1][TempY - 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                                if (TempY - 1 < 1)
                                    TempY = 5;
                                if (coord[TempX][TempY - 1] != "__")
                                    coord[TempX][TempY - 1] = "__";
                                else
                                    coord[TempX][TempY - 1] = "SH";
                                TempX = inputInt2;
                                TempY = inputInt3;

                            }
                            break;
                    }
                //set blue as winner
                if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[1][2] == "B1" || coord[1][2] == "B2" || coord[1][2] == "B3" || coord[1][2] == "B4") && (coord[1][3] == "B1" || coord[1][3] == "B2" || coord[1][3] == "B3" || coord[1][3] == "B4") && (coord[1][4] == "B1" || coord[1][4] == "B2" || coord[1][4] == "B3" || coord[1][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }

                if ((coord[2][1] == "B1" || coord[2][1] == "B2" || coord[2][1] == "B3" || coord[2][1] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" || coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[2][4] == "B1" || coord[2][4] == "B2" || coord[2][4] == "B3" || coord[2][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }

                if ((coord[3][1] == "B1" || coord[3][1] == "B2" || coord[3][1] == "B3" || coord[3][1] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" || coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" || coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[3][4] == "B1" || coord[3][4] == "B2" || coord[3][4] == "B3" || coord[3][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }

                if ((coord[4][1] == "B1" || coord[4][1] == "B2" || coord[4][1] == "B3" || coord[4][1] == "B4") && (coord[4][2] == "B1" || coord[4][2] == "B2" || coord[4][2] == "B3" || coord[4][2] == "B4") && (coord[4][3] == "B1" || coord[4][3] == "B2" || coord[4][3] == "B3" || coord[4][3] == "B4") && (coord[4][4] == "B1" || coord[4][4] == "B2" || coord[4][4] == "B3" || coord[4][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }

                if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[2][1] == "B1" || coord[2][1] == "B2" || coord[2][1] == "B3" || coord[2][1] == "B4") && (coord[3][1] == "B1" || coord[3][1] == "B2" || coord[3][1] == "B3" || coord[3][1] == "B4") && (coord[4][1] == "B1" || coord[4][1] == "B2" || coord[4][1] == "B3" || coord[4][1] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }

                if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" || coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[4][2] == "B1" || coord[4][2] == "B2" || coord[4][2] == "B3" || coord[4][2] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }
                if ((coord[1][3] == "B1" || coord[1][3] == "B2" || coord[1][3] == "B3" || coord[1][3] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" || coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" || coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[4][3] == "B1" || coord[4][3] == "B2" || coord[4][3] == "B3" || coord[4][3] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }
                if ((coord[1][4] == "B1" || coord[1][4] == "B2" || coord[1][4] == "B3" || coord[1][4] == "B4") && (coord[2][4] == "B1" || coord[2][4] == "B2" || coord[2][4] == "B3" || coord[2][4] == "B4") && (coord[3][4] == "B1" || coord[3][4] == "B2" || coord[3][4] == "B3" || coord[3][4] == "B4") && (coord[4][4] == "B1" || coord[4][4] == "B2" || coord[4][4] == "B3" || coord[4][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }
                //diagonal	winner
                if ((coord[1][1] == "B1" || coord[1][1] == "B2" || coord[1][1] == "B3" || coord[1][1] == "B4") && (coord[2][2] == "B1" || coord[2][2] == "B2" || coord[2][2] == "B3" || coord[2][2] == "B4") && (coord[3][3] == "B1" || coord[3][3] == "B2" || coord[3][3] == "B3" || coord[3][3] == "B4") && (coord[4][4] == "B1" || coord[4][4] == "B2" || coord[4][4] == "B3" || coord[4][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }
                //diagonal winner
                if ((coord[4][1] == "B1" || coord[4][1] == "B2" || coord[4][1] == "B3" || coord[4][1] == "B4") && (coord[3][2] == "B1" || coord[3][2] == "B2" || coord[3][2] == "B3" || coord[3][2] == "B4") && (coord[2][3] == "B1" || coord[2][3] == "B2" || coord[2][3] == "B3" || coord[2][3] == "B4") && (coord[1][4] == "B1" || coord[1][4] == "B2" || coord[1][4] == "B3" || coord[1][4] == "B4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Blue wins!");
                    Winner = true;
                    BlueWins = true;
                    break;
                }

                //set green as winner
                if ((coord[1][1] == "G1" || coord[1][1] == "G2" || coord[1][1] == "G3" || coord[1][1] == "G4") && (coord[1][2] == "G1" || coord[1][2] == "G2" || coord[1][2] == "G3" || coord[1][2] == "G4") && (coord[1][3] == "G1" || coord[1][3] == "G2" || coord[1][3] == "G3" || coord[1][3] == "G4") && (coord[1][4] == "G1" || coord[1][4] == "G2" || coord[1][4] == "G3" || coord[1][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }

                if ((coord[2][1] == "G1" || coord[2][1] == "G2" || coord[2][1] == "G3" || coord[2][1] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" || coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[2][4] == "G1" || coord[2][4] == "G2" || coord[2][4] == "G3" || coord[2][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }

                if ((coord[3][1] == "G1" || coord[3][1] == "G2" || coord[3][1] == "G3" || coord[3][1] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" || coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" || coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[3][4] == "G1" || coord[3][4] == "G2" || coord[3][4] == "G3" || coord[3][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }

                if ((coord[4][1] == "G1" || coord[4][1] == "G2" || coord[4][1] == "G3" || coord[4][1] == "G4") && (coord[4][2] == "G1" || coord[4][2] == "G2" || coord[4][2] == "G3" || coord[4][2] == "G4") && (coord[4][3] == "G1" || coord[4][3] == "G2" || coord[4][3] == "G3" || coord[4][3] == "G4") && (coord[4][4] == "G1" || coord[4][4] == "G2" || coord[4][4] == "G3" || coord[4][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }

                if ((coord[1][1] == "G1" || coord[1][1] == "G2" || coord[1][1] == "G3" || coord[1][1] == "G4") && (coord[2][1] == "G1" || coord[2][1] == "G2" || coord[2][1] == "G3" || coord[2][1] == "G4") && (coord[3][1] == "G1" || coord[3][1] == "G2" || coord[3][1] == "G3" || coord[3][1] == "G4") && (coord[4][1] == "G1" || coord[4][1] == "G2" || coord[4][1] == "G3" || coord[4][1] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }

                if ((coord[1][2] == "G1" || coord[1][2] == "G2" || coord[1][2] == "G3" || coord[1][2] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" || coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[4][2] == "G1" || coord[4][2] == "G2" || coord[4][2] == "G3" || coord[4][2] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }
                if ((coord[1][3] == "G1" || coord[1][3] == "G2" || coord[1][3] == "G3" || coord[1][3] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" || coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" || coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[4][3] == "G1" || coord[4][3] == "G2" || coord[4][3] == "G3" || coord[4][3] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }
                if ((coord[1][4] == "G1" || coord[1][4] == "G2" || coord[1][4] == "G3" || coord[1][4] == "G4") && (coord[2][4] == "G1" || coord[2][4] == "G2" || coord[2][4] == "G3" || coord[2][4] == "G4") && (coord[3][4] == "G1" || coord[3][4] == "G2" || coord[3][4] == "G3" || coord[3][4] == "G4") && (coord[4][4] == "G1" || coord[4][4] == "G2" || coord[4][4] == "G3" || coord[4][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }
                //diagonal winner
                if ((coord[1][1] == "G1" || coord[1][1] == "G2" || coord[1][1] == "G3" || coord[1][1] == "G4") && (coord[2][2] == "G1" || coord[2][2] == "G2" || coord[2][2] == "G3" || coord[2][2] == "G4") && (coord[3][3] == "G1" || coord[3][3] == "G2" || coord[3][3] == "G3" || coord[3][3] == "G4") && (coord[4][4] == "G1" || coord[4][4] == "G2" || coord[4][4] == "G3" || coord[4][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }
                //diagonal winner
                if ((coord[4][1] == "G1" || coord[4][1] == "G2" || coord[4][1] == "G3" || coord[4][1] == "G4") && (coord[3][2] == "G1" || coord[3][2] == "G2" || coord[3][2] == "G3" || coord[3][2] == "G4") && (coord[2][3] == "G1" || coord[2][3] == "G2" || coord[2][3] == "G3" || coord[2][3] == "G4") && (coord[1][4] == "G1" || coord[1][4] == "G2" || coord[1][4] == "G3" || coord[1][4] == "G4")) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Green wins!");
                    Winner = true;
                    GreenWins = true;
                    break;
                }
                //In case of a draw
                if (GreenWins == true && BlueWins == true) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");
                    System.out.println();
                    System.out.println("Draw!");
                    break;
                }
                //print board if invalid move is not equal to true

                if (InvalidMove != true) {
                    System.out.println();
                    System.out.println("   c1" + " c2" + " c3" + " c4");
                    System.out.println("r1 " + coord[1][1] + "|" + coord[1][2] + "|" + coord[1][3] + "|" + coord[1][4] + "|");
                    System.out.println("r2 " + coord[2][1] + "|" + coord[2][2] + "|" + coord[2][3] + "|" + coord[2][4] + "|");
                    System.out.println("r3 " + coord[3][1] + "|" + coord[3][2] + "|" + coord[3][3] + "|" + coord[3][4] + "|");
                    System.out.println("r4 " + coord[4][1] + "|" + coord[4][2] + "|" + coord[4][3] + "|" + coord[4][4] + "|");

                }

            }
            //print out statistics
            if (Winner != true && Quit == false)
                System.out.println();
            System.out.println("No winner, input file ended");
            System.out.println("Statistics for each stack present on the board");

            for (int i = 0; i < Stat.size(); i++) {
                System.out.println(Stat.get(i));
            }
            System.out.println("Statistics external stacks blue player");

            if (BlueStackList1 == 0)
                System.out.println("Stack 1: B1 B2 B3 B4");
            else if (BlueStackList1 == 1)
                System.out.println("Stack 1: B2 B3 B4");
            else if (BlueStackList1 == 2)
                System.out.println("Stack 1: B3 B4");
            else if (BlueStackList1 == 3)
                System.out.println("Stack 1: B4");
            else System.out.println("Stack 1:");

            if (BlueStackList2 == 0)
                System.out.println("Stack 2: B1 B2 B3 B4");
            else if (BlueStackList2 == 1)
                System.out.println("Stack 2: B2 B3 B4");
            else if (BlueStackList2 == 2)
                System.out.println("Stack 2: B3 B4");
            else if (BlueStackList2 == 3)
                System.out.println("Stack 2: B4");
            else System.out.println("Stack 2:");

            if (BlueStackList3 == 0)
                System.out.println("Stack 3: B1 B2 B3 B4");
            else if (BlueStackList3 == 1)
                System.out.println("Stack 3: B2 B3 B4");
            else if (BlueStackList3 == 2)
                System.out.println("Stack 3: B3 B4");
            else if (BlueStackList3 == 3)
                System.out.println("Stack 3: B4");
            else System.out.println("Stack 3:");
            System.out.println("Statistics external stacks green player");

            if (GreenStackList1 == 0)
                System.out.println("Stack 1: G1 G2 G3 G4");
            else if (GreenStackList1 == 1)
                System.out.println("Stack 1: G2 G3 G4");
            else if (GreenStackList1 == 2)
                System.out.println("Stack 1: G3 G4");
            else if (GreenStackList1 == 3)
                System.out.println("Stack 1: G4");
            else System.out.println("Stack 1:");

            if (GreenStackList2 == 0)
                System.out.println("Stack 2: G1 G2 G3 G4");
            else if (GreenStackList2 == 1)
                System.out.println("Stack 2: G2 G3 G4");
            else if (GreenStackList2 == 2)
                System.out.println("Stack 2: G3 G4");
            else if (GreenStackList2 == 3)
                System.out.println("Stack 2: G4");
            else System.out.println("Stack 2:");
            if (GreenStackList3 == 0)
                System.out.println("Stack 3: G1 G2 G3 G4");
            else if (GreenStackList3 == 1)
                System.out.println("Stack 3: G2 G3 G4");
            else if (GreenStackList3 == 2)
                System.out.println("Stack 3: G3 G4");
            else if (GreenStackList3 == 3)
                System.out.println("Stack 3: G4");
            else System.out.println("Stack 3:");

        }
    }

}