import java.text.DecimalFormat;


public class Troco {
	private static final double[] notes = {100.0, 50.0, 20.0,
			           10.0,  5.0,  2.0, 1.0,
			           0.50, 0.25, 0.10,
			           0.05, 0.01};
	private double trocoValue;
	private String trocoNotes;
	public String calculate(double paid, double due) {
		trocoValue = paid-due;
		trocoNotes = "";
		return trocoNotes();
	}
	
	private String trocoNotes() {
		for(double note : notes) {
			if(note <= trocoValue) {
				trocoValue-=note;
				trocoNotes += convert(note);
				trocoNotes();
				break;
			}
		}
		return trocoNotes;
	}

	private Object convert(double note) {
		DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");  
		return "["+df.format(note)+"]";
	}
}
