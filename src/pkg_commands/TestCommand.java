package pkg_commands;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * The TestCommand class is used to execute a series of commands from a file.
 * This command allows the player to load and execute predefined commands from a text file.
 * 
 * @author Piere MATAR
 */
public class TestCommand extends Command
{
    /**
     * Executes the "test" command.
     * If no file name is provided, prompts the player to specify a file.
     * If a valid file is found, executes each command inside it.
     * 
     * @param pPlayer The player who executed the command.
     * @param pGameEngine The game engine.
     */
    
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
