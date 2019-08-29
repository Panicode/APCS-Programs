import java.util.Scanner;
public class rockPaperScissors{
     public static void main(String []args){
        boolean yesplay = true;
        while (yesplay == true){
            Scanner input = new Scanner(System.in);
            System.out.println("----------------------------------------------------");
            System.out.println("Wanna play a game of Rock, Paper, Scissors? [y/n]");
            String in = input.nextLine();
            if(in.contains("y")&&in.contains("n")){System.out.println("Sorry, invalid response.");
            }else if(in.contains("n")){System.out.println("Alright chill, have it your way.");yesplay = false;
            }else if(in.contains("y")){
                System.out.println("----------------------------------------------------");
                System.out.println("Okay! Let's play!");
                System.out.println("I'll choose a number between 1-3!");
                int botenter = (int)(Math.random()*3+1);
                System.out.println("----------------------------------------------------");
                System.out.println("1 corresponds to: Rock");
                System.out.println("2 corresponds to: Paper");
                System.out.println("3 corresponds to: Scissors");
                System.out.println("----------------------------------------------------");
                System.out.println("Choose a number and see if you can beat me!");
                boolean gameend = false;
                boolean argwon = false;
                int plenter = input.nextInt();
                while(gameend == false){
                    if(plenter==botenter){
                        gameend = false;
                        System.out.println("It was a tie! Go again!");
                        botenter = (int)(Math.random()*3+1);
                        plenter = input.nextInt();
                    }else if(plenter == 1){
                        if(botenter == 2){argwon = false;gameend=true;}
                        if(botenter == 3){argwon = true;gameend=true;}
                    }else if(plenter == 2){
                        if(botenter == 3){argwon = false;gameend=true;}
                        if(botenter == 1){argwon = true;gameend=true;}
                    }else if(plenter == 3){
                        if(botenter == 1){argwon = false;gameend=true;}
                        if(botenter == 2){argwon = true;gameend=true;}
                    }
                }
                if(argwon == false){
                    System.out.println("You lost!");gameend = false;
                }
                if(argwon == true){
                    System.out.println("You won!");gameend = false;
                }
                String botentv = "";
                String plentv = "";
                if(botenter==1){botentv="Rock";}if(botenter==2){botentv="Paper";}if(botenter==1){botentv="Scissors";}
                if(plenter==1){plentv="Rock";}if(plenter==2){plentv="Paper";}if(plenter==1){plentv="Scissors";}
                System.out.println("You chose "+plentv+", and the bot chose "+botentv+".");
            }
         }
    }
}
