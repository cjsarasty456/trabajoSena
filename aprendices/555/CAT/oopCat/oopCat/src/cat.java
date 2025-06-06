public class cat {

    // atributos
    public String name;
    private String color;
    public double weight;
    public byte age;
    public String gender;

    /*
     * modificador de acceso
     * public
     * private
     * protected
     * 
     * Tipo de retorno
     * void=vacío, que no hay retorno
     * int,boolean,String,etc al finalizar el
     * método se espera un valor
     * ()=Parámetros=valores o variables
     * que requiero para ejecutar el método
     */

    public void breathe() {
        System.out.println("El gato respira");
    }

    public void eat(String food) {
        System.out.println("El gato comió " + food);
    }

    public void run(String destination) {
        System.out.println("El gato corrió hacia " + destination);
    }

    public void meow() {
        System.out.println("meow!!");
    }

    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return this.color;
    }
}
