/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author enrique
 */
public class AssignStatement extends Statement {

    private Expr left;
    private Expr right;

    public AssignStatement(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void genC(PW pw) {
        left.genC(pw, false);
<<<<<<< HEAD
        if (right != null) {
            pw.print(" = ");
            right.genC(pw, false);
        }
        pw.println(";");
=======
        if(right != null){
            pw.print(" = ");
            right.genC(pw, false);
            pw.println(";");
        }
>>>>>>> ae9783e2a2684d436f90ed1a45a924638e1d3376
    }

}
