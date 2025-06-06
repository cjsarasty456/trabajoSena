public class App {
    public static void main(String[] args) throws Exception {
        //definición del objeto
        cat lino;
        //instancia del objeto
        lino=new cat();

        lino.name="lino";
        lino.age=2;
        lino.weight=2;
        //atributo privado
        //lino.color="cafe";
        lino.setColor("cafe");
        lino.gender="Masculino";

        cat bastet =new cat();
        bastet.name="bastet" ;
        bastet.age=3;
        bastet.weight=2;
        bastet.setColor("negro");
        bastet.gender="Femenino";

        System.out.println("Gato 1:");
        System.out.println("name:"+lino.name);
        System.out.println("age:"+lino.age+" year old");
        System.out.println("weight:"+lino.weight+" kg");
        System.out.println("color:"+lino.getColor());
        lino.breathe();
        lino.eat("Comida");
        lino.meow();
        lino.run("cocina");
        
        
        System.out.println("Gato 2:");
        System.out.println("name:"+bastet.name);
        System.out.println("age:"+bastet.age+" year old");
        System.out.println("weight:"+bastet.weight+" kg");
        System.out.println("color:"+bastet.getColor());
        
    }
}
