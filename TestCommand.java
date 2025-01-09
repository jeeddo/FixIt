import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * Décrivez votre classe TestCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestCommand extends Command
{
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
  
    if (!super.hasSecondWord()) {
        pGameEngine.getGui().println("Which file do you want to test ?");
        return; 
    }

 
    String vSecondWord = super.getSecondWord();

 
    File vDossier = new File("./tests");
    File vFichier = new File(vDossier, vSecondWord + ".txt");


    if (!vFichier.exists()) {
        pGameEngine.getGui().println("The file " + vSecondWord + ".txt' does not exist.");
        return;  
    }

     try (Scanner vScanner = new Scanner(vFichier)) {
        pGameEngine.setTestMode(true);
         while (vScanner.hasNextLine()) {
            
             pGameEngine.interpretCommand(vScanner.nextLine());
        }
        pGameEngine.setTestMode(false);
    } catch (IOException e) {
        System.out.println("An error occured : " + e.getMessage());
    }
}
}
