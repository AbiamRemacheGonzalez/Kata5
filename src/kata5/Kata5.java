package kata5;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.persistence.database.DatabaseMailListLoader;
import kata5.ui.HistogramDisplay;
import kata5.persistence.ObjectsListLoader;

public class Kata5 {

    public static void main(String[] args){
        String databaseName = "data/us500.db";
        ObjectsListLoader loader = new DatabaseMailListLoader();
        List<Mail> mails = loader.loadMails(databaseName);
        
        Histogram<String> histograma = HistogramBuilder.build(mails);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay(histograma,"HISTOGRAM");
        histogramDisplay.execute();
    }
    
}
