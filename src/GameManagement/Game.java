package GameManagement;

public class Game implements GameFlow {
	
	private CoreSystem coreSystem;

	@Override
	public void run(int boardSize,Player p1,Player p2) {
		initialSetUp(boardSize,p1,p2);
		int size = coreSystem.getBoard().getBoardSize();
		while(coreSystem.getBoard().getMoves()<=coreSystem.getBoard().getBoardSize()*coreSystem.getBoard().getBoardSize()) {
			coreSystem.makeMove();
			System.out.println("Display of the board");
			this.coreSystem.getBoard().displayBoard();
			
			if(this.coreSystem.getBoard().getSituation().equals(EventType.WIN)) {
				announceWinner();
			}
			if(this.coreSystem.getBoard().getMoves()==this.coreSystem.getBoard().getBoardSize()*this.coreSystem.getBoard().getBoardSize()) {
				System.out.println("The game is Draw");
				break;
			}
		}
	}

	@Override
	public void announceWinner() {
//		write the userchoices logic here properly
	}

	@Override
	public void initialSetUp(int boardSize,Player p1,Player p2) {
		GameBoard gameBoard = new GameBoard(boardSize,p1,p2);
		gameBoard.initialize();
		gameBoard.displayBoard();
		this.coreSystem.setBoard(gameBoard);
	}

}
