package assignment7;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private int attemptedCredits;
    private int passingCredits;
    private double totalGradeQualityPoints;
    private double balance;

    public Student(String firstName, String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.attemptedCredits = 0;
        this.passingCredits = 0;
        this.totalGradeQualityPoints = 0;
        this.balance = 0;
    }

    public String getFullName(){
        return this.firstName;
    }
    public int getId(){
        return this.id;
    }
    public int getTotalAttemptedCredits(){
        return this.attemptedCredits;
    }
    public int getTotalPassingCredits(){
        return this.passingCredits;
    }
    public double getBearBucksBalance(){
        return this.balance;
    }

	public double calculateGradePointAverage(){
        return totalGradeQualityPoints / attemptedCredits;
    }

    public void submitGrade(double grade, int credits){
        this.attemptedCredits += credits;
        if (grade >= 1.7){
            this.passingCredits += credits;
            this.totalGradeQualityPoints += (credits * grade);
        }
    }

    public String getClassStanding(){
        if (passingCredits < 30){
            return "First Year";
        } else if (passingCredits < 60){
            return "Sophomore";
        } else if (passingCredits < 90){
            return "Junior";
        } else {
            return "Senior";
        }
    }

    public boolean isEligibleForPhiBetaKappa(){
        if (this.passingCredits >= 98 && this.calculateGradePointAverage() >= 3.6){
            return true;
        }
        if (this.passingCredits >= 75 && this.calculateGradePointAverage() >= 3.8){
            return true;
        }
        return false;
    }

    public void depositBearBucks(double amount){
        this.balance += amount;
    }
    public void deductBearBucks(double amount){
        this.balance -= amount;
    }

    public double cashOutBearBucks(){
        double currentBal = this.balance;
        if (currentBal < 10){
            this.balance = 0;
            return 0;
        } else {
            this.balance = 0;
            return currentBal - 10;
        }
    }

    public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id){
        Student legacyKid;
        if (isHyphenated) {
            legacyKid = new Student(firstName, this.lastName + "-" + otherParent.lastName,id);
        } else {
            legacyKid = new Student(firstName, this.lastName, id);
        }
        legacyKid.depositBearBucks(this.cashOutBearBucks() + otherParent.cashOutBearBucks());
        return legacyKid;
    }

    public String toString(){
        return this.id + ": " + this.firstName + " " + this.lastName;
    }


}
