package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Program> allProgram = new ArrayList<>();
        Deserialization deserialization = new Deserialization();
        ArrayList<String> fileData;

        try {
            fileData = deserialization.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String curChannel = null;

        BroadcastsTime curTime = null;
        for (String fileDatum : fileData) {
            if (fileDatum.contains("#")) {
                curChannel = fileDatum;
            }
            else if (fileDatum.contains(":") && fileDatum.length() == 5) {
                curTime = new BroadcastsTime(fileDatum);
            } else {
                allProgram.add(new Program(curChannel, curTime, fileDatum));
            }
        }
        sortTime(allProgram);


        Serialization writer = new Serialization(allProgram, "программы.xlsx");
        Serialization.saveToExcel(allProgram, "программы.xlsx"); //сохранение данных в экслеь
    }
    public static ArrayList<Program> sortTime(ArrayList<Program> allProgram){
        allProgram.sort((program1, program2) -> {
            int timeComparison = program1.getTime().compareTo(program2.getTime());
            return timeComparison;
        });
        return allProgram;
    }
    public static ArrayList<Program> curProgram(ArrayList<Program> allProgram, String curTime){
        BroadcastsTime curBroadTome = new BroadcastsTime(curTime);
        ArrayList<Program> curProg = new ArrayList<>();
        for (Program program : allProgram) {
            if (program.getTime().compareTo(curBroadTome) == 0) {
                curProg.add(program);
            }
        }
        return curProg;
    }
    public static ArrayList<Program> getProgramsWithName(ArrayList<Program> programs, String name) {
        ArrayList<Program> programsWithName = new ArrayList<>();
        for(Program program: programs) {
            if (program.getName().equals(name)) {
                programsWithName.add(program);
            }
        }
        return programsWithName;
    }
    public static ArrayList<Program> programBetween(ArrayList<Program> allProgram, String time1, String time2, String channel){
        BroadcastsTime broadTime1 = new BroadcastsTime(time1);
        BroadcastsTime broadTime2 = new BroadcastsTime(time2);
        ArrayList<Program> progBetween = new ArrayList<>();
        for (Program program : allProgram) {
            if (program.getTime().between(broadTime1, broadTime2) && (program.getChannel().equals("#" + channel))){
                progBetween.add(program);
            }
        }return progBetween;
    }
    public static ArrayList<Program> getChanelNameAndCurTime(ArrayList<Program> allProgram, String curTime, String chanelName) {
        ArrayList<Program> currTimePrograms = curProgram(allProgram, curTime);
        ArrayList<Program> programsWithChanelAndCurrTime = new ArrayList<>();
        for(Program program: currTimePrograms) {
            if (program.getChannel().equals("#" + chanelName)) {
                programsWithChanelAndCurrTime.add(program);
            }
        }
        return programsWithChanelAndCurrTime;
    }
}