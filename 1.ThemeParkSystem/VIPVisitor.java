// VIPVisitor.java
public class VIPVisitor extends Visitor {
    private String vipCode;

    public VIPVisitor(String name, int height, String vipCode) {
        super(name, height);
        this.vipCode = vipCode;
    }

    public String getVipCode() {
        return vipCode;
    }

    @Override
    public String toString() {
        return "VIPVisitor{" +
                "name='" + getName() + '\'' +
                ", height=" + getHeight() +
                ", vipCode='" + vipCode + '\'' +
                '}';
    }
}
