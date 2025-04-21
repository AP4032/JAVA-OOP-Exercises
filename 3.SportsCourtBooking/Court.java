import java.lang.reflect.Array;

public class Court {
    public boolean book;
    public String courttype;

    public Court(String courttype) {
        this.courttype = courttype;
        this.book=false;
    }

    public boolean status(){
        return this.book;
    }

    public void setbook(){
    this.book=true;}

    public String name(){
        return courttype;
    }

}
