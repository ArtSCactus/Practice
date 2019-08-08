/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Home_library.EmailSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**How this system works:
 * There's a directory with files, which has name user id+".txt
 * Each file is a mailbox of user with id, that that name of file consist
 * This system allows to add and search mailboxes.
 *
 * @author ArtSCactus
 */
public class EmailSystem {
/**Contains directory with users emails.
 * 
 */
    private File mailDir;
    /**Contains list of mailboxes.
     * 
     */
    private List<Mailbox> mailboxes;
/**Constructs email system, initializing list and connects files(mailboxes).
 * 
 */
    public EmailSystem(String emailStoragePath) {
        mailboxes = new ArrayList<>();
        File mailDir = new File(emailStoragePath+"\\Emails");
        if (!mailDir.mkdir()) mailDir.mkdir();
        for (File item : mailDir.listFiles()) {
            mailboxes.add(new Mailbox(item, Integer.parseInt(item.getName().replaceAll(".txt", ""))));
        }
    }
    /**Adds new mailbox file with name of given user id.
     * 
     * @param userId
     * @throws IOException 
     */
    public void addMailbox(int userId) throws IOException{
        File mailbox = new File(mailDir.getName()+"\\"+Integer.toString(userId)+".txt");
        mailbox.createNewFile();
        mailboxes.add(new Mailbox(mailbox, userId));
    }
    /**Returns mailbox by it's id.
     * 
     * @param id
     * @return 
     */
    public Mailbox getMailboxById(int id){
        for (Mailbox mailbox:mailboxes)
            if(mailbox.getId()==id) return mailbox;
                    return null;
    }
}
