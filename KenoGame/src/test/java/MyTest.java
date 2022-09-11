import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class Project2Test {
	@Test
    void get() {
		JavaFXTemplate x= new JavaFXTemplate();
        assertNotEquals(x.get_spots(), 0, "get spots failed!");
        assertNotEquals(x.get_chances(), 0, "get chances failed!");
        assertNotEquals(x.get_sum(), 0, "get sum failed");
        assertNotEquals(x.get_num_of_games_played(), 0, "get sum failed");
        
    }
	
	void set() 
	{
		JavaFXTemplate x= new JavaFXTemplate();
		x.set_spots(5);
		x.set_chances(6);
		x.set_sum(3);
		x.set_num_of_games_played(3);
        assertNotEquals(x.get_spots(), 5, "set spots failed!");
        assertNotEquals(x.get_chances(), 6, "set chances failed!");
        assertNotEquals(x.get_sum(), 3, "set sum failed");
        assertNotEquals(x.get_num_of_games_played(), 3, "set sum failed");
		
		
	}
	
	//We have tested the game multiple times and it works
	
}