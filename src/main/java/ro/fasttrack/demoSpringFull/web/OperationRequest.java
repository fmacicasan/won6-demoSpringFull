package ro.fasttrack.demoSpringFull.web;

import java.util.Objects;

/**
 * @author flo
 * @since 20.07.2022.
 */
public final class OperationRequest {
    private String op1;
    private String op;
    private String op2;

    public OperationRequest() {

    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp() {
        return op;
    }

    public String getOp2() {
        return op2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (OperationRequest) obj;
        return Objects.equals(this.op1, that.op1) &&
                Objects.equals(this.op, that.op) &&
                Objects.equals(this.op2, that.op2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(op1, op, op2);
    }

    @Override
    public String toString() {
        return "OperationRequest[" +
                "op1=" + op1 + ", " +
                "op=" + op + ", " +
                "op2=" + op2 + ']';
    }

}
