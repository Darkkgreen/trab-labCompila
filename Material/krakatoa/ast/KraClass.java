package ast;

public class KraClass extends Type {
	
   public KraClass( String name ) {
      super(name);
	  superclass = null;
      instanceVariableList = new InstanceVariableList();
      publicMethodList = new MethodList();
      privateMethodList = new MethodList();
   }
   
   public String getCname() {
      return getName();
   }
   
   private String name;
   private KraClass superclass;
   private InstanceVariableList instanceVariableList;
   private MethodList publicMethodList;
   private MethodList privateMethodList;

   public void setSuper(KraClass superClasse){
      this.superclass = superClasse;
   }

   public KraClass getSuper(){
      return superclass;
   }

   public void setPublicMethodList(MethodList publicm){
      this.publicMethodList = publicm;
   }

   public void setPrivateMethodList(MethodList privatem){
      this.privateMethodList = privatem;
   }

   public void setVariableList(InstanceVariableList ivl){
      this.instanceVariableList = ivl;
   }
   
   public boolean hasPublicMethod() {
	   return this.publicMethodList.getSize() != 0;
   }

   public boolean hasPublicMethod(String m){
      return this.publicMethodList.contains(m);
   }

   public boolean hasPrivateMethod(String m){
      return this.privateMethodList.contains(m);
   }

   public boolean hasInstanceVariable(String m){
      return this.instanceVariableList.contains(m);
   }

   public Method getMethod(String m){
      for(Method aux: publicMethodList){
         if(aux.getName().equals(m)){
            return aux;
         }
      }

      return null;
   }
}