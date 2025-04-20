public class Visitor {
    private String name;
    private int ticket;

    public Visitor(String name , int ticket){
        this.name = name;
        this.ticket = ticket;
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
