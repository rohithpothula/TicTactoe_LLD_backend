package GameManagement;

public interface GameFlow {
	void run(int boardsize,Player p1,Player p2);
    void announceWinner();
    void initialSetUp(int boardsize,Player p1,Player p2);
}
