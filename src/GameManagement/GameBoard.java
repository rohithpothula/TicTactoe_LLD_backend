package GameManagement;

public class GameBoard implements GameBoardFeatures {
	
	private Player p1;
	private Player p2;
	
	private int boardSize;
	private int moves;
	private EventType situation = EventType.ONGOING;
	private Character [][]board;
	
	
	public int getBoardSize() {
		return boardSize;
	}


	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}


	public int getMoves() {
		return moves;
	}


	public void setMoves(int moves) {
		this.moves = moves;
	}


	public EventType getSituation() {
		return situation;
	}


	public void setsituation(EventType situation) {
		this.situation = situation;
	}


	public Character[][] getBoard() {
		return board;
	}


	public void setBoard(Character[][] board) {
		this.board = board;
	}


	public GameBoard(int size,Player p1,Player p2) {
		this.boardSize=size;
		this.p1=p1;
		this.p2=p2;
	}
	

	@Override
	public void initialize() {
		board = new Character[this.boardSize+1][this.boardSize+1];
		for(int i=0;i<this.boardSize;i++) {
			for(int j=0;j<this.boardSize;j++) {
				board[i][j]=Symbol.CROSS.getVal();
			}
		}

	}

	@Override
	public void displayBoard() {
		for(int i=0;i<this.boardSize;i++) {
			for(int j=0;j<this.boardSize;j++) {
				System.out.print(this.board[i][j]+" ");
			}
		}

	}
}
