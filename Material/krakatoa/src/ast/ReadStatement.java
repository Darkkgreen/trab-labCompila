// Enrique Sampaio dos Santos
// Gustavo Rodrigues

package ast;

/**
 *
 * @author enrique
 */
public class ReadStatement extends Statement {
    private VariableList vl;
    
    public ReadStatement(VariableList vl) {
        this.vl = vl;
    }

    @Override
    public void genC(PW pw) {
        for(Variable aux: vl.getList()){
            pw.printlnIdent("{");
            pw.add();
            pw.printlnIdent("char __s[512];");
            pw.printlnIdent("gets(__s);");
            if(aux.getType().getName().equals("String")){
                pw.printlnIdent("sscanf(__s, \"%c\", &_"+ aux.getName()+");");
            }else if(aux.getType().getName().equals("boolean")){
                pw.printlnIdent("sscanf(__s, \"%d\", &_"+ aux.getName()+");");
            }else if(aux.getType().getName().equals("int")){
                pw.printlnIdent("sscanf(__s, \"%d\", &_"+ aux.getName()+");");
            }
            pw.sub();
            pw.printlnIdent("}");
            pw.println();
        }
    }
    
    @Override
    public void genKra(PW pw) {
    	pw.printIdent("read(");
    	
    	int size = vl.getSize();
    	
    	for(Variable aux: vl.getList()){
            pw.print(aux.getName());
            if (--size > 0 ) {
            	pw.print(", ");
            }
        }
    	
    	pw.println(");");
    }
}
