import javafx.animation.PauseTransition;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class JavaFXTemplate extends Application {
	
	
	
	

  public static void main(String[] args) {
     // TODO Auto-generated method stub
     launch(args);
  }

  private int spot=0;
  private int chances=0;
  private int tot_sum=0;
  private int num_of_games_played=0;
  private List<Integer> bet_num = new ArrayList<>();
  
  
  public int get_spots() 
  {
	  
	  return spot;
  }
  
  public int get_chances() 
  {
	  return chances;
	  
  }
  
  public int get_sum() {
	  
	  return tot_sum;
  }
  
  public int get_num_of_games_played()
  {
	  return num_of_games_played;
	  
  }
  
  public void set_spots(int x) {spot=x;}
  public void set_chances(int x) {chances=x;}
  public void set_sum(int x){tot_sum=x;}
  public void set_num_of_games_played(int x) {num_of_games_played=x;}
  
  
  
  
  private void back_b(String url, BorderPane p){
	 p.setStyle("-fx-font-family: SansSerif;");
     p.setPrefSize(830,830);
     p.setPadding(new Insets(0,10,0,0));
     BackgroundImage b = new BackgroundImage(new Image(url),BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(830, 830, true, true, true, false));
     p.setBackground(new Background(b));

  }

  

  private void back_grid(String url, GridPane gp){
	 gp.setStyle("-fx-font-family: SansSerif;");
     gp.setPrefSize(830,830);
     gp.setPadding(new Insets(0,10,0,0));
     BackgroundImage b = new BackgroundImage(new Image(url),BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(830, 830, true, true, true, false));
     gp.setBackground(new Background(b));

  }

  // ODDS of the game 
  private void ODDS(Stage ps, String pic)
  {
	 //pane
     GridPane p = new GridPane();
     back_grid("rules.jpg",p);
     p.setMinSize(830,830);
     p.setMaxSize(830,830);
     
     //setting gaps
     p.setHgap(5);
     p.setVgap(5);

     //title
     Label title = new Label("Odds of winning");
     title.setUnderline(true);
     GridPane.setHalignment(title, HPos.CENTER);
     title.setFont(new Font("Tahoma",40));
     title.setTextFill(Color.web("#FFC0CB"));
     p.add(title,6,0);
     GridPane.setHalignment(title, HPos.CENTER);
     
     //actual odds of the game
     Label o = new Label("Spot Game: Odds \n \n" +
           "1: 1 in 4.00\n\n" +
           "4: 1 in 3.86 \n\n" +
           "8: 1 in 9.77 \n\n" +
           "10: 1 in 9.05");
     o.setFont(new Font("Tahoma",35));
     o.setTextFill(Color.web("#FFFFFF"));
     o.setWrapText(true);
     p.add(o,1,1);
     GridPane.setHalignment(o, HPos.CENTER);
     
     //back button
     Button back = new Button("<--");
     EventHandler<ActionEvent> back_h;
     back_h = e->{
    	 menu_page(ps,pic);
     };
     back.setOnAction(back_h);
     back.setStyle("-fx-background-color: #FFA500; -fx-font-size: 2em; -fx-border-color: #545454; -fx-border-width: 2px;");
     p.add(back,1,40);
     
     //scene
     Scene scene = new Scene(p,830,830);
     ps.setScene(scene);
     ps.show();
  }



  private void Rules(Stage ps,String pic){
	 //grid
     GridPane p = new GridPane();
     back_grid("rules.jpg",p);
     //setting grid
     p.setMinSize(830,830);
     p.setMaxSize(830,830);
     p.setHgap(5);
     p.setVgap(5);
     p.setStyle("-fx-font-family: SansSerif;");
     
     //title  that says Rules
     Label title = new Label("Rules");
     title.setUnderline(true);
     GridPane.setHalignment(title, HPos.CENTER);
     title.setFont(new Font("Tahoma",40));
     title.setTextFill(Color.web("#FFC0CB"));
     p.add(title,1,0);
     
     //rules copied from the document for proj 2
     Label r = new Label("\n1. Wager by choosing a set amount of numbers( pick 2 numbers, pick 10 numbers,etc.) " +
           "ranging from 1 to 80\n \n2. After all players have made their wagers and picked their numbers, twenty numbers are drawn at random, between 1 and 80 with no duplicates.\n" +
           "\n3. The amount of numbers drawn and the amount of numbers matched that players are allowed to wager on will differ from casino to casino and state lottery to state lottery" +
           "\n \n4. Players win by matching a set amount of their numbers to the numbers that are randomly drawn.\n");
     r.setFont(new Font("Tahoma",25));
     r.setTextFill(Color.web("#FFFFFF"));
     r.setWrapText(true);
     GridPane.setHalignment(r, HPos.CENTER);
     p.add(r,1,1);
     
     //back button
     Button back = new Button("<--");
     EventHandler<ActionEvent> back_h;
     back_h = e->{

        menu_page(ps,pic);
     };
     back.setOnAction(back_h);
     back.setStyle("-fx-background-color: #FFA500; -fx-font-size: 2em; -fx-border-color: #545454; -fx-border-width: 2px;");
     p.add(back,1,40);
     
     //setting the stage
     Scene scene = new Scene(p,830,830);
     ps.setScene(scene);
     ps.show();

  }

  
  private void exit_page(Stage ps,String pic) 
  {
	  
	  	GridPane p = new GridPane();
	    back_grid(pic,p);
	    p.setMinWidth(830);
	    p.setMaxWidth(830);
	    p.setStyle("-fx-font-family: SansSerif;");
	    
	    //Setting gaps
	    p.setHgap(10);
	    p.setVgap(10);
	    
	    
	    //Label for exit
	    Label e = new Label("Exit: Are You Sure?");
	    e.setFont(new Font("Tahoma",45));
	    e.setUnderline(true);
	    e.setTextFill(Color.web("#FFC0CB"));
	    p.add(e,6,4,7,7);
	    
	    Button yes = new Button("YES");
	    EventHandler<ActionEvent> yes_h;
	    yes_h =x->{
	    	Platform.exit();
	    };
	    yes.setOnAction(yes_h);
	     yes.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
	     p.add(yes,5,35);
  
	     //No button
	     Button no = new Button("No");
	     EventHandler<ActionEvent> no_h;
	     no_h =x->{
	    	 menu_page(ps,pic);
	     };
	     no.setOnAction(no_h);
	     no.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
	     p.add(no, 20,35);
	   
	     //Scene
	     Scene scene = new Scene(p,830,830);
	     ps.setScene(scene);
	     ps.show();
  }
  
  
  
  private void menu_page(Stage ps,String pic)
  {

     GridPane p = new GridPane();
     back_grid(pic,p);
     p.setMinWidth(830);
     p.setMaxWidth(830);
     p.setStyle("-fx-font-family: SansSerif;");
     
     //Menu Label
     Label m = new Label("Menu:");
     m.setFont(new Font("Tahoma",50));
     m.setTextFill(Color.web("#FFC0CB"));
     m.setUnderline(true);
     p.add(m,0,0,3,3);
     
     
     p.setAlignment(Pos.CENTER);
     p.setHgap(10);
     p.setVgap(10);
     
     ////////Rules button
     Button rules = new Button("Rules");
     EventHandler<ActionEvent> rules_h;
     rules_h = e->{
        Rules(ps,pic);
     };
     rules.setOnAction(rules_h);
     rules.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     p.add(rules,5,5);
     
     
     /////////Odds button
     Button odds = new Button("Odds");
     EventHandler<ActionEvent> odds_h;
     odds_h = e->{
        ODDS( ps, pic);
     };
     odds.setOnAction(odds_h);
     odds.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     p.add(odds,10,15);

     
     /////////leaves the game
     Button exit = new Button("Exit");
     EventHandler<ActionEvent> exit_h;
     exit_h = e->{
        exit_page(ps,pic);
     };
     exit.setOnAction(exit_h);
     exit.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     p.add(exit,15,30);



     /////////Back button which takes u to the homepage
     Button back = new Button("<--");
     EventHandler<ActionEvent> back_handler;
     back_handler = e->{

        home_page(ps,pic);
     };
     back.setOnAction(back_handler);
     back.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     p.add(back,0,40);

     //Scene
     Scene scene = new Scene(p,830,830);
     ps.setScene(scene);
     ps.show();

  }

  
  //checks winnings if any number is the same to the other number
  private boolean checkwinnings(int s,List<Integer> x)
	{
	  int count=0;
	  if(x.size()==0) {return false;}
	  while(count<x.size())
	  	{
		  if(x.get(count)==s) {return true;}
		  
	  	count++;
	  	}
	  return false;
	  
	}
  
  
  private List<Integer> won(List<Integer> x)
  {
	  List<Integer> ret= new ArrayList<>();
	  
	  for(int i =0;i<bet_num.size();i++)
	  {
		  for(int j=0;j<x.size();j++)
		  {
			  if(bet_num.get(i)==x.get(j)) 
			  {
				  ret.add(bet_num.get(i));
				  }
			  
		  }
		  
		  
	  }
	  
	  
	  return ret;
  }
  
  
  
  private void final_screen(Stage ps,String pic) 
  {
	  
	  //pane
	 	BorderPane pane = new BorderPane();
		back_b(pic,pane);
		pane.setStyle("-fx-font-family: SansSerif;");
	  	
		Label title = new Label("You have won $"+tot_sum+" the whole time you played");
 	     title.setFont(new Font("Tahoma",50));
 	     title.setWrapText(true);
 	     title.setTextFill(Color.web("#FFC0CB"));
 	     title.setAlignment(Pos.TOP_CENTER);
 	     pane.setTop(title);
 	     
 	     Button leave= new Button("Exit!");
 	    leave.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
	     pane.setCenter(leave);
 	     EventHandler<ActionEvent> exit_h;
	     exit_h =x->{
	    	 Platform.exit();
	     };
	     leave.setOnAction(exit_h);
		
		
	  
		//Scene
	     Scene scene = new Scene(pane,830,830);
	     ps.setScene(scene);
	     ps.show();  
	  
  }
  
  
  private void p_a(Stage ps,String pic)
  {
	 	GridPane p = new GridPane();
	    back_grid(pic,p);
	    p.setMinWidth(830);
	    p.setMaxWidth(830);
	    p.setStyle("-fx-font-family: SansSerif;");
	    
	    //Setting gaps
	    p.setHgap(10);
	    p.setVgap(10);
	    
	    
	    //Label for exit
	    Label e = new Label("Play Again: Yes or No?");
	    e.setFont(new Font("Tahoma",35));
	    e.setUnderline(true);
	    e.setTextFill(Color.web("#FFC0CB"));
	    p.add(e,6,4,7,7);
	    
	    Button yes = new Button("YES");
	    EventHandler<ActionEvent> yes_h;
	    yes_h =x->{
	    	spot_func(ps,pic);
	    };
	    yes.setOnAction(yes_h);
	     yes.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
	     p.add(yes,5,35);
  
	     //No button
	     Button no = new Button("No");
	     EventHandler<ActionEvent> no_h;
	     no_h =x->{
	    	 final_screen(ps,pic);
	     };
	     no.setOnAction(no_h);
	     no.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
	     p.add(no, 20,35);
	   
	     //Scene
	     Scene scene = new Scene(p,830,830);
	     ps.setScene(scene);
	     ps.show();  
	  
	  
	  
  }
  
  
  
  private int prize_money(List<Integer>x) 
  {
	  int prize=0;
	  if (spot==1 && x.size()==1) {prize=2;}
	  
	  else if(spot==4) 
	  {
		  if(x.size()==2) {prize=1;}
		  else if(x.size()==3) {prize=5;}
		  else if(x.size()==4) {prize=75;}
	  }
	  else if(spot==8)
	  {
		  if(x.size()==4) {prize=2;}
		  else if(x.size()==5) {prize=12;}
		  else if(x.size()==6) {prize=50;}
		  else if(x.size()==7) {prize=750;}
		  else if(x.size()==8) {prize=10000;}
	  }
	  else if(spot==10)
	  {
		  if(x.size()==0) {prize=5;}
		  else if(x.size()==5) {prize=2;}
		  else if(x.size()==6) {prize=15;}
		  else if(x.size()==7) {prize=40;}
		  else if(x.size()==8) {prize=450;}
		  else if(x.size()==9) {prize=4250;}
		  else if(x.size()==10) {prize=100000;}
		  
		  
		  
	  }
	  
	  return prize;
  }
  
  private void winnings(Stage ps,String pic)
  {
	  	
	  	
	  		num_of_games_played=num_of_games_played+1;
	  		int num;
	  		int count=0;
	  		List<Integer> x = new ArrayList<>();
	  		while(count<20) {
	  		 Random rand =new Random();
	  		 //Did this so 0 doesnt get involved
			 num= rand.nextInt(80)+1;
			 if(checkwinnings(num,x)==false)
			 	{
				 x.add(num);
				 count++;
			 	}
	  		}
	  		
	  		
	  		//pane
	  	 	BorderPane pane = new BorderPane();
			back_b(pic,pane);
			pane.setStyle("-fx-font-family: SansSerif;");
		  	
			 //title 
	  	     Label title = new Label("Winning Numbers");
	  	     title.setUnderline(true);
	  	     title.setFont(new Font("Tahoma",60));
	  	     title.setWrapText(true);
	  	     title.setTextFill(Color.web("#FFC0CB"));
	  	     title.setAlignment(Pos.TOP_CENTER);
	  	     pane.setTop(title);
	  	     
	  	     //Number 
	  	     Label nums = new Label("Numbers:");
	  	     
	  	     nums.setFont(new Font("Tahoma",40));
	  	     nums.setWrapText(true);
	  	     nums.setTextFill(Color.web("#FFC0CB"));
	  	     nums.setAlignment(Pos.CENTER);
	  	     nums.setWrapText(true);
	  	     pane.setCenter(nums);
	  	     
	  	     //Next
	  	     Button n = new Button("Next");
	  	     n.setMinSize(80, 40);
	  	     n.setStyle("-fx-background-color: #FFA500; -fx-font-size: 2em; -fx-border-color: #545454; -fx-border-width: 2px;");
	  	     n.setDisable(true);
	  	     //next button handler
	  	     EventHandler<ActionEvent> next_h;
	  	     next_h = e->{
	  	    	if(num_of_games_played>=chances) 
	  		  	{
	  		  		p_a(ps,pic);
	  		  	}
	  	    	else {
	  	    	 winnings(ps,pic);
	  	    	}
	  	     };
	  	     n.setOnAction(next_h);
	  	     BorderPane.setAlignment(n, Pos.BOTTOM_RIGHT);
	  	     pane.setRight(n);
	  	     
	  	     
	  	     //Puase transitions
	  		 PauseTransition p1 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p2 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p3 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p4 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p5 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p6 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p7 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p8 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p9 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p10 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p11 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p12 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p13 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p14 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p15 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p16 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p17 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p18 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p19 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p20 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p21 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p22 = new PauseTransition(Duration.seconds(1));
	  		 PauseTransition p23 = new PauseTransition(Duration.seconds(2));
	  		 
	  		//playing those pause transitions so it pauses every 1 sec
	  		 p1.play();
	  		 
	  		p1.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(0)));
	            p2.play();
	        });
	  		
	  		p2.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(1)));
	            p3.play();
	        });
	  		
	  		p3.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(2)));
	            p4.play();
	        });
	  		
	  		p4.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(3)));
	            p5.play();
	        });
	  		
	  		p5.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(4)));
	            p6.play();
	        });
	  		
	  		p6.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(5)));
	            p7.play();
	        });
	  		
	  		p7.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(6)));
	            p8.play();
	        });
	  		
	  		p8.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(7)));
	            p9.play();
	        });
	  		
	  		p9.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(8)));
	            p10.play();
	        });
	  		
	  		p10.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(9)));
	            p11.play();
	        });
	  		
	  		p11.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(10)));
	            p12.play();
	        });
	  		
	  		p12.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(11)));
	            p13.play();
	        });
	  		p13.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(12)));
	            p14.play();
	        });
	  		
	  		p14.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(13)));
	            p15.play();
	        });
	  		
	  		p15.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(14)));
	            p16.play();
	        });
	  		
	  		p16.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(15)));
	            p17.play();
	        });
	  		
	  		p17.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(16)));
	            p18.play();
	        });
	  		
	  		p18.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(17)));
	            p19.play();
	        });
	  		
	  		p19.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(18)));
	            p20.play();
	        });
	  		
	  		p20.setOnFinished(e->{
	            nums.setText(String.valueOf(x.get(19)));
	            p21.play();
	        });
	  		
	  		p21.setOnFinished(e->{
	            nums.setText("Those were the winning numbers!\nLets see which numbers you Matched!");
	            p22.play();
	        });
	  		
	  		
	  		//checks how many numbers were equal in the random selection
	  		List<Integer>ret =won(x);
	  		
	  		//gets the prize money for this draw
	  		int prize=prize_money(ret);
	  		
	  		tot_sum+=prize;
	  		p22.setOnFinished(e->{
	  			if(ret.size()==0) {nums.setText("Sadly you did not match with any numbers!"+"\n You won $"+prize+" this round\nYou have won "+tot_sum+" ever since you started the program!");}
	  			else if(ret.size()==1) {nums.setText("You matched with "+ret.size()+" number! It was "+ret+"\n You won $"+prize+" this round\nYou have won "+tot_sum+" ever since you started the program!");}
	  			else 
	  			{
	            nums.setText("You matched with "+ret.size()+" numbers! They were:"+ret+"\n You won $"+prize+" this round\nYou have won "+tot_sum+" ever since you started the program! ");
	  			}
	            p23.play();
	            n.setDisable(false);
	        });
	  		
	  		
	  		
	  	

	        
	//Scene
		Scene scene = new Scene(pane,830,830);
		ps.setScene(scene);
		ps.show(); 
	  	
  
  }
  
  
  
  
  //helper functions for randomizing
  
  
  //Checks so we don't have a duplicate
  private boolean check(int s)
  	{
	  int count=0;
	  if(bet_num.size()==0) {return false;}
	  while(count<bet_num.size())
	  	{
		  if(bet_num.get(count)==s) {return true;}
		  
	  	count++;
	  	}
	  return false;
	  
  	}
  
  
  //gets a random number
  private void randomize() 
  {
	  if(bet_num.size()>=spot)
	 	{bet_num.clear();}
	 int c=0;
	 int num;
	 while(c<spot) 
	 {
		 Random rand =new Random();
		 num= rand.nextInt(80)+1;
		 if(check(num)==false)
		 	{
			 bet_num.add(num);
			 c++;
		 	}
}
  }
  
  
  
  //This is for reseting the number grid
  private void resetnums(GridPane pane) {
		for (Node child : pane.getChildren()) 
		{
			child.setStyle("-fx-font-size: 2em;-fx-background-color:#E1E1E1;-fx-border-width: 2px;");
		}
	}
  
  
  

  
  
  
  
  
  
  //bet card which shows numbers 1-80
  private void bet_card(Stage ps,String pic) 
  {
	  	GridPane p = new GridPane();

		p.setAlignment(Pos.CENTER);
	    p.setStyle("-fx-font-family: SansSerif;");
	    
	    //CHECK THIS
		Button Randomize = new Button("Randomize");
		Button next = new Button("Submit");
		next.setStyle("-fx-background-color: #FFA500;-fx-border-color: #545454; -fx-border-width: 1px;");
		Randomize.setStyle("-fx-background-color: #FFA500; -fx-border-color: #545454;-fx-border-width: 1px;");
		next.setDisable(true);
		

		BorderPane pane = new BorderPane();
		back_b(pic,pane);
		pane.setStyle("-fx-font-family: SansSerif;");
		
		
		//Title
		String number ="numbers";
		if (spot>=0) {number="number";}
		Label title = new Label("Bet Card: Please Pick or randomize \n"+spot+" "+number);
		title.setWrapText(true);
		title.setFont(new Font("Tahoma", 45));
		title.setUnderline(true);
		title.setTextFill(Color.web("#FFC0CB"));
		
		//Shows what number u chose
		Label x = new Label("You chose:"+bet_num);
		x.setFont(new Font("Tahoma", 30));
		x.setTextFill(Color.web("#FFFFFF"));
		
		
		///PANE
		pane.setTop(title);
		pane.setCenter(p);
		pane.setLeft(Randomize);
		pane.setRight(next);
		BorderPane.setAlignment(Randomize, Pos.CENTER_LEFT);
		BorderPane.setAlignment(next, Pos.BOTTOM_RIGHT);
		
		
		//To get Random numbers clears everything in the 
		EventHandler<ActionEvent> rando_h;
		rando_h = e->{
			 bet_num.clear();
			 resetnums(p);
			 randomize();
			 x.setText("You chose:"+bet_num.toString());
			 pane.setBottom(x);
			 next.setDisable(false);
		};
		Randomize.setOnAction(rando_h);
		
		
		//NEXT
		EventHandler<ActionEvent> next_h;
		next_h = e->{
			winnings(ps,pic);
		};
		next.setOnAction(next_h);
		
		
		// Puts the grid and 1-80 numbers
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {
				int num = j + 1 + (10 * i);
				Button button = new Button(String.valueOf(num));
				button.setStyle("-fx-font-size: 2em;-fx-background-color:#E1E1E1;-fx-border-width: 2px;");
				p.add(button, j, i);
				EventHandler<ActionEvent> button_h;
		           button_h = e->{
		        if(check(num)==false) {
		           if(bet_num.size()==spot) 
		           {
		        	   resetnums(p);
		        	   bet_num.clear();
		        	   next.setDisable(true);
		           }
		           bet_num.add(num);
		           button.setStyle("-fx-background-color:#FFC0CB");
		           x.setText("You chose:"+bet_num.toString());
		           pane.setBottom(x);
		           if(bet_num.size()==spot) {next.setDisable(false);}
		        }
		          };
		           button.setOnAction(button_h);
				
				
				
			}
		}
	  
	  
	//Scene
	Scene scene = new Scene(pane,830,830);
	ps.setScene(scene);
	ps.show();
  }
  
  private void final_submission(Stage ps,String pic)
  {
	  
	  		GridPane p = new GridPane();
		    back_grid("rules.jpg",p);
		    p.setMinWidth(830);
		    p.setMaxWidth(830);
		    p.setStyle("-fx-font-family: SansSerif;");
		    
		    //Setting gaps
		    p.setHgap(10);
		    p.setVgap(10);
		    
		    
		    //Label for exit
		    Label e = new Label("Submit: Are You Sure?\n\n NO GOING BACK!");
		    e.setAlignment(Pos.CENTER);
		    e.setWrapText(true);
		    e.setFont(new Font("Tahoma",45));
		    e.setUnderline(true);
		    e.setTextFill(Color.web("#FFC0CB"));
		    p.add(e,6,4,7,7);
		    
		    Button yes = new Button("YES");
		    EventHandler<ActionEvent> yes_h;
		    yes_h =x->{
		    	bet_card(ps,pic);
		    };
		    yes.setOnAction(yes_h);
		     yes.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
		     p.add(yes,5,35);
	  
		     //No button
		     Button no = new Button("No");
		     EventHandler<ActionEvent> no_h;
		     no_h =x->{
		    	 drawing_func(ps,pic);
		     };
		     no.setOnAction(no_h);
		     no.setStyle("-fx-background-color: #FFA500; -fx-font-size: 4em; -fx-border-color: #545454; -fx-border-width: 4px;");
		     p.add(no, 20,35);
		   
		     //Scene
		     Scene scene = new Scene(p,830,830);
		     ps.setScene(scene);
		     ps.show();
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  private void drawing_func(Stage ps,String pic){
     GridPane p = new GridPane();
     p.setPadding(new Insets(1));
     p.setHgap(70);
     p.setVgap(20);

     p.setAlignment(Pos.CENTER);

     //Next Button
     Button n = new Button("Submit");
     n.setMinSize(80, 40);
     n.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     n.setDisable(true);
     
     
     //border pane
     BorderPane pane = new BorderPane();
     pane.setStyle("-fx-font-family: SansSerif;");
     back_b(pic,pane);
     pane.setCenter(p);
    
     
     //Label 
     Label title = new Label("Choose The Number of Drawings");
     title.setUnderline(true);
     title.setFont(new Font("Tahoma",60));
     title.setWrapText(true);
     title.setTextFill(Color.web("#FFC0CB"));
     title.setAlignment(Pos.CENTER);
     pane.setTop(title);
     
     
     
     //shows the amount of drawings the user chose
     Label x = new Label();
     x.setFont(new Font("Tahoma",45));
     x.setWrapText(true);
     x.setTextFill(Color.web("#FFC0CB"));
     x.setAlignment(Pos.CENTER);
     
     
     //for loop from the spot function but a bit different without the array
     for (int r = 0; r < 2; r++) {
        for (int c = 0; c < 2; c++) {
           int number = 2 * r + c;
           Button button = new Button(String.valueOf(number+1));
           button.setMinSize(200, 100);
           button.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 5px;");
           p.add(button, c, r);
           EventHandler<ActionEvent> button_handler;
           button_handler = e->{
              n.setDisable(false);
              chances = number+1;
              x.setText("You Chose: "+chances);
              pane.setBottom(x);
              
           };
           button.setOnAction(button_handler);

        }
     }


     //next button handler
     EventHandler<ActionEvent> next_h;
     next_h = e->{
    	 final_submission(ps,pic);
     };
     n.setOnAction(next_h);
     BorderPane.setAlignment(n, Pos.BOTTOM_RIGHT);
     pane.setRight(n);
     
   //Back button
     Button b = new Button("<--");
     b.setMinSize(80, 40);
     b.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     EventHandler<ActionEvent> back_h;
     back_h = e->{

        spot_func(ps,pic);
     };
     b.setOnAction(back_h);
     BorderPane.setAlignment(b, Pos.BOTTOM_LEFT);
     pane.setLeft(b);



     
     
     //scene
     Scene scene = new Scene(pane,830,830);
     ps.setScene(scene);
     ps.show();
  }


  private void spot_func(Stage ps,String pic){

     //pane
	 GridPane p = new GridPane();
     p.setStyle("-fx-font-family: SansSerif;");
     p.setPadding(new Insets(1));
     
     //setting the gap
     p.setHgap(70);
     p.setVgap(20);

     p.setAlignment(Pos.CENTER);

     int[] num = {1,4,8,10};
     //next button
     Button n = new Button("-->");
     n.setMinSize(80, 40);
     n.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     n.setDisable(true);

     //back button
     Button b = new Button("<--");
     b.setMinSize(80, 40);
     b.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 2px;");
     
     BorderPane pane = new BorderPane();
     Label x = new Label("You Chose:"+spot);
     x.setWrapText(true);
     x.setTextFill(Color.web("#FFC0CB"));
     x.setFont(new Font("Tahoma",40));
     x.setAlignment(Pos.CENTER);
     x.setWrapText(true);
     //rows and cols putting the buttons using this loop and this also makes sure only one selection is being chosen and then puts it in the private variable called spot.
     
     for (int r = 0; r < 2; r++) {
        for (int c = 0; c < 2; c++) {
           int number = 2 * r + c;
           Button button = new Button(String.valueOf(num[number]));
           button.setMinSize(200, 100);
           button.setStyle("-fx-background-color: #FFA500; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 5px;");
           p.add(button, c, r);
           EventHandler<ActionEvent> button_h;
           button_h = e->{
              n.setDisable(false);
              spot = num[number];
              //this is to show the user which number they have chosen!
              x.setText("You Chose:"+spot);
              pane.setBottom(x);
           };
           button.setOnAction(button_h);

        }
     }

     //background pane to add the title and the next and back buttons
     back_b(pic,pane);
     pane.setCenter(p);
     //title 
     Label title = new Label("Please choose the number of spots!");
     title.setUnderline(true);
     title.setFont(new Font("Tahoma",60));
     title.setWrapText(true);
     title.setTextFill(Color.web("#FFC0CB"));

     title.setAlignment(Pos.CENTER);
     pane.setTop(title);
     
     //Next button
     EventHandler<ActionEvent> next_h;
     next_h = e->{
        drawing_func(ps,pic);
     };
     n.setOnAction(next_h);
     BorderPane.setAlignment(n, Pos.BOTTOM_RIGHT);
     pane.setRight(n);
     
     
     //Back button
     EventHandler<ActionEvent> back_h;
     back_h = e->{

        home_page(ps,pic);
     };
     b.setOnAction(back_h);
     BorderPane.setAlignment(b, Pos.BOTTOM_LEFT);
     pane.setLeft(b);

     //scene
     Scene scene = new Scene(pane,830,830);
     ps.setScene(scene);
     ps.show();

  }


  //HOME PAGE
  private void home_page(Stage ps,String background_pic){
	  
	  //making # of spots 0
	  spot=0;
	 GridPane p = new GridPane();
     back_grid(background_pic,p);
     p.setStyle("-fx-font-family: SansSerif;");
     //Labels for the WELCOME TO KENO
     Label w = new Label("Welcome");
     w.setUnderline(true);
     Label t = new Label("To");
     
     Label k = new Label("Keno!");
     
     w.setFont(new Font("Tahoma",60));
     w.setTextFill(Color.web("#FFC0CB"));
     
     t.setFont(new Font("Tahoma",60));
     t.setTextFill(Color.web("#FFC0CB"));
     t.setUnderline(true);
     
     k.setFont(new Font("Tahoma",60));
     k.setTextFill(Color.web("#FFC0CB"));
     k.setUnderline(true);
     //Setting gaps
     p.setHgap(90);
     p.setVgap(10);
     
   //new look
     Button new_look= new Button("New Look");
     new_look.setAlignment(Pos.TOP_LEFT);
     new_look.setStyle("-fx-background-color: #FFAA00;-fx-font-size:1em; -fx-border-color: #545454; -fx-border-width: 1px");
     p.add(new_look, 1, 1);
     EventHandler<ActionEvent> new_h;
     new_h = e->{
    	 String x;
    	 if(background_pic=="rules.jpg") {x="backgrd_pic.jpg";}
    	 else {x="rules.jpg";}
        home_page(ps,x);
     };
     new_look.setOnAction(new_h);
     
     
     //menu
     Button menu = new Button("Menu");
     EventHandler<ActionEvent> menu_h;
     menu_h = e->{
        menu_page(ps,background_pic);
     };
     menu.setOnAction(menu_h);
     menu.setStyle("-fx-background-color: #FFAA00; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 4px;");
     p.add(menu,4,10);
     
     
     //start
     Button start = new Button("Start");
     EventHandler<ActionEvent> start_h;
     start_h = e->{
        spot_func(ps,background_pic);
     };
     start.setOnAction(start_h);

     start.setMaxSize(150,100);
     start.setStyle("-fx-background-color: #FFAA00; -fx-font-size: 3em; -fx-border-color: #545454; -fx-border-width: 4px;");
     p.add(start,4,40);
     

     //adding labels
     p.add(w,4,20,3,3);
     p.add(t,4,25,3,3);
     p.add(k,4,30,3,3);
     

     Scene scene = new Scene(p,830,830);
     ps.setScene(scene);
     ps.show();
  }

  //feel free to remove the starter code from this method
  @Override
  public void start(Stage ps) throws Exception {
     // TODO Auto-generated method stub
     ps.setTitle("KENO");

     home_page(ps,"backgrd_pic.jpg");
    


  }

}


