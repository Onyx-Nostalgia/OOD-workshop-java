import java.util.Objects;

public class TennisGame1 {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    public static final int ADVANTAGE_MATCH_POINT = 4;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            m_score1 += 1;
        else if (Objects.equals(playerName, player2Name))
            m_score2 += 1;
    }

    public String getScore() {
        String[] scoreResults = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        int differentScore = Math.abs(m_score1 - m_score2);
        StringBuilder score = new StringBuilder();

        // All
        if (isAll()) return scoreResults[m_score1] + "-" + "All";

        // Deuce
        if (isDeuce()) return "Deuce";

        // Normal
        if (m_score1 < ADVANTAGE_MATCH_POINT && m_score2 < ADVANTAGE_MATCH_POINT)
        return scoreResults[m_score1] + "-" + scoreResults[m_score2];

        // Advantage and Win
        if(differentScore == 1) score.append("Advantage ");
        else score.append("Win for ");
        if(m_score1 > m_score2)return score.append(player1Name).toString();
        return score.append(player2Name).toString();

    }

    private boolean isDeuce() {
        return m_score1 == m_score2 && m_score1 > 2;
    }

    private boolean isAll() {
        return m_score1 == m_score2 && m_score1 <= 2;
    }
}
