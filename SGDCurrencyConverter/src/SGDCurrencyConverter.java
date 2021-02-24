import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SGDCurrencyConverter {
	
	static double usd;
	static double gbp;
	static double yen;
	static double sgd = 0;
	static DecimalFormat d = new DecimalFormat("##.##");
	static ImageIcon cashicon = new ImageIcon("cashicon.png");

	public static void main(String[] args) {
		
		String option = (String) JOptionPane.showInputDialog(null, "Which currency would you like to Convert?\n1. USD\n2. GBP\n3. Yen", "SGD Currency Converter", JOptionPane.INFORMATION_MESSAGE);

		switch (option) {
			case "1":
				String x = JOptionPane.showInputDialog(null, "Enter the amount of money you want to convert", "Convert Amount", JOptionPane.INFORMATION_MESSAGE);
				sgd = new Double(x).doubleValue();
				usd = sgd * 0.76 ;
				JOptionPane.showMessageDialog(null, x + "SGD is " + d.format(usd) + "USD.", "SGD -> USD", JOptionPane.INFORMATION_MESSAGE, cashicon);
				break;
			case "2":
				String y = JOptionPane.showInputDialog(null, "Enter the amount of money you want to convert", "Convert Amount", JOptionPane.INFORMATION_MESSAGE);
				sgd = new Double(y).doubleValue();
				gbp = sgd * 0.54 ;
				JOptionPane.showMessageDialog(null, y + "SGD is " + d.format(gbp) + "GBP.", "SGD -> GBP", JOptionPane.INFORMATION_MESSAGE, cashicon);
				break;
			case "3":
				String z = JOptionPane.showInputDialog(null, "Enter the amount of money you want to convert", "Convert Amount", JOptionPane.INFORMATION_MESSAGE);
				sgd = new Double(z).doubleValue();
				yen = sgd * 80.16 ;
				JOptionPane.showMessageDialog(null, z + "SGD is " + d.format(yen) + "Yen." , "SGD -> Yen", JOptionPane.INFORMATION_MESSAGE, cashicon);
				break;
		}
		
		//System.exit(0);
	}

}
