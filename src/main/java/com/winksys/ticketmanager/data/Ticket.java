package com.winksys.ticketmanager.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numero;
    @Column(name="data_abertura")

    private Date dataAbertura;

    @Column(name="data_resolucao")
    private Date dataResolucao;

    @Column(name="data_prevista")

    private Date dataPrevista;
    private String assunto;
    private String descritivo;
    private String contato;
    private int tempo;
    private int status;

    @ManyToOne
    @JoinColumn(name="grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="responsavel")
    private Usuario responsavel;
    private Integer prioridade;
    private String versao;
    private Date prazo;

    @Column(name="usuario_ultimo_tramite")
    private String usuarioUltimoTramite;

    @Column(name="data_ultimo_tramite")
    private Date dataUltimoTramite;

    @Column(name="tempo_previsto")
    private double tempoPrevisto;

    @Column(name="data_previsao")
    private Date dataPrevisao;
    private String email;

    @Column(name="versao_origem")
    private String versaoOrigem;

    @Column(name="usuario_exclusao")
    private String usuarioExclusao;

    @Column(name="data_exclusao")
    private Date dataExclusao;
    private boolean excluido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getUsuarioUltimoTramite() {
        return usuarioUltimoTramite;
    }

    public void setUsuarioUltimoTramite(String usuarioUltimoTramite) {
        this.usuarioUltimoTramite = usuarioUltimoTramite;
    }

    public Date getDataUltimoTramite() {
        return dataUltimoTramite;
    }

    public void setDataUltimoTramite(Date dataUltimoTramite) {
        this.dataUltimoTramite = dataUltimoTramite;
    }

    public double getTempoPrevisto() {
        return tempoPrevisto;
    }

    public void setTempoPrevisto(double tempoPrevisto) {
        this.tempoPrevisto = tempoPrevisto;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVersaoOrigem() {
        return versaoOrigem;
    }

    public void setVersaoOrigem(String versaoOrigem) {
        this.versaoOrigem = versaoOrigem;
    }

    public String getUsuarioExclusao() {
        return usuarioExclusao;
    }

    public void setUsuarioExclusao(String usuarioExclusao) {
        this.usuarioExclusao = usuarioExclusao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
}
