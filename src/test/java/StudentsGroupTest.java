import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentsGroupTest {
    private StudentsGroup studentsGroup1;

    @Test
    public void addStudent() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        StudentsGroup studentsGroup2 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна", "Зубенко Михаил Петрович"), List.of("физика", "программирование"));
        studentsGroup1.addStudent("Зубенко Михаил Петрович");
        Assert.assertEquals(studentsGroup2.getNames(), studentsGroup1.getNames());
    }

    @Test(expected = Exception.class)
    public void addStudentException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addStudent("Зуб3нко Михаил Петрович");
    }

    @Test
    public void deleteStudent() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        StudentsGroup studentsGroup2 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна"), List.of("физика", "программирование"));
        studentsGroup1.deleteStudent("Ковалева София Алексеевна");
        Assert.assertEquals(studentsGroup2.getNames(), studentsGroup1.getNames());
    }

    @Test(expected = Exception.class)
    public void deleteStudentException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.deleteStudent("Зуб3нко Михаил Петрович");
    }

    @Test
    public void addSubject() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        StudentsGroup studentsGroup2 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна"), List.of("физика", "программирование", "социология"));
        studentsGroup1.addSubject("социология");
        Assert.assertEquals(studentsGroup2.getSubjects(), studentsGroup1.getSubjects());
    }

    @Test(expected = Exception.class)
    public void addSubjectException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addSubject("с0циология");
    }

    @Test
    public void deleteSubject() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        StudentsGroup studentsGroup2 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна"), List.of("программирование"));
        studentsGroup1.deleteSubject("физика");
        Assert.assertEquals(studentsGroup2.getSubjects(), studentsGroup1.getSubjects());
    }

    @Test(expected = Exception.class)
    public void deleteSubjectException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.deleteSubject("фи3ика");
    }

    @Test
    public void addGrade() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addGrade("Грубенкова Елизавета Валерьевна", "физика", 5);
        Assert.assertEquals((Integer) 5, studentsGroup1.getGradeBook().get("Грубенкова Елизавета Валерьевна").get("физика"));
    }

    @Test(expected = Exception.class)
    public void addGradeException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addGrade("Грубенкова Елизавета Валерьевна", "физика", 6);
    }

    @Test
    public void deleteGrade() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addGrade("Грубенкова Елизавета Валерьевна", "физика", 5);
        studentsGroup1.deleteGrade("Грубенкова Елизавета Валерьевна", "физика");
        Assert.assertEquals((Integer) 0, studentsGroup1.getGradeBook().get("Грубенкова Елизавета Валерьевна").get("физика"));
    }

    @Test(expected = Exception.class)
    public void deleteGradeException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.deleteGrade("Грубенкова Елизавета Валерьевна", "фи3ика");
    }

    @Test
    public void changeGrade() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addGrade("Грубенкова Елизавета Валерьевна", "физика", 5);
        studentsGroup1.changeGrade("Грубенкова Елизавета Валерьевна", "физика", 4);
        Assert.assertEquals((Integer) 4, studentsGroup1.getGradeBook().get("Грубенкова Елизавета Валерьевна").get("физика"));

    }
    @Test(expected = Exception.class)
    public void changeGradeException() throws Exception {
        studentsGroup1 = new StudentsGroup("353090100006", List.of("Грубенкова Елизавета Валерьевна", "Ковалева София Алексеевна"), List.of("физика", "программирование"));
        studentsGroup1.addGrade("Грубенкова Елизавета Валерьевна", "физика", 5);
        studentsGroup1.changeGrade("Груб3нкова Елизавета Валерьевна", "физика", 5);
    }
}