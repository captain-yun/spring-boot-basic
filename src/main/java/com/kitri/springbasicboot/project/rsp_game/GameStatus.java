package com.kitri.springbasicboot.project.rsp_game;

public class GameStatus {
    private int winCount = 0;
    private int loseCount = 0;
    private int drawCount = 0;
    private String winner = "you";
    private int computerSrc = 0;
    private int yourSrc = 0;

    public GameStatus() {

    }

    public GameStatus(int winCount, int loseCount, int drawCount) {
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.drawCount = drawCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void upWinCount() {
        this.winCount = winCount + 1;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void upLoseCount() {
        this.loseCount = loseCount + 1;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void upDrawCount() {
        this.drawCount = drawCount + 1;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getComputerSrc() {
        return computerSrc;
    }

    public int getYourSrc() {
        return yourSrc;
    }

    public String convertSrc(int what) {
        String what_ = "";
        if (what == 0) {
            what_ = "rock";
        } else if (what == 1) {
            what_ = "scissors";
        } else {
            what_ = "paper";
        }
        return "/rsp_game/" + what_ + ".png";
    }

    public void setComputerSrc(int computerSrc) {
        this.computerSrc = computerSrc;
    }

    public void setYourSrc(int yourSrc) {
        this.yourSrc = yourSrc;
    }
}
