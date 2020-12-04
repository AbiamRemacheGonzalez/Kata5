package kata5;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;

public class HistogramBuilder {
    public static Histogram<String> build(List<Mail> mails) {
        Histogram<String> histogram = new Histogram();
        for(Mail main: mails){
            histogram.increment(main.getDomain());
        }        
        return histogram;
    }
}
