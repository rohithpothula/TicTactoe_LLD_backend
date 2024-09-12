package GameManagement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoreSystem implements CoreSystemFeatures {
	
	private GameBoard board;
	
	Player p1;
	
	Player p2;
	
	private Queue<Player> userChoices = new LinkedList<>();
	
	public GameBoard getBoard() {
		return board;
	}


	public void setBoard(GameBoard board) {
		this.board = board;
	}


	public Player getP1() {
		return p1;
	}


	public void setP1(Player p1) {
		this.p1 = p1;
	}


	public Player getP2() {
		return p2;
	}


	public void setP2(Player p2) {
		this.p2 = p2;
	}


	public Queue<Player> getUserChoices() {
		return userChoices;
	}


	public void setUserChoices(Queue<Player> userChoices) {
		this.userChoices = userChoices;
	}


	public CoreSystem(GameBoard board) {
		this.p1.setName("Rohith");
		this.p2.setName("Shiva");
		this.board=board;
		this.board.setsituation(EventType.ONGOING);
		this.p1.setSymbol(Symbol.ZERO);
		this.p2.setSymbol(Symbol.CROSS);
		userChoices.add(this.p1);
		userChoices.add(this.p2);
	}
	

	@Override
	public void judge() {
//		Row check 
		for(int i=0;i<this.board.getBoardSize();i++) {
			Character start = this.board.getBoard()[i][0];
			int count =0;
			for(int j=0;j<this.board.getBoardSize();j++) {
				if(this.board.getBoard()[i][j]==start) {
					count++;
				}
			}
			if(count==this.board.getBoardSize()) {
				if(start.equals(Symbol.ZERO.getVal()) || start.equals(Symbol.CROSS.getVal())){
					this.board.setsituation(EventType.WIN);
				}
			}
		}
//		column check
		for(int i=0;i<this.board.getBoardSize();i++) {
			Character start = this.board.getBoard()[i][0];
			int count =0;
			for(int j=0;j<this.board.getBoardSize();j++) {
				if(this.board.getBoard()[j][i]==start) {
					count++;
				}
			}
			if(count==this.board.getBoardSize()) {
				if(start.equals(Symbol.ZERO.getVal()) || start.equals(Symbol.CROSS.getVal())){
					this.board.setsituation(EventType.WIN);
				}
			}
		}
//		diagonal check
		int count=0;
		Character start = this.board.getBoard()[0][0];
		for(int i=0;i<this.board.getBoardSize();i++) {
			if(this.board.getBoard()[i][i].equals(start)) {
				count++;
			}
		}
		if(count==this.getBoard().getBoardSize()) {
			if(start.equals(Symbol.ZERO.getVal()) || start.equals(Symbol.CROSS.getVal())) {
				this.board.setsituation(EventType.WIN);
			}
		}
//		reverse diagonal check
		count=0;
		start = this.board.getBoard()[0][this.board.getBoardSize()-1];
		for(int i=0;i<this.board.getBoardSize();i++) {
			if(this.board.getBoard()[i][this.board.getBoardSize()-1]==start) {
				count++;
			}
		}
		if(count==this.board.getBoardSize()) {
			if(start.equals(Symbol.CROSS.getVal()) || start.equals(Symbol.ZERO.getVal())) {
				this.board.setsituation(EventType.WIN);
			}
		}

	}

	@Override
	public void announceTurn(Player p) {
		System.out.println("UserTurn -:"+p.getName());
	}

	@Override
	public Integer makeChoice(Player p) {
		System.out.println(p.getName()+" please make a Choice of you position to be made");
		System.out.println("Please choose a number between 0 and "+ this.board.getBoardSize()*this.board.getBoardSize());
		Scanner scn = new Scanner(System.in);
		Integer choice = scn.nextInt();
		return choice;
	}

	@Override
	public Boolean isValid(Integer choice) {
		int x = choice/this.board.getBoardSize();
		int y = choice%this.board.getBoardSize();
		return choice>=0 && choice<=this.getBoard().getBoardSize()*this.getBoard().getBoardSize() && Symbol.STAR.getVal().equals(this.board.getBoard()[x][y]);
		
	}

	@Override
	public void doChanges(Integer choice, Player p) {
		int x=choice/this.board.getBoardSize();
		int y=choice%this.board.getBoardSize();
		this.board.getBoard()[x][y]=p.getSymbol().getVal();
		judge();
	}

	@Override
	public void makeMove() {
		Player p = this.userChoices.poll();
		announceTurn(p);
		Scanner scn = new Scanner(System.in);
		Integer choice = makeChoice(p); 
		if(!isValid(choice)) {
			System.out.println("please make valid choice since the previous one is not good choice");
		}
		this.board.setMoves(this.board.getMoves()+1);
		this.board.setsituation(this.board.getSituation());
		doChanges(choice,p);
	}

}
