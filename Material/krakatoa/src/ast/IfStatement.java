// Enrique Sampaio dos Santos
// Gustavo Rodrigues

package ast;

/**
 *
 * @author enrique
 */
public class IfStatement extends Statement {
    private Expr e;
    private Statement sIf, sElse;
    
    public IfStatement(Expr e, Statement sIf, Statement sElse) {
        this.e = e;
        this.sIf = sIf;
        this.sElse = sElse;
    }
    
    @Override
    public void genC(PW pw) {
        pw.printIdent("if");
        e.genC(pw, true);
        pw.println(" {");
        pw.add();
        sIf.genC(pw);
        pw.sub();
        if(sElse != null){
            pw.printlnIdent("} else {");
            pw.add();
            sElse.genC(pw);
            pw.sub();
        }
        pw.printlnIdent("}");
    }
    
    @Override
    public void genKra(PW pw) {
        pw.printIdent("if");
        e.genKra(pw, true);
        pw.println(" {");
        pw.add();
        sIf.genKra(pw);
        pw.sub();
        if(sElse != null){
            pw.printlnIdent("} else {");
            pw.add();
            sElse.genKra(pw);
            pw.sub();
        }
        pw.printlnIdent("}");
    }
    
}
