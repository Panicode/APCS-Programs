public class TicAI{
    int realBoy[][]=new int[3][3];
    public int compute(int in[][],int playNum){
        int outRow=0;
        int outCol=0;
        int arCheck[][]=new int[0][0];
        int amount=0;
        for(int i=0;i<realBoy.length;i++){        //finds all inputs given (playNum)
            for(int j=0;j<realBoy[0].length;j++){
                if(in[i][j]==playNum){
                    arCheck[amount][0]=i;
                    arCheck[amount][1]=j;
                    amount++;
                }
            }
        }
                                                  //found all the coordinates of every single input done by the player, put them in an array.
        if(amount==0){
            outRow=(int)(Math.random()*3);
            outCol=(int)(Math.random()*3);        //if all of the inputs are invalid, it outputs a random integer
        }else{
            for(int i=0;i<arCheck.length;i++){
                int checkBoard[][]=new int[3][3];
                for(int j=0;j<checkBoard.length;j++){
                    for(int l=0;l<checkBoard[0].length;l++){
                        checkBoard[j][l]=l;
                    }
                }
            }
            
        }
        return realBoy[outRow][outCol];           //outputs the EXACT COORDINATES of where the bot wants to place the output
    }
}

