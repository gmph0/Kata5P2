package kata5P2.main;
import java.util.*;

import kata5P2.model.*;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReaderBD;

public class Controller {
	
    private static List<String> mailList;
    private static Histogram<String> histogram;
    
     public static void main(String[] args) {
        execute();
    }
     
     private static void execute(){
        Input();
        Process();
        Output();
    }
     
     private static void Input(){
        mailList = MailListReaderBD.read("jdbc:sqlite:KATA5.db");
    }
     
     private static void Process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
     
     private static void Output(){
        (new HistogramDisplay(histogram)).execute();
    }
}
