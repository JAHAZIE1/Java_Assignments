import java.io.*;
import java.util.*;

public class CountWords {


    public static void main(String[] args) throws IOException {
        //set up global Hashmap variable which will contain the answer
        HashMap <String,Set<Integer>> answer = new HashMap<String,Set<Integer>> ();

        if (args.length != 2) {
            System.out.println("Two arguments required for input");
            System.exit(0);
        }

        String argumentRead = args[0];
        String argumentWrite = args[1];

        //Reading input file
        try (BufferedReader Br = new BufferedReader(new FileReader(new File (argumentRead))))
        {
            String s;
            int line = 0;
            while ((s = Br.readLine()) != null) {
                line++;
                String word = "";
                for (int index=0; index < s.length(); index++ ) {//iterates through each character being read in file
                    char currentLetter = s.charAt(index);
                    if (Character.isUpperCase(currentLetter)) { //converts character to lower case if upper case and add to current word
                        currentLetter = Character.toLowerCase(currentLetter);
                        word = word + currentLetter;
                    } else if (Character.isLowerCase(currentLetter)) { //adds all lowercase character to current word
                        word = word + currentLetter;
                    } else if (word.equals("")) {//captures empty strings. Left blank so that it will skip if variable is empty or will hit the else statement

                    } else {// it not a letter then word is complete. Update word as per requirements and adds to HashSet
                        String entryKey = word + ": line(s)";
                        if (answer.containsKey(entryKey)) { // if key present updates the value set
                            Set<Integer> entryValue = new HashSet<Integer>();
                            entryValue = answer.get(entryKey);
                            entryValue.add(line);
                            answer.replace(entryKey, entryValue);
                            word = "";
                        } else { // if key is not present adds new combination
                            Set<Integer> entryValue = new HashSet<Integer>();
                            entryValue.add(line);
                            answer.put(entryKey, entryValue);
                            word = "";
                        }

                    }

                }
            }


        }
        catch (IOException e) {
            System.out.println("There was an IO read error");
        }

        //All keys added into an array and sorted into alphabetic order
        ArrayList<String> listOfKeys = new ArrayList<String>(answer.keySet());
        Collections.sort(listOfKeys);

        // write output onto console and designated file
        try (FileReader Wr = new FileReader(new File (argumentWrite))) {
            FileWriter fw = new FileWriter(argumentWrite);
            for (String k : listOfKeys) { //iterates through all keys
                Set<Integer> value = new HashSet<Integer>(answer.get(k));
                System.out.print(k);
                fw.write(k);
                for (Integer v : value) { // iterates through all value for each key
                    System.out.print(" " + v);
                    fw.write(" " + v);
                }
                System.out.println();
                fw.write("\n");
            }
            fw.close();


        } catch (IOException e) {
            System.out.println("There was an IO write error");
        }


    }


    }

