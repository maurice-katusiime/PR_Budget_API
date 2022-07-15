package budgetapproval;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class BudgetUpload extends JFrame {
    private static final int WIDTH = 720;
    private static final int LENGTH = 480;

    private void fileChooserActionPerformed(ActionEvent evt){
        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            System.out.println("approve selection");
        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            System.out.println("cancel selection");
        }
    }

    public BudgetUpload(){
        setSize(WIDTH, LENGTH);

        JPanel panel = new JPanel();
        JFileChooser fileUpload = new JFileChooser();
        /*int response = fileUpload.showOpenDialog(BudgetUpload.this);
        if(response == JFileChooser.APPROVE_OPTION){
            //run action
            UploadAction action = new UploadAction();
            fileUpload.addActionListener(action);
            //System.out.println("Open was selected");
        }else if(response == JFileChooser.CANCEL_OPTION){

            //System.out.println("Cancel was selected");
        }*/



        panel.add(fileUpload);
        
        add(panel);

        fileUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooserActionPerformed(e);
            }
        });








    }



    /* class UploadAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            System.out.println("Hi");

        }
    }*/
}
