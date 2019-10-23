package com.example.appengine.java8;

import java.util.ArrayList;
import java.util.Collections;

public class GamesRecord {
    public ArrayList<GameInstance> gamesRecord = new ArrayList<GameInstance>();

    /**
     * adds a Game to the GamesRecord
     * @param instance
     */
    void add(GameInstance instance) { gamesRecord.add(instance); }

    /**
     * @return the average score for all games added to the record
     */
    int average()
    {
        int totalScore = 0;
        for (GameInstance game:gamesRecord){
            totalScore += game.getScore();
        }
        return totalScore/gamesRecord.size();
    }

    /**
     * @param playerId
     * @return the average score for all games of a particular player
     */
    int average(String playerId)
    {
        System.out.println(playerId);
        int totalScore = 0;
        int gamesPlayed = 0;
        for (GameInstance game:gamesRecord)
        {
            if (game.getPlayer() == playerId) {
                totalScore+=game.getScore();
                gamesPlayed++;
            }
        }

        return totalScore/gamesPlayed;
    }

    int gamesPlayed(String playerId)
    {
        int games = 0;
        for (GameInstance game:gamesRecord)
        {
            if (game.getPlayer() == playerId)
            {
                games++;
            }
        }
        return games;
    }


    /**
     * This method should use the Collections class to sort the game instances.
     * @param topN
     * @return a sorted list of the top n scores including player and score.
     */
    ArrayList highGameList(int topN)
    {
        ArrayList<GameInstance> highScores = new ArrayList<GameInstance>(gamesRecord);
        System.out.println("--------------------TOP "+topN+" SCORES-----------------------");
        Collections.sort(highScores);
        Collections.reverse(highScores);
        highScores = new ArrayList(highScores.subList(0,topN));
        return highScores;
    }

    /**
     * This method should use the Collections class to sort the game instances.
     * @param playerId
     * @param topN
     * @return a sorted list of the top n scores for the specified player.
     */
    ArrayList highGameList(String playerId, int topN)
    {
        System.out.println("---------------"+playerId+"'s highest "+topN+" scores---------------");
        ArrayList<GameInstance> highScores = new ArrayList<GameInstance>();
        // this for loops seeks out all the GameInstance that playerId played
        for (GameInstance game:gamesRecord)  if (game.getPlayer() == playerId)  highScores.add(game);

        Collections.sort(highScores);
        Collections.reverse(highScores);
        highScores = new ArrayList(highScores.subList(0,topN));
        return highScores;
    }

    @Override
    public String toString()
    {
        // we build our own stringbuilder gr to avoid using ArrayList's built-in toString methods, to avoid printing []
        StringBuilder gr = new StringBuilder();
        for (GameInstance instance: gamesRecord)  gr.append(instance);
        return "\n------------------------Records-------------------------\n" + gr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamesRecord that = (GamesRecord) o;

        return gamesRecord != null ? gamesRecord.equals(that.gamesRecord) : that.gamesRecord == null;
    }

}
