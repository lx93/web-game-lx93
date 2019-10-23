package com.example.appengine.java8;

import java.util.*;

import static java.lang.System.out;

public class MasterMind implements java.io.Serializable
{
    private final int CODESIZE = 4;
    private final ArrayList<Character> COLORS = new ArrayList<>(Arrays.asList('r','g','b','y','o','p'));
    protected StringBuilder randomPhrase;
    protected StringBuilder hiddenPhrase;
    protected HashSet<String> previousGuesses = new HashSet<>();
    protected int exacts = 0;
    protected int partials = 0;
    protected int lives = 6;
    protected boolean correct;


    protected MasterMind()
    {
        randomPhrase = generateRandomPhrase();
        hiddenPhrase = generateHiddenPhrase();
    }

    /**
     * check for exact matches
     * @param randomPhrase
     * @param guess
     * @return number of exact matches
     */
    private int checkExacts(StringBuilder randomPhrase, StringBuilder guess)
    {
        for (int i=0;i<CODESIZE;i++)
        {
            if (randomPhrase.charAt(i)==guess.charAt(i)) exacts++;
        }
        return exacts;
    }

    /**
     * check for partial matches
     * @param randomPhrase
     * @param guess
     * @return number of partial matches
     */
    private int checkPartials(StringBuilder randomPhrase, StringBuilder guess)
    {
        // compare secret to guess
        StringBuilder secretSB = new StringBuilder(randomPhrase);
        StringBuilder guessSB = new StringBuilder(guess);
        int i=0;
        while (i<CODESIZE)
        {
            int j=0;
            while (j<CODESIZE)
            {
                if (secretSB.charAt(i) == guessSB.charAt(j))
                {
                    partials++;
                    secretSB.setCharAt(i,'-');
                    guessSB.setCharAt(j,'*');
                }
                j++;
            }
            i++;
        }
        return partials;
    }

    protected GameInstance play(GameInstance instance,String guess)
    {
        partials = 0;
        exacts = 0;
        if (lives >0)
        {
            System.out.print(instance.getPlayer()+" guessed: "+guess+", ");
            correct = processGuess(guess);

            if (!correct)
            {
                lives --;
                instance.setScore(instance.getScore()-5);
                System.out.println("which is INCORRECT! " + lives + " tries left. Current score: "+instance.getScore());
            }
            else
            {
                instance.setScore(instance.getScore()+100);
                out.println("which is CORRECT! Congrats, you won!! Your score: " + instance.getScore());
            }
        }

        else{System.out.println("Oops, you lost!");}

        previousGuesses = new HashSet<>();

        return instance;
    }

    private boolean processGuess(String guess)
    {
        StringBuilder guessSB = new StringBuilder(guess);
        if (guess.equals(randomPhrase.toString())) return true;
        else {
            partials = checkPartials(randomPhrase,guessSB);
            exacts = checkExacts(randomPhrase,guessSB);
            out.println("You got "+partials+ " partial and "+exacts+" exact matches");
        }
        return false;
    }


    /**
     * generate a random color pattern that user will try to guess correctly
     * @return a random color combo in SB
     */
    StringBuilder generateRandomPhrase()
    {
        randomPhrase = new StringBuilder();
        while(randomPhrase.length()<4)
        {
            Random rand = new Random();
            int index = rand.nextInt(CODESIZE);
            randomPhrase.append(COLORS.get(index));
        }
        out.println(randomPhrase);
        return randomPhrase;
    }

    /**
     * encrypt our randomPhrase and replace all letters with *
     * @return SB that is encrypted
     */
    StringBuilder generateHiddenPhrase ()
    {
        hiddenPhrase = new StringBuilder(randomPhrase);
        for (int i=0;i<hiddenPhrase.length();i++){
            if (Character.isLetter(hiddenPhrase.charAt(i))){hiddenPhrase.replace(i,i+1,"*");}
        }
        System.out.println("\n   " + hiddenPhrase+"   \n");
        return hiddenPhrase;
    }
}
