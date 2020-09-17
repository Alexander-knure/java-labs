package lab3;

public class Main {
    public static void main(String[] args) {

        String locationFile = "C://Users//alex2//eclipse-workspace//JavaLab3_7//src//lab3//TestFile.txt"; // СЃС‚СЂРѕРєР° РґР»СЏ Р·Р°РїРёСЃРё

        ReplaceFile f = new ReplaceFile(locationFile);
        f.write("The Tragedy of Hamlet, Prince of Denmark, often shortened to Hamlet (/ˈhæmlɪt/), is a tragedy written "
        		+ "by William Shakespeare sometime between 1599 and 1601. It is Shakespeare's longest play with 30,557 "
        		+ "words. Set in Denmark, the play depicts Prince Hamlet and his revenge against his uncle, Claudius, "
        		+ "who has murdered Hamlet's father in order to seize his throne and marry Hamlet's mother.");

        f.read();
        f.readCollection();
        f.setSubstrings();
        f.readCollection();
        f.read();
    }
}
