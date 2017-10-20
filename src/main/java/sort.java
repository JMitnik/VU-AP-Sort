import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class sort {
    private static boolean optionI;
    private static boolean optionD;
    private BinarySearchTree<Identifier> tree;

    sort() {
        optionI = false;
        optionD = false;
        tree = new BinarySearchTree<>();
    }

    /**
     * Toggles the options, throws an exception when option is not recognized
     * or the option is given twice.
     * @param option - The argument given on command line
     */
    private void toggleOption( String option) throws APException {
        if (option.equals("-i") && !optionI)  {
            optionI = true;
        } else if (option.equals("-d") && !optionD ) {
            optionD = true;
        } else {
            throw new APException("Wrong use of option");
        }
    }

    /**
     * Returns either a descending or ascending iterator according to the set 'optionD'.
     */
    private Iterator<Identifier> getIterator() {
        if (optionD) {
            return tree.descendingIterator();
        } else {
            return tree.ascendingIterator();
        }
    }

    /**
     * Prints the Identifiers that occur an uneven number of times. Each
     * Identifier is followed by an end-of-line. When the option "-i" is passed
     * on invocation of the program, all identifiers are printed in lower case.
     */
    private void printUniq() {
        Iterator<Identifier> idList = getIterator();

        while (idList.hasNext()) {
            System.out.println(idList.next().getIdentifier());
        }
    }

    /**
     * Reads all the files given on the command line.
     * @param filelist - A list of the files passed.
     */
    private void readFiles(ArrayList<File> filelist) throws APException, FileNotFoundException {
        if (filelist.isEmpty()) {
            throw new APException("No files given!");
        }

        for ( File file: filelist) {
            readFile(file);
        }
    }


    /**
     * Reads the text in file, if -d is given as an argument the lines will
     * be passed in lowercase.
     * @param file - File that needs to be read.
     */
    private void readFile(File file) throws APException, FileNotFoundException {
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            if (optionI) {
                readLine(new Scanner( fileScanner.nextLine().toLowerCase() ));
            } else {
                readLine(new Scanner( fileScanner.nextLine() ));
            }
        }
    }


    /**
     * Reads a line of text, one character at a time, and parses it.
     * @param linescanner - A Scanner over one line of text
     */
    private void readLine(Scanner linescanner) throws APException{
        linescanner.useDelimiter("");
        ignoreNonAlphaNumeric(linescanner);

        while (linescanner.hasNext()) {
            if (nextCharIsLetter(linescanner)) {
                toggleIdentifier( buildIdentifier(linescanner) );
            } else {
                skipNonIdentifier(linescanner);
            }
            ignoreNonAlphaNumeric(linescanner);
        }
    }


    /**
     * Extracts and builds an Identifier from a line.
     * @param input - Scanner on a line of text.
     * @return Identifier - The Identifier it extracted and build from the line.
     */
    private Identifier buildIdentifier(Scanner input) {
        Identifier id = new IdentifierImp();

        while( nextCharIsAlphanumeric(input)) {
            id.addChar(nextChar(input));
        }

        return id;
    }


    /**
     * Toggles the identifier given to it, when it is already in the tree it
     * is removed from the tree. Otherwise it is added
     * @param id - The identifier it performs the action with
     */
    private void toggleIdentifier(Identifier id) {
        if (tree.contains(id)) {
            tree.remove(id);
        } else {
            tree.add(id);
        }
    }


    /**
     * Reads the arguments that have been passed through the command line and
     * processes them.
     * @param argv - Array of arguments passed on to the program in the terminal
     */
    private void readArguments( String[] argv ) throws APException, FileNotFoundException {
        if (argv.length == 0) {
            throw new APException("No arguments given!");
        }

        //index to keep track where in the array we are
        int i = 0;
        ArrayList<File> filelist = new ArrayList<>();

        // Read options
        while ( argv[i].charAt(0) == '-' ) {
            toggleOption(argv[i++]);
            if ( i == argv.length ) {
                throw new APException("No Files given!");
            }
        }

        // Read filenamess
        while ( i < argv.length ) {
            filelist.add( new File(argv[i++]) );
        }

        readFiles(filelist);
    }


    /**
     * Reads a nonIdentifier and ignores it.
     * @param input - Scanner on a line of text.
     */
    private void skipNonIdentifier (Scanner input) throws APException {
        if ( nextCharIsDigit(input)){
            while( nextCharIsAlphanumeric(input)) {
                nextChar(input);
            }
        }
    }


    /**
     * Ignores all subsequent non alphanumerical characters
     * @param input - Scanner on a line of text.
     */
    private void ignoreNonAlphaNumeric(Scanner input)  {
        while ( !nextCharIsDigit(input) && !nextCharIsLetter(input) && input.hasNext() ) {
            input.next();
        }
    }


    /**
     * @param input - Scanner on a line of text.
     * @return boolean - true if it is alphanumeric, false otherwise
     */
    private boolean nextCharIsAlphanumeric(Scanner input) {
        return nextCharIsLetter(input) || nextCharIsDigit(input);
    }


    /**
     * @param input - Scanner on a line of text.
     * @return char - the next character
     */
    private char nextChar (Scanner input) {
        return input.next().charAt(0);
    }


    /**
     * @param input - Scanner on a line of text.
     * @return boolean - true is next char is a digit, false otherwise.
     */
    private boolean nextCharIsDigit (Scanner input) {
        return input.hasNext("[0-9]");
    }


    /**
     * @param input - Scanner on a line of text.
     * @return boolean - true is next char is a letter, false otherwise.
     */
    private boolean nextCharIsLetter (Scanner input) {
        return input.hasNext("[A-Za-z]");
    }


    /**
     * Reads and processes all the arguments given, and prints out the
     * Identifiers that occur in the given files an uneven number of times.
     * @param argv - Array of arguments passed on to the program in the terminal
     */
    private void start( String[] argv) throws APException, FileNotFoundException {
        readArguments(argv);
        printUniq();
    }

    public static void main(String[] argv) throws APException, FileNotFoundException {
            new sort().start(argv);
    }

}
