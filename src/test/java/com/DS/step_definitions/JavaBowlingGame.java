package com.DS.step_definitions;

import java.util.Scanner;

public class JavaBowlingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] score = new int[23];
        int frameIndex = 0;
        String isFoulFirst = "";
        String isFoulSecond = "";
        String[] messages = new String[10];
        int totalScore = 0;

        for (int frame = 1; frame <= 10; frame++) {
            int firstBall = 0;
            int secondBall = 0;
            System.out.println("Frame " + frame + " is starting");
            System.out.println("is it FOUL Y/N?");
            isFoulFirst = sc.next();
            if (isFoulFirst.equalsIgnoreCase("N")) {

                System.out.println("Enter score for frame " + (frame) + ": ");
                firstBall = sc.nextInt();
                frameIndex = frame * 2;
                score[frameIndex] = firstBall;
                while (firstBall > 10 || firstBall < 0) {
                    System.out.println("Invalid score, score must be between 0 and 10");
                    firstBall = sc.nextInt();
                }
                if (firstBall == 10) {
                    messages[frame - 1] = "Strike";
                    System.out.println("Delivery: Strike");
                    continue;
                }
            } else {
                System.out.println("Its a FOUL");
            }
            System.out.println("is it FOUL Y/N?");
            isFoulSecond = sc.next();
            if (isFoulSecond.equalsIgnoreCase("N")) {
                System.out.println("Please enter second ball score");
                secondBall = sc.nextInt();
                score[frameIndex] = secondBall;
                while (secondBall > 10 || secondBall < 0) {
                    System.out.println("Invalid score, score must be between 0 and 10");
                    secondBall = sc.nextInt();
                }
            } else {
                System.out.println("Its a FOUL");
                if (isFoulFirst.equalsIgnoreCase("Y")) {
                    messages[frame - 1] = "Foul";
                }
            }
            if (firstBall + secondBall == 10) {
                messages[frame - 1] = "Spare";
                System.out.println("Delivery: Spare");
            } else if (firstBall + secondBall < 10) {
                if (firstBall == 0 && secondBall == 0) {
                    messages[frame - 1] = "Foul";
                    System.out.println("Delivery: Foul");
                } else if (firstBall == 0 || secondBall == 0) {
                    messages[frame - 1] = "Split";
                    System.out.println("Delivery: Split");

                } else {
                    messages[frame - 1] = "Open";
                    System.out.println("Delivery: Open");
                }
            }
        }
        int strikeCount = 0;
        for (int frame = 0; frame < 10; frame++) {
            int frameStartIndex = frame * 2;
            if (score[frameStartIndex] == 10) {
                totalScore += 10 + score[frameStartIndex + 2] + score[frameStartIndex + 4];
                strikeCount++;
                if (strikeCount == 2) {
                    System.out.println("Mark: Double");
                } else if (strikeCount == 3) {
                    System.out.println("Mark: Turkey");
                } else if (strikeCount == 4) {
                    System.out.println("Mark: Four Bagger");
                }
            } else if (score[frameStartIndex] + score[frameStartIndex + 1] == 10) {
                totalScore += 10 + score[frameStartIndex + 2];
                strikeCount = 0;
            } else {
                totalScore += score[frameStartIndex] + score[frameStartIndex + 1];
                strikeCount = 0;
            }
        }
        for (int frame = 0; frame < 10; frame++) {
            System.out.println("Frame " + (frame + 1) + ": " + messages[frame]);
        }
            System.out.println("Final Score: " + totalScore);
    }
}
