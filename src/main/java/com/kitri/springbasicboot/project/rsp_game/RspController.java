package com.kitri.springbasicboot.project.rsp_game;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rsp")
public class RspController {
    static int ROCK = 0;
    static int SCISSORS = 1;
    static int PAPAER = 2;
    @GetMapping
    public String home() {
        return "/project/rsp_game/rsp";
    }

    @GetMapping("/play")
    public String playGame(HttpServletRequest request, @RequestParam int yourInput) {
        HttpSession session = request.getSession();
        if (session == null) {
            session.setAttribute("status", new GameStatus());
        }

        GameStatus status = (GameStatus) session.getAttribute("status");
        if (status == null) {
            session.setAttribute("status", new GameStatus());
        }
        status = (GameStatus) session.getAttribute("status");
        status.setWinner("");

        int computerInput = (int)(Math.random() * 3);

        status.setYourSrc(yourInput);
        status.setComputerSrc(computerInput);

        if (yourInput == ROCK) {
            if (computerInput == ROCK) {
                status.upDrawCount();
            } else if (computerInput == SCISSORS) {
                status.upWinCount();
                status.setWinner("you");
            } else {
                status.upLoseCount();
                status.setWinner("computer");
            }
        } else if (yourInput == SCISSORS) {
            if (computerInput == ROCK) {
                status.upLoseCount();
                status.setWinner("computer");
            } else if (computerInput == SCISSORS) {
                status.upDrawCount();
            } else {
                status.upWinCount();
                status.setWinner("you");
            }
        } else {
            if (computerInput == ROCK) {
                status.upWinCount();
                status.setWinner("you");
            } else if (computerInput == SCISSORS) {
                status.upLoseCount();
                status.setWinner("computer");
            } else {
                status.upDrawCount();
            }
        }
        return "/project/rsp_game/rsp";
    }

}
