
package _99_extra;

import javax.swing.JOptionPane;

/* NASA wants to shoot a rocket into orbit. 
  * Somebody has to do the countdown or the rocket won't launch.
 * 
 * The ground control chief will tell you where to start – then count down to 0. 
 * 
 * (example for '11': 11 10 9 8 7 6 5 4 3 2 1 0)
 * 
 **/

public class NasaCountdown {
	public static void main(String[] args) throws InterruptedException {
		// 2. Use a pop-up to ask the user where to start counting from
		int countdown = Integer.parseInt(JOptionPane.showInputDialog(null,"What do you wanna start counting from"));
		// 3. Change the countdown to use the new starting point
		
		// 1. Print a countdown from 10 to 0 on the console
		while(countdown > 0) {
			System.out.println(countdown);
			speak(countdown+"");
			countdown = countdown - 1;
		
			// 4. Use the speak method to hear the countdown.
		Thread.sleep(1000);
		}
			// 6. Use the following code to make the program wait one second for each number: Thread.sleep(1000);
		speak("blastoff!!!!!!!!!!!!!!!!!!!!!");
		// 5. when the counting is done, speak "blastoff!"
	}

static void speak(String words) {
		
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


