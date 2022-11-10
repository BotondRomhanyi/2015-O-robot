package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Codes> codes = new ArrayList<>();

            //1.feladat

            try (BufferedReader reader = new BufferedReader(new FileReader("progs.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Codes results1 = new Codes(line);
                    codes.add(results1);
                }
            }

            //2.feladat

            System.out.println("2. Feladat: Tanulók száma: " + codes.size() + " fő");

            //3.feladat

            char[] goodChars = {'E', 'B', 'J', 'H'};
            int badCodeCounter = 0;
            int letterCounter = 0;
            String best = null;
            double farest = 0.0;
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ivsz.txt")))) {
                for (Codes code : codes) {
                    for (int i = 0; i < code.code.length(); i++) {
                        for (char goodchar : goodChars) {
                            if (code.code.charAt(i) == goodchar) {
                                letterCounter++;
                                break;
                            }
                        }
                    }
                    if (code.code.length() != letterCounter) {
                        badCodeCounter++;

                        //4. Feladat

                    } else {
                        int switchCounter = 0;
                        char beforeLetter = 0;
                        for (int i = 0; i < code.code.length(); i++) {
                            if (i == 0) {
                                beforeLetter = code.code.charAt(0);
                                continue;
                            }
                            if (code.code.charAt(i) != beforeLetter) {
                                switchCounter++;
                            }
                            beforeLetter = code.code.charAt(i);
                        }
                        writer.print(code.name + " " + switchCounter + "\n");

                        //5. Feladat

                        int xtav = 0;
                        int ytav = 0;
                        for (int i = 0; i < code.code.length(); i++) {
                            if (code.code.charAt(i) == goodChars[0]) {
                                ytav += 1;
                            } else if (code.code.charAt(i) == goodChars[1]) {
                                xtav -= 1;
                            } else if (code.code.charAt(i) == goodChars[2]) {
                                xtav += 1;
                            } else {
                                ytav += 1;
                            }
                        }
                        double ditance = Math.sqrt(Math.pow(xtav,2) + Math.pow(ytav,2));
                        if (ditance > farest) {
                            best = code.name;
                            farest = ditance;
                        }
                    }
                    letterCounter = 0;
                }
            }
            System.out.println("3. Feladat: Helytelen kódsorozatok száma: " + badCodeCounter);
            System.out.println("5. Feladat: Legtávolabbra jutó robot vezérlését készítette: " + best);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}