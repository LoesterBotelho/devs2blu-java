package fx;

import javax.swing.JOptionPane;

public class TestFx {

	public static void main(String[] args) {
		
		String input = (String)JOptionPane.showInputDialog(null,
				"Esta é uma pergunta?",
				"Título da Caixa de Diálogo",
				2,
				null,
				null,
				"Digite algo aqui.");
		
		
		String[] acceptableValues = {"Choice 1", "Choice 2", "Choice 3"};
		String Input2 = (String)JOptionPane.showInputDialog(null,
		"Esta é uma pergunta?",
		"Título da Caixa de Diálogo",
		2,
		null,
		acceptableValues,
		acceptableValues[1]);
		
		JOptionPane.showMessageDialog(
				null,
				"Não há uma entrada aqui; apenas uma mensagem",
				"Título",
				0);
		
	}
		
}
