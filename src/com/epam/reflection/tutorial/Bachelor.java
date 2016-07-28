package com.epam.reflection.tutorial;

/**
 * Created by Зая on 28.07.2016.
 */
@ClassInfo(author = "Pidhurska", date = "28 Jul 2016")
public class Bachelor extends Student {

    @FieldAnnotation(author = "Pidhurska", date = "28 Jul 2016")
    private String degreeWorkTitle;

    private Qualification qualification;

    public Bachelor() {

    }


    public Bachelor(String name, int courseYear, int id, String degreeWorkTitle, Qualification qualification) {
        super(name, courseYear, id);
        this.degreeWorkTitle = degreeWorkTitle;
        this.qualification = qualification;
    }

    public String getDegreeWorkTitle() {
        return degreeWorkTitle;
    }

    public void setDegreeWorkTitle(String degreeWorkTitle) {
        this.degreeWorkTitle = degreeWorkTitle;
    }

    @Override
    @MethodInfo(author = "Pidhurska", comments = "toString method", date = "28 Jul 2016", revision = 1)
    public String toString() {
        return super.toString() +"qualification='"+qualification+
                ", degreeWorkTitle='" + degreeWorkTitle + '\'' +
                '}';
    }

    @Deprecated
    @MethodInfo(comments = "deprecate method", date = "28 Jul 2016")
    public static void oldmethod() {
        System.out.println("Old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "Pidhurska", comments = "test method", date = "28 Jul 2016", revision = 1)
    public static void test() {
        System.out.println("test method goes here...");
        oldmethod();
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }
}
