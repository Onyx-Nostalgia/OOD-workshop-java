import java.util.Objects;

public class TennisGame1 {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    private static final int SCORE_ADVANTAGE_MATCH_POINT = 4;
    private static final int DIFFERENT_SCORE_WIN_MATCH = 2;
    private static final int DIFFERENT_SCORE_ADVANTAGE_MATCH = 1;

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

        // Advantage
        if(isAdvantage()) {
            String playerAdvantage = WhoAdvantage();
            return "Advantage " + playerAdvantage;
        }

        // Win
        if (isWin()) {
            String playerAdvantage = WhoAdvantage();
            return "Win for " + playerAdvantage;
        }

        return scoreResults[m_score1] + "-" + scoreResults[m_score2];
    }

    private String WhoAdvantage() {
        if (m_score1 > m_score2) return player1Name;
        return player2Name;
    }

    private boolean isAdvantage(){
        int differentScore = Math.abs(m_score1 - m_score2);
        return (m_score1 >= SCORE_ADVANTAGE_MATCH_POINT || m_score2 >= SCORE_ADVANTAGE_MATCH_POINT)
                && differentScore == DIFFERENT_SCORE_ADVANTAGE_MATCH;
    }

    private boolean isWin(){
        int differentScore = Math.abs(m_score1 - m_score2);
        return (m_score1 >= SCORE_ADVANTAGE_MATCH_POINT || m_score2 >= SCORE_ADVANTAGE_MATCH_POINT)
                && differentScore >=DIFFERENT_SCORE_WIN_MATCH;
    }

    private boolean isDeuce() {
        return m_score1 == m_score2 && m_score1 > 2;
    }

    private boolean isAll() {
        return m_score1 == m_score2 && m_score1 <= 2;
    }
}
