import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class StudentsGroup {
    private Map<String, Integer> subjects;
    private String number;
    private Map<String, Map<String, Integer>> gradeBook;
    private List<String> names;

    public StudentsGroup(String number, List<String> names, List<String> subjectsList) throws Exception {
        if (number.matches("^\\d")) throw new Exception("Некорректные данные");
        this.subjects = new HashMap<>();
        this.number = number;
        this.gradeBook = new HashMap<>();
        this.names = new ArrayList<String>();
        for (String subject: subjectsList) {
            if (Pattern.matches("[^а-яА-Я]",subject)) {
                throw new Exception("Некорректные данные");
            } else {
                this.subjects.put(subject, 0);
            }
        }
        for (String name: names) {
            if (Pattern.matches("[^а-яА-Я^\\s]", name)) {
                throw new Exception("Некорректные данные");
            } else {
                Map<String, Integer> map = new HashMap<>(this.subjects);
                this.gradeBook.put(name, map);
                this.names.add(name);
            }
        }
    }

    public void addStudent(String name) throws Exception {
        if (name.matches("[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+")) {
            this.gradeBook.put(name, this.subjects);
            this.names.add(name);
        }
        else {
            throw new Exception("Некорректные данные");
        }
    }

    public void deleteStudent(String name) throws Exception {
         if (name.matches("[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+")) {
            this.gradeBook.remove(name);
            this.names.remove(name);
        } else {
             throw new Exception("Некорректные данные");
         }
    }

    public void addSubject(String subject) throws Exception {
        if (subject.matches("[а-яА-Я]+")) {
            for (Map.Entry<String, Map<String, Integer>> entry : gradeBook.entrySet()) {
                entry.getValue().put(subject, 0);
            }
            this.subjects.put(subject, 0);
        } else
            throw new Exception("Некорректные данные");
    }

    public void deleteSubject(String subject) throws Exception {
        if (subject.matches("[а-яА-Я]+"))  {
            for (Map.Entry<String, Map<String, Integer>> entry : gradeBook.entrySet()) {
                if (entry.getValue().containsKey(subject)) {
                    entry.getValue().remove(subject);
                }
            }
            this.subjects.remove(subject);
        }
        else
            throw new Exception("Некорректные данные");
    }

    public void addGrade(String name, String subject, int grade) throws Exception {
        if (subject.matches("[а-яА-Я]+") && name.matches("[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+") && grade < 6) {
            this.gradeBook.get(name).replace(subject, grade);
        } else throw new Exception("Некорректные данные");
    }

    public void deleteGrade(String name, String subject) throws Exception {
        if (subject.matches("[а-яА-Я]+") && name.matches("[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+")) {
            this.gradeBook.get(name).replace(subject, 0);
        } else throw new Exception("Некорректные данные");
    }

    public void changeGrade(String name, String subject, int grade) throws Exception {
        if (subject.matches("[а-яА-Я]+") && name.matches("[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+") && grade < 6) {
            this.gradeBook.get(name).replace(subject, grade);
        } else throw new Exception("Некорректные данные");
    }

    public void setGradeBook(Map<String, Map<String, Integer>> gradeBook) {
        this.gradeBook = gradeBook;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSubjects(Map<String, Integer> subjects) {
        this.subjects = subjects;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Map<String, Integer> getSubjects() { return subjects; }

    public Map<String, Map<String, Integer>> getGradeBook() {
        return gradeBook;
    }

    public List<String> getNames() { return names; }

    public String getNumber () {
        return this.number;
    }

}