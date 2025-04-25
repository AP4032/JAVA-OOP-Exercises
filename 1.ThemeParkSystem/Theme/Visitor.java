package Theme;

public class Visitor {
    protected String name;
    protected int ticket;

    public Visitor(String name , int ticket){
        this.name = name;
        this.ticket = ticket;
    }

    public Visitor(String visitorName) {
    }

    public String getname(){
        return name;
    }
    public int getTicket(){
        return ticket;
    }
    public boolean useTicket(){
        if (ticket > 0){
            ticket--;
            return true;
        }
        return false;
    }
}

