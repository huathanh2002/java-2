/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass_gd22;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author An Dong PC
 */
public class Clock implements Runnable{
    JLabel clocklabel;

    public Clock(JLabel clocklabel) {
        this.clocklabel = clocklabel;
    }
    
    
    @Override
    public void run() {
        while (true) {            
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
            clocklabel.setText(sdf.format(now));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        
    }
    
}
