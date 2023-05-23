package OOP_Practical;

public class userProfile {

    private String name;
    private int age;
    private String title;
    private String gender;
    private String occupation;

    public userProfile(){
    }

    //setting values
    public void setName(String a){

        name = a;
    }
    public void setAge(int a){

        age = a;
    }
    public void setTitle(String a){

        title = a;
    }
    public void setGender(String a){

        gender = a;
    }
    public void setOccupation(String a){
        occupation = a;
    }

    //returning values
    public String getName(){

        return name;
    }
    public int getAge(){

        return age;
    }
    public String getTitle(){

        return title;
    }
    public String getGender(){

        return gender;
    }
    public String getOccupation(){

        return occupation;
    }
}
