public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual(){
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    //metodo construtor (vai ser executado sempre que uma nova classe for instaciada - virar um obj)
    public ContaBanco () {
        this.setSaldo(0);
        this.setStatus(false);
    }

    //metodos
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC"){
            this.setSaldo(50);
        }else if (t == "CP"){
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta(){
        if (this.getSaldo() > 0){
            // não é uma boa pratica - isso aqui é momentâneo
            System.out.println("Conta com dinheiro!");
        }else if (this.getSaldo() < 0){
            System.out.println("Conta em débito!");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float v){
        //o certo seria isStatus, mas por fim didáticos vai ficar assim por enquanto
        if (this.getStatus() == true){
            //saldo = saldo + v; (esse ou a de baixo podem ser usadas - a de baixo é mais indicada)
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Depósito realizado na conta de "+ this.getDono());
        }else{
            System.out.println("Impossível depositar!");
        }
    }

    public void sacar(float v){
        if (this.getStatus() == true){
            if (this.getSaldo() >= v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado com sucesso " + this.getDono());
            }else{
                System.out.println("Saldo insuficiente!");
            }
        }else{
            System.out.println("Impossível sacar!");
        }
    }

    public void pagarMensal(){
        int v = 0;
        if (this.getTipo() == "CC"){
            v = 12;
        }else if (this.getTipo() == "CP"){
            v = 20;
        }

        if (status == true){
            if (saldo > v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Mensalidade paga com sucesso por " + this.getDono());
            }else{
                System.out.println("Saldo insuficiente!");
            }
        }else{
            System.out.println("Impossível pagar!");
        }
    }

    // get - set
    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
