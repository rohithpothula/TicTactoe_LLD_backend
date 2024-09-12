package GameManagement;

public interface CoreSystemFeatures {
	public void judge();
	void announceTurn(Player p);
	Integer makeChoice(Player p);
	Boolean isValid(Integer choice);
	void doChanges(Integer choice,Player p);
	void makeMove();
}
