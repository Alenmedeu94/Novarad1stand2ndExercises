Feature: Bowling Game
  As a player, I want to enter my score for each frame and get my final score along with the delivery type of each frame

  Scenario Outline: Verify Final Score for a Game
    Given the player has entered scores for all the 10 frames
    When the scores are processed
    Then the final score and delivery type of each frame is displayed
    Examples:
      | firstBall1 | secondBall1 | firstBall2 | secondBall2 | firstBall3 | secondBall3 | firstBall4 | secondBall4 | firstBall5 | secondBall5 | firstBall6 | secondBall6 | firstBall7 | secondBall7 | firstBall8 | secondBall8 | firstBall9 | secondBall9 | firstBall10 | secondBall10 |
      |     7      |     3       |     9      |     1       |    10      |      0      |     8      |     2       |    10      |      0      |    10      |      0      |     10     |      0      |     8      |      2      |    10      |      0      |     8      |      2      |

  Scenario Outline: Boundary Testing
    Given the player has entered an invalid score for a frame '<firstBall>' or '<secondBall>'
    When the score is processed
    Then the error message "Invalid score, score must be between 0 and 10" is displayed
    Examples:
      | firstBall | secondBall |
      |    11     |     2      |
      |    -1     |     2      |
      |     5     |    11      |
      |     5     |    -1      |

  Scenario:Negative Test - User score Foul in first and second round
      Given all deliveries are Foul
      Then final score should be 0

  Scenario 3: Positive Test - User scores an Open in the first frame
    Given the user is playing the bowling game
    When the user scores 4 in the first ball and 3 in the second ball of the first frame
    Then the message "Delivery: Open" should be displayed
    And the message "Frame 1: Open" should be displayed in the final scores

  Scenario 6: Negative Test - User enters Foul in both balls of the first frame
    Given the user is playing the bowling game
    When the user enters "Y" in response to "is it Foul Y/N?" for both balls of the first frame
    Then the message "Its a Foul" should be displayed twice
    And the message "Frame 1: Foul" should be displayed in the final scores

  Scenario 1: Positive Test - User scores a Strike in the first frame
    Given the user is playing the bowling game
    When the user scores 10 in the first ball of the first frame
    Then the message "Delivery: Strike" should be displayed
    And the message "Frame 1: Strike" should be displayed in the final scores

    # My Automated test cases examples

