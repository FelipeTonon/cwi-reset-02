public class PropostaFinanciamento {

    private Beneficiario beneficiario;
    private Imovel imovel;
    private Integer prazoDePagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, Integer prazoDePagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazoDePagamento = prazoDePagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    public void validarProposta() {
        if(imovel.getEstado().equals(UnidadeFederativa.SP)){
            if((beneficiario.getSalario() * this.prazoDePagamento) >= (0.65 * imovel.getValor())){
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaReprovada();
            }
        } else if(imovel.getEstado().equals(UnidadeFederativa.RJ)) {
            if((beneficiario.getSalario() * this.prazoDePagamento) >= (0.6 * imovel.getValor())){
            imprimirPropostaAprovada();
            } else {
            imprimirPropostaReprovada();
            }
        } else {
            if((beneficiario.getSalario() * this.prazoDePagamento) >= (0.5 * imovel.getValor())){
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaReprovada();
            }
        }
    }

    private void imprimirPropostaAprovada(){
        System.out.println("*** INFORMAÇÕES DA PROPOSTA ***");
        System.out.println("Beneficiário: " + beneficiario.getNome());
        System.out.println("Renda: R$" + beneficiario.getSalario());
        System.out.println(imovel.apresentacao());
        System.out.println("Prazo de financiamento: " + prazoDePagamento);
        System.out.println("***TÃ TÃ TÃ TÃÃÃN! PARABÉNS MAGNATA! VOCÊ JÁ PODE FINANCIAR ESSA DESGRAÇA!");
    }

    private void imprimirPropostaReprovada(){
        System.out.println("*** INFORMAÇÕES DA PROPOSTA ***");
        System.out.println("Beneficiário: " + beneficiario.getNome());
        System.out.println(imovel.apresentacao());
        System.out.println("Prazo de financiamento: " + prazoDePagamento);
        System.out.println("***TÃ TÃ TÃ TÃÃÃN! NÃO FOI DESSA VEZ CHEFE! COM ESSE SALÁRIO VOCÊ NÃO FINANCIA NEM UMA OCA!");
    }

}