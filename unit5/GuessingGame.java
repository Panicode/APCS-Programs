import java.util.Scanner;
public class GuessingGame{
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        boolean yesPlay=true;
        boolean ifStart=false;
        while(yesPlay=true){
            if(ifStart==false){
                System.out.println("Do you wanna play my guessing game? y/n");
                ifStart=true;
            }
            String ans=input.nextLine();
            if(ans.contains("y")&&ans.contains("n")){
                System.out.println("\f"+"Invalid answer! Please attempt again!");
            }else if(ans.contains("n")){
                System.out.println("\f"+"That's rude, alright bye.");
                yesPlay=false;
                break;
            }else if(ans.contains("y")){
                System.out.println("\f"+"Okay! Let's play!"+"\n"+"\n"+"The rules of the game is simple,"+"\n"+
                "There's a gameboard of a player-specified size"+"\n"+"and you have to guess which coordinate has a 0 in it!"
                +"\n"+"I'll tell you how close or far you are!"+"\n"+"\n"+"Let's start out by choosing how many rows and columns you want!");
                boolean ifActive=false;
                int row=0;
                int col=0;
                while(ifActive==false){
                    System.out.println("Please input the amount of rows you want.");
                    row=input.nextInt();
                    System.out.println("Please input the amount of columns you want.");
                    col=input.nextInt();
                    if(row==0||col==0){
                        System.out.println("One of the numbers are zero! Try again!");
                    }else{ifActive=true;}}
                int gameBoard[][]=new int[row][col];
                for(int i=0;i<gameBoard.length;i++){ //filling array
                    for(int j=0;j<gameBoard[0].length;j++){
                        gameBoard[i][j]=(int)(Math.random()*100+1);
                    }
                }
                int ranRow=(int)(Math.random()*row);
                int ranCol=(int)(Math.random()*col);
                gameBoard[ranRow][ranCol]=0;
                String visualBoard[][]=new String[row][col];
                for(int i=0;i<visualBoard.length;i++){ //filling array (this is for graphics)
                    for(int j=0;j<visualBoard[0].length;j++){
                        visualBoard[i][j]="X";
                    }
                }
                int guessCount=0;
                boolean gameWon=false;
                boolean startA=false;
                int rowOff=0;
                int colOff=0;
                while(gameWon==false){
                    int gaRow=0;
                    int gaCol=0;
                    boolean invalCheck=false;
                    System.out.println("\f");
                    System.out.println("X = Hasn't been guessed"+"\n"+"A = Has been guessed before");
                    for(int k=0;k<visualBoard.length;k++){
                        for(int l=0;l<visualBoard[0].length;l++){
                            System.out.print(visualBoard[k][l]+" ");
                        }
                        System.out.println();
                    }
                    if(startA==true){
                        System.out.println("\n"+"Your last input is "+rowOff+" rows off, and "+colOff+" columns off."+"\n");
                    }
                    while(invalCheck==false){
                        System.out.println("\n"+"Input your row guess!");
                        gaRow=input.nextInt();
                        System.out.println("\n"+"Input your column guess!");
                        gaCol=input.nextInt();
                        if(gaRow<=0||gaCol<=0){
                            System.out.println("One or more of the inputs are zero! Try again!");
                        }else if(gaRow>gameBoard.length||gaCol>gameBoard[0].length){
                            System.out.println("One or more of the inputs are bigger than the board! Try again!");
                        }else{invalCheck=true;}
                    }
                    if(gameBoard[gaRow-1][gaCol-1]==0){ //if won statement
                        System.out.println("\f"+" _     _                                  _ "+"\n"+"| |   | |                                | |"+"\n"+
                        "| |___| | ___  _   _    _ _ _  ___  ____ | |"+"\n"+"|_____  |/ _ "+"\\"+"| | | |  | | | |/ _ "+"\\"+"|  _ "+"\\"+"|_|"+"\n"+" _____| | |_| | |_| |  | | | | |_| | | | |_ "+"\n"+
                        "(_______|"+"\\"+"___/|____/    "+"\\"+"___/ "+"\\"+"___/|_| |_|_|"+"\n"+"\n"+"Amazing job!");
                        gameWon=true;
                    }else{
                        visualBoard[gaRow-1][gaCol-1]="A";
                        rowOff=Math.abs(ranRow-(gaRow-1));
                        colOff=Math.abs(ranCol-(gaCol-1));
                        startA=true;
                    }
                }
                System.out.println("\n"+"\n"+"Wanna play again? y/n");
                String ansD=input.nextLine();
                if(ansD.contains("y")&&ansD.contains("n")){
                    System.out.println("\f"+"Invalid answer! Please attempt again!");
                }else if(ansD.contains("n")){
                    System.out.println("\f"+"See ya! Thanks for playing!");
                    yesPlay=false;break;
                }
            }else{System.out.println("\f"+"Invalid answer! Please attempt again!");}
        }
    }
}
