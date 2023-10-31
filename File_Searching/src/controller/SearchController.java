package controller;

import common.Validate;
import repository.SearchRepository;
import view.Menu;

public class SearchController extends Menu {

    static String[] mc = {"Count Word In File", "Find File By Word", "Exit"};
    SearchRepository sr;
    Validate validate;

    public SearchController() {
        super("Word Program", mc);
        sr = new SearchRepository();
        validate = new Validate();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println("-------- Count Word --------");
                sr.countWordInFile(validate.checkString("Enter path"),
                        validate.checkString("Enter Word"));
                break;
            case 2:
                System.out.println("-------- Find File By Word --------");
                sr.getFileNameContainsWordInDirectory(validate.checkString("Enter path"),
                        validate.checkString("Enter Word"));
                break;
            case 3:
                System.out.println("Closed..");
                System.exit(0);
            default:
                System.out.println("Choose again.");
                break;
        }
    }
}
