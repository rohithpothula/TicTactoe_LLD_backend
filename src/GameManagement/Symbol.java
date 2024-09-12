package GameManagement;

public enum Symbol {
	
	STAR('*'),ZERO('O'),CROSS('X');
	
	private Character val;
	
	Symbol(Character val) {
		this.val=val;
	}

	public Character getVal() {
		return val;
	}

	public void setVal(Character val) {
		this.val = val;
	}

}
