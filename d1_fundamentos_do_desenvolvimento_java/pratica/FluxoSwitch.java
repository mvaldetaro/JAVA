import javax.swing.JOptionPane;

public class FluxoSwitch {
      public static void main(String[] args) {
	int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia da semana"));
	switch(dia){

		case 1:
			System.out.println("Hoje � domingo!");
		break;
		case 2:
			System.out.println("Hoje � segunda!");
		break;
		case 3:
			System.out.println("Hoje � ter�a!");
		break;
		case 4:
			System.out.println("Hoje � quarta!");
		break;
		case 5:
			System.out.println("Hoje � quinta!");
		break;
		case 6:
			System.out.println("Hoje � sexta!");
		break;
		case 7:
			System.out.println("Hoje � s�bado!");
		break;
		default:
			System.out.println("Digite um dia v�lido, entre 1 e 7.");
	}
      }
}