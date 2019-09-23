public class TicAI{
    public int[] compute(int in[][],int playNum,int empty){
        int output[]={0,0};
        int arCheck[][]=new int[0][0];
        int amount=0;
        for(int i=0;i<in.length;i++){ //finds all inputs given (playNum)
            for(int j=0;j<in[0].length;j++){
                if(in[i][j]==playNum){
                    arCheck[amount][0]=i;
                    arCheck[amount][1]=j;
                    amount++;
                }
            }
        } //found all the coordinates of every single input done by the player, put them in an array.
        if(amount==0){
            output[0]=(int)(Math.random()*3);
            output[1]=(int)(Math.random()*3); //if all of the inputs are invalid, it outputs a random integer
        }else{
            for(int i=0;i<arCheck.length;i++){
                int checkBoard[][][]=new int[3][3][2];
                for(int j=0;j<checkBoard.length;j++){
                    checkBoard[0][j][0]=arCheck[0][0]-1;
                    checkBoard[1][j][0]=arCheck[0][0];
                    checkBoard[2][j][0]=arCheck[0][0]+1;
                }
                for(int j=0;j<checkBoard.length;j++){
                    checkBoard[j][0][1]=arCheck[0][1]-1;
                    checkBoard[j][1][1]=arCheck[0][1];
                    checkBoard[j][2][1]=arCheck[0][1]+1;
                }
                for(int n=0;n<checkBoard.length;n++){
                    for(int m=0;m<checkBoard.length;m++){
                        int checkNum[]={checkBoard[n][m][0],checkBoard[n][m][1]};
                        if(checkNum[0]>=0&&checkNum[1]>=0&&checkNum[0]<3&&checkNum[1]<3){
                            if(checkNum[0]!=arCheck[i][0]&&checkNum[1]!=arCheck[i][1]){
                                //AI found adjacent valid tiles.
                                if(in[checkNum[0]][checkNum[1]]==playNum){
                                    //AI found adjacent playNum opponet values
                                    
                                }
                            }
                        }
                    }
                }
            }
            
        }
        return output;           //outputs the EXACT COORDINATES of where the bot wants to place the output
    }
}
