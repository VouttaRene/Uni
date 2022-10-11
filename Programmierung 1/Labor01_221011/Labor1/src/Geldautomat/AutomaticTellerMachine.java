/**
 * @author RenéVoutta
 * @version 1.0
 * @email u38509@hs-harz.de
 */

/*
 * Programmierung 1 
 * 1. Labor
 * 
 * Ziele:
 * Sie entwickeln das Programm eines virtuellen Geldautomaten, das in der Lage ist, 
 * auf Nutzereingaben zu reagieren und die kleinstmögliche Menge an Geldscheinen auszugeben. 
 * Inhaltliche Schwerpunkte sind insbesondere die Verwendung von Variablen, 
 * Konsolenein- und ausgaben, Bedingungen und Schleifen.
 * 
 * Durchführung:
 * Sie bearbeiten in Einzelarbeit die Aufgabe des ersten Labors in einer 
 * Entwicklungsumgebung Ihrer Wahl. Sie lösen die Aufgabenstellung und erläutern Ihren 
 * Quellcode beim Tutor, um das Testat zu erhalten. Anschließend laden Sie die Lösung in 
 * Form Ihres Projektverzeichnisses als Zip-Archiv in den dafür vorgesehenen Ordner in 
 * StudIP. Sollten Sie das Testat zum Abgabetermin nicht fertigstellen oder bestehen 
 * können, so besteht in der darauffolgenden Woche die Möglichkeit eines 
 * Wiederholungstermins.
 * 
 * Aufgabe:
 * Implementieren Sie die Klasse AutomaticTellerMachine, die einen (virtuellen) 
 * Geldautomaten grundlegend simulieren soll. Die Klasse soll Methoden mit folgenden 
 * Funktionen enthalten:
 * • Eine Methode, die prüft mit welchem Medium (Girocard oder Kreditkarte) Geld abgehoben
 * werden soll. Implementieren Sie die Überprüfung mit einer switch-Anweisung.
 * Die Eingabe und somit Auswahl des Mediums soll mit Hilfe einer Konsoleneingabe 
 * erfolgen. Alle Ausgaben sollen auch über die Konsole realisiert werden.
 * • Eine Methode, die anschließend anhand einer weiteren Konsoleneingabe eines Geldwertes
 * (ganze Zahl) die kleinstmögliche Anzahl an verschiedenen Geldscheinen durch
 * Bedingungen sowie Schleifen berechnet und ausgibt (Konsolenausgabe).
 * Hinweise: Beachten Sie, dass der Geldautomat ausschließlich Geldscheine und keine
 * Geldstücke ausgeben kann (z.B. Geldautomat kann nicht 563 Euro ausgeben; diese Eingabe
 * muss abgewiesen werden!). Weiterhin wird angenommen, dass der Geldautomat unendlich 
 * viel Geld ausgeben kann. Um die Verständlichkeit Ihres Java-Codes zu erhöhen, schreiben 
 * Sie zu jeder Methode aussagekräftige Kommentare!
 * 
 */
package Geldautomat;
//Importing java.util.Scanner to get import using the console
import java.util.Scanner;

/*This class simulates a virtual ATM. We only have 500, 200 , 100, 50, 20, 10 and 5 Euro 
*bills. A withdrawal request that doesn`t fit this criteria should be denied.
*For simplicity we assume that the ATM has an unlimited number of bills available.
*/
public class AutomaticTellerMachine {
	
	//Declaring and initializing a scanner to be able to input arguments through our console.
	static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		AskForCard();
		WithdrawCalc();
		System.out.println("Thanks for using our ATM");
	}
	
	//This method asks the user for the card type. Either Girocard or credit card are accepted.
	public static void AskForCard() {
		System.out.println("What medium do you want to use to withdraw money: Girocard (1) or credit card (2) ?");
		
		
		boolean validCardType = false;		//Flag for accepted creditCard.
		String card = "none";
		
		while(!validCardType) {
			int cardType = scanner.nextInt();
			switch(cardType) {
			case 1:			//Valid Input: Case Girocard
				card = "Girocard";
				validCardType = true;
				break;
			case 2:			//Valid Input: Case Credit Card
				card = "credit card";
				validCardType = true;
				break;
			default:		//Invalid Input! Try again
				System.out.println("Incorrect Card type! Try again!");
				break;
			}
		}
		
		System.out.println("You have selected: " + card + ".");
		
	}
	
	//This method asks for the withdrawal amount and checks if the amount is acceptable 
	public static void WithdrawCalc() {		
		System.out.println("How much do you want to withdraw?");
		int withdraw = 0;
		
		while(withdraw == 0 || withdraw % 5 != 0) {
			withdraw = scanner.nextInt();
			if (withdraw % 5 == 0 && withdraw > 0) {
				Berechnung(withdraw);	//Amount is acceptable and the bills will be calculated.
			}else {
				System.out.println("Your request was denied! Invalid withdrawal!");
				//Withdrawal was denied. It will ask for a new withdrawal amount.
			}
		}
		
	}

	//This method does the calculation of the amount of bills.
	//At last it will print out the amount of bills.
	private static void Berechnung(int withdrawal) {
		int fiveHundred = 0;
		int twoHundred = 0;
		int oneHundred = 0;
		int fifty = 0;
		int twenty = 0;
		int ten = 0;
		int five = 0;
		
		while(withdrawal >= 500) {
			fiveHundred = withdrawal / 500;
			withdrawal = withdrawal - (fiveHundred * 500);
		}
		while(withdrawal >= 200) {
			twoHundred = withdrawal / 200;
			withdrawal = withdrawal - (twoHundred * 200);
		}
		while(withdrawal >= 100) {
			oneHundred = withdrawal / 100;
			withdrawal = withdrawal - (oneHundred * 100);
		}
		while(withdrawal >= 50) {
			fifty = withdrawal / 50;
			withdrawal = withdrawal - (fifty * 50);
		}
		while(withdrawal >= 20) {
			twenty = withdrawal / 20;
			withdrawal = withdrawal - (twenty * 20);
		}
		while(withdrawal >= 10) {
			ten = withdrawal / 10;
			withdrawal = withdrawal - (ten * 10);
		}
		while(withdrawal >= 5) {
			five = withdrawal / 5;
			withdrawal = withdrawal - (five * 5);
		}
		
		System.out.println(fiveHundred + " times 500 Euro bills");
		System.out.println(twoHundred + " times 200 Euro bills");
		System.out.println(oneHundred + " times 100 Euro bills");
		System.out.println(fifty + " times 50 Euro bills");
		System.out.println(twenty + " times 20 Euro bills");
		System.out.println(ten + " times 10 Euro bills");
		System.out.println(five + " times 5 Euro bills");
		
	}

}
