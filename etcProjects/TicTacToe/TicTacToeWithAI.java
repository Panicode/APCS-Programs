import java.util.Scanner;
class TicAI{
    public int[] compute(int in[][],int playNum,int empty){
        int[] output= new int[2];
        boolean iffound=false;
        int opfound=0;
        for(int i=0;i<in.length;i++){
            if(!iffound){
                opfound=0;
                for(int j=0;j<in[0].length;j++){
                    if(in[i][j]==playNum){
                        opfound++;
                    }
                }
                if(opfound==2){
                    for(int j=0;j<in[0].length;j++){
                        if(in[i][j]==empty){
                            iffound=true;
                            output[0]=i;output[1]=j;
                        }
                    }
                }
            }
        }
        for(int i=0;i<in.length;i++){
            if(!iffound){
                opfound=0;
                for(int j=0;j<in[0].length;j++){
                    if(in[j][i]==playNum){
                        opfound++;
                    }
                }
                if(opfound==2){
                    for(int j=0;j<in[0].length;j++){
                        if(in[i][j]==empty){
                            iffound=true;
                            output[0]=i;output[1]=j;
                        }
                    }
                }
            }
        }
        if(!iffound){
            opfound=0;
            if(in[0][0]==playNum){opfound++;}if(in[1][1]==playNum){opfound++;}if(in[2][2]==playNum){opfound++;}
            if(opfound==2){
                if(in[0][0]==empty){output[0]=0;output[1]=0;iffound=true;}
                if(in[1][1]==empty){output[0]=1;output[1]=1;iffound=true;}
                if(in[2][2]==empty){output[0]=2;output[1]=2;iffound=true;}
            }
        }
        if(!iffound){
            opfound=0;
            if(in[0][2]==playNum){opfound++;}if(in[1][1]==playNum){opfound++;}if(in[2][0]==playNum){opfound++;}
            if(opfound==2){
                if(in[0][2]==empty){output[0]=2;output[1]=0;iffound=true;}
                if(in[1][1]==empty){output[0]=1;output[1]=1;iffound=true;}
                if(in[2][0]==empty){output[0]=2;output[1]=0;iffound=true;}
            }
        }
        if(!iffound){
            for(int i=0;i<in.length;i++){
                if(!iffound){
                    for(int j=0;j<in[0].length;j++){
                        if(!iffound){
                            if(in[i][j]==empty){
                                iffound=true;
                                output[0]=i;output[1]=j;
                            }
                        }
                    }
                }
            }
        }
        return output;
    }
    public int checkWon(int in[][],int playNum,int aiNum,int empty){
        int mate=0;
        int winner=0;
        if(mate==0){
        for(int i=0;i<in.length;i++){
            mate=0;
            for(int j=0;j<in[0].length;j++){
                if(in[i][j]==1){
                    mate++;
                }else if(in[i][j]==2){
                    mate--;
                }
            }
            if(mate==3){
                winner= 1;
            }else if(mate==-3){
                winner= 2;
            }else{
                winner= 0;
            }
        }}
        if(mate==0){
            for(int i=0;i<in.length;i++){
                mate=0;
                for(int j=0;j<in[0].length;j++){
                    if(in[j][i]==1){
                        mate++;
                    }else if(in[j][i]==2){
                        mate--;
                    }
                }
                if(mate==3){
                    winner= 1;
                }else if(mate==-3){
                    winner= 2;
                }else{
                    winner= 0;
                }
            }
        }
        if(mate==0){
            mate=0;
            if(in[0][0]==playNum){mate++;}if(in[1][1]==playNum){mate++;}if(in[2][2]==playNum){mate++;}
            if(in[0][0]==aiNum){mate--;}if(in[1][1]==aiNum){mate--;}if(in[2][2]==aiNum){mate--;}
            if(mate==3){
                winner= 1;
            }else if(mate==-3){
                winner= 2;
            }else{
                winner= 0;
            }
        }
        if(mate==0){
            mate=0;
            if(in[0][2]==playNum){mate++;}if(in[1][1]==playNum){mate++;}if(in[2][0]==playNum){mate++;}
            if(in[0][2]==aiNum){mate--;}if(in[1][1]==aiNum){mate--;}if(in[2][0]==aiNum){mate--;}
            if(mate==3){
                winner= 1;
            }else if(mate==-3){
                winner= 2;
            }else{
                winner= 0;
            }
        }
        return winner;
    }
}
public class TicTacToeWithAI{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        boolean playYes=true;
        boolean again=false;
        int rounds=0;
        while(playYes==true){
            if(again){
                System.out.println("\nDo you wanna play again? y/n");
            }
            System.out.println("Hello! Do you wanna play Tic Tac Toe Against an AI? y/n");
            String playAns=input.nextLine();
            if((playAns.contains("y")&&playAns.contains("n"))||(playAns.contains("y")==false&&playAns.contains("n")==false)){
                System.out.println("\fInvalid input! Try again!\n");
            }else if(playAns.contains("n")){
                System.out.println("\fOkay. Nevermind.");
                playYes=false;
            }else if(playAns.contains("y")){
                System.out.println("\fOkie dokie! Let's-a-go!");
                int[][] gameBoard=new int[3][3];
                for(int i=0;i<gameBoard.length;i++){
                    for(int j=0;j<gameBoard[0].length;j++){
                        gameBoard[i][j]=0;
                    }
                }
                boolean gameDone=false;
                int wonStatement=0;
                int checkIfWon=0;
                TicAI aiMain=new TicAI();
                while(gameDone==false){//main game
                    System.out.println("\f");
                    for(int i=0;i<gameBoard.length;i++){
                        for(int j=0;j<gameBoard[0].length;j++){
                            String putter="";
                            if(gameBoard[i][j]==0){putter="-";}
                            else if(gameBoard[i][j]==1){putter="X";}
                            else if(gameBoard[i][j]==2){putter="O";}
                            System.out.print(putter+" ");
                        }
                        System.out.println();
                    }
                    if(gameDone==false){//player
                        System.out.println("\n(Rows and columns are chosen from 0-2)");
                        boolean activePerm=false;
                        while(!activePerm){
                            System.out.println("\nPlease choose your row input!");
                            int rowPlay=input.nextInt();
                            System.out.println("\nPlease choose your column input!");
                            int colPlay=input.nextInt();
                            if((rowPlay>=0&&colPlay>=0)&&(rowPlay<=2&&colPlay<=2)){
                                if(gameBoard[rowPlay][colPlay]==0){
                                    gameBoard[rowPlay][colPlay]=1;
                                    activePerm=true;
                                }else{
                                    System.out.println("The number isn't empty! try again!");
                                }
                            }else{
                                System.out.println("The number isn't within the paremeters! try again!");
                            }
                        }
                    }
                    rounds++;
                    checkIfWon=aiMain.checkWon(gameBoard,1,2,0);
                    if(checkIfWon!=0){
                        gameDone=true;
                        wonStatement=checkIfWon;
                    }
                    if(gameDone==false){//ai
                        int[] aiInput=aiMain.compute(gameBoard,1,0);
                        gameBoard[aiInput[0]][aiInput[1]]=2;
                        rounds++;
                    }
                    checkIfWon=aiMain.checkWon(gameBoard,1,2,0);
                    if(checkIfWon!=0){
                        gameDone=true;
                        wonStatement=checkIfWon;
                    }
                    if(rounds>8){
                        gameDone=true;
                    }
                }
                if(wonStatement==1){
                    System.out.println("\fYou win!");
                    gameDone=true;
                    break;
                }else if(wonStatement==2){
                    System.out.println("\ftoo bad so sad :(");
                    gameDone=true;
                    break;
                }else{
                    System.out.println("\ftie!");
                    gameDone=true;
                    break;
                }
            }
        }
    }
}
