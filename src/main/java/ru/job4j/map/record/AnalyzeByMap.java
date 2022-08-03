package ru.job4j.map.record;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int subjects = 0;
        for (Pupil pupil : pupils) {
            subjects += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>(pupils.size());
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            rsl.add(new Label(pupil.name(), score / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldV, newV) -> (oldV + newV));
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>(pupils.size());
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            rsl.add(new Label(pupil.name(), score));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldV, newV) -> (oldV + newV));
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            rsl.add(new Label(key, value));
        }
        rsl.sort(Comparator.naturalOrder());

        return rsl.get(rsl.size() - 1);
    }
}
