package ro.fasttrack.demoSpringFull.domain;

import javax.persistence.*;

/**
 * @author flo
 * @since 20.07.2022.
 */
@Entity
@Table(name = "operationhistory")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private long id;
    @Column(name = "nr1")
    private Integer op1;
    @Column(name = "nr2")
    private Integer op2;
    private String op;
    private double result;

    public Operation() {
    }

    public Operation(Integer op1, String op, Integer op2, double result) {
        this.op1 = op1;
        this.op2 = op2;
        this.op = op;
        this.result = result;
    }

    public Integer getOp1() {
        return op1;
    }

    public Integer getOp2() {
        return op2;
    }

    public String getOp() {
        return op;
    }

    public double getResult() {
        return result;
    }
}
