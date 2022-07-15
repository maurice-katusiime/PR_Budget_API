package budgetapproval;

import javax.swing.*;
import java.awt.*;

public class Upload {


    public static void main(String[] args){
            EventQueue.invokeLater(() ->{
                BudgetUpload frame  = new BudgetUpload();
                frame.setTitle("Upload Budget");

                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            });

                }


    }

