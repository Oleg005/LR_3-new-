package com.laba.task3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Main {
    private final static List<Student> students = new ArrayList<>();
    private final static String[] subArr = { "Фізика","Математика","Англійська мова" };
    private final static Object[][] objects = new Object[][]{
            { 1, "Василенко", "Федір", "Тарасович" },
            { 2, "Антоненко", "Костянтин", "Олексійович" },
            { 3, "Лисенко", "Ярослав", "Федорович" },
            { 4, "Шевчук", "Леонід", "Євгенович" },
            { 5, "Броваренко", "Артем", "Миколайович" },
            { 6, "Антоненко", "Ярослав", "Євгенович" }
    };

    public static void main(final String[] args) {
        createStudents();
        print("Список студентів:", students);

        List<StudentSimple> studentSimples = toStudentSimple(students);
        print("Середній бал студентів:", studentSimples);

        studentSimples = deleteStudents(studentSimples);
        print("Студенти з середнім балом >= 3:", studentSimples);

        final Set<Integer> set_rates = getRatesEnglishLanguage();
        System.out.println("Унікальні оцінки з англійської мови:\n" + set_rates);

        final List<Student> sortedStudents = sortByFullName();
        print("Відсортовані по ПІБ студенти:", sortedStudents);

        final Student student = findStudentByMaxAvg();
        System.out.println("Студент з найбільшим середнім балом:\n" + student.toString());

        System.out.println("Прізвища всіх студентів, через дефіс:");
        System.out.println(getAllSurnames());
    }

    private final static List<StudentSimple> toStudentSimple(final List<Student> list) {
        return list.stream()
                    .map(student -> new StudentSimple(student.getName(),
                                student.getSubjects().stream().mapToInt(p->p.getRate().getRate()).average().orElse(0)))
                    .collect(Collectors.toList());
    }

    private final static List<StudentSimple> deleteStudents(final List<StudentSimple> list) {
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i).getAverageRate() >= 3)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }

    private final static Set<Integer> getRatesEnglishLanguage(){
        return students.stream()
                .map(student -> student.getSubjects())
                .flatMap(subjects -> subjects.stream())
                .filter(s -> s.getName().equalsIgnoreCase("Англійська мова") && s.getRate().getRate() != 0)
                .map(subj -> subj.getRate().getRate())
                .collect(Collectors.toSet());
    }

    private final static List<Student> sortByFullName() {
        return students.stream().sorted((o1, o2) -> {
            final int res1 = o1.getSurname().compareToIgnoreCase(o2.getSurname());
            if(res1 != 0) return res1;
            final int res2 = o1.getName().compareToIgnoreCase(o2.getName());
            if(res2 != 0) return res2;
            return o1.getPatronymic().compareToIgnoreCase(o2.getPatronymic());
        }).collect(Collectors.toList());
    }

    private final static Student findStudentByMaxAvg() {
        Student student = null;
        double maxAvg = 0;
        for(final Student s : students){
            final double avg = s.getSubjects().stream().mapToInt(p->p.getRate().getRate()).average().orElse(0);
            if (avg > 0 && avg > maxAvg){
                student = s;
                maxAvg = avg;
            }
        }
        return student;
    }

    private final static String getAllSurnames() {
        return students.stream()
                .map(Student::getSurname)
                .collect(Collectors.joining("-"));
    }

    private final static void createStudents(){
        for(final Object[] obj:objects){
            students.add(createStudent((int) obj[0],(String) obj[2], (String) obj[1], (String) obj[3]));
        }
    }
    private final static Student createStudent(final int id, final String name, final String surname, final String patronymic){
        final Random random = new Random();
        final Student student = new Student(id, name, surname, patronymic);
        for(final String sub : subArr){
            student.addSubject(sub);
            final int rate = random.nextInt(6);
            student.setRate(sub,rate);
        }
        return  student;

    }

    private final static <T> void print(final String description, final List<T> list){
        System.out.println(description);
        list.forEach(System.out::println);
    }
}