package exercicios25072026parte1.contabil.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;


public class PlanoConta extends Entidade<Integer>
        implements Comparable<PlanoConta> {


    private static final long serialVersionUID = 1L;



    private Integer codigoInterno;


    private String codigo;


    private String descricao;


    private NaturezaConta natureza;


    private TipoConta tipoConta;


    private Integer nivel;


    private boolean aceitaLancamento;


    private boolean ativo;



    private PlanoConta contaPai;



    private final List<PlanoConta> contasFilhas =
            new ArrayList<>();



    private BigDecimal saldo =
            BigDecimal.ZERO;





    public PlanoConta() {

    }






    public PlanoConta(
            Integer id,
            String codigo,
            String descricao,
            NaturezaConta natureza,
            TipoConta tipoConta,
            Integer nivel,
            boolean aceitaLancamento) {


        setId(id);

        this.codigoInterno = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.natureza = natureza;
        this.tipoConta = tipoConta;
        this.nivel = nivel;
        this.aceitaLancamento = aceitaLancamento;
        this.ativo = true;

    }






    public PlanoConta(
            Integer id,
            Integer codigoInterno,
            String codigo,
            String descricao,
            NaturezaConta natureza,
            TipoConta tipoConta,
            Integer nivel,
            boolean aceitaLancamento) {


        setId(id);

        this.codigoInterno = codigoInterno;
        this.codigo = codigo;
        this.descricao = descricao;
        this.natureza = natureza;
        this.tipoConta = tipoConta;
        this.nivel = nivel;
        this.aceitaLancamento = aceitaLancamento;
        this.ativo = true;

    }







    public Integer getCodigoInterno() {

        return codigoInterno;

    }



    public void setCodigoInterno(Integer codigoInterno) {

        this.codigoInterno = codigoInterno;

    }







    public String getCodigo() {

        return codigo;

    }



    public void setCodigo(String codigo) {

        this.codigo = codigo;

    }







    public String getDescricao() {

        return descricao;

    }



    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }







    public NaturezaConta getNatureza() {

        return natureza;

    }



    public void setNatureza(NaturezaConta natureza) {

        this.natureza = natureza;

    }







    public TipoConta getTipoConta() {

        return tipoConta;

    }



    public void setTipoConta(TipoConta tipoConta) {

        this.tipoConta = tipoConta;

    }







    public Integer getNivel() {

        return nivel;

    }



    public void setNivel(Integer nivel) {

        this.nivel = nivel;

    }







    public boolean isAceitaLancamento() {

        return aceitaLancamento;

    }



    public void setAceitaLancamento(
            boolean aceitaLancamento) {

        this.aceitaLancamento = aceitaLancamento;

    }







    public boolean isAtivo() {

        return ativo;

    }



    public void setAtivo(boolean ativo) {

        this.ativo = ativo;

    }







    public PlanoConta getContaPai() {

        return contaPai;

    }



    public void setContaPai(PlanoConta contaPai) {

        this.contaPai = contaPai;

    }







    public List<PlanoConta> getContasFilhas() {

        return List.copyOf(contasFilhas);

    }







    public BigDecimal getSaldo() {

        return saldo;

    }



    public void setSaldo(BigDecimal saldo) {

        this.saldo = saldo == null

                ? BigDecimal.ZERO

                : saldo;

    }







    public void adicionarFilha(
            PlanoConta filha) {


        Objects.requireNonNull(
                filha,
                "Conta filha obrigatória"
        );


        if(this.equals(filha)) {

            throw new IllegalArgumentException(
                    "Uma conta não pode ser filha dela mesma"
            );

        }



        filha.setContaPai(this);



        if(!contasFilhas.contains(filha)) {

            contasFilhas.add(filha);

        }

    }







    public void removerFilha(
            PlanoConta filha) {


        if(filha == null) {

            return;

        }



        if(contasFilhas.remove(filha)) {

            filha.setContaPai(null);

        }

    }







    public boolean possuiFilhos() {

        return !contasFilhas.isEmpty();

    }







    public int quantidadeFilhos() {

        return contasFilhas.size();

    }







    public boolean isAnalitica() {

        return tipoConta == TipoConta.ANALITICA;

    }







    public boolean isSintetica() {

        return tipoConta == TipoConta.SINTETICA;

    }







    public void ordenarFilhos() {


        contasFilhas.sort(

                Comparator.comparing(
                        PlanoConta::getCodigo,
                        Comparator.nullsLast(
                                String::compareToIgnoreCase
                        )
                )

        );

    }







    public PlanoConta localizar(
            String codigo) {


        return contasFilhas.stream()

                .filter(

                        conta -> Objects.equals(
                                conta.getCodigo(),
                                codigo
                        )

                )

                .findFirst()

                .orElse(null);

    }







    public PlanoConta localizarRecursivo(
            String codigo) {


        if(Objects.equals(
                this.codigo,
                codigo)) {

            return this;

        }



        for(PlanoConta filha : contasFilhas) {


            PlanoConta encontrada =
                    filha.localizarRecursivo(codigo);



            if(encontrada != null) {

                return encontrada;

            }

        }



        return null;

    }







    public BigDecimal calcularSaldoTotal() {


        BigDecimal total = saldo;



        for(PlanoConta filha : contasFilhas) {


            total = total.add(
                    filha.calcularSaldoTotal()
            );

        }



        return total;

    }







    public long quantidadeContas() {


        return 1 +

                contasFilhas.stream()

                .mapToLong(
                        PlanoConta::quantidadeContas
                )

                .sum();

    }







    public void imprimir(
            String espacos) {


        System.out.println(

                espacos
                + codigo
                + " - "
                + descricao
                + " ["
                + tipoConta
                + "]"

        );



        contasFilhas.forEach(

                conta ->

                        conta.imprimir(
                                espacos + "    "
                        )

        );

    }







    @Override
    public int compareTo(
            PlanoConta outra) {


        if(outra == null) {

            return 1;

        }


        return Comparator
                .nullsLast(String::compareToIgnoreCase)
                .compare(
                        this.codigo,
                        outra.codigo
                );

    }







    @Override
    public boolean equals(Object obj) {


        if(this == obj) {

            return true;

        }



        if(!(obj instanceof PlanoConta outra)) {

            return false;

        }



        if(getId() == null ||
                outra.getId() == null) {

            return false;

        }



        return Objects.equals(
                getId(),
                outra.getId()
        );

    }







    @Override
    public int hashCode() {


        return getId() == null

                ? System.identityHashCode(this)

                : Objects.hash(getId());

    }







    @Override
    public String toString() {


        return codigo
                + " - "
                + descricao;

    }


}