/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Home_library.EmailSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ArtSCactus
 */
public class EmailSystem {

    private File mailDir;
    private List<Mailbox> mailboxes;

    public EmailSystem() {
        mailboxes = new ArrayList<>();
        File mailDir = new File("src\\Practice\\Home_library\\EmailSystem\\Emails");
        for (File item : mailDir.listFiles()) {
            mailboxes.add(new Mailbox(item, Integer.parseInt(item.getName().replaceAll(".txt", ""))));
        }
    }
    public void addAdminMailbox(int userId) throws IOException{
        File mailbox = new File(mailDir.getName()+"\\"+Integer.toString(userId)+".txt");
        mailbox.createNewFile();
        mailboxes.add(new Mailbox(mailbox, userId));
    }
    public Mailbox getMailboxById(int id){
        for (Mailbox mailbox:mailboxes)
            if(mailbox.getId()==id) return mailbox;
                    return null;
    }
}
