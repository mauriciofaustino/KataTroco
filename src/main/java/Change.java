import java.text.DecimalFormat;


public class Change {
	private static final double[] notes = {100.0, 50.0, 20.0,
			           10.0,  5.0,  2.0, 1.0,
			           0.50, 0.25, 0.10,
			           0.05, 0.01};
	private double changeValue;
	private String changeBucks;
	public String calculate(double paid, double due) {
		changeValue = paid-due;
		changeBucks = "";
		return changeBucks();
	}
	
	private String changeBucks() {
		for(double note : notes) {
			if(note <= changeValue) {
				changeValue-=note;
				changeBucks += convert(note);
				changeBucks();
				break;
			}
		}
		return changeBucks;
	}

	private Object convert(double note) {
		DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");  
		return "["+df.format(note)+"]";
	}
}
