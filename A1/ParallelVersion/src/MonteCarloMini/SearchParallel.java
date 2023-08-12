//D.Naidoo (NDXDAN019)
//Modification of the Search.java 
//Modified to Allow for Parallel Computation

package MonteCarloMini;

/* M. Kuttel 2023
 * Searcher class that lands somewhere random on the surfaces and 
 * then moves downhill, stopping at the local minimum.
 */

//Imports
import java.util.concurrent.RecursiveTask;
import MonteCarloMini.SearchParallel.Direction;
import java.util.concurrent.ForkJoinPool;

public class SearchParallel extends RecursiveTask<Integer> {
    
	//Define Variables
    private int id;			 			// Searcher identifier
	private int pos_row, pos_col;		// Position in the grid
	private int steps; 					//number of steps to end of search
	private boolean stopped;			// Did the search hit a previous trail?
	
   
	private TerrainArea terrain;
	enum Direction {
		STAY_HERE,
	    LEFT,
	    RIGHT,
	    UP,
	    DOWN
	  }

	//SearchParallel Constructor 
	public SearchParallel(int id, int pos_row, int pos_col, TerrainArea terrain) {
		this.id = id;
		this.pos_row = pos_row; //randomly allocated
		this.pos_col = pos_col; //randomly allocated
		this.terrain = terrain;
		this.stopped = false;
	}
	

    //Compute Function to allow for parallelization using Fork/Join
    @Override
    protected Integer compute() {
        int height = Integer.MAX_VALUE;
        while (terrain.visited(pos_row, pos_col) == 0) {
            height = terrain.get_height(pos_row, pos_col);
            terrain.mark_visited(pos_row, pos_col, id);
            steps++;
            Direction next = terrain.next_step(pos_row, pos_col);

            // Update the position based on the next step
            switch (next) {
                case STAY_HERE:
                    return height; // Found local valley
                case LEFT:
                    pos_row--;
                    break;
                case RIGHT:
                    pos_row = pos_row + 1;
                    break;
                case UP:
                    pos_col = pos_col - 1;
                    break;
                case DOWN:
                    pos_col = pos_col + 1;
                    break;
            }
        }
        stopped = true;
        return height;
	
    }


	public int getID() {
		return id;
	}

	public int getPos_row() {
		return pos_row;
	}

	public int getPos_col() {
		return pos_col;
	}

	public int getSteps() {
		return steps;
	}
	public boolean isStopped() {
		return stopped;
	}
    
    
}

