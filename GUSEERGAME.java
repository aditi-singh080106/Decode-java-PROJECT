// package Decode java PROJECT;
import java.util.Scanner ;
class Gusser {
    int GusserNum ;
    public int GusserNumb(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Gusser kindly guess a number");
        GusserNum = sc.nextInt();
        return GusserNum ;
    }
}
class Player {
    int PlayerNum ;
    public int PlayerNumb(){
        Scanner sc = new Scanner(System.in);
        PlayerNum = sc.nextInt();
        return PlayerNum ;
    }
}
class Umpire{
    int Gussernum;
    int Playernum1;
    int Playernum2;
    int Playernum3;
    public void CollectNumFromGusser(){
        Gusser Gu = new Gusser();
        Gussernum = Gu.GusserNumb();
    }
    public void CollectNumFromPlayer(){
        System.out.println("Player1 kindly guess a number");
        Player Pl1 = new Player();
        Playernum1 = Pl1.PlayerNumb();
        System.out.println("Player2 kindly guess a number");
        Player Pl2 = new Player();
        Playernum2 = Pl2.PlayerNumb();
        System.out.println("Player3 kindly guess a number");
        Player Pl3 = new Player();
        Playernum3 = Pl3.PlayerNumb();
    }
    public void Compare(){
        if(Gussernum == Playernum1 && Gussernum == Playernum2 && Gussernum == Playernum3){
            System.out.println("All players guessed the number");
        }
        else if(Gussernum == Playernum1 && Gussernum == Playernum2 && Gussernum != Playernum3){
            System.out.println("Player1 and Player2 guessed the number");
        }
        else if (Gussernum == Playernum1 && Gussernum != Playernum2 && Gussernum == Playernum3){
            System.out.println("Player1 and Player3guessed the number");
        }
        else if(Gussernum != Playernum1 && Gussernum == Playernum2 && Gussernum == Playernum3){
            System.out.println("Player2 and Player3 guessed the number");
        }
        else if(Gussernum == Playernum1){
            System.out.println("Player1 guessed the number");
        }
        else if(Gussernum == Playernum2){
            System.out.println("Player2 guessed the number");
        }
        else if(Gussernum == Playernum3){
            System.out.println("Player3 guessed the number");
        }
        else{
            System.out.println("No players guessed the correct number");
        }
    }
}
public class GUSEERGAME {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Umpire Um = new Umpire();
        System.out.println("---------------Game Start -----------------");
        Um.CollectNumFromGusser();
        Um.CollectNumFromPlayer();
        Um.Compare();
        System.out.println("---------------Game Over -----------------");
        sc.close();
    }
}
